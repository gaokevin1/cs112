/*
	
FileFinder.java
Author: Kevin Gao

This class will find all of the MP3 files in the given directory and create a new SongList.

*/

import java.io.File;

public class FileFinder
{
	public static SongList buildSongList(String path) 
	{
		File f = new File(path);
		
		if(!f.exists())
		{
			System.out.println("Directory does not exist.");
			return null;
		}
		
		// Create a new SongList
		SongList sl = new SongList();

		// Build LinkedList of songs from mp3 files in directory
		buildList(f, sl);
		return sl;			
	}

	private static void buildList(File f, SongList sl) 
	{
		// Recursively get all mp3s from directory and store them in a SongList
		if (f.isFile()) 
		{
			if (f.getAbsolutePath().endsWith(".mp3"))
			{
				try 
				{
					sl.add(new Song(f));
				} 
				catch (Exception e) 
				{

				}
			} 
			else
			{
				return;
			}
		} 
		else 
		{
			File[] files = f.listFiles();
			
			for (int i = 0; i < files.length; i++) 
			{
				buildList(files[i], sl);
			}
		}
	}
}