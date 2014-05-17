package com.matelli.carpet.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.matelli.carpet.config.CarpetConstantes;

public class ReposService extends Service {
	private static final String TAG = "ReposService";


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
			Log.d(TAG, "000000000");
		
			// On lance le thread qui va changer les coordonnées géographiques
			new Thread(new Runnable() {

				@Override
				public void run() {
					while(true) {
						try {
							Log.d(TAG, "1111111");
							Thread.sleep(CarpetConstantes.TIME_CHECK_REPOS);
						} catch (Exception e) {
							// TODO: handle exception
						}
						Log.d(TAG, "2222222222");
						Intent intent = new Intent();
						intent.setAction(CarpetConstantes.BROADCAST_REPOS);
						sendBroadcast(intent);
						Log.d(TAG, "3333333333");
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
