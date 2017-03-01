package sri.snippets.hackertests;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions1
{
	public static void main(String[] args) 
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            String x = scanner.next();
            String y = scanner.next();
            scanner.close();
            
            try
            {
                if (Long.parseLong(x) < 0 || Long.parseLong(x) > 2147483647)
                    throw new InputMismatchException();
                if (Long.parseLong(y) < 0 || Long.parseLong(y) > 2147483647)
                    throw new InputMismatchException();
            }catch(Exception e)
            {
                throw new InputMismatchException();
            }
            
            int ix = Integer.parseInt(x);
            int iy = Integer.parseInt(y);
            
            System.out.println(ix/iy);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
