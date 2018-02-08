/*

PalindromeTester.java
Author: Kevin Gao

This class is used to test whether or not a word is a palindrome.
*/

public class PalindromeTester
{
	public static void main(String[] args)
	{
		// If invalid console input
		if (args.length != 1)
		{
			System.out.println("usage: java PalindromeTester <word>");
			System.exit(0);
		}
		else
		{
			// Data Members
			boolean isPalindrome = isPalindrome(args[0]);

			// Display whether true or false
			if (isPalindrome == true)
			{
				System.out.println(args[0] + " is a palindrome.");
			}
			else
			{
				System.out.println(args[0] + " is not a palindrome.");
			}
		}
	}

	public static boolean isPalindrome(String word)
	{
		// If length is 1 character, then return true
		if (word.length() == 1)
		{
			return true;
		}
		// Recursively call the method again, checking if the next character matches the end of the word
		else if (word.charAt(0) == word.charAt(word.length() - 1))
		{
			return isPalindrome(word.substring(1, word.length() - 1));
		}
		// Otherwise return false
		else
		{
			return false;
		}
	}
}