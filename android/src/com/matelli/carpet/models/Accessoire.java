package com.matelli.carpet.models;


/**
 * Represente les accessoires qu'un chien peut avoir (casquette, t-shirt)
 * 
 */
public class Accessoire {
	
	// ex: cap, hat, collar ...
	private String type;

	
	/**
	 * Empty constructor
	 */
	public Accessoire() {
		super();
	}
	
	
	
	// GETTER / SETTER
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
