package sri.snippets.hackertests;

import java.util.Scanner;

public class PalindromeCheck
{
	public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int n = A.length();
        boolean isPalindrome = true;
        for (int i = 0; i < (n/2); ++i) 
        {
            if (A.charAt(i) != A.charAt(n - i - 1)) 
            {
                isPalindrome = false;
                break;
            }  
        }
        System.out.println(isPalindrome ? "Yes" : "No");
        sc.close();
    }
}
