/*

MovieList.java
Author: Kevin Gao

This class prints the contents of a MovieList object that contains many Movie objects
*/

import java.util.ArrayList;

public class MovieList
{
	// Data Members
	private ArrayList<Movie> l1;

	/**
		* Constructor
	**/
	public MovieList()
	{
		l1 = new ArrayList<Movie>();
	}

	// Adds each Movie object to the ArrayList "l1"
	public void addMovie(Movie movie)
	{
		l1.add(movie);
	}

	// Returns a string representation of the MovieList
	public String toString()
	{
		String movieList = "";

		for (int i = 0; i < l1.size(); i++)
		{
			movieList += l1.get(i).toString() + "\n";
		}

		return movieList;
	}

	// Returns the average budget of all Movie objects
	public double averageBudget()
	{	
		// Data Members
		long budget = 0;
		double budgetAvg = 0;

		// Adds up all budgets from every Movie object
		for (int i = 0; i < l1.size(); i++)
		{
			budget += l1.get(i).getBudget();
		}

		// Calculates average
		budgetAvg = (((long) budget) / (l1.size()));

		// Returns average
		return budgetAvg;
	}

	// Returns the average duration of all Movie objects
	public double averageDuration()
	{
		// Data Members
		int duration = 0;
		double durationAvg = 0;

		// Adds up all durations from every Movie object
		for (int i = 0; i < l1.size(); i++)
		{
			duration += l1.get(i).getDuration();
		}

		// Calculates average
		durationAvg = (duration / (l1.size()));

		// Returns average
		return durationAvg;
	}

	// Returns the average IMDB Score of all Movie objects
	public double averageScore()
	{
		// Data Members
		double imdbScore = 0;
		double imdbScoreAvg = 0;

		// Adds up all IMDB scores from every Movie object
		for (int i = 0; i < l1.size(); i++)
		{
			imdbScore += l1.get(i).getImdbScore();
		}

		// Calculates average
		imdbScoreAvg = (((double) imdbScore) / (l1.size()));

		// Returns average
		return imdbScoreAvg;
	}


	public String titleHighestBudget()
	{	
		// Data Members
		String title = "";
		long currentHighestBudget = 0;

		// Finds the Movie object with the highest budget
		for (int i = 0; i < l1.size(); i++)
		{
			if (l1.get(i).getBudget() > currentHighestBudget)
			{
				currentHighestBudget = l1.get(i).getBudget();
				title = l1.get(i).getTitle();
			}
		}

		// Returns title string
		return title;
	}

	public String titleLowestBudget()
	{
		// Data Members
		String title = "";
		long currentLowestBudget = l1.get(0).getBudget();

		// Finds the Movie object with the lowest budget
		for (int i = 0; i < l1.size(); i++)
		{
			if (l1.get(i).getBudget() < currentLowestBudget)
			{
				currentLowestBudget = l1.get(i).getBudget();
				title = l1.get(i).getTitle();
			}
		}

		// Returns title string
		return title;
	}

	public String titleShortestDuration()
	{
		// Data Members
		String title = "";
		int currentShortestDuration = l1.get(0).getDuration();

		// Finds the Movie object with the shortest duration
		for (int i = 0; i < l1.size(); i++)
		{
			if (l1.get(i).getDuration() < currentShortestDuration)
			{
				currentShortestDuration = l1.get(i).getDuration();
				title = l1.get(i).getTitle();
			}
		}

		// Returns title string
		return title;
	}

	public String titleLongestDuration()
	{
		// Data Members
		String title = "";
		int currentLongestDuration = 0;

		// Finds the Movie object with the longest duration
		for (int i = 0; i < l1.size(); i++)
		{
			if (l1.get(i).getDuration() > currentLongestDuration)
			{
				currentLongestDuration = l1.get(i).getDuration();
				title = l1.get(i).getTitle();
			}
		}

		// Returns title string
		return title;
	}

	public ArrayList<Movie> scoreGreaterThan(double score)
	{
		// Creates a new ArrayList object that will store the better movies
		ArrayList<Movie> betterMovies = new ArrayList<Movie>();

		// Adds all Movie objects with a higher IMDB score to the ArrayList "betterMovies"
		for (int i = 0; i < l1.size(); i++)
		{
			if (l1.get(i).getImdbScore() > score)
			{
				betterMovies.add(l1.get(i));
			}
		}

		// Returns ArrayList "betterMovies"
		return betterMovies;
	}
}