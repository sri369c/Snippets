package sri.snippets.patterns;

import java.util.regex.Pattern;

public class PatternTests
{
	public static void main(String[] args)
	{
		String inputStr = "asa sa function(sdfsds) fsdfsdfdsf";
		
		Pattern scriptPattern = Pattern.compile("function\\(", Pattern.CASE_INSENSITIVE);
		
		String outputStr = scriptPattern.matcher(inputStr).replaceAll("");
		
		System.out.println(inputStr + " --> " + outputStr);
	}
}
