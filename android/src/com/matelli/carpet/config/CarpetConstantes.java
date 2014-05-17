package com.matelli.carpet.config;

public class CarpetConstantes {

	public static final String HUMEUR_FATIGUE = "fatigue";
	public static final String HUMEUR_FACHE = "fache";
	public static final String HUMEUR_OK = "ok";
	public static final String HUMEUR_CONTENT = "content";
	
	
	// NETWORK
	public static final String BASE_URL = "http://10.33.1.3:8000/";
	//public static final String BASE_URL = "http://localhost:8080/carpet/";
	public static final String EVENT_URL = BASE_URL + "events/";
	
	
	// TIMBER
	public static final int TIME_CHECK_VITESSE = 1000;
	
	
	// BROADCAST
	public static final String BROADCAST_VITESSE_LIMITE_ATTEINTE = "com.matelli.carpet.events.vitesse";

}
