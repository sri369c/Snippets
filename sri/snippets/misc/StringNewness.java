package sri.snippets.misc;

public class StringNewness
{

	public static void main(String[] args)
	{
		String oldStr = "aaa aaa aaa aaa aaa aaa aaa aaa aaa aaa aaa bbb bbb bbb bbb ccc";
		String newStr = "bbb bbb bbb bbb ccc ccc ccc ccc";
		
		int overlapLength = getOverlappedStringLength(oldStr, newStr);
		System.out.println(newStr.substring(0,overlapLength));
		System.out.println(newStr.substring(overlapLength, newStr.length()));
	}

	public static String findOverlap(String s1, String s2)
	{
		if (s1 == null)
			return s2;
		if (s2 == null)
			return s1;
		int len = Math.min(s1.length(), s2.length());

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
	
	static int getOverlappedStringLength(String s1, String s2)
	{
		if (s1.length() > s2.length())
			s1 = s1.substring(s1.length() - s2.length());

		int[] T = ComputeBackTrackTable(s2); 
		
		int m = 0, i = 0;
		while (m + i < s1.length())
		{
			if (s2.charAt(i) == s1.charAt(m + i))
			{
				i += 1;
			}
			else
			{
				m += i - T[i];
				if (i > 0)
					i = T[i];
			}
		}
		return i;
	}

	static int[] ComputeBackTrackTable(String s)
	{
		int[] T = new int[s.length()];
		int cnd = 0;
		T[0] = -1;
		T[1] = 0;
		int pos = 2;
		
		while (pos < s.length())
		{
			if (s.charAt(pos - 1) == s.charAt(cnd))
			{
				T[pos] = cnd + 1;
				pos += 1;
				cnd += 1;
			}
			else if (cnd > 0)
			{
				cnd = T[cnd];
			}
			else
			{
				T[pos] = 0;
				pos += 1;
			}
		}
		return T;
	}
}
