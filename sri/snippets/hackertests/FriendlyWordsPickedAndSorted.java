package sri.snippets.hackertests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FriendlyWordsPickedAndSorted
{
    static String[] friendlyWords(String[] input) 
    {
    	int wordCount = input.length;
    	List<String> outputStringList = new ArrayList<String>(wordCount); 
    	Set<String> totalWordSet= new HashSet<String>(); // so there are no duplicates added
    	
    	for (int i=0; i<wordCount; i++)
    	{
    		if (totalWordSet.contains(input[i]))
				continue;
    		
    		Set<String> wordSet= new HashSet<String>();
    		for (int j=1;j<wordCount;j++)
    		{
    			if (sameChars(input[i], input[j]))
    			{
   					wordSet.add(input[i]);
   					wordSet.add(input[j]);
    			}
    		}

    		if (! wordSet.isEmpty())
    		{
    			totalWordSet.addAll(wordSet);
    			outputStringList.add(String.join(" ", (new TreeSet<String>(wordSet))));
    		}
    	}
    	Collections.sort(outputStringList);
        return (String[]) outputStringList.toArray(new String[outputStringList.size()]);
    }
    
    private static boolean sameChars(String str1, String str2) 
    {
    	char[] str1Chars = str1.toCharArray();
    	char[] str2Chars = str2.toCharArray();
    	Arrays.sort(str1Chars);
    	Arrays.sort(str2Chars);
    	return Arrays.equals(str1Chars, str2Chars);
    }
    
    public static void main(String[] args) throws IOException 
    {
    	String[] wordsList = {"car", "cheating", "dale", "deal", "lead", "listen", "silent", "teaching"};
    	
    	System.out.println("Incoming words list: " + Arrays.toString(wordsList));
    	
    	System.out.println("\nFriendly words sets found (and listed alphabetically):");
    	for (String words : friendlyWords(wordsList)) 
            System.out.println(words);
    }
}
