package sri.snippets.hackertests;

import java.util.Scanner;

public class Staircase
{
	public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int rowCount = Integer.parseInt(scanner.next());
        scanner.close();
        
        for (int i=0; i<rowCount; i++)
        {
            for (int j=0; j<(rowCount-i-1); j++)
                 System.out.print(" ");
            for (int j=0; j<((rowCount+1) - (rowCount-i)); j++)
                 System.out.print("#");
            System.out.println("");
        }
    }
}
