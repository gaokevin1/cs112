/*

CounterDriver.java
Author: Kevin Gao

This class sets up two counter objects and
	manipulates them, testing out the different methods.
*/

public class CounterDriver
{
	public static void main(String[] args)
	{
		// Setting up new Counter objects
		Counter c1 = new Counter();
		Counter c2 = new Counter();

		// Adds 1 to the current count
		c1.click();
		c1.click();
		c1.click();
		c2.click();

		System.out.println("The count of c1 is: " + c1.getCount());
		System.out.println("The count of c2 is: " + c2.getCount());

		c2.click();

		System.out.println("The count of c2 is: " + c2.getCount());

		// Resets the count
		c1.reset();

		System.out.println("The count of c1 is: " + c1.getCount());
	}
}