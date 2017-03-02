package sri.snippets.hackertests;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Scanner;

public class MD5Create
{
	public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        String inStr = scanner.nextLine();
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        byte[] hashedBytes = digest.digest(inStr.getBytes(StandardCharsets.UTF_8));
        StringBuffer sb = new StringBuffer();
		for (byte b : hashedBytes)
			sb.append(String.format("%02x", b & 0xff));
		System.out.println(sb.toString());
        scanner.close();
    }
}
