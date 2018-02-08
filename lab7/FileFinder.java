/*

FileFinder.java
Author: Kevin Gao

This class is used to find the number of files with a specific extension
	in a given directory.
*/

import java.io.File;
import java.util.HashMap;

public class FileFinder
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("usage: java FileFinder <absolute_path>");
			System.exit(0);
		}
		else
		{
			// Create new HashMap to store information
			HashMap<String, Integer> result = findFiles(args[0]);

			// Print counts of each type of file in console
			for (String key: result.keySet())
			{
				if (result.get(key) != 0)
				{
					System.out.println(key + " files: " + result.get(key));
				}
			}
		}
	}

	public static void countFilesDirs(File input, HashMap<String, Integer> result)
	{
		// If valid file
		if (input.isFile())
		{
			String extension = "other";

			// Get extension from file
			int i = input.getName().lastIndexOf('.');
		
			if (i > 0) 
			{
				extension = input.getName().substring(i + 1);
			}
			else
			{
				// Ignore ".DS_Store" files
				if (input.getName().equals(".DS_Store"))
				{
					result.put(extension, -1);
				}
				else
				{
					result.put(extension, 0);
				}
			}

			// Add to the count of a specific extension
			if (result.containsKey(extension))
			{
				int value = result.get(extension);
				value++;

				result.put(extension, value);
			}
			else
			{
				result.put(extension, 1);
			}
		}
		else
		{
			File[] children = input.listFiles();

			// Recursively call method to get extensions of all files in directory
			for (File f : children) 
			{
				countFilesDirs(f, result);
			}
		}
	}

	public static HashMap<String, Integer> findFiles(String directory)
	{
		// Create a new HashMap to store number of files with different extensions
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		countFilesDirs(new File(directory), result);
		return result;
	}
}