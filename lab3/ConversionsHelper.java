import java.util.*;

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

	String[] timeZones = {"PST", "MST", "CST", "EST"};
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

	/**
 	 * Converts the given hour from the fromTZ (timezone) to the toTZ (timezone).
	 * 
	 * Valid time zones are PST, MST, CST, and EST.
	 * MST is PST + 1
	 * CST is MST + 1
	 * EST is CST + 1
	 *
	 * If fromTZ or toTZ is not a valid time zone the method will return -1.
	 * 
	 * Uses 24 hour clock and accounts for new day.
	 * Hour 22 in PST is hour 1 in EST 
	 * 
	 * Hour may be a valid integer from 0 to 23. If hour is outside of that range 
	 * the method will return -1;
	 *
	 * 
	 * @param hour
	 * @param fromTZ
	 * @param toTZ
	 * @return
	 */
	public int timeZone(int hour, String fromTZ, String toTZ) 
	{
		// Data Members
		int numFromTZ = 0, numToTZ = 0, timeDifference = 0, finalTime = 0;
		
		// Check to make sure that the hour is a valid integer
		if (hour < 0 || hour > 23)
		{
			return -1;
		}

		// Checks through the timeZones[] array and gathers the time difference from both time zones
		for (int i = 1; i <= 4; i++)
		{
			if (fromTZ.equals(timeZones[i - 1]))
			{
				numFromTZ = i;
			}

			if (toTZ.equals(timeZones[i - 1]))
			{
				numToTZ = i;
			}
		}

		// Check to make sure that the fromTZ and toTZ strings are valid
		if (numFromTZ == 0 || numToTZ == 0)
		{
			return -1;
		}

		// Calculates the time difference when the original time zone is behind
		if (numToTZ > numFromTZ)
		{
			timeDifference = numToTZ - numFromTZ;
			finalTime = hour + timeDifference;
		}
		// Calculates the time difference when the original time zone is ahead
		else if (numToTZ < numFromTZ)
		{
			timeDifference = numFromTZ - numToTZ;
			finalTime = hour - timeDifference;
		}
		// Returns original hour when the original and new time zone are the same
		else
		{
			return hour;
		}

		System.out.println(finalTime);

		// Loop around using 24 hour time (i.e. instead of hour 25 it returns hour 1)
		if (finalTime > 24)
		{
			finalTime = finalTime - 24;
		}
		else if (finalTime == 0)
		{
			finalTime = 24;
		}
		else if (finalTime < 0)
		{
			finalTime = 24 + finalTime;
		}

		// Returns converted hour
		return finalTime;
	}

	/**
	 * Calculates total calories burned running given weight in pounds and duration 
	 * of exercise in minutes. 
	 * 
	 * Use the following formulas:
	 * Calories per minute = (.0175) X (MET) X (weight in Kilograms)
	 * MET (Metabolic equivalent of task) = 10 for running (at 6mph) - use this value
	 * Weight in Kg = Weight in pounds / 2.2
	 * 
	 * @param weightInPounds
	 * @param durationInMinutes
	 * @return
	 */
	public double caloriesBurnedRunning(int weightInPounds, int durationInMinutes) 
	{
		// Converts the user entered weight from pounds to kilos 
		double weightInKilos = ((double) weightInPounds) / 2.2;

		// Calculates amount of calories burned while running
		double caloriesPerMinute = (.0175) * (10) * (weightInKilos);
		double caloriesBurnedRunning = caloriesPerMinute * ((double) durationInMinutes);

		// Returns amount of calories burned given weight and duration of run
		return caloriesBurnedRunning;
	}
}