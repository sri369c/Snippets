package sri.snippets.threading.two;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import sri.snippets.threading.two.vo.ResponseVO;
import sri.snippets.threading.two.vo.TaskVO;

public class TaskWorker implements TaskConstants
{
	/*
	 * maps to TaskConstants.TASK001
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FutureTask<ResponseVO> performTask001(final TaskVO taskInfo)
	{
		return new FutureTask<ResponseVO>(
				new Callable()
				{
					@Override
					public ResponseVO call() throws Exception
					{
						ResponseVO response = new ResponseVO();
						response.setTaskIdentifier(taskInfo.getTaskIdentifier());
						
						/*
						 * perform task here
						 */
						
						response.setResponseData(taskInfo.getTask() + " response (place holder response)");
						return response;
					}
				}
			);
	}
	
	/*
	 * maps to TaskConstants.TASK001
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FutureTask<ResponseVO> performTask002(final TaskVO taskInfo)
	{
		return new FutureTask<ResponseVO>(
				new Callable()
				{
					@Override
					public ResponseVO call() throws Exception
					{
						ResponseVO response = new ResponseVO();
						response.setTaskIdentifier(taskInfo.getTaskIdentifier());
						
						/*
						 * perform task here
						 */
						
						response.setResponseData(taskInfo.getTask() + " response (place holder response)");
						return response;
					}
				}
			);
	}
	
	/*
	 * maps to TaskConstants.TASK003
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FutureTask<ResponseVO> performTask003(final TaskVO taskInfo)
	{
		return new FutureTask<ResponseVO>(
				new Callable()
				{
					@Override
					public ResponseVO call() throws Exception
					{
						ResponseVO response = new ResponseVO();
						response.setTaskIdentifier(taskInfo.getTaskIdentifier());
						
						/*
						 * perform task here
						 */
						
						response.setResponseData(taskInfo.getTask() + " response (place holder response)");
						return response;
					}
				}
			);
	}
}
