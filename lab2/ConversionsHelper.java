/*

ConversionsHelper.java
Author: Kevin Gao

This class contains methods that convert user input from ConversionsDriver.java
*/

public class ConversionsHelper
{
	// String array which contains respective month names as strings
	String[] monthNames = {"January", "February", "March", "April",
								"May", "June", "July", "August", "September", 
									"October", "November", "December"};
	/**
		* Returns number of bytes in given amount of bits
	**/
	public double bitsToBytes(int bits)
	{
		double bytes = (((double) bits) / 8.0);
		return bytes;
	}

	/**
		* Converts temperature in fahernheit from celsius
	**/
	public double celsiusToFahrenheit(int tempInCel)
	{
		double tempInFahr = (((double) tempInCel) * (1.8)) + 32;
		return tempInFahr;
	}

	/**
		* Returns day number in the year of a given day and month
	**/
	public int dayOfYear(int day, String month)
	{
		// Initialize data members
		int numMonth = 0, dayOfYear = 0;

		// Make sure that the day integer is valid
		if (day > 31 || day < 1)
		{
			return -1;
		}

		// Calculate the number order in 2017 of the month given from the monthNames[] array
		for (int i = 1; i <= 12; i++)
		{
			if (month.equals(monthNames[i - 1]))
			{
				numMonth = i;
			}
		}

		// Calculate dayOfYear integer by adding number of days in previous months to the user given day
		if (numMonth == 1)
		{
			dayOfYear = day;
		}
		// Make sure that user given day is not greater than 28
		else if (numMonth == 2 && day <= 28)
		{
			dayOfYear = day + 31;
		}
		else if (numMonth == 3)
		{
			dayOfYear = day + 59;
		}
		// Make sure that user given day is not greater than 30
		else if (numMonth == 4 && day <= 30)
		{
			dayOfYear = day + 90;
		}
		else if (numMonth == 5)
		{
			dayOfYear = day + 120;
		}
		// Make sure that user given day is not greater than 30
		else if (numMonth == 6 && day <= 30)
		{
			dayOfYear = day + 151;
		}
		else if (numMonth == 7)
		{
			dayOfYear = day + 181;
		}
		else if (numMonth == 8)
		{
			dayOfYear = day + 212;
		}
		// Make sure that user given day is not greater than 30
		else if (numMonth == 9 && day <= 30)
		{
			dayOfYear = day + 243;
		}
		else if (numMonth == 10)
		{
			dayOfYear = day + 273;
		}
		// Make sure that user given day is not greater than 30
		else if (numMonth == 11 && day <= 30)
		{
			dayOfYear = day + 304;
		}
		else if (numMonth == 12)
		{
			dayOfYear = day + 334;
		}
		else
		{
			return -1;
		}

     	return dayOfYear;
	}
}
