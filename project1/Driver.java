/*

Driver.java
Author: Kevin Gao

This class is used to print and test methods as part of the MovieList and MovieListBuilder classes
*/

import java.util.ArrayList;

public class Driver
{
	public static void main (String[] args)
	{	
		// Check to make sure that the correct command line parameters were passed through
		if (args.length != 1)
		{
			System.out.println("usage: java Driver <filename>");
			System.exit(0);
		}
		else
		{
			// Creates a new MovieListBuilder object
			MovieListBuilder m1 = new MovieListBuilder();

			// Creates a new MovieList object
			MovieList l1 = m1.buildMovieList(args[0]);

			// Creates a new ArrayList object to store movies with IMDB scores above 8
			ArrayList<Movie> movies = new ArrayList<Movie>();

			// If MovieList is empty...
			if (l1 == null)
			{
				System.out.println("This MovieList is void and has no contents.");
				System.exit(0);
			}
			else
			{
				// Displays all Movie objects in the MovieList
				System.out.println("All Movies: ");
				System.out.println(l1.toString());

				// Displays the title of the lowest budget Movie object
				System.out.println("Lowest budget: " + l1.titleLowestBudget());
				// Displays the title of the longest duration Movie object
				System.out.println("Longest duration: " + l1.titleLongestDuration());
				// Displays the title of the highest budget Movie object
				System.out.println("Highest budget: " + l1.titleHighestBudget());
				// Displays the title of the shortest duration Movie object
				System.out.println("Shortest duration: " + l1.titleShortestDuration());
				// Displays the average IMDB scores of all Movie objects
				System.out.printf("%s %1.2f\n", "Average score: ", l1.averageScore());
				// Displays the average budget of all Movie objects
				System.out.printf("%s %1.2f\n", "Average budget: $", l1.averageBudget());
				// Displays the average duration of all Movie objects
				System.out.printf("%s %1.2f\n", "Average score: ", l1.averageDuration());

				// Displays information of all Movie objects with IMBD scores greater than 8
				System.out.println("Movies with IMDB score greater than 8: ");
				movies = new ArrayList<Movie>(l1.scoreGreaterThan(8.0));

				for (int i = 0; i < movies.size(); i++)
				{
					System.out.println("    " + movies.get(i).toString());
				}

				// Displays information of all Movie objects with IMBD scores greater than 9
				System.out.println("Movies with IMDB score greater than 9: ");
				movies = new ArrayList<Movie>(l1.scoreGreaterThan(9.0));

				for (int i = 0; i < movies.size(); i++)
				{
					System.out.println("    " + movies.get(i).toString());
				}
			}
		}
	}
}