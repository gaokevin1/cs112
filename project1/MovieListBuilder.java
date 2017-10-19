/*

MovieListBuilder.java
Author: Kevin Gao

This class reads from a CSV file and creates a new MovieList object
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieListBuilder
{
	/**
		* Constructor
	**/
	public MovieListBuilder()
	{
		
	}

	public MovieList buildMovieList(String filename)
	{
		// Creates a new MovieList object
		MovieList l1 = new MovieList();
		// Creates a new File object
		File file = new File(filename);

		// Try and catch for errors
		try (Scanner input = new Scanner(file))
		{
			input.useDelimiter(",|\n");

			// Skip first line
			input.nextLine();

			while (input.hasNext())
			{
				// Data members
				String title = "";
				int duration = 0;
				long budget = 0;
				double imdbScore = 0;

				// Skip 3 lines
				for (int i = 0; i < 3; i++)
				{
					input.next();
				}

				// Gets information from the CSV file and turns it into a string variable
				String inputDuration = input.next();

				// Check to see if read line is an integer type
				if (inputDuration.trim().isEmpty() == false)
				{
					duration = Integer.parseInt(inputDuration);
				}
				else
				{
					duration = 0;
				}

				// Skip 7 lines
				for (int i = 0; i < 7; i++)
				{
					input.next();
				}

				// Gets information from the CSV file and turns it into a string variable
				String inputTitle = input.next();

				// Check to see if read line is an string type
				if (inputTitle.trim().isEmpty() == false)
				{
					title = inputTitle;
				}
				else
				{
					title = "";
				}

				// Skip 10 lines
				for (int i = 0; i < 10; i++)
				{
					input.next();
				}

				// Gets information from the CSV file and turns it into a string variable
				String inputBudget = input.next();

				// Check to see if read line is a long type
				if (inputBudget.trim().isEmpty() == false)
				{
					budget = Long.parseLong(inputBudget);
				}
				else
				{
					budget = 0;
				}

				// Skip 2 lines
				for (int i = 0; i < 2; i++)
				{
					input.next();
				}

				// Gets information from the CSV file and turns it into a string variable
				String inputScore = input.next();

				// Check to see if read line is a double type
				if (inputScore.trim().isEmpty() == false)
				{
					imdbScore = Double.parseDouble(inputScore);
				}
				else
				{
					imdbScore = 0;
				}

				// Checks to make sure all file-read data is valid
				if ((duration != 0) && (budget != 0) && (imdbScore != 0) && (!title.equals("")))
				{
					// Creates a new Movie object with information from CSV file
					Movie m = new Movie(title, duration, budget, imdbScore);
					l1.addMovie(m);
				}

				// Skip 2 lines
				for (int i = 0; i < 2; i++)
				{
					input.next();
				}
			}

			// Close scanner
			input.close();
		}
		catch (FileNotFoundException fnf)
		{
			return null;
		}

		return l1;
	}
}