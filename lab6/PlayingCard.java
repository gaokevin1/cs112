/*

PlayingCard.java
Author: Kevin Gao

This class is used to store the properties of a PlayingCard
*/

public class PlayingCard implements Comparable<PlayingCard>
{
	// Data Members
	private int value;
	private String suit, color;

	/**
		* Constructor
	**/
	public PlayingCard(int value, String suit, String color)
	{
		this.value = value;
		this.suit = suit;
		this.color = color;
	}

	/**
		* Constructor
	**/
	public PlayingCard(String value, String suit, String color)
	{	
		// Determine what numerical value is
		if (value.equals("Jack"))
		{
			this.value = 11;
		}
		else if (value.equals("Queen"))
		{
			this.value = 12;
		}
		else if (value.equals("King"))
		{
			this.value = 13;
		}
		else
		{
			this.value = 1;
		}

		this.suit = suit;
		this.color = color;
	}

	// compareTo Method
	public int compareTo(PlayingCard pC)
	{	
		String[] suits = {"Spades, Hearts, Diamonds, Clubs"};
		int pos = 0, posPC = 0;

		// If value is equal to value of compared instance
		if (value == pC.value)
		{	
			// Get position in array of suits
			for (int i = 0; i < suits.length; i++)
			{
				if (pC.suit.equals(suits[i]))
				{
					pos = i;
				}
			}

			// Get position in array of suits
			for (int i = 0; i < suits.length; i++)
			{
				if (suit.equals(suits[i]))
				{
					posPC = i;
				}
			}

			// Compare positions in array to determine order
			if (posPC > pos)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
		// If value is less than value of compared instance 
		else if (value < pC.value)
		{
			return -1;
		}
		// If value is greater than value of compared instance
		else
		{
			return 1;
		}
	}

	public String toString()
	{
		// Data Members
		String valueStr = "", playingCard = "";

		// Change value to "Jack"
		if (value == 11)
		{
			valueStr = "Jack";
			playingCard = "'" + valueStr + " of " + suit + "'";
		}
		// Change value to "Queen"
		else if (value == 12)
		{
			valueStr = "Queen";
			playingCard = "'" + valueStr + " of " + suit + "'";
		}
		// Change value to "King"
		else if (value == 13)
		{
			valueStr = "King";
			playingCard = "'" + valueStr + " of " + suit + "'";
		}
		// Change value to "Ace"
		else if (value == 1)
		{
			valueStr = "Ace";
			playingCard = "'" + valueStr + " of " + suit + "'";
		}
		// If an integer, do not change value to string
		else
		{
			playingCard = "'" + value + " of " + suit + "'";
		}
		
		// Return playingCard info
		return playingCard;
	}
}