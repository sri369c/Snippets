package sri.snippets.threading.one;

public class WebServiceInfo
{
	private String serviceName;
	private String targetUrl;
	/*
	 * Add all needed information to access the target web service 
	 */
	
	public String getServiceName()
	{
		return serviceName;
	}
	public void setServiceName(String serviceName)
	{
		this.serviceName = serviceName;
	}
	public String getTargetUrl()
	{
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl)
	{
		this.targetUrl = targetUrl;
	}
}
