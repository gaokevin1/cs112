/*

SourceLinesComments.java
Author: Kevin Gao

This class is used to get the number of source lines without 
	comments in a given java file.
*/

import java.io.*;
import java.util.ArrayList;

public class SourceLinesComments
{
	// Data Members
	ArrayList<File> files;
	ArrayList<Integer> numLinesNoCom;
	int lines, commentLines;
	boolean commentStarted;

	/**
		* Constructor
	**/
	public SourceLinesComments(ArrayList<File> files)
	{	
		this.files = files;
		numLinesNoCom = new ArrayList<Integer>();
		lines = 0;
		commentLines = 0;
		commentStarted = false;
	}

	public ArrayList<Integer> sourceLinesNoComFinder()
	{
		// Run through all files
		for (int i = 0; i < files.size(); i++)
		{
			// Reset line and comment line count
			lines = 0;
			commentLines = 0;

			gatherSourceLinesNoCom(files.get(i));
		}

		// Return ArrayList with number of comments of each class
		return numLinesNoCom;
	}

	public void gatherSourceLinesNoCom(File input)
	{
		// Data Members
		boolean sameLine = false;
		String line = "";
		BufferedReader reader = null;

		try
		{
			// Read text from java class file
			reader = new BufferedReader(new FileReader(input.getAbsolutePath()));

			// While line has valid text
			while ((line = reader.readLine()) != null) 
			{
				line = line.trim();


				// Set string to "empty" so it can pass through while loop
				if (line.isEmpty())
				{
					line = "empty";
				}

				// If there is a multi-line comment
				while (line != null && line.length() > 0)
				{
					line = analyzeLine(line);
				}
			}
		}
		catch (IOException e)
		{

		}
		finally
		{
			try
			{
				// Close reader and add line count to ArrayList
				if (reader != null)
				{
					reader.close();
					numLinesNoCom.add(lines);
				}
			}
			catch (IOException ex)
			{

			}
		}
	}

	public String analyzeLine(String currentLine)
	{
		// If multi-line comment starts
		if (currentLine.contains("/*"))
		{
			// Set boolean to show that multi-line comment has started
			commentStarted = true;

			// Add to commentLines count
			commentLines++;

			// If multi-line comment ends on same line
			if (currentLine.contains("*/"))
			{
				// Set boolean to show that multi-line comment has ended
				commentStarted = false;

				// Set currentLine equal to null, to escape while loop
				currentLine = null;
			}
			else
			{	
				// Set currentLine equal to null, to escape while loop
				currentLine = null;
			}
		}
		// If multi-line comment ends
		else if (commentStarted && currentLine.contains("*/"))
		{
			// Add to commentLines count
			commentLines++;

			// Set boolean to show that multi-line comment has ended
			commentStarted = false;

			// Set currentLine equal to null, to escape while loop
			currentLine = null;
		}
		// If single line comment starts
		else if (currentLine.startsWith("//"))
		{
			// Add to commentLines count
			commentLines++;

			// Set currentLine equal to null, to escape while loop
			currentLine = null;
		}
		// If multi-line comment has not ended yet
		else if (commentStarted)
		{
			// Add to commentLines count
			commentLines++;

			// Set currentLine equal to null, to escape while loop
			currentLine = null;
		}
		// If regular line
		else
		{
			// Set boolean to show that multi-line comment has ended
			commentStarted = false;

			// Add to lines count
			lines++;

			// Set currentLine equal to null, to escape while loop
			currentLine = null;
		}

		// Return currentLine
		return currentLine;
	}
}