					/* In the name of GOD, the Most Gracious, the Most Merciful */
/*
 *	Date : 27th of May 2011
 *	Description : Adapter for the sura listview
 *
 * 	Author	: Jazarine Jamal
 *  E-Mail 	: jazarinester@gmail.com
 *  Web		: http://www.jazarine.com
 * */
package org.qiraat;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.Shader.TileMode;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

class SuraAdapterView extends LinearLayout {        
    public static final String LOG_TAG = "WeatherAdapterView";

    public SuraAdapterView(Context context, String surah, int position) {
        super( context );

        LinearLayout.LayoutParams suraParams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        suraParams.rightMargin = 30;
        TextView suraControl = new TextView( context );
        Typeface externalFont=Typeface.createFromAsset(context.getAssets(), "fonts/me_quran_volt_newmet.ttf");
        suraControl.setTypeface(externalFont);
        suraControl.setTextSize(30);
        suraControl.setText(surah);
        suraControl.setGravity(Gravity.RIGHT);
        /*Shader textShader = new LinearGradient(0, 0, 0, 20,new int[]{Color.GREEN,Color.BLACK},new float[]{0, 1}, TileMode.CLAMP);
        suraControl.getPaint().setShader(textShader);*/
        suraControl.setTextColor(R.color.browney);
        addView( suraControl, suraParams);
        
      
    }
}

class CustomSuraListAdapter extends BaseAdapter{
	private Context context;
    private List<String> surahList;

    public CustomSuraListAdapter(Context context, List<String> surahList ) { 
        this.context = context;
        this.surahList = surahList;
    }
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return surahList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return surahList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String surah = surahList.get(position);
        return new SuraAdapterView(this.context, surah, position );
	}
	
}