/*

JavaClassAnalyzer.java
Author: Kevin Gao

This class is used process all class files in a given directory and 
	determine various information about the classes.
*/

import java.io.File;
import java.util.ArrayList;

public class JavaClassAnalyzer
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("usage: java JavaClassAnalyzer <absolute_path>");
			System.exit(0);
		}
		else
		{
			// Data Members
			int sum = 0, sumNoC = 0;
			ArrayList<File> files = new ArrayList<File>();
			ArrayList<Integer> sourceLines = new ArrayList<Integer>();
			ArrayList<Integer> sourceLinesNoCom = new ArrayList<Integer>();
			ArrayList<File> invalidFiles = new ArrayList<File>();

			// Creates a new reference of FileFinder, with the given directory
			FileFinder f1 = new FileFinder(args[0]);

			// Gets an ArrayList of all the java files in the given directory
			files = f1.findFiles();

			// Creates a new reference of SourceLines, with the given files
			SourceLines sl1 = new SourceLines(files);
			// Creates a new reference of SourceLines, with the given files
			SourceLinesComments sc1 = new SourceLinesComments(files);
			// Creates a new reference of ValidityChecker, with the given files
			ValidityChecker vc1 = new ValidityChecker(files);

			// Gets an ArrayList of the number of SLOC in each class
			sourceLines = sl1.sourceLinesFinder();

			// Gets an ArrayList of the number of SLOC (excluding comments) in each class
			sourceLinesNoCom = sc1.sourceLinesNoComFinder();

			// Gets an ArrayList of all the invalid files found
			invalidFiles = vc1.invalidFilesFinder();

			// Calculate sum of all SLOC
			for (int i = 0; i < sourceLines.size(); i++)
			{
				int tempSum = sourceLines.get(i);
				sum += tempSum;
			}

			// Calculate sum of all SLOC (excluding comments)
			for (int i = 0; i < sourceLinesNoCom.size(); i++)
			{
				int tempSum = sourceLinesNoCom.get(i);
				sumNoC += tempSum;
			}

			System.out.println();

			// Display the number of valid classes in the given directory
			int numValidClasses = files.size() - invalidFiles.size();
			System.out.println("Valid Classes - Total: " + numValidClasses);

			// Display the number of SLOC and SLOC (excluding comments) for each class
			for (int i = 0; i < sourceLines.size(); i++)
			{
				// Get filename
				String fileName = files.get(i).getName();
				int pos = fileName.indexOf(".");
				fileName = fileName.substring(0, pos);

				System.out.println("Class: " + fileName + " [" + files.get(i).getAbsolutePath() + "]");
				System.out.println("       SLOC: " + sourceLines.get(i));
				System.out.println("       SLOC (excluding comments): " + sourceLinesNoCom.get(i));
			}

			// Display the sum of all SLOC and SLOC (excluding comments) for all classes
			System.out.println("Total SLOC: " + sum);
			System.out.println("Total SLOC (excluding comments): " + sumNoC);

			// Display all invalid classes in the given directory
			System.out.println("Invalid Classes: ");

			for (int i = 0; i < invalidFiles.size(); i++)
			{
				System.out.println(invalidFiles.get(i).getAbsolutePath());
			}
		}
	}
}