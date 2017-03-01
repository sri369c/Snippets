package sri.snippets.misc;

import java.io.File;

public class DirectoryLister
{
	public static void main(String[] args)
	{
		String basePath = "C:\\Windows";

		String files;
		File folder = new File(basePath);
		System.out.println("Path: " + folder.getAbsolutePath());
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++)
		{
			if (listOfFiles[i].isFile())
			{
				files = listOfFiles[i].getName();
//				if (files.endsWith(".log") || files.endsWith(".txt"))
				System.out.println(files);
			}
		}
	}
}
