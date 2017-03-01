package sri.snippets.misc;

import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Hashtests
{

	public static void main(String[] args)
	{
		long startTime, endTime;
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>(100000);
		for (int i=0; i<100001; i++)
			hm.put(i, "gFn8mTHKlPrd98dVZOziIK0No5TwJUOBOQ0gtpCepBbHMnyI9Stp4S9hG553H5xtBivN0ofDBRvxCQCEaALCpH7UhhYonQVMTRpN4EG980vH1heGRzVT6zJ0GI1Zk6ySFQRiUWH0qH2LThJjb45tSTwq245887b1L5VJvW5fqCfdU7G7UCSS4DLSfizN4TeCbh8uHnsJhArKFFYGETG6g9REccXC1LkGGphQmu8mfTd2oHYC3XXafgRtiuxgGjetEEqYULmIQZLADo8RfyXN0AjEiZmU0tZx8jgp2PKGgbA0: --------- " + i);
		startTime = Calendar.getInstance().getTimeInMillis();
		System.out.println(hm.get(91000));
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("1 -------------------- startTime: " + startTime);
		System.out.println("1 -------------------- endTime: " + endTime);
		Runtime.getRuntime().gc();
		Runtime.getRuntime().gc();
		
		ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<Integer, String>(100000);
		for (int i=0; i<100001; i++)
			chm.put(i, "m2GlATHte4ksd6v8QWjTfaCCME0BZTcjk9GMyu1CPOWPKwySUMbtJ1fSF0RrLSoJyzjJ4k56P9CbHfgP0lNOMrRkh7foFTsv97i0Vi0Zy08DOMEUmiD59Lus0HNABxScqgJ8qPNyVlEmKA75o8WdvvUBX0v8Pl90878ktRxr780epP2uDJfp0MzTkpJp17Vt5MzsHTLfrikJumpCQemN78xiO0iyhyhtWJkrWv9cq7O69VPWzasuLzP1oC4eE4qjeFAO1Zr9dHQI9DOIISrFCSYaiUxHFUwaKupzCdDQcViK: --------- " + i);
		startTime = Calendar.getInstance().getTimeInMillis();
		System.out.println(chm.get(93000));
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("2 -------------------- startTime: " + startTime);
		System.out.println("2 -------------------- endTime: " + endTime);
		
		Runtime.getRuntime().gc();
		Runtime.getRuntime().gc();
	}
	
}
