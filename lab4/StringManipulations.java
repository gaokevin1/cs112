/*

StringManipulations.java
Author: Kevin Gao

This class returns specific information about a user inputted string passed through the class.
*/

import java.util.ArrayList;

public class StringManipulations
{
	/**
 	* Returns a count of the number of times the character
 	* c appears in the String original.
 	* 
 	* Example: "hello there", 'e' -> 3
 	* Example: "hello there", 'z' -> 0
 	* 
 	* @param original
 	* @param c
 	* @return
 	*/
	public int countChars(String original, char c) 
	{
		// Data Members
		int count = 0;

		// Adds one to the count for every additional character 'c' found in phrase
		for (int i = 0; i < original.length(); i++)
		{
			if (original.charAt(i) == c)
			{
				count++;
			}
		}

		return count;
	}

	/**
 	* Returns the length of the longest word in a given sentence.
 	* 
 	* Example: "I love CS" returns 4 (length of 'love')
 	* Example: "Hi, there!" returns 6 (length of 'there!')
 	* 
 	* Any whitespace character (spaces, tabs, etc) separates words.
 	* For full credit, solution may *only* use the following methods:
 	* String .length()
 	* String .charAt(index)
 	* Character.isWhitespace(character)
 	* 
 	* @param original
 	* @return
 	*/
	public int longestWord(String original) 
	{
		// Data Members
		ArrayList<String> words = new ArrayList<String>();
		int length = 0, startPosition = 0, highestCount = 0;
		String word = "";

		// Adds each word of the phrase to the ArrayList "words"
		for (int i = 0; i < original.length(); i++)
		{
			if (Character.isWhitespace(original.charAt(i)))
			{
				// Gets each word from the big phrase string
				word = original.substring(startPosition, i);
				
				// Creates a new start position after the whitespace character
				startPosition = i + 1;

				// Adds each word to the ArrayList "words"
				words.add(word);
			}
		}

		// Adds the last word of the phrase to the ArrayList "words"
		word = original.substring(startPosition, original.length());
		words.add(word);

		// Finds the longest word in the ArrayList and records the length of it in a variable
		for (int i = 0; i < words.size(); i++)
		{
			word = words.get(i);

			if (word.length() > highestCount)
			{
				highestCount = word.length();
			}
		}

		// Returns length of longest word
		return highestCount;
	}
}