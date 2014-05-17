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
	
	
	// TIMER
	public static final int TIME_CHECK_VITESSE = 1000;
	public static final int TIME_CHECK_TRAFFIC = 60000*2;
	public static final int TIME_CHECK_REPOS = 60000*3;
	
	
	// BROADCAST
	public static final String BROADCAST_VITESSE_LIMITE_ATTEINTE = "com.matelli.carpet.events.vitesse";
	public static final String BROADCAST_BONNE_CONDUITE = "com.matelli.carpet.events.bonne_conduite";
	public static final String BROADCAST_TRAFFIC = "com.matelli.carpet.events.traffic";
	public static final String BROADCAST_REPOS = "com.matelli.carpet.events.repos";
	
	// BROADCAST EXTRA

	public static final String BROADCAST_EXTRA_SCORE = "score";

}
