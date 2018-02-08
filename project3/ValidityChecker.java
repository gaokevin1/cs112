/*

ValidityChecker.java
Author: Kevin Gao

This class is used to find all invalid classes in a given directory.
*/

import java.io.*;
import java.util.ArrayList;

public class ValidityChecker
{
	// Data Members
	ArrayList<File> files;
	ArrayList<File> invalidFiles;

	/**
		* Constructor
	**/
	public ValidityChecker(ArrayList<File> files)
	{
		this.files = files;
		invalidFiles = new ArrayList<File>();
	}

	public void gatherInvalidFiles(File input)
	{
		try
		{
			// Data Members
			String header = "", fileName = "";
			
			// Read text from java class file
			BufferedReader reader = new BufferedReader(new FileReader(input.getAbsolutePath()));

			while ((header = reader.readLine()) != null)
			{
				header = header.trim();

				// First time class access modifier appears
				if (header.contains("public") || header.contains("protected")
						|| header.contains("private"))
				{
					break;
				}
			}

			reader.close();
				
			// Get filename of java class file
			fileName = input.getName();
			fileName = fileName.substring(0, fileName.lastIndexOf('.'));

			// Compare filename to first line of java class file
			if (!header.contains(fileName))
			{
				invalidFiles.add(input);
			}
		}
		catch (IOException ioe)
		{

		}
	}

	public ArrayList<File> invalidFilesFinder()
	{
		// Run through all files
		for (int i = 0; i < files.size(); i++)
		{
			gatherInvalidFiles(files.get(i));
		}

		// Return invalidFiles ArrayList
		return invalidFiles;
	}
}