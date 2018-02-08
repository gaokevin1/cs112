/*

MP3Player.java
Author: Kevin Gao

This class is used to gather all java files in a given directory.

*/

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import javazoom.jl.decoder.JavaLayerException;


public class MP3Player 
{
	public static void main(String[] args) throws CannotReadException, IOException
	{
		// If user input is not valid
		if (args.length != 1)
		{
			System.out.println("usage: java JavaClassAnalyzer <absolute_path>");
			System.exit(0);
		}
		else
		{
			// Data Members
			String directory = args[0];

			FileFinder f1 = new FileFinder();

			SongList sl1 = f1.buildSongList(directory);

			try
			{
				// Open up Song Manager
				sl1.songManager();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}