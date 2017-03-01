package sri.snippets.threading.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadedWorker
{
	private static final int MAX_NUMBER_OF_THREADS = 3;
	private static final long TIMEOUT_IN_SECONDS = 15;
	
	public static void main(String[] args)
	{
		List<WebServiceInfo> wsInfoList = new ArrayList<WebServiceInfo>();
		
		WebServiceInfo info;
		for (int i=1; i<11; i++)
		{
			info = new WebServiceInfo();
			info.setTargetUrl("targeturl 00" + i);
			info.setServiceName("service name 00" + i);
			wsInfoList.add(info);
		}
		
		List<WebServiceResponseInfo> responsesList = new ThreadedWorker().setupWebServiceCalls(wsInfoList);
		for (WebServiceResponseInfo responseInfo : responsesList)
			System.out.println(responseInfo.getWebserviceIdentifier() + " --> " + responseInfo.getResponseData());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WebServiceResponseInfo> setupWebServiceCalls(List<WebServiceInfo> wsInfoList)
	{
		List <FutureTask<WebServiceResponseInfo>> wsTasksList = new ArrayList<FutureTask<WebServiceResponseInfo>>();
		
		try
		{
			FutureTask<WebServiceResponseInfo> wsTask;
			
			for (final WebServiceInfo serviceInfo : wsInfoList)
			{
				wsTask = new FutureTask<WebServiceResponseInfo>(
						new Callable()
						{
							@Override
							public WebServiceResponseInfo call() throws Exception
							{
								WebServiceResponseInfo response = new WebServiceResponseInfo();
								response.setWebserviceIdentifier(serviceInfo.getServiceName());
								
								/*
								 * make web service call here with details available in the serviceInfo object
								 */
								
								response.setResponseData(serviceInfo.getServiceName() + " response (place holder response)");
								return response;
							}
						}
					);
				wsTasksList.add(wsTask);
			}
			
			return fetchData(wsTasksList);
		}
		catch (Exception e)
		{
			System.out.println("Exception retrieving data: " + e);
			return null;
		}
	}
	
	private List<WebServiceResponseInfo> fetchData(List <FutureTask<WebServiceResponseInfo>> wsTasksList) throws InterruptedException, ExecutionException, TimeoutException
	{
		ExecutorService executorService = Executors.newFixedThreadPool(MAX_NUMBER_OF_THREADS);
		
		System.out.println("Starting the executor service...");
		for (FutureTask<WebServiceResponseInfo> wsTask : wsTasksList)
			executorService.execute(wsTask);
		
		List<WebServiceResponseInfo> wsResponseList = new ArrayList<WebServiceResponseInfo>();
		int tasksCount = wsTasksList.size();
		System.out.println("Starting the data collection...");
		while (true)
		{
			for (FutureTask<WebServiceResponseInfo> wsTask : wsTasksList)
			{
				if (wsTask.isDone())
				{
					wsResponseList.add(wsTask.get(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS));
					wsTask.cancel(true);
					wsTasksList.remove(wsTask);
					break;
				}
			}
			if (wsResponseList.size() == tasksCount)
			{
				System.out.println("Data collection complete. Shutting down the executor service.");
				executorService.shutdownNow();
				break;
			}
		}
		return wsResponseList;
	}
}
