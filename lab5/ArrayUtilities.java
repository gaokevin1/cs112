/*

ArrayUtilities.java
Author: Kevin Gao

This class is used with utility methods for manipulating one and two dimensional 
		arrays of characters.
*/

public class ArrayUtilities 
{ 

	/**
		Determines whether the 2D array is square. The array 
		is square if the length of every row is the same. 
		Returns true if the array is square and false
		otherwise. The solution may not make any assumptions about
		the number of rows or columns in original.		
	**/
	public static boolean isSquare(char[][] original) 
	{
		// Creates a boolean variable to return
		boolean isSquare = true;

		// Goes through each row and column and compares the lengths of each
		for (int i = 0; i < original.length; i++)
		{
			for (int j = 0; j < original[i].length; j++)
			{
				// If the number of rows equals the number of columns
				if (original.length != original[i].length)
				{
					isSquare = false;
				}
			}
		}

		// Returns if original array is square
		return isSquare;
	}

	/**
		Converts a two dimensional array of char to a one 
		dimensional array of char. This method may assume
		that all subarrays of the original are of the same
		length.
		Returns the one dimensional array.
		Example input: 
		[['a', 'b', 'c']
		 ['e', 'd', 'f']
		 ['i', 'h', 'g']]
		 Example output:
		 ['a', 'b', 'c', 'e', 'd', 'f', 'i', 'h', 'g']
	**/
	public static char[] to1D(char[][] original) 
	{
		// Length of new one-dimensional array
		int newArrayLength = original.length * original[0].length;
		int k = 0;
		// Creates a new array to store elements from original array
		char[] newArray = new char[newArrayLength];

		// Goes through each row and column and adds each element to newArray[]
		for (int i = 0; i < original.length; i++)
		{
			for (int j = 0; j < original[i].length; j++)
			{
				newArray[k] = original[i][j];
				k++;
			}
		}

		// Returns new one-dimensional array
		return newArray;
	}

	/**
		Finds the char with the smallest value in each row
		of the original and returns an array containing the 
		values found. the result at position [0] will be the
		smallest valued char in row 0 of original.
		This method does NOT assume that all subarrays of the
		original are of the same length.
		Example input:
		[['e', 'c', 'f', 'g', 'c', 'e']
		 ['b', 'b', 'b', 'b']
		 ['a', 'd']
		 ['d', 'c', 'b']]
		Example output:
		['c', 'b', 'a', 'b']
	**/
	public static char[] smallestPerRow(char[][] original) 
	{
		// Data Members
		char currentLowest = 'z';
		// Creates a new array to store elements from original array
		char[] newArray = new char[original.length];

		// Adds Smallest Value to newArray[]
		for (int i = 0; i < original.length; i++)
		{
			for (int j = 0; j < original[i].length; j++)
			{
				if (original[i][j] < currentLowest)
				{
					currentLowest = original[i][j];
				}
			}

			newArray[i] = currentLowest;
			currentLowest = 'z';
		}

		// Returns new one-dimensional array
		return newArray;
	}

}