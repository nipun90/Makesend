package com.Makesend.makesend;



import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	static ListView mDrawerList;
	static DrawerLayout mDrawerLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		ArrayList<String> pages = new ArrayList<String>();
		pages.add("Home");
		pages.add("Shop");
		pages.add("Login");
		pages.add("Register");
		MArrayAdapter adapter = new MArrayAdapter(getApplicationContext(),pages);
		mDrawerList.setAdapter(adapter);
		mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                int position, long id) {
            	displayFragment(position);
            }

          });
		if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayFragment(0);
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}
	
	public void displayFragment(int position){
		Fragment fragment = null;
    	switch(position){
    	case 0:
    		fragment= new Home();
    		break;
    	case 1:
    		fragment= new Discuss();
    		break;
    	case 2:
    		fragment= new Login();
    		break;
    	case 3:
    		fragment= new Register();
    		break;
    	}
    	if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();
 
            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
	}

}
