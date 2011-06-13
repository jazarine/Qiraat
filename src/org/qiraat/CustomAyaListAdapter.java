					/* In the name of GOD, the Most Gracious, the Most Merciful */
/*
 *	Date : 27th of May 2011
 *	Description : Adapter for the aya listview
 *
 * 	Author	: Jazarine Jamal
 *  E-Mail 	: jazarinester@gmail.com
 *  Web		: http://www.jazarine.com
 * */
package org.qiraat;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

class AyahAdapterView extends LinearLayout {        
    public static final String LOG_TAG = "WeatherAdapterView";

    public AyahAdapterView(Context context, String ayah, String translatedAya, int nTranslationVal) {
        super( context );
        
        LinearLayout.LayoutParams ayaParams = new LinearLayout.LayoutParams(100,LayoutParams.WRAP_CONTENT);
        ayaParams.weight = 1;
        ayaParams.bottomMargin = 5;
        ayaParams.topMargin=5;
        ayaParams.rightMargin=20;
        LinearLayout.LayoutParams translatedAyaParams = new LinearLayout.LayoutParams(90,LayoutParams.WRAP_CONTENT);
        translatedAyaParams.weight = 1;
        translatedAyaParams.bottomMargin=50;
        translatedAyaParams.topMargin = 5;
        //translatedAyaParams.rightMargin = 2;
        if(nTranslationVal != 0)
        {
        	//translatedAyaParams = new LinearLayout.LayoutParams(150,LayoutParams.MATCH_PARENT);
        	//ayaParams.leftMargin = 2;
        }
        
        TextView ayahControl = new TextView( context );
        TextView translatedAyahControl = new TextView( context );
        
        Typeface externalFont=Typeface.createFromAsset(context.getAssets(), "fonts/me_quran_volt_newmet.ttf");
       	ayahControl.setTypeface(externalFont);
        ayahControl.setTextSize(25);
        ayahControl.setTextColor(Color.BLACK);
        //ayahControl.setWidth();
        ayahControl.setText(ayah +'\u200F');	//Jaz - Append the RTF character so that the last character is displayed as last character itself.
        ayahControl.setGravity(Gravity.RIGHT);
        
        
        //Translation..
        if(nTranslationVal != 0)
        {
	        if(nTranslationVal == 2)
	        {
		        externalFont=Typeface.createFromAsset(context.getAssets(), "fonts/suruma.ttf");
		        translatedAyahControl.setTypeface(externalFont);
		        translatedAyahControl.setTextSize(25);
	        }
	        translatedAyahControl.setText(translatedAya);
	        
	        translatedAyahControl.setTextColor(Color.BLACK);
	        translatedAyahControl.setGravity(Gravity.LEFT);
	        addView(translatedAyahControl,translatedAyaParams);
        }
        addView(ayahControl, ayaParams);
    }
}

class CustomAyaListAdapter extends BaseAdapter{
	private Context context;
    private List<String> ayahList;
    private List<String> translatedAyaList;
    private int nTranslationVal;

    public CustomAyaListAdapter(Context context, List<String> ayahList, List<String> translatedAyaList, int nTranslationVal ) { 
        this.context = context;
        this.ayahList = ayahList;
        this.translatedAyaList = translatedAyaList;
        this.nTranslationVal = nTranslationVal;
    }
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ayahList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return ayahList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String ayah = ayahList.get(position);
		String translatedAya = "";
		if(this.nTranslationVal != 0)
		{
			translatedAya = translatedAyaList.get(position);
		}
        return new AyahAdapterView(this.context, ayah, translatedAya,this.nTranslationVal );
	}
	
}