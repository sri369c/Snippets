package sri.snippets.misc;

public class StringOverlap
{
	public static void main(String[] args)
	{
		String oldStr = "aaa aaa aaa aaa aaa aaa aaa aaa aaa aaa aaa bbb bbb bbb bbb ccc";
		String newStr = "bbb bbb bbb bbb ccc ccc ccc ccc";
		
		System.out.println(findOverlap(oldStr, newStr));
	}
	
	public static String findOverlap(String s1, String s2)
	{
		if (s1 == null)
			return s2;
		if (s2 == null)
			return s1;
		int len = Math.min(s1.length(), s2.length());

		// Find the index for the end of overlapping part
		int index = -1;
		for (int i = len; i > 0; i--)
		{
			String substring = s2.substring(0, i);
			if (s1.endsWith(substring))
			{
				index = i;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder(s1);
		if (index < 0)
			sb.append(s2);
		else 
			if (index <= s2.length())
				sb.append(s2.substring(index));
		
		return sb.toString();
	}
}
