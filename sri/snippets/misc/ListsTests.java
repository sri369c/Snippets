package sri.snippets.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListsTests
{
	public static void main(String[] args)
	{
		String[] oldValues = {"1", "2", "3", "4", "5"};
		String[] newValues = {"1", "2", "4", "5", "6"};
		
		List<String> oldValuesList = new ArrayList<String>(Arrays.asList(oldValues));
		List<String> newValuesList = new ArrayList<String>(Arrays.asList(newValues));

		List<String> deletionList = new ArrayList<String>(oldValuesList);
		deletionList.removeAll(newValuesList);
		System.out.println(Arrays.toString(deletionList.toArray()));
		
		List<String> insertionList = new ArrayList<String>(newValuesList);
		insertionList.removeAll(oldValuesList);
		System.out.println(Arrays.toString(insertionList.toArray()));
	}
}
