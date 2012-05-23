					/* In the name of GOD, the Most Gracious, the Most Merciful */
/*
 *	Date : 27th of May 2011
 *	Description : Reads from relevant XML file and returns data
 *
 * 	Author	: Jazarine Jamal
 *  E-Mail 	: jazarinester@gmail.com
 *  Web		: http://www.jazarine.org
 * */
package com.qiraat;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.content.Context;
import android.util.Log;
import com.qiraat.R;
 
public class MetaDataParser
{
	public static final String LOG_TAG = "MetaDataParser";
	private static final boolean isERRORLOG = false;
	
	public static ArrayList<String> getSurahNames(Context context,XmlPullParser xpp)
	{
		ArrayList<String> surahNameList = new ArrayList<String>();
		try 
		{
			//XmlPullParser xpp=context.getResources().getXml(R.xml.qurandata);
			while (xpp.getEventType()!=XmlPullParser.END_DOCUMENT)
			{
				if (xpp.getEventType()==XmlPullParser.START_TAG)
				{
					if (xpp.getName().equals("sura"))
					{
						//String surahName=new ArabicReshaper(xpp.getAttributeValue(3).toString()).getReshapedWord();
						String surahName=xpp.getAttributeValue(3).toString();
						String[] surahNameWords=surahName.split(" ");
						String surahNameFinal="";
						for (int nCount=0;nCount<surahNameWords.length;nCount++)
						{
							surahNameFinal +=new ArabicReshaper(surahNameWords[nCount]).getReshapedWord();
						}
						surahNameList.add(surahNameFinal);
					}
				}
				xpp.next();
			}
		}
		catch(Exception ex)
		{
			return surahNameList;
		}
		return surahNameList;
	}
	
	public static int[] getNumAyas(Context context,XmlPullParser xpp)
	{
		int suraPos=0,numAyas=0;
		int []numAyasList = new int[114];
		try 
		{
			//XmlPullParser xpp=context.getResources().getXml(R.xml.qurandata);
			while (xpp.getEventType()!=XmlPullParser.END_DOCUMENT)
			{
				if (xpp.getEventType()==XmlPullParser.START_TAG)
				{
					if (xpp.getName().equals("sura"))
					{
						//String surahName=new ArabicReshaper(xpp.getAttributeValue(3).toString()).getReshapedWord();
						
						numAyas=Integer.parseInt(xpp.getAttributeValue(1));
						
						numAyasList[suraPos]=numAyas;
						suraPos++;
					}
				}
				xpp.next();
			}
		}
		catch(Exception ex)
		{
			
		}
		return numAyasList;
	}

	public static ArrayList<String> getTranslatedSuraNames(QiraatActivity qiraatActivity, XmlPullParser xpp)
	{
		// TODO Auto-generated method stub
		ArrayList<String> translatedSuraNameList = new ArrayList<String>();
		try 
		{
			//XmlPullParser xpp=context.getResources().getXml(R.xml.qurandata);
			while (xpp.getEventType()!=XmlPullParser.END_DOCUMENT)
			{
				if (xpp.getEventType()==XmlPullParser.START_TAG)
				{
					if (xpp.getName().equals("sura"))
					{
						//String surahName=new ArabicReshaper(xpp.getAttributeValue(3).toString()).getReshapedWord();
						String translatedSuraName=xpp.getAttributeValue(5).toString();
						translatedSuraNameList.add(translatedSuraName);
					}
				}
				xpp.next();
			}
		}
		catch(Exception ex)
		{
			if (isERRORLOG) {
				Log.e(LOG_TAG, "Error in getTranslatedSuraNames: " + ex.toString());
			}
			return null;
		}
		return translatedSuraNameList;
	}
}