/*
	
SongList.java
Author: Kevin Gao

This class will store all of the songs in a linked list and manage how they are used in the program.

*/

import java.io.File;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.NoSuchElementException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SongList extends LinkedList<Song> 
{	
	private Player player;

	/**
		* Constructor
	**/
	public SongList()
	{
		player = null;
	}
	
	public Player getPlayer() 
	{
		return player;
	}
	
	public void setPlayer(Player newPlayer)
	{
		player = newPlayer;
	}
	
	public void print()
	{
		for(int i = 0; i < size(); i++)
		{
			Song s = (Song)get(i);
			System.out.println("(" + (i + 1) + ")" + s);
		}
	}

	public void sortByArtist()
	{
		Collections.sort(this, new Comparator<Song>() 
		{
			public int compare(Song s1, Song s2) 
			{
				return s1.getArtist().compareTo(s2.getArtist());
			}
		});

	}

	public void sortByTitle()
	{
		Collections.sort(this, new Comparator<Song>() 
		{
			public int compare(Song s1, Song s2) 
			{
				return s1.getTitle().compareTo(s2.getTitle());
			}
		});
	}

	public String songManager() 
	{
		// Data Members
		boolean musicPlaying = false;
		int songChoice = 0;

		UserInterface ui = new UserInterface();
		int choice = ui.getChoice();
		SongPlayer p = new SongPlayer(this);

		while(choice != 7)
		{
			switch(choice)
			{
				case 1:
					// Sort the SongList by artist
					sortByArtist();
					// Print the SongList in the console
					print();

					// Print empty line for formatting
					System.out.println();
					break;
				case 2:
					// Sort the SongList by title
					sortByTitle();
					// Print the SongList in the console
					print();

					// Print empty line for formatting
					System.out.println();
					break;
				case 3:
					// If music is already playing, close player before changing song
					if (musicPlaying && player != null)
					{
						System.out.println();
						System.out.println("Music Already Playing! (Stopped)");
						System.out.println();

						musicPlaying = false;
						songChoice = 1;

						player.close();
						
						// Get choice of song from user
						try
						{
							songChoice = ui.getSongChoice(this, size());
						}
						catch (NoSuchElementException e)
						{
							break;
						}

						// Add song to player, to begin playing song
						try 
						{
							musicPlaying = true;
							p.playSong(songChoice, this);
						} 
						catch (JavaLayerException e) 
						{
						
						}
					}
					else
					{
						// Get choice of song from user
						try
						{
							songChoice = ui.getSongChoice(this, size());
						}
						catch (NoSuchElementException e)
						{
							break;
						}

						// Add song to player, to begin playing song
						try 
						{
							musicPlaying = true;
							p.playSong(songChoice, this);
						} 
						catch (JavaLayerException e) 
						{
						
						}
					}

					// Print empty line for formatting
					System.out.println();
					break;
				case 4:
					// Close player to stop music playing
					if (player != null)
					{
						musicPlaying = false;
						songChoice = 1;
						player.close();					
					}
						
					// Print empty line for formatting
					System.out.println();
					break;
				case 5:
					// If music is not already playing
					if (!musicPlaying && player != null)
					{
						// Print empty line for formatting
						System.out.println();
						break;
					}
					else if (musicPlaying && player != null)
					{
						player.close();

						// Add song to player, to begin playing song
						try 
						{
							if ((songChoice + 1) <= size())
							{
								songChoice += 1;
								p.playSong(songChoice, this);

								System.out.println("Next Song Playing...");
							}
							else
							{
								songChoice = 1;

								p.playSong(songChoice, this);

								System.out.println("Next Song Playing...");
							}
						} 
						catch (JavaLayerException e) 
						{
						
						}

						// Print empty line for formatting
						System.out.println();
						break;
					}
				case 6:
					// If music is still playing, stop the music
					if (musicPlaying)
					{
						player.close();
						musicPlaying = false;
					}

					// Randomize list of songs
					Collections.shuffle(this);
			}
			
			// Get new user input from user
			choice = ui.getChoice();
			
			// If user wants to exit and player is already closed, program quits
			if (choice == 7)
			{
				if (!musicPlaying)
				{
					break;
				}
				// If song is still playing, close player and then quit program
				else
				{
					player.close();
					break;
				}
			}
		}

		// Returns done
		return "done";
	}
}