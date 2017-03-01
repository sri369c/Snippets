package sri.snippets.patterns;

import java.text.ParseException;

public class PhoneNumberFormatter
{
	public static void main (String[] args) throws ParseException
	{
		System.out.println(new PhoneNumberFormatter().getFormattedPhoneNumber("999999999"));
		System.out.println(new PhoneNumberFormatter().getFormattedPhoneNumber("9999999999"));
	    System.out.println(new PhoneNumberFormatter().getFormattedPhoneNumber("99999999999"));
	    System.out.println(new PhoneNumberFormatter().getFormattedPhoneNumber("999999999999"));
	    System.out.println(new PhoneNumberFormatter().getFormattedPhoneNumber("9999999999999"));
	    System.out.println(new PhoneNumberFormatter().getFormattedPhoneNumber("99999999999999"));
	    System.out.println(new PhoneNumberFormatter().getFormattedPhoneNumber("999999999999999"));
	    System.out.println(new PhoneNumberFormatter().getFormattedPhoneNumber("9999999999999999"));
	    System.out.println(new PhoneNumberFormatter().getFormattedPhoneNumber("99999999999999999"));
	}
	
	public String getFormattedPhoneNumber(String phoneDigitsOnlyWithOptExt)
	{
		if (phoneDigitsOnlyWithOptExt.length() < 10 || phoneDigitsOnlyWithOptExt.length() > 16)
			return "Number of digits in phone number supplied is not between 10 and 16.";
		else if (phoneDigitsOnlyWithOptExt.length() == 10)
			return String.valueOf(phoneDigitsOnlyWithOptExt).replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
		else
			return String.valueOf(phoneDigitsOnlyWithOptExt).replaceFirst("(\\d{3})(\\d{3})(\\d{4})(\\d+)", "$1-$2-$3 $4");
	}
}
