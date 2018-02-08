/*

NumberPrinter.java
Author: Kevin Gao

This class is used to recursively print a triangular shape of numbers.
*/

public class NumberPrinter
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("usage: java NumberPrinter <int>");
			System.exit(0);
		}
		else
		{
			// Data Members
			String output = "";

			// Make sure that input is an integer
			try
			{
				int num = Integer.parseInt(args[0]);

				// Print triangle
				printTriangleStructure(num, 0, false);
			}
			catch (Exception e)
			{
				System.out.println("You did not input a valid integer!");
				System.exit(0);
			}
		}
	}

	public static void printTriangleRow(int num, int count, int size)
	{
		// Recursively print the row of numbers with the given length (size)
		if (count < size)
		{
			System.out.print(count);
			count++;
			printTriangleRow(num, count, size);
		}
		else
		{
			return;
		}
	}

	public static void printTriangleStructure(int num, int size, boolean halfGenerated)
	{
		// If input is invalid, return
		if (num < 0)
		{
			System.out.println("Invalid Input");
			return;
		}
		
		// Check to see if top half of triangle has already been printed
		if (size > (num + 1))
		{
			halfGenerated = true;
			size--;
		}

		// If top half has already been printed, 
		// 		print bottom half of triangle (iterating down until done)
		if (halfGenerated == true && size > 0)
		{
			printTriangleRow(num, 0, size - 1);
			System.out.println();

			printTriangleStructure(num, size - 1, true);
		}
		// Print top half (iterating integers up until done)
		else if (size <= (num + 1) && halfGenerated == false)
		{
			printTriangleRow(num, 0, size);
			System.out.println();

			printTriangleStructure(num, size + 1, false);
		}
		else
		{
			return;
		}
	}
}