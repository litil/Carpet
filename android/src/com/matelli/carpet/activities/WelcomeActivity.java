package com.matelli.carpet.activities;

import com.matelli.carpet.R;
import com.matelli.carpet.R.id;
import com.matelli.carpet.R.layout;
import com.matelli.carpet.R.menu;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
	
	private double longitude = 0f;
	private double latitude = 0f;
	private LocationManager lm;
	
	private final LocationListener locationListener = new LocationListener() {
	    public void onLocationChanged(Location location) {
	        longitude = location.getLongitude();
	        latitude = location.getLatitude();
	        Log.v("TEST", "Longitude : " + longitude + " - Latitude : " + latitude);
	        Toast.makeText(currentActivity, ("Super Longitude : " + longitude + " - Latitude : " + latitude + " - Speed : " + location.getSpeed()), Toast.LENGTH_LONG).show();
	    }

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
	};

	
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
        
        testGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	 Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                 double longitud = location.getLongitude();
                 double latitud = location.getLatitude();
                 Toast.makeText(currentActivity, ("Longitude : " + longitud + " - Latitude : " + latitud + " - Speed (m/s) : " + location.getSpeed()), Toast.LENGTH_LONG).show();
            }
        });
        
        
       
        
        lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 0, locationListener);
    }

    
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }
    
}
