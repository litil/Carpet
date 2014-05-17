package com.matelli.carpet.network;

import java.sql.Timestamp;
import java.util.Date;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.matelli.carpet.utils.DateUtils;

public class VolleySharedInstance {
	private static VolleySharedInstance INSTANCE = new VolleySharedInstance();
	
	private Gson gson;
	protected RequestQueue mRequestQueue;
	protected ImageLoader mImageLoader;
	
	public VolleySharedInstance () {}
	
	public static VolleySharedInstance getInstance(Context c) {
		if (INSTANCE.mRequestQueue == null){
			//Default initialization
			INSTANCE.mRequestQueue = Volley.newRequestQueue(c);
			
			//INSTANCE.mImageLoader = new ImageLoader(INSTANCE.mRequestQueue, new BitmapLruCache());
			
			INSTANCE.gson  = new GsonBuilder()
			.registerTypeAdapter(Timestamp.class, new DateUtils.TimestampDeserializer())
			.registerTypeAdapter(Date.class, new DateUtils.DateDeserializer())
			.setDateFormat(DateUtils.SIMPLE_DATE_FORMAT_DEFAULT).create();
		}
		
		
		return INSTANCE;
	}
	
	public RequestQueue getSharedRequestQueue(){
		return mRequestQueue;
	}
	
	public ImageLoader getSharedImageLoader(){
		return mImageLoader;
	}

	public Gson getGSON(){
		return gson;
	}
}
