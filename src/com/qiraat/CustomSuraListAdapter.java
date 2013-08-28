					/* In the name of GOD, the Most Gracious, the Most Merciful */
/*
 *	Date : 27th of May 2011
 *	Description : Adapter for the sura listview
 *
 * 	Author	: Jazarine Jamal
 *  E-Mail 	: jazarinester@gmail.com
 *  Web		: http://www.jazarine.org
 * */
package com.qiraat;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.app.Activity;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.Shader.TileMode;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import com.qiraat.R;

class SuraAdapterView extends LinearLayout {
    public SuraAdapterView(Context context, String surah, String translatedSuraName, int position) {
        super( context );
        
        /*LinearLayout.LayoutParams suraParams = new LinearLayout.LayoutParams(100,LayoutParams.WRAP_CONTENT);
        suraParams.weight = 1;
        suraParams.bottomMargin = 5;
        suraParams.topMargin=5;
        suraParams.rightMargin=20;

        LinearLayout.LayoutParams translatedSuraParams = new LinearLayout.LayoutParams(90,LayoutParams.WRAP_CONTENT);
        translatedSuraParams.weight = 1;
        translatedSuraParams.bottomMargin=50;
        translatedSuraParams.topMargin = 5;*/

        //RelativeLayout layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams suraParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams translatedSuraParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //layout.setLayoutParams(layoutParams);
        
        
        TextView suraControl = new TextView( context );
        TextView translatedSuraControl = new TextView( context );
        
        Typeface externalFont=Typeface.createFromAsset(context.getAssets(), "fonts/me_quran_volt_newmet.ttf");
        suraControl.setTypeface(externalFont);
        suraControl.setTextSize(30);
        suraControl.setText(surah);
        suraControl.setId(1);
        //suraControl.setGravity(Gravity.RIGHT);
        
        suraControl.setTextColor(0xff552D00);		//Setting R.color.browney does not work for some reason! Required to use the HexCode

        //translatedSuraParams.addRule(RelativeLayout.BELOW, suraControl.getId());
        translatedSuraControl.setText(translatedSuraName);
        translatedSuraControl.setTextSize(15);
        Typeface translatedTypeFace = Typeface.create("serif", Typeface.ITALIC);
		translatedSuraControl.setTypeface(translatedTypeFace );
        translatedSuraControl.setTextColor(Color.BLACK);
        //translatedSuraControl.setGravity(Gravity.LEFT);
        //translatedSuraControl.setGravity(Gravity.BOTTOM);
        
        addView(translatedSuraControl, translatedSuraParams);
        addView( suraControl, suraParams);
        
      
    }
}

class CustomSuraListAdapter extends BaseAdapter{
	private Context context;
    private List<String> surahList;
    private List<String> translatedSuraList;
    private LayoutInflater mInflater;
    public CustomSuraListAdapter(Context context, List<String> surahList, List<String> translatedSuraList ) { 
        this.context = context;
        this.surahList = surahList;
        this.translatedSuraList = translatedSuraList;
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


    /*private view holder class*/
    private class ViewHolder {
        TextView txtSuraNum;
        TextView txtSuraName;
        TextView txtTranslatedSuraName;
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String surah = surahList.get(position);
		String translatedSuraName = translatedSuraList.get(position);
        //return new SuraAdapterView(this.context, surah, translatedSuraName, position );


        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtSuraNum = (TextView) convertView.findViewById(R.id.num);
            holder.txtSuraName = (TextView) convertView.findViewById(R.id.suraname);
            holder.txtTranslatedSuraName = (TextView) convertView.findViewById(R.id.translatedsuraname);
            //holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtSuraNum.setText(String.valueOf(position+1));

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB_MR2){
            Typeface externalFont=Typeface.createFromAsset(context.getAssets(), "fonts/me_quran_volt_newmet.ttf");
            holder.txtSuraName.setTypeface(externalFont);
            //holder.txtSuraName.setTextSize(30);
        }


        holder.txtSuraName.setText(surah);
        holder.txtTranslatedSuraName.setText(translatedSuraName);
        //holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;

        /*if (convertView == null) convertView = mInflater.inflate(android.R.layout.two_line_list_item,parent,false);
        //TextView title = (TextView) convertView.findViewById(R.id.item_title);
        //TextView sub = (TextView) convertView.findViewById(R.id.item_subtitle);*/


	}
	
}