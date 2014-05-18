package com.matelli.carpet.services;

import java.util.List;

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

import com.android.volley.Request.Method;
import com.matelli.carpet.application.CarpetApplication;
import com.matelli.carpet.config.CarpetConstantes;
import com.matelli.carpet.models.Coordonnees;
import com.matelli.carpet.utils.FakeDataHelper;

public class LocationService extends Service {
	private static final String TAG = "LocationService";

	private CarpetApplication app = null;
	private LocationManager lm = null;

	private List<Coordonnees> coordonnees = null;
	private static int nbGoodCheck = 0;


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(coordonnees == null || coordonnees.size() == 0) {
			coordonnees = FakeDataHelper.fillListWithFakeCoordonnees();

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
						setMockLocation(coordonnee.getLatitude(), coordonnee.getLongitude(), 500, coordonnee.getVitesse());
						try {
							Thread.sleep(CarpetConstantes.TIME_CHECK_VITESSE);
						} catch(Exception e) {

						}
					}
				}
			}).start();

			// On lance le thread qui va changer les coordonnées géographiques
			new Thread(new Runnable() {

				@Override
				public void run() {
					while(true) {
						try {
							Thread.sleep(CarpetConstantes.TIME_CHECK_TRAFFIC);
						} catch (Exception e) {
							// TODO: handle exception
						}
						Intent intent = new Intent();
						intent.setAction(CarpetConstantes.BROADCAST_TRAFFIC);
						sendBroadcast(intent);
					}
				}
			}).start();

			// On lance le thread qui va changer les coordonnées géographiques
			new Thread(new Runnable() {

				@Override
				public void run() {
					while(true) {
						try {
							Thread.sleep(CarpetConstantes.TIME_CHECK_REPOS);
						} catch (Exception e) {
							// TODO: handle exception
						}
						Intent intent = new Intent();
						intent.setAction(CarpetConstantes.BROADCAST_REPOS);
						sendBroadcast(intent);
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

		public void onLocationChanged(final Location location) {
			double longitude = location.getLongitude();
			double latitude = location.getLatitude();
			Log.v("TEST", "Longitude : " + longitude + " - Latitude : " + latitude + " - Vitesse : " + location.getSpeed());

			// TODO détecter depassement de vitesse et broadcaster un message
			if(location.getSpeed() > 50) {
				// send broadcast
				Log.e(TAG, "MAUVAISE VITESSE");
				nbGoodCheck = 0;
				Intent intent = new Intent();
				intent.setAction(CarpetConstantes.BROADCAST_VITESSE_LIMITE_ATTEINTE);
				sendBroadcast(intent);
			} else {
				nbGoodCheck++;
				Log.e(TAG, "BONNE VITTESSE " + nbGoodCheck);
				if(nbGoodCheck%5==0) {
					Intent intent = new Intent();
					intent.putExtra(CarpetConstantes.BROADCAST_EXTRA_SCORE, nbGoodCheck*100);
					intent.setAction(CarpetConstantes.BROADCAST_BONNE_CONDUITE);
					sendBroadcast(intent);
				}
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
			java.lang.reflect.Method locationJellyBeanFixMethod = Location.class.getMethod("makeComplete");
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


} 
