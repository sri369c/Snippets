package sri.snippets.hackertests;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyConverter
{
	public static void main(String[] args) 
    {
//        Scanner scanner = new Scanner(System.in);
//        double payment = scanner.nextDouble();
//        scanner.close();

        double payment =200.0;
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
