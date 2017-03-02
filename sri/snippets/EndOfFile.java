package sri.snippets.hackertests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EndOfFile 
{
    public static void main(String[] args) 
    {
    	Scanner scan = new Scanner(System.in);
        
        List<String> inData = new ArrayList<String>();
        while (scan.hasNext())
            inData.add(scan.nextLine());
        
        for (int i=0; i<inData.size(); i++)
            System.out.println((i+1) + " " + inData.get(i));
        
        scan.close();
    }
}