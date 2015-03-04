package com.csit175.span.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.csit175.span.R;
import com.csit75.span.models.DashboardItem;

public class DashboardAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final ArrayList<DashboardItem> items;
	
	public DashboardAdapter(Context context, ArrayList<DashboardItem> items){
		super(context, R.layout.fragment_main);
		this.context=context;
		this.items=items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflater.inflate(R.layout.fragment_main, parent, false);
		TextView day = (TextView) rowView.findViewById(R.id.day);
		TextView day_name = (TextView) rowView.findViewById(R.id.day_name);
		TextView about_act = (TextView) rowView.findViewById(R.id.act);
		TextView time_place = (TextView) rowView.findViewById(R.id.place);
		ImageView cover = (ImageView) rowView.findViewById(R.id.image);
		
		day.setText(items.get(position).day);
		day_name.setText(items.get(position).day_name);
		about_act.setText(items.get(position).about_act);
		time_place.setText(items.get(position).time_place);
		cover.setImageResource(items.get(position).cover);
		
		return rowView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	
}
