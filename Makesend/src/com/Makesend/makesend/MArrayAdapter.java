package com.Makesend.makesend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class MArrayAdapter extends ArrayAdapter<String>{
	List<String> page = new ArrayList<String>();
	Context context;
	public MArrayAdapter(Context c, List<String> list){
		super(c, R.layout.list_element, list);
		context = c;
		page = list;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.list_element, parent, false);
		TextView t1 = (TextView)rowView.findViewById(R.id.title);
		t1.setText(page.get(position));
    	return rowView;
	} 

	
}
