/*

Counter.java
Author: Kevin Gao

This class contains methods for a Counter object in which 
	the user can increase, reset, or get the current count.
*/

public class Counter
{
	// Data Members
	int count;

	/**
		* Constructor
	**/
	public Counter()
	{
		this.count = 0;
	}

	/**
		* Adds 1 to the current count
	**/
	public void click()
	{
		count++;
	}

	/**
		* Get the count
	**/
	public int getCount()
	{
		return count;
	}

	/**
		* Resets the count
	**/
	public void reset()
	{
		count = 0;
	}
}