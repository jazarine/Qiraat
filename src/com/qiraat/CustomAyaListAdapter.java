					/* In the name of GOD, the Most Gracious, the Most Merciful */
/*
 *	Date : 27th of May 2011
 *	Description : Adapter for the aya listview
 *
 * 	Author	: Jazarine Jamal
 *  E-Mail 	: jazarinester@gmail.com
 *  Web		: http://www.jazarine.org
 *  
 *  Updated: 22nd May 2012 - Malayalam Font Fix using ComplexCharacterMapper.java
 * */
package com.qiraat;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.text.Spanned;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiraat.R;

class AyahAdapterView extends LinearLayout {
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
        	Typeface translatedTypeFace = Typeface.create("serif", Typeface.ITALIC);
			translatedAyahControl.setTypeface(translatedTypeFace );
			translatedAyahControl.setTextColor(Color.BLACK);
	        translatedAyahControl.setGravity(Gravity.LEFT);
	        translatedAyahControl.setTextSize(20);
	        if(nTranslationVal == 1)
	        {
	        	Spanned translatedAyaSpan = Html.fromHtml(translatedAya);
	        	translatedAyahControl.setText(translatedAyaSpan);
	        }
	        else if(nTranslationVal == 2)
	        {
	        	translatedAyahControl.setText(translatedAya);
	        }
	        else if(nTranslationVal == 3)
	        {
		        externalFont=Typeface.createFromAsset(context.getAssets(), "fonts/AnjaliOldLipi.ttf");
		        translatedAyahControl.setTypeface(externalFont);
		        translatedAyahControl.setTextSize(20);
		      //+ Jaz 22nd May 2012 - Malayalam Font Fix
		        translatedAya = ComplexCharacterMapper.fix(translatedAya, 0);
		        //- Jaz
		        translatedAyahControl.setText(translatedAya);  
	        }
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

    /*private view holder class*/
    private class ViewHolder {
        TextView txtAyaNum;
        TextView txtAya;
        TextView txtTranslatedAya;
        View spacer;
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
        //return new AyahAdapterView(this.context, ayah, translatedAya,this.nTranslationVal );
        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_ayas, null);
            holder = new ViewHolder();
            holder.txtAyaNum = (TextView) convertView.findViewById(R.id.ayanum);
            holder.txtAya = (TextView) convertView.findViewById(R.id.aya);
            holder.txtTranslatedAya = (TextView) convertView.findViewById(R.id.translatedaya);
            holder.spacer = (View) convertView.findViewById(R.id.spacer);
            //holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtAyaNum.setText(String.valueOf(position+1));
        //holder.txtAyaNum.setBackgroundResource(R.layout.linesample);


        Typeface externalFont=Typeface.createFromAsset(context.getAssets(), "fonts/me_quran.ttf");


        holder.txtAya.setTypeface(externalFont);
        //holder.txtAya.setTextDirection(View.TEXT_DIRECTION_RTL);
        //holder.txtAya.setGravity(Gravity.RIGHT);
        holder.txtAya.setText(ayah);
        //holder.txtAya.lay


        if(nTranslationVal != 0)
        {
            holder.txtTranslatedAya.setVisibility(View.VISIBLE);
            holder.spacer.setVisibility(View.VISIBLE);
            //Typeface translatedTypeFace = Typeface.create("serif", Typeface.ITALIC);
            //holder.txtTranslatedAya.setTypeface(translatedTypeFace );
            //holder.txtTranslatedAya.setTextColor(Color.BLACK);
            holder.txtTranslatedAya.setGravity(Gravity.LEFT);
            //holder.txtTranslatedAya.setTextSize(20);
            if(nTranslationVal == 1)
            {
                Spanned translatedAyaSpan = Html.fromHtml(translatedAya);
                //translatedAya = translatedAyaSpan.toString();
                holder.txtTranslatedAya.setText(translatedAyaSpan);
            }
            else if((nTranslationVal == 2) || (nTranslationVal == 3))
            {
                //holder.txtTranslatedAya.setText(translatedAya);
                holder.txtTranslatedAya.setText(translatedAya);
            }
            else if(nTranslationVal == 4)
            {
                externalFont=Typeface.createFromAsset(context.getAssets(), "fonts/AnjaliOldLipi.ttf");
                //holder.txtTranslatedAya.setTypeface(externalFont);
                //holder.txtTranslatedAya.setTextSize(20);
                //+ Jaz 22nd May 2012 - Malayalam Font Fix
                //translatedAya = ComplexCharacterMapper.fix(translatedAya, 0);
                //- Jaz
                holder.txtTranslatedAya.setText(translatedAya);
            }

        }

        //holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;
	}
	
}