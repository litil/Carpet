package com.matelli.carpet.activities;

import roboguice.activity.RoboActivity;
import android.os.Bundle;
import android.view.Menu;

import com.matelli.carpet.R;

public class ConducteurActivity extends RoboActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
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
