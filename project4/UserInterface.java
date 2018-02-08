/*

UserInterface.java
Author: Kevin Gao

This class is used to help the user utilize the functions of the program.

*/

import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInterface
{
	public int getChoice()
	{
		// Data Members
		int choice = 0;

		// Create new scanner to get user input
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		// Make sure that the choice is between 1 and 7
		while(choice < 1 || choice > 7)
		{
			// Prompt user with choice of various MP3Player function
			System.out.println("Enter Choice (Type Corresponding Number): ");	
			System.out.println("(1) List all sorted by Artist Name");
			System.out.println("(2) List all sorted by Song Title");
			System.out.println("(3) Play MP3");
			System.out.println("(4) Stop MP3 Playback");
			System.out.println("(5) Next MP3");
			System.out.println("(6) Shuffle Songs");
			System.out.println("(7) Exit");
			
			// Set user input equal to "choice" integer
			choice = sc.nextInt();
		}
		
		// Return choice
		return choice;
	}

	public int getSongChoice(SongList sl, int size)
	{
		// Data Members
		int songChoice = 0;

		// Create new scanner to get user input
		Scanner sc = new Scanner(new InputStreamReader(System.in));
					
		// Loop until user enters valid element in SongList
		while (songChoice < 1 || songChoice > size)
		{
			// Print empty line for formatting
			System.out.println();
			System.out.println("Enter Song Choice: ");
			sl.print();

			songChoice = sc.nextInt();
		}

		return songChoice;
	}
}