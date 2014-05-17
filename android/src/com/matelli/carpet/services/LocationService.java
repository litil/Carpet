package com.matelli.carpet.services;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.matelli.carpet.application.CarpetApplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class LocationService extends Service {

	private CarpetApplication app = null;
	private LocationManager lm = null;
	
	private List<Coordonnees> coordonnees = new ArrayList<Coordonnees>();
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(coordonnees.size() == 0)
		{
			// On initialise la liste de coordonnées
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 30.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 60.0f));
			coordonnees.add(new Coordonnees(15.387653, 73.872585, 50.0f));
						
			// On récupère le location manager et on l'initialise en mode test
			app =(CarpetApplication)this.getApplication();
			lm = app.getLm();
			
			lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
			lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
			
			// On lance le thread qui va changer les coordonnées géographiques
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(Coordonnees coordonnee : coordonnees) {
						setMockLocation(coordonnee.latitude, coordonnee.longitude, 500, coordonnee.vitesse);
						try {
							Thread.sleep(15000);
						} catch(Exception e) {
							
						}
					}
				}
			}).start();
		}
		
		return Service.START_NOT_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		//TODO for communication return IBinder implementation
		return null;
	}
	
	// Listener pour les changement de coordonnees géographiques
	private final LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			double longitude = location.getLongitude();
			double latitude = location.getLatitude();
			Log.v("TEST", "Longitude : " + longitude + " - Latitude : " + latitude + " - Vitesse : " + location.getSpeed());
			
			// TODO détecter dépassement de vitesse et broadcaster un message
			if(location.getSpeed() > 50) {
				Log.v("TEST", "DANGEEEEEEEEEEEER");
			}
		}

		@Override
		public void onProviderDisabled(String provider) {
		}

		@Override
		public void onProviderEnabled(String provider) {
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	};
	
	/**
	 * Méthode permettant de créer de fausse coordonnées
	 * 
	 * @param latitude
	 * @param longitude
	 * @param accuracy
	 */
	private void setMockLocation(double latitude, double longitude, float accuracy, float speed) {
		lm.addTestProvider (LocationManager.GPS_PROVIDER,
				"requiresNetwork" == "",
				"requiresSatellite" == "",
				"requiresCell" == "",
				"hasMonetaryCost" == "",
				"supportsAltitude" == "",
				"supportsSpeed" == "supportsSpeed",
				"supportsBearing" == "",
				android.location.Criteria.POWER_LOW,
				android.location.Criteria.ACCURACY_FINE);      

		Location newLocation = new Location(LocationManager.GPS_PROVIDER);

		newLocation.setLatitude(latitude);
		newLocation.setLongitude(longitude);
		newLocation.setAccuracy(accuracy);
		newLocation.setSpeed(speed);

		try
		{
			// Permet de compléter la location avec tous les champs obligatoires
			Method locationJellyBeanFixMethod = Location.class.getMethod("makeComplete");
			if (locationJellyBeanFixMethod != null) {
				locationJellyBeanFixMethod.invoke(newLocation);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

		lm.setTestProviderEnabled(LocationManager.GPS_PROVIDER, true);

		lm.setTestProviderStatus(LocationManager.GPS_PROVIDER,
				LocationProvider.AVAILABLE,
				null,System.currentTimeMillis());    

		lm.setTestProviderLocation(LocationManager.GPS_PROVIDER, newLocation);  

	}
	
	// Classe coordonnees uniquement à usage interne
	public class Coordonnees {
		double longitude;
		double latitude;
		float vitesse;
		
		public Coordonnees(double longitude, double latitude, float vitesse) {
			this.longitude = longitude;
			this.latitude = latitude;
			this.vitesse = vitesse;
		}
		
		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public float getVitesse() {
			return vitesse;
		}

		public void setVitesse(float vitesse) {
			this.vitesse = vitesse;
		}

	}
	
	
} 
