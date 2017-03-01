package sri.snippets.hackertests;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
    The username can contain alphanumeric characters and/or underscores(_).
    The username must start with an alphabetic character.
    8 <= Username <= 30.
 */
public class PatternMatching1
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0)
		{
			String username = in.nextLine();

			String pattern = "^[a-zA-z][a-zA-Z0-9_]{7,29}$";

			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(username);
			if (m.find())
			{
				System.out.println("Valid");
			}
			else
			{
				System.out.println("Invalid");
			}
			testCases--;
		}
		in.close();
	}
}
