package sri.snippets.patterns;

import java.util.regex.Pattern;

public class PatternMatcher
{
	public static void main(String[] args)
	{
		System.out.println(Pattern.matches("[A-Z]\\d[A-Z] \\d[A-Z]\\d", "M2H 3S7"));
		System.out.println(Pattern.matches("[A-Z]\\d[A-Z] \\d[A-Z][0-9]", "M2H 3S7"));
		System.out.println(Pattern.matches("[A-Z]\\d[A-Z] \\d[A-Z][0-4]", "M2H 3S7"));
	}
}
