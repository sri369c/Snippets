package sri.snippets.hackertests;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class BigInteger2
{
	public static void main(String[] args)
    {
		String[] s = {
				"9",
				"-100",
				"50",
				"0",
				"56.6",
				"90",
				"0.12",
				".12",
				"02.34",
				"000.000"
		};
		
		int n = s.length;

		// method 1
//		Arrays.sort(s, new Comparator<Object>() {
//		       @Override
//		       public int compare(Object bd1, Object bd2) 
//		       {
//		           return ((new BigDecimal((String)bd2)).compareTo(new BigDecimal((String)bd1)));
//		       }
//		});
		
		// method 2
		for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                if((new BigDecimal((String)s[i])) .compareTo(new BigDecimal((String)s[j])) == -1)
                {
                    String temp = s[j];
                    s[j] = s[i];
                    s[i] = temp;
                }
            }
        }
		
        for(int i=0;i<s.length;i++)
            System.out.println(s[i]);
    }
}
