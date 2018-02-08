/*

Book.java
Author: Kevin Gao

This class is used to contain the properties of Book objects
*/

public class Book extends Publication
{	
	// Data Members
	boolean isHardCover;

	/**
		* Constructor
	**/
	public Book(String title, int numOfPages, boolean isHardCover)
	{
		super(title, numOfPages);

		this.isHardCover = isHardCover;
	}

	public String toString()
	{
		String hardOrSoft = "";

		// Determine whether or not the book is a hard or soft cover by the boolean
		if (isHardCover == true)
		{
			hardOrSoft = "HARD COVER";
		}
		else
		{
			hardOrSoft = "SOFT COVER";
		}

		String output = "Title: " + title + " - Number of Pages: " + numOfPages + " - Cover of Book: " + hardOrSoft;

		// Return output
		return output;
	}
}