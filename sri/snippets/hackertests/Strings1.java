package sri.snippets.hackertests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Strings1
{
    public static void main(String[] args) 
    {
//        String A = "hello";
//        String B = "java";
//        System.out.println(A.length() + B.length());
//        System.out.println(A.compareTo(B)>0 ? "Yes" : "No");
//        System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " + B.substring(0, 1).toUpperCase() + B.substring(1));
        
    	/**
    	 Given a string, find out the lexicographically smallest and largest substring of length .
		[Note: Lexicographic order is also known as alphabetic order dictionary order. 
		So "ball" is smaller than "cat", "dog" is smaller than "dorm". 
		Capital letter always comes before smaller letter, so "Happy" is smaller than "happy" and "Zoo" is smaller than "ball".]
    	 */
        Scanner sc = new Scanner(System.in);
        String inStr = sc.nextLine();
        int count = sc.nextInt();
        
        List<String> strs = new ArrayList<String>();
        for (int i=0; i <= inStr.length()-count; i++)
            strs.add(inStr.substring(i, i+count));
        
        Collections.sort(strs);
       	System.out.println(strs.get(0));
       	System.out.println(strs.get(strs.size()-1));
       	sc.close();
    }
}
