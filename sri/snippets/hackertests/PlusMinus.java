package sri.snippets.hackertests;

import java.util.Scanner;

/**
Given an array of integers, calculate which fraction of its elements are positive, 
which fraction of its elements are negative, and which fraction of its elements are zeroes, respectively. 
Print the decimal value of each fraction on a new line.
 */
public class PlusMinus
{
	public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        int valuesCount = Integer.parseInt(scanner.next());
        
        double positives=0.0,negatives=0.0,zeroes=0.0;
        for (int i=0; i<valuesCount; i++)
        {
            int inValue = Integer.parseInt(scanner.next());
            if (inValue < 0)
                negatives++;
            else if (inValue > 0)
                positives++;
            else
                zeroes++;
        }
        scanner.close();
        
        System.out.printf("%.6f", positives/valuesCount);
        System.out.printf("\n%.6f", negatives/valuesCount);
        System.out.printf("\n%.6f", zeroes/valuesCount);
    }
}
