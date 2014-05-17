package com.matelli.carpet.activities;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

import com.matelli.carpet.R;
import com.matelli.carpet.application.CarpetApplication;
import com.matelli.carpet.utils.FakeDataHelper;

public class WelcomeActivity extends RoboActivity {
	private static final String TAG = "WelcomeActivity";

	@InjectView(R.id.button_loggin)		RelativeLayout buttonLoggin; 

	private CarpetApplication carpetApp;
	private Activity currentActivity;

	private double longitude = 0f;
	private double latitude = 0f;
	private LocationManager lm;

	//	private final LocationListener locationListener = new LocationListener() {
	//	    public void onLocationChanged(Location location) {
	//	        longitude = location.getLongitude();
	//	        latitude = location.getLatitude();
	//	        Log.v("TEST", "Longitude : " + longitude + " - Latitude : " + latitude);
	//	    }
	//
	//		@Override
	//		public void onProviderDisabled(String provider) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void onProviderEnabled(String provider) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void onStatusChanged(String provider, int status, Bundle extras) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//	};


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

		lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 

		//        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
	}





	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}
