/*

StringManipulationsDriver.java
Author: Kevin Gao

This class creates a StringManipulations object and tests the methods of the object.
*/

public class StringManipulationsDriver 
{
	public static void main (String[] args)
	{
		// Creates a new StringManipulations object
		StringManipulations sm1 = new StringManipulations();

		// Prints out number of given letters in a word
		System.out.println("The count is: " + sm1.countChars("hello there", 'z'));

		// Prints out the longest word in the given phrase
		System.out.println("The length of the longest word in the sentence is: " + sm1.longestWord("Hi, there!"));
	}
}