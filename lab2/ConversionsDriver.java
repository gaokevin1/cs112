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
	
		System.out.print("Please Enter the Number of Bits: ");
		int bits = inputInt.nextInt();
		
		// Outputs conversion of bits into bytes
		System.out.println("The number of bytes is: " + helper.bitsToBytes(bits));

		System.out.print("Please Enter the Temperature in Celsius: ");
		int tempInCelsius = inputInt.nextInt();

		// Outputs conversion of temperature in celsius to fahernheit
		System.out.println("The temperature in fahrenheit: " + helper.celsiusToFahrenheit(tempInCelsius));

		System.out.print("Please Enter a Day: ");
		int day = inputInt.nextInt();
		
		System.out.print("Please Enter a Month: ");
		String month = inputStr.nextLine();

		// Outputs the number of the day in the year given a specific month and day
		System.out.println("The number of the day: " + helper.dayOfYear(day, month));
	}
}