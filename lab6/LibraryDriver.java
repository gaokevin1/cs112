/*

LibraryDriver.java
Author: Kevin Gao

This class is used to manipulate the collection of Books and Magazine publications
*/

import java.util.ArrayList;
import java.util.Collections;

public class LibraryDriver
{
	public static void main(String[] args)
	{	
		// Data Members
		String output = "";

		// Creates a new ArrayList to store PlayingCards in
		ArrayList<Publication> p = new ArrayList<Publication>();

		// Creates new PlayingCard objects
		Book b1 = new Book("Twilight", 567, false);
		Book b2 = new Book("1984", 738, true);
		Magazine m1 = new Magazine("Trump World", 57, 198213);
		Magazine m2 = new Magazine("Golf Digest", 76, 600);
		Book m3 = new Book("Atlas of the World", 567, true);

		// Add to ArrayList
		p.add(b1);
		p.add(b2);
		p.add(m1);
		p.add(m2);
		p.add(m3);

		// Sort ArrayList
		Collections.sort(p);

		// Gathers information from all different objects 
		for (int i = 0; i < p.size(); i++)
		{
			if (i < p.size() - 1)
			{
				output += p.get(i).toString() + "\n";
			}
			else
			{
				output += p.get(i).toString();
			}
		}

		// Outputs information
		System.out.println(output);
	}
}