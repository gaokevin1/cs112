/*
	
SongPlayer.java
Author: Kevin Gao

This class will pass through an MP3 file and play it through the JL Player.

*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SongPlayer 
{
	// Data Members
	private SongList songList;

	/**
		* Constructor
	**/
	public SongPlayer(SongList sl)
	{
		songList = sl;
	}

	public void playSong(int songChoice, SongList sl) throws JavaLayerException
	{
		Thread t = new Thread() 

		{
			public void run()
			{
				Song song = songList.get(songChoice - 1);
				InputStream in = null;
				
				try 
				{
					in = new FileInputStream(song.getAbsolutePath());
				} 
				catch (FileNotFoundException e1) 
				{
					return;
				}
				
				Player player = null;
				
				try 
				{
					player = new Player(in);
				} 
				catch (JavaLayerException e1) 
				{
					return;
				}
				
				sl.setPlayer(player);
				
				try
				{
					player.play();
				} 
				catch(Exception e)
				{

				}
			}
		};
		
		t.start();
	}
}
