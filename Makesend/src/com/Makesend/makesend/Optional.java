package com.Makesend.makesend;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Optional extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_optional, container, false);
		Button skip = (Button)rootView.findViewById(R.id.skip);
		skip.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Fragment fragment = new Discuss();
				FragmentManager fragmentManager = getFragmentManager();
	            fragmentManager.beginTransaction()
	                    .replace(R.id.frame_container, fragment).commit();
	 
	            // update selected item and title, then close the drawer
	            MainActivity.mDrawerList.setItemChecked(1, true);
	            MainActivity.mDrawerList.setSelection(1);
			}});
		return rootView;
	}

}
