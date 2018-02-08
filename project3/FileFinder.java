/*

FileFinder.java
Author: Kevin Gao

This class is used to gather all java files in a given directory.
*/

import java.io.File;
import java.util.ArrayList;

public class FileFinder
{
	// Data Members
	String directory;
	ArrayList<File> files;

	/**
		* Constructor
	**/
	public FileFinder(String directory)
	{
		this.directory = directory;
		files = new ArrayList<File>();
	}	

	public void gatherFiles(File input)
	{
		// If valid file
		if (input.isFile())
		{
			String extension = "";

			// Get extension from file
			int i = input.getName().lastIndexOf('.');
			
			// If valid extension exists
			if (i > 0) 
			{
				extension = input.getName().substring(i + 1);

				// Only add java files to "files" ArrayList
				if (extension.equals("java"))
				{
					files.add(input);
				}
			}
		}
		else
		{
			File[] children = input.listFiles();

			// Recursively call method to get extensions of all files in directory
			for (File f : children) 
			{
				gatherFiles(f);
			}
		}
	}

	public ArrayList<File> findFiles()
	{
		gatherFiles(new File(directory));

		// Return files
		return files;
	}
}