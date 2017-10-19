/*

Movie.java
Author: Kevin Gao

This class contains two constructors and returns information about each movie object.
*/

public class Movie
{
	// Data Members
	private String title;
	private int duration;
	private long budget;
	private String lengthString;

	/**
		* Constructor
	**/
	public Movie(String title, int duration, long budget)
	{
		this.title = title;
		this.duration = duration;
		this.budget = budget;
	}

	/**
		* Constructor
	**/
	public Movie(String title, int duration)
	{
		this.title = title;
		this.duration = duration;
		this.budget = 0;
	}

	/**
		* Get the title
	**/
	public String getTitle()
	{
		return title;
		// return this.title;
	}

	/**
		* Get the duration
	**/
	public int getDuration()
	{
		return duration;
		// return this.duration;
	}

	/**
		* Get the budget
	**/
	public long getBudget()
	{
		return budget;
		// return this.budget;
	}

	/**
		* Updates the title
	**/
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}

	/**
		* Updates the duration
	**/
	public void setDuration(int newDuration)
	{
		duration = newDuration;
	}

	/**
		* Updates the budget
	**/
	public void setBudget(long newBudget)
	{
		budget = newBudget;
	}

	/**
		* Return a string representation of a movie object
	**/
	public String toString()
	{
		lengthString = "average";

		// Describing length of movie in words rather than an integer
		if (duration > 120)
		{
			lengthString = "long";
		}
		else if (duration < 90)
		{
			lengthString = "short";
		}

		return (title + " - Budget: $" + budget + " Length: " + lengthString);
	}
}