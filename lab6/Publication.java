/*

Publication.java
Author: Kevin Gao

This class is used as a super class for the Book and Magazine classes to inherit properties from
*/

public abstract class Publication implements Comparable<Publication>
{	
	// Data Members
	String title;
	int numOfPages;

	/**
		* Constructor
	**/
	public Publication(String title, int numOfPages)
	{
		this.title = title;
		this.numOfPages = numOfPages;
	}

	// compareTo method
	public int compareTo(Publication p1)
	{
		// If value is equal to value of compared instance
		if (numOfPages == p1.numOfPages)
		{
			return 0;
		}
		// If value is greater than value of compared instance
		else if (numOfPages > p1.numOfPages)
		{
			return 1;
		}
		// If value is less than value of compared instance
		else
		{
			return -1;
		}
	}
}