/*
	
Song.java
Author: Kevin Gao

This class will contain the information needed for each song. 

*/

import java.io.File;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class Song  
{
	private AudioFile audioFile;
	private Tag tag;
	private AudioHeader audioHeader;
	private String artist, title;

	/**
		* Constructor
	**/
	public Song (File file) throws Exception
	{
		audioFile = AudioFileIO.read(file);
		tag = audioFile.getTag();
		audioHeader = audioFile.getAudioHeader();
		artist = tag.getFirst(FieldKey.ARTIST);
		title = tag.getFirst(FieldKey.TITLE);
	}

	public String toString()
	{
		String s = "Artist: " + getArtist() + " Title: " + getTitle();
		return s;
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getAbsolutePath()
	{
		File file = audioFile.getFile();
		String absolutePath = file.getAbsolutePath();
		return absolutePath;
	}
}