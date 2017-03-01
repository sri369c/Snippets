package sri.snippets.threading.two;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import sri.snippets.threading.two.vo.ResponseVO;
import sri.snippets.threading.two.vo.TaskVO;

public class TaskManager implements TaskConstants
{
	public static void main(String[] args)
	{
		List<TaskVO> taskList = new ArrayList<TaskVO>();
		
		TaskVO taskInfo;
		for (int i=1; i<11; i++)
		{
			taskInfo = new TaskVO();
			
			if (i%3 == 0)
				taskInfo.setTask(TASKS.TASK001);
			else if (i%5 == 0)
				taskInfo.setTask(TASKS.TASK002);
			else
				taskInfo.setTask(TASKS.TASK003);
			
			taskInfo.setTaskIdentifier("task count 00" + i);
			taskList.add(taskInfo);
		}
		
		List<ResponseVO> responsesList = new TaskManager().performTasks(taskList);
		for (ResponseVO responseInfo : responsesList)
			System.out.println(responseInfo.getTaskIdentifier() + " --> " + responseInfo.getResponseData());
	}
	
	public List<ResponseVO> performTasks(List<TaskVO> taskInfoList)
	{
		List <FutureTask<ResponseVO>> tasksList = new ArrayList<FutureTask<ResponseVO>>();
		
		try
		{
			TaskWorker worker = new TaskWorker();
			
			for (final TaskVO taskInfo : taskInfoList)
			{
				if (TASKS.TASK001.equals(taskInfo.getTask()))
						tasksList.add(worker.performTask001(taskInfo));
				else if (TASKS.TASK002.equals(taskInfo.getTask()))
					tasksList.add(worker.performTask002(taskInfo));
				else if (TASKS.TASK003.equals(taskInfo.getTask()))
					tasksList.add(worker.performTask003(taskInfo));
				else
					throw new RuntimeException("Unhandled task identifier.");
			}
			
			return executeTasksAndFetchData(tasksList);
		}
		catch (Exception e)
		{
			System.out.println("Exception retrieving data: " + e);
			return null;
		}
	}
	
	private List<ResponseVO> executeTasksAndFetchData(List <FutureTask<ResponseVO>> tasksList) throws InterruptedException, ExecutionException, TimeoutException
	{
		ExecutorService executorService = Executors.newFixedThreadPool(MAX_NUMBER_OF_THREADS);
		
		System.out.println("Starting the executor service...");
		for (FutureTask<ResponseVO> task : tasksList)
			executorService.execute(task);
		
		List<ResponseVO> responsesList = new ArrayList<ResponseVO>();
		int tasksCount = tasksList.size();
		System.out.println("Starting the data collection...");
		while (true)
		{
			for (FutureTask<ResponseVO> task : tasksList)
			{
				if (task.isDone())
				{
					responsesList.add(task.get(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS));
					task.cancel(true);
					tasksList.remove(task);
					break;
				}
			}
			if (responsesList.size() == tasksCount)
			{
				System.out.println("Data collection complete. Shutting down the executor service.");
				executorService.shutdownNow();
				break;
			}
		}
		return responsesList;
	}
}
