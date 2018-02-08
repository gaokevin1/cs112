/*

SourceLines.java
Author: Kevin Gao

This class is used to get the number of source lines with 
	comments in a given java file.
*/

import java.io.*;
import java.util.ArrayList;

public class SourceLines
{	
	// Data Members
	ArrayList<File> files;
	ArrayList<Integer> numLines;
	int lines;

	/**
		* Constructor
	**/
	public SourceLines(ArrayList<File> files)
	{	
		this.files = files;
		numLines = new ArrayList<Integer>();
		lines = 0;
	}

	public void gatherSourceLines(File input)
	{
		// Data Members
		int lines = 0;
		BufferedReader reader = null;

		try
		{
			// Read text from java class file
			reader = new BufferedReader(new FileReader(input.getAbsolutePath()));
			
			// Increase count of lines, for every line found that is not null
			while (reader.readLine() != null) 
			{
				lines++;
			}

			// Close reader
			reader.close();

			// Add count of lines without comments to ArrayList
			numLines.add(lines);
		}
		catch (IOException ioe)
		{

		}
	}

	public ArrayList<Integer> sourceLinesFinder()
	{
		// Run through all files
		for (int i = 0; i < files.size(); i++)
		{
			gatherSourceLines(files.get(i));
		}

		// Return numLines
		return numLines;
	}
}