package sri.snippets.hackertests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loops1
{
	/**
	 https://www.hackerrank.com/challenges/java-loops
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        List<String[]> outValues = new ArrayList<String[]>(t);
        for(int i=0;i<t;i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            String[] intermittantValues = new String[n];
            for (int j=0; j<n; j++)
            {
            	int ternaryValue = 0;
            	int multiplier = 1;
            	for (int k=0; k<n; k++)
            	{
            		ternaryValue = ternaryValue + (b * multiplier);
            		intermittantValues[k] = "" + (a + ternaryValue); 
            		multiplier = 2 * multiplier;
            	}
            }
            outValues.add(intermittantValues);
        }
        
        for (String[] values : outValues) 
        {
        	StringBuilder builder = new StringBuilder();
        	for (String value : values)
        	    builder.append(value + " ");

            System.out.println(builder.toString().trim());
        }
        
        in.close();
	}
}
