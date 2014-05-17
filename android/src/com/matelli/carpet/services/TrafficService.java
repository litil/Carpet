package com.matelli.carpet.services;

import com.matelli.carpet.config.CarpetConstantes;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TrafficService extends Service {
	private static final String TAG = "TrafficService";


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
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
		return Service.START_NOT_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		//TODO for communication return IBinder implementation
		return null;
	}



} 
