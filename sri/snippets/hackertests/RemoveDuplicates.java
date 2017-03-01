package sri.snippets.hackertests;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Remove duplicates, and leave only the first occurrence Case insensitive when removing duplicates, but the left word should have case preserved
 */

public class RemoveDuplicates
{
	public static void main(String args[]) throws Exception
	{
		String regex = "(?i)\\b([a-z]+)\\b(?:\\s+\\1\\b)+";
		Pattern p = Pattern.compile(regex);

		Scanner in = new Scanner(System.in);
		int rowCount = Integer.parseInt(in.nextLine());

		while (rowCount -- > 0)
		{
			String input = in.nextLine();
			Matcher m = p.matcher(input);

			// Check for subsequences of input that match the compiled pattern
			while (m.find())
				input = input.replaceAll("(?i)\\b([a-z]+)\\b(?:\\s+\\1\\b)+", "$1");

			// Prints the modified sentence.
			System.out.println(input);
		}

		in.close();
	}
}
