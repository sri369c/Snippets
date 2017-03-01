package sri.snippets.threading.two.vo;

import sri.snippets.threading.two.TaskConstants.TASKS;

/**
 * @author Srinivas
 *
 * Variables to hold standard information
 */
public class TaskBaseVO
{
	private String taskIdentifier;
	private TASKS task;
	
	public String getTaskIdentifier()
	{
		return taskIdentifier;
	}
	public void setTaskIdentifier(String taskIdentifier)
	{
		this.taskIdentifier = taskIdentifier;
	}
	public TASKS getTask()
	{
		return task;
	}
	public void setTask(TASKS task)
	{
		this.task = task;
	}
}
