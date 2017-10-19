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
	private double imdbScore;

	/**
		* Constructor
	**/
	public Movie(String title, int duration, long budget, double imdbScore)
	{
		this.title = title;
		this.duration = duration;
		this.budget = budget;
		this.imdbScore = imdbScore;
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
		* Get the IMDB Score
	**/
	public double getImdbScore()
	{
		return imdbScore;
		// return this.imdbScore;
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

		return (title + " - Budget: $" + budget + " IMDB Score: " + imdbScore + " Length: " + lengthString);
	}
}