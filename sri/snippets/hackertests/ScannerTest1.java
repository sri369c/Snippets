package sri.snippets.hackertests;

import java.util.Scanner;

/**
42
3.1415
Welcome to HackerRank's Java
*/

public class ScannerTest1
{
	public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        
        scan.close();
    }
}
