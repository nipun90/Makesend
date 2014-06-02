package com.Makesend.makesend;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Optional extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_optional);
		Button skip = (Button)findViewById(R.id.skip);
		skip.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent myIntent = new Intent(Optional.this, Discuss.class);
				Optional.this.startActivity(myIntent);
			}});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.optional, menu);
		return true;
	}

}
