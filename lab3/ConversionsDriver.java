/*

ConversionsDriver.java
Author: Kevin Gao

This class converts input (such as number of bits to bytes) from user 
	and feeds information into methods of ConversionsHelper.java
*/

import java.util.Scanner; 

public class ConversionsDriver
{
	public static void main (String[] args)
	{
		// Sets up new ConversionsHelper object
		ConversionsHelper helper = new ConversionsHelper();

		// Gets input as String and Integer from user
		Scanner inputInt = new Scanner(System.in);
		Scanner inputStr = new Scanner(System.in);
		
		// Asks user for the number of bits
		System.out.print("Please Enter the Number of Bits: ");
		int bits = inputInt.nextInt();
		
		// Outputs conversion of bits into bytes
		System.out.println("The number of bytes is: " + helper.bitsToBytes(bits));

		System.out.print("Please Enter the Temperature in Celsius: ");
		int tempInCelsius = inputInt.nextInt();

		// Outputs conversion of temperature in celsius to fahernheit
		System.out.println("The temperature in fahrenheit: " + helper.celsiusToFahrenheit(tempInCelsius));

		// Asks user for a day integer and a month string
		System.out.print("Please Enter a Day: ");
		int day = inputInt.nextInt();
		System.out.print("Please Enter a Month: ");
		String month = inputStr.nextLine();

		// Outputs the number of the day in the year given a specific month and day
		System.out.println("The number of the day: " + helper.dayOfYear(day, month));

		// Asks user for hour and timezones to convert from and to
		System.out.print("Please Enter an Hour: ");
		int hour = inputInt.nextInt();
        System.out.print("Please Enter a Time Zone You Wish to Convert From: ");
		String fromTZ = inputStr.nextLine();
        System.out.print("Please Enter a Time Zone You Wish to Convert To: ");
		String toTZ = inputStr.nextLine();

		// Outputs the hour result of the timezone conversion
		System.out.println("The new converted hour is: " + helper.timeZone(hour, fromTZ, toTZ));

		// Asks user for weight in pounds and running duration in minutes
		System.out.print("Please Enter a Weight in Pounds: ");
		int weightInPounds = inputInt.nextInt();
		System.out.print("Please Enter a Running Duration (in Minutes): ");
		int durationInMinutes = inputInt.nextInt();

		// Outputs the hour result of the timezone conversion
		System.out.println("The amount of calories burned is: " + helper.caloriesBurnedRunning(weightInPounds, durationInMinutes));
	}
}
