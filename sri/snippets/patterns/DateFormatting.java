package sri.snippets.patterns;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatting
{
	public static void main(String[] args) throws ParseException
	{
		String inputText = "2014-08-06 21:38:41";
		
//		String DATE_FORMAT_FOR_DB_QUERIES = "yyyy-MM-DD HH24:MI:SS";
//		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_FOR_DB_QUERIES);
		
		DateFormat outputFormat = new SimpleDateFormat("MM/yyyy");
		DateFormat inputFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

		
		Date date = inputFormat.parse(inputText);
		String outputText = outputFormat.format(date);
		
		System.out.println(outputText);
		
//		System.out.println(formatter.format(inputText));
	}
}
