/*

PlayingCardDriver.java
Author: Kevin Gao

This class is used to call methods of the class PlayingCard on instances of PlayingCards
*/

import java.util.ArrayList;
import java.util.Collections;

public class PlayingCardDriver
{
	public static void main(String[] args)
	{	
		// Data Members
		String output = "Example: ";

		// Creates a new ArrayList to store PlayingCards in
		ArrayList<PlayingCard> pC = new ArrayList<PlayingCard>();

		// Creates new PlayingCard objects
		PlayingCard pc1 = new PlayingCard(5, "Diamonds", "Red");
		PlayingCard pc2 = new PlayingCard(10, "Clubs", "Black");
		PlayingCard pc3 = new PlayingCard("King", "Spades", "Black");
		PlayingCard pc4 = new PlayingCard(10, "Spades", "Black");
		PlayingCard pc5 = new PlayingCard(2, "Hearts", "Red");

		// Add to ArrayList
		pC.add(pc1);
		pC.add(pc2);
		pC.add(pc3);
		pC.add(pc4);
		pC.add(pc5);

		// Sort ArrayList
		Collections.sort(pC);

		// Gathers information from all different objects 
		for (int i = 0; i < pC.size(); i++)
		{
			if (i < pC.size() - 1)
			{
				output += pC.get(i).toString() + ", ";
			}
			else
			{
				output += pC.get(i).toString();
			}
		}

		// Outputs information
		System.out.println(output);
	}
}