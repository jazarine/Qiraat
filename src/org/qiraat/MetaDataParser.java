					/* In the name of GOD, the Most Gracious, the Most Merciful */

package org.qiraat;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.content.Context;
 
public class MetaDataParser
{
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
}