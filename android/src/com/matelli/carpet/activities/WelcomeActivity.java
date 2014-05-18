package com.matelli.carpet.activities;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

import com.matelli.carpet.R;
import com.matelli.carpet.application.CarpetApplication;
import com.matelli.carpet.services.LocationService;
import com.matelli.carpet.services.ReposService;
import com.matelli.carpet.services.TrafficService;
import com.matelli.carpet.utils.FakeDataHelper;

public class WelcomeActivity extends RoboActivity {
	private static final String TAG = "WelcomeActivity";

	private Activity currentActivity;

	@InjectView(R.id.button_loggin)		RelativeLayout buttonLoggin; 

	private CarpetApplication carpetApp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		currentActivity = this;

		carpetApp = (CarpetApplication) this.getApplication();

		// got to EnfantActivity
		buttonLoggin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO request facebook
				// for now we build a fake User
				carpetApp.setUser(FakeDataHelper.createFakeUser());
				
				Intent intent = new Intent(currentActivity, EnfantActivity.class);
				currentActivity.startActivity(intent);
			}
		});


		Intent i = new Intent(this, LocationService.class);
		this.startService(i); 
		
		Intent iRepos = new Intent(this, ReposService.class);
		//this.startService(iRepos); 
		
		Intent iTraffic = new Intent(this, TrafficService.class);
		//this.startService(iTraffic); 
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}
