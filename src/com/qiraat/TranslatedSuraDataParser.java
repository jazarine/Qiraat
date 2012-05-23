					/* In the name of GOD, the Most Gracious, the Most Merciful */
/*
 *	Date : 27th of May 2011
 *	Description : Read from relevant XML file and return data
 *
 * 	Author	: Jazarine Jamal
 *  E-Mail 	: jazarinester@gmail.com
 *  Web		: http://www.jazarine.org
 * */
package com.qiraat;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.content.Context;
import com.qiraat.R;
 
public class TranslatedSuraDataParser
{
	public static ArrayList<String> getTranslatedAyaList(Context context,XmlPullParser xpp,int position)
	{
		ArrayList<String> ayahList = new ArrayList<String>();
		try 
		{
			boolean suraFound=false;
			boolean suraFoundandFinishedGet = false;
			while ((xpp.getEventType()!=XmlPullParser.END_DOCUMENT))
			{
				if (xpp.getEventType()==XmlPullParser.START_TAG)
				{
					if(xpp.getName().equals("sura"))
					{
						if(xpp.getAttributeValue(0).equals(position+""))
						{
							xpp.nextTag();
							suraFound = true;
							suraFoundandFinishedGet=false;
							continue;
						}
						else
						{
							if (suraFound)
							{
								suraFoundandFinishedGet = true;
							}
						}
					}
					if(suraFoundandFinishedGet)
					{
						break;
					}
					if (xpp.getName().equals("aya") && suraFound)
					{
						String translatedAya=xpp.getAttributeValue(1).toString();
						translatedAya.trim();
						ayahList.add(translatedAya);
						
					}
				}
				xpp.next();
			}
		}
		catch(Exception ex)
		{
			return ayahList;
		}
		return ayahList;
	}
}