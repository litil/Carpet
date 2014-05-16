package com.matelli.carpet.activities;

import com.matelli.carpet.R;
import com.matelli.carpet.R.layout;
import com.matelli.carpet.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ConducteurActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conducteur);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.conducteur, menu);
		return true;
	}

}
