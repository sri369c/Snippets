package sri.snippets.hackertests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Permission;

/**
 You are given a class Solution and its main method in the editor. In each test cases, it takes an input which represents a choice of the following:

    represents the volume of a cube that has to be calculated where represents the length of the sides of the cube.
    represents the volume of a cuboid that has to be calculated where represent the dimensions of a cuboid.
    represents the volume of a hemisphere that has to be calculated where represents the radius of a hemisphere.
    represents the volume of a cylinder that has to be calculated where represent the radius and height of the cylinder respectively.

Your task is to create the class Calculate and the required methods so that the code prints the volume of the figures rounded to exactly decimal places.

In case any of the dimensions of the figures are , print "java.lang.NumberFormatException: All the values must be positive" without quotes and terminate the program.

Note: Use Math.PI or as the value of pi.

Input Format

First line contains , the number of test cases. Each test case contains ch, representing the choice as given in the problem statement.

    When ch=1, Next line contains , length of the sides of the cube.
    When ch=2, Next three lines contain , , representing length, breadth and height of the cuboid respectively. , , will be in three separate lines
    When ch=3, Next line contains , the radius of the hemisphere
    When ch=4, Next two lines contain , representing the radius and height of the cylinder respectively. , will be in two separate lines.

Note: You have to determine the data type of each parameter by looking at the code given in the main method.

Constraints


There will be at most digits after decimal point in input.

Output Format

For each test case, print the answer rounded up to exactly 3 decimal places in a single line. For example, 1.2345 should be rounded to 1.235, 3.12995 should be rounded to 3.130.

Sample Input 1

2
1
4
4
67.89
-98.54

Sample Output 1

64.000
java.lang.NumberFormatException: All the values must be positive
 */

class Calculate
{
	BufferedReader br;
	Output output = new Output();

	public Calculate()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public int get_int_val() throws NumberFormatException, IOException
	{
		int value = Integer.parseInt(br.readLine());
		if (value <= 0)
		{
			throwNumberFormatException();
		}
		return value;
	}

	public double get_double_val() throws NumberFormatException, IOException
	{
		double value = Double.parseDouble(br.readLine());
		if (value <= 0)
		{
			throwNumberFormatException();
		}
		return value;
	}

	public void throwNumberFormatException()
	{
		throw new NumberFormatException("All the values must be positive");
	}

	public static Calculate do_calc()
	{
		return new Calculate();
	}

	public double get_volume(int a)
	{
		return a * a * a;
	}

	public double get_volume(int l, int b, int h)
	{
		return l * b * h;
	}

	public double get_volume(double r)
	{
		return Math.PI * r * r * r * 2 / 3;
	}

	public double get_volume(double r, double h)
	{
		return Math.PI * r * r * h;
	}
}

class Output
{
	public void display(double volume)
	{
		System.out.printf("%.3f\n", volume);
	}
}

public class CalculateVolume
{

	public static void main(String[] args)
	{
		DoNotTerminate.forbidExit();
		try
		{
			Calculate cal = new Calculate();
			int T = cal.get_int_val();
			while (T-- > 0)
			{
				double volume = 0.0;
				int ch = cal.get_int_val();
				if (ch == 1)
				{
					int a = cal.get_int_val();
					volume = Calculate.do_calc().get_volume(a);
				}
				else if (ch == 2)
				{
					int l = cal.get_int_val();
					int b = cal.get_int_val();
					int h = cal.get_int_val();
					volume = Calculate.do_calc().get_volume(l, b, h);
				}
				else if (ch == 3)
				{
					double r = cal.get_double_val();
					volume = Calculate.do_calc().get_volume(r);
				}
				else if (ch == 4)
				{
					double r = cal.get_double_val();
					double h = cal.get_double_val();
					volume = Calculate.do_calc().get_volume(r, h);
				}
				cal.output.display(volume);
			}
		} catch (NumberFormatException e)
		{
			System.out.print(e);
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (DoNotTerminate.ExitTrappedException e)
		{
			System.out.println("Unsuccessful Termination!!");
		}

	} // end of main
} // end of Solution

/**
 * This class prevents the user form using System.exit(0) from terminating the program abnormally.
 *
 */
class DoNotTerminate
{

	@SuppressWarnings("serial")
	public static class ExitTrappedException extends SecurityException
	{
	}

	public static void forbidExit()
	{
		final SecurityManager securityManager = new SecurityManager()
		{
			@Override
			public void checkPermission(Permission permission)
			{
				if (permission.getName().contains("exitVM"))
				{
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
} // end of Do_Not_Terminate
