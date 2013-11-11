package com.newzreadrapp.newzreadr;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		//Click Implementor class object
		CustomDialog onclicklistener = new CustomDialog(MainActivity.this);
		ImageButton eenaduButton = (ImageButton)findViewById(R.id.eenaduButton);
		ImageButton toiButton = (ImageButton) findViewById(R.id.toiButton);
		ImageButton andhrajyothiButton = (ImageButton)findViewById(R.id.andhrajyothiButton);
		eenaduButton.setOnClickListener(onclicklistener);
		toiButton.setOnClickListener(onclicklistener);
		andhrajyothiButton.setOnClickListener(onclicklistener);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
