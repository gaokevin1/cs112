/*

MovieDriver.java
Author: Kevin Gao

This class creates three distinct movie objects and displays information about each in the console.
*/

public class MovieDriver
{
	/**
		* Main Method
	**/
	public static void main (String[] args)
	{
		// Setting up new Movie objects
		Movie m1 = new Movie("The Godfather", 180, 45000000);
		Movie m2 = new Movie("Meet the Parents", 100, 8900000);
		Movie m3 = new Movie("Twilight", 70);
        
        // Printing information about each movie object
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}
}
