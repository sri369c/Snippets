package sri.snippets.hackertests;

import java.util.Scanner;

/**
 Given a square matrix of size , calculate the absolute difference between the sums of its diagonals.

Input Format
The first line contains a single integer, . The next lines denote the matrix's rows, with each line containing space-separated integers describing the columns.

Output Format
Print the absolute difference between the two sums of the matrix's diagonals as a single integer.
 */

public class DiagonalDifference
{
	public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        int rowCount = Integer.parseInt(scanner.next());
        
        int[][] values = new int[rowCount][rowCount]; // square matrix
        for (int i=0; i<rowCount; i++)
        {
            for (int j=0; j<rowCount; j++)
            {
                values[i][j] = Integer.parseInt(scanner.next());
            }
        }
        scanner.close();
        
        int sum1 = 0, sum2 = 0;
        for (int i=0; i<rowCount; i++)
        {
            sum1 += values[i][i];
            sum2 += values[rowCount-1-i][i];
        }

        System.out.println(Math.abs(sum1 - sum2));
    }
}
