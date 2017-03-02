package sri.snippets.hackertests;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256Create
{
	public static void main(String[] args) throws NoSuchAlgorithmException
    {
        Scanner scanner = new Scanner(System.in);
        String inStr = scanner.nextLine();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        byte[] hashedStr = digest.digest(inStr.getBytes(StandardCharsets.UTF_8));
        System.out.println(String.format("%064x", new java.math.BigInteger(1, hashedStr)));
        scanner.close();
    }
}
