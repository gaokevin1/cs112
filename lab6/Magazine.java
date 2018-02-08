/*

Magazine.java
Author: Kevin Gao

This class is used to contain the properties of Magazine objects
*/

public class Magazine extends Publication
{
	// Data Members
	int numOfSubscribers;

	/**
		* Constructor
	**/
	public Magazine(String title, int numOfPages, int numOfSubscribers)
	{
		super(title, numOfPages);

		this.numOfSubscribers = numOfSubscribers;
	}

	public String toString()
	{
		String output = "Title: " + title + " - Number of Pages: " + numOfPages + " - Number of Subscribers: " + numOfSubscribers;

		// Return output
		return output;
	}
}