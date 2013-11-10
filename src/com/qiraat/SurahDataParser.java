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
import android.os.Build;

import com.qiraat.R;
 
public class SurahDataParser
{
	public static ArrayList<String> getAyahList(Context context,XmlPullParser xpp,int position)
	{
		ArrayList<String> ayahList = new ArrayList<String>();
		try 
		{
			//XmlPullParser xpp=context.getResources().getXml(R.xml.qurandata);
			boolean suraFound=false;
			boolean suraFoundandFinishedGet = false;
            int ayanum=0;
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

                        String ayah="";
                        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB_MR2){
                            ayah=ArabicUtilities.reshapeSentence(xpp.getAttributeValue(1));
                        }
                        else if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN){
                            ayah=xpp.getAttributeValue(1);
                            if(Build.VERSION.SDK_INT == Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1){
                                ayah=ayah.replaceAll(" ","      ");
                            }
                        }
                        else{
                            ayah=xpp.getAttributeValue(1);
                            ayah=ayah.replaceAll(" ","      ");
                        }
						ayahList.add(ayah);
                        ayanum+=1;
						
						/*String aya=xpp.getAttributeValue(1).toString();
						String finalAya = aya.substring(0,1) + aya.substring(1,aya.length()-1) + aya.substring(aya.length()-1,aya.length()) + "\0";
						String[] ayaWords=finalAya.split(" ");
						 
						
						String ayaFinal = "";
						for (int nCount=0;nCount<ayaWords.length;nCount++)
						{
							ayaFinal +=new ArabicReshaper(ayaWords[nCount]).getReshapedWord();
							ayaFinal += "            ";
							//ayaFinal +=ayaWords[nCount];
						}						
						ayahList.add(ayaFinal);
						*/
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