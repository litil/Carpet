package com.matelli.carpet.models;

import java.util.HashMap;


/**
 * This class is used to send "events" to the web server. 
 * Like "LIMIT_REACHED", limit : 130, value : 150
 *
 */
public class EventDTO {
	
	public String type;
	public HashMap<String, String> params;

	
	// limite de vitesse
	private String VITESSE_LIMITE_ATTEINTE = "VITESSE_LIMITE_ATTEINTE";
	private String VITESSE_LIMITE_ATTEINTE_OBJECTIF = "VITESSE_LIMITE_ATTEINTE_OBJECTIF";
	private String VITESSE_LIMITE_ATTEINTE_VALEUR = "VITESSE_LIMITE_ATTEINTE_VALEUR";
	
	// temps de trajet trop long
	private String TEMPS_CONDUITE = "TEMPS_CONDUITE";
	private String TEMPS_CONDUITE_OBJECTIF = "TEMPS_CONDUITE_OBJECTIF";
	private String TEMPS_CONDUITE_VALEUR = "TEMPS_CONDUITE_VALEUR";
	
	
	
	/**
	 * Empty constructor
	 */
	public EventDTO() {
		super();
	}


	/**
	 * Full constructor
	 * 
	 * @param type
	 * @param params
	 */
	public EventDTO(String type, HashMap<String, String> params) {
		super();
		this.type = type;
		this.params = params;
	}
	
	
	// GETTER / SETTER
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public HashMap<String, String> getParams() {
		return params;
	}
	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}
}
