				/* In the name of GOD, the Most Gracious, the Most Merciful */
/*
 *	Date : 27th of May 2011
 *	Description: The implementation of the android media player for recitation.
 *
 * 	Author	: Jazarine Jamal
 *  E-Mail 	: jazarinester@gmail.com
 *  Web		: http://www.jazarine.org
 * */
package com.qiraat;

import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.Log;
import com.qiraat.R;

public class Recitation
{
	public static final String LOG_TAG = "Recitation";
	private static final boolean isERRORLOG = false;

	public static MediaPlayer qiraatPlayer = null;
	public static Context context = null;
	public static int suraPos = 0;
	public static int numAyas = 0;
	public static String[] pathDir;
	public static int currentAyaPos = 1;
	
	public static void play(Context context, int suraPos, int numAyas, boolean playBismillah)
	{
		qiraatPlayer = new MediaPlayer();
		Recitation.context = context;
		Recitation.suraPos=suraPos;
		Recitation.numAyas = numAyas;
		//+ Jaz 19th May 2012 - Play from current position.
		if(Recitation.currentAyaPos == 0)
		{
			Recitation.currentAyaPos = 1;
		}
		else if(Recitation.currentAyaPos != 1)
		{
			Recitation.currentAyaPos--;
		}//- Jaz
		pathDir = new String[numAyas];
		//String applicationAudioPath = DisplaySuraActivity.getAudioPath();
		String applicationAudioPath = DisplaySuraActivity.appAudioPath;
        //String applicationAudioPath = DisplaySuraActivity.getFullAudioPath();
		for(int nCount=0;nCount<numAyas;nCount++)
		{
			if(suraPos<10)
			{
				if(nCount+1<10)
				{
					pathDir[nCount] = applicationAudioPath +"00"+suraPos+"00"+(nCount+1)+".mp3";
				}
				else if(nCount+1<100)
				{
					pathDir[nCount] = applicationAudioPath+"00"+suraPos+"0"+(nCount+1)+".mp3";
				}
				else
				{
					pathDir[nCount] = applicationAudioPath+"00"+suraPos+(nCount+1)+".mp3";
				}
			}
			else if(suraPos<100)
			{
				if(nCount+1<10)
				{
					pathDir[nCount] = applicationAudioPath+"0"+suraPos+"00"+(nCount+1)+".mp3";
				}
				else if(nCount+1<100)
				{
					pathDir[nCount] = applicationAudioPath+"0"+suraPos+"0"+(nCount+1)+".mp3";
				}
				else
				{
					pathDir[nCount] = applicationAudioPath+"0"+suraPos+(nCount+1)+".mp3";	
				}
			}
			else
			{
				if(nCount+1<10)
				{
					pathDir[nCount] = applicationAudioPath+suraPos+"00"+(nCount+1)+".mp3";
				}
				else if(nCount+1<100)
				{
					pathDir[nCount] = applicationAudioPath+suraPos+"0"+(nCount+1)+".mp3";
				}
				else
				{
					pathDir[nCount] = applicationAudioPath+suraPos+(nCount+1)+".mp3";	
				}
			}
		}
		try 
		{
			//Play Bismillah..
			
			String bismiPath = applicationAudioPath+"bismillah"+".mp3";
			if(DisplaySuraActivity.nReciterVoiceID == 1)		//For Sudais
			{
				bismiPath = applicationAudioPath+"001001"+".mp3";
			}
			qiraatPlayer.setDataSource(bismiPath);
			
			qiraatPlayer.prepare();
			
			qiraatPlayer.setOnCompletionListener(new OnCompletionListener()
			{

				@Override
				public void onCompletion(MediaPlayer arg0) {
					// TODO Auto-generated method stub					
					if(DisplaySuraActivity.ayaOnTapEnabled!=true){
                        Recitation.playNextAya();
                    }
				}
				
			});
			if (!playBismillah)
			{
				Recitation.playNextAya();
			}
			else
			{
				qiraatPlayer.start();
			}
			
			
		} 
		catch (Exception e)
		{
			if (isERRORLOG) {
				//Stop playback..
				Log.e(LOG_TAG, "Error in Playback"+ e.toString());
				e.printStackTrace();
			}
			
			releasePlayer();
			return;
		}
	}
	protected static void playNextAya()
	{
		if(currentAyaPos<=numAyas)
		{
			DisplaySuraActivity.goToNextAya(currentAyaPos-1);
			//currentAyaPos++;
			int ayaPos=currentAyaPos-1;
			String mp3Path=pathDir[ayaPos];
			if(qiraatPlayer != null)
			{    
				qiraatPlayer.reset();
	        }
			try {
				qiraatPlayer.setDataSource(mp3Path);
				qiraatPlayer.prepare();
			}
			catch (Exception e)
			{
				Log.e(LOG_TAG, "Error in playNextAya" + e.toString());
				releasePlayer();
				return;
			}
			
			qiraatPlayer.start();
			currentAyaPos++;
            if(DisplaySuraActivity.ayaOnTapEnabled!=true){
			    DisplaySuraActivity.playStopMenuItem.setTitle("Stop");
            }
		}
		else
		{
			currentAyaPos = 0;
			if(qiraatPlayer != null)
			{
				if(qiraatPlayer.isPlaying())
				{
					qiraatPlayer.stop();
				}
				qiraatPlayer.reset();
			}
			DisplaySuraActivity.playStopMenuItem.setTitle("Recite");
		}
	}
	public static void pausePlayer()
	{
		if(qiraatPlayer != null)
		{
			if(qiraatPlayer.isPlaying())
			{
				qiraatPlayer.pause();
			}
		}
	}
	public static void releasePlayer()
	{
		if(qiraatPlayer != null)
		{
			currentAyaPos = 0;
			if(qiraatPlayer.isPlaying())
			{
				qiraatPlayer.stop();
			}
			qiraatPlayer.reset();
			qiraatPlayer.release();		
			//Need to set this to null manually. After calling release(), cannot call any other method on the mediaplayer object.
			qiraatPlayer = null;
		}
	}
	public static boolean isPlaying() {
		// TODO Auto-generated method stub
		if(qiraatPlayer != null)
		{
			return qiraatPlayer.isPlaying();
		}
		return false;
	}
}