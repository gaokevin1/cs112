/*

Sorter.java
Author: Kevin Gao

This class prints the contents of words.txt in order smallest to largest and largest to smallest.
*/

import java.util.Collections;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sorter
{
	public static void main (String[] args)
	{
		// Creates a new arraylist to store the different words
		ArrayList<String> words = new ArrayList<String>();

		// Try and catch exception
		try
		{
			// Creates a BufferedReader object to read from a file
			BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
			// String variable to store read text from file
			String input;

			// Reads in each line as a new word and stores it into the "words" ArrayList
			while ((input = reader.readLine()) != null)
			{
				words.add(input);
			}
		} 
		catch (IOException e)
		{
			System.out.println("Uh oh! Something is wrong with the file...");
		}

		// Sorts the ArrayList in alphabetical order
		Collections.sort(words);

		System.out.println("Alphabetical A-Z: ");

		// Displays the ArrayList in alphabetical order
		for (int i = 0; i < words.size(); i++)
		{
			System.out.println(words.get(i));
		}

		System.out.println("\nAlphabetical Z-A: ");

		// Displays the ArrayList in reverse alphabetical order
		for (int i = words.size() - 1; i >= 0; i--)
		{
			System.out.println(words.get(i));
		}
	}
}