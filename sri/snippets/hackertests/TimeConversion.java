package sri.snippets.hackertests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeConversion
{
	public static void main(String[] args) throws Exception
    {
        new TimeConversion().test1();
    }
	
	public void test1() throws Exception
	{
		Scanner scanner = new Scanner(System.in);
        String inTime = scanner.next();
        scanner.close();
        inTime = inTime.substring(0, inTime.length()-2) 
            + " " 
            + inTime.substring(inTime.length()- 2, inTime.length());
        
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ss a");
        Date date = parseFormat.parse(inTime);
        System.out.println(displayFormat.format(date));
	}

}
