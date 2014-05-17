package com.matelli.carpet.network;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.util.Log;

import com.android.volley.Request.Method;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.matelli.carpet.config.CarpetConstantes;


/**
 * Just an example activity to make a request.
 *
 */
public class TestNetworkRequest extends Activity{
	private static final String TAG = "TestNetworkRequest";
	
	Activity currentActivity;

	public void testTequest(){
		String url = CarpetConstantes.BASE_URL + CarpetConstantes.EVENT_URL;

		//Listener Success
		Listener<String> listener = new com.android.volley.Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				Log.d(TAG, response);
				Gson gson = VolleySharedInstance.getInstance(currentActivity).getGSON();
			}
		};

		//Listener "Error" 
		com.android.volley.Response.ErrorListener errorListener = new com.android.volley.Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.d(TAG, "Error Loading friends...");
			}
		};


		VolleyAuthStringRequest myReq = new VolleyAuthStringRequest(Method.GET,  
				url,  
				listener,  
				errorListener, currentActivity) {  

			protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {  
				Map<String, String> params = new HashMap<String, String>();  
				return params;  
			};  
		};


		VolleySharedInstance.getInstance(currentActivity).getSharedRequestQueue().add(myReq);
	}
	
}
