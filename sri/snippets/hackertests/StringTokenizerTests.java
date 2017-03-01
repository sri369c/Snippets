package sri.snippets.hackertests;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerTests
{
	 /**
	s is composed of any of the following: 
	English alphabetic letters, 
	blank spaces, 
	exclamation points (!), 
	commas (,), 
	question marks (?), 
	periods (.), 
	underscores (_), 
	apostrophes ('), 
	and at symbols (@).	  
	  */

	
	public static void main(String[] args) 
    {
//		Scanner scan = new Scanner(System.in);
//        String s = scan.nextLine();
//        scan.close();
		String s = "          ";
        
        s = s.trim();
        
        if (s.isEmpty())
        	System.out.println(0);
        else
        {
	        //String[] tokens = s.replaceAll("^[\\W+\\s+]", "").split("[\\s!,?._'@]+");
	        String[] tokens = s.split("[ !,?._'@ ]+");
	        
	        System.out.println(tokens.length);
	        for (int i=0; i<tokens.length; i++)
	            System.out.println(tokens[i]);
        }
    }
}
