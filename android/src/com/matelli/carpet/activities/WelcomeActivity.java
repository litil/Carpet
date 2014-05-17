package com.matelli.carpet.activities;

import java.lang.reflect.Method;
import java.util.Date;

import com.matelli.carpet.R;
import com.matelli.carpet.R.id;
import com.matelli.carpet.R.layout;
import com.matelli.carpet.R.menu;
import com.matelli.carpet.services.LocationService;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends RoboActivity {
	private static final String TAG = "WelcomeActivity";

	@InjectView(R.id.button_goto_enfant)		Button gotoEnfant; 
	@InjectView(R.id.button_goto_conducteur)	Button gotoConducteur; 
	@InjectView(R.id.button_geo)				Button testGeo; 

	private Activity currentActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		currentActivity = this;

		// got to EnfantActivity
		gotoEnfant.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(currentActivity, EnfantActivity.class);
				currentActivity.startActivity(intent);
			}
		});

		// got to ConducteurActivity
		gotoConducteur.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(currentActivity, ConducteurActivity.class);
				currentActivity.startActivity(intent);
			}
		});

//		testGeo.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//				double longitud = location.getLongitude();
//				double latitud = location.getLatitude();
//				Toast.makeText(currentActivity, ("Longitude : " + longitud + " - Latitude : " + latitud + " - Speed (m/s) : " + location.getSpeed()), Toast.LENGTH_LONG).show();
//			}
//		});




		

		Intent i= new Intent(this, LocationService.class);
		this.startService(i); 

	}





	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

	

}
