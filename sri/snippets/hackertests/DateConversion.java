package sri.snippets.hackertests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateConversion
{
	public static void main(String[] args) throws Exception
    {
        new DateConversion().test1();
    }
	
	public void test1() throws Exception
	{
		//Scanner scanner = new Scanner(System.in);
        String inDate = "08 05 2015"; //scanner.next();
        //scanner.close();
        
        SimpleDateFormat displayFormat = new SimpleDateFormat("EEEE");
        SimpleDateFormat parseFormat = new SimpleDateFormat("MM dd yyyy");
        Date date = parseFormat.parse(inDate);
        System.out.println((displayFormat.format(date)).toUpperCase());
	}
}
