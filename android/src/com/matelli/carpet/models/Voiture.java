package com.matelli.carpet.models;


/**
 * Cette classe contient les informations liees a la voiture : 
 <pre>
 	- type
 	- consommation
 	- couleur
 </pre>
 *
 */
public class Voiture {

	private String type;
	private Double consommation;
	private String couleur;
	
	
	public Voiture() {
		
	}
	
	
	// GETTER / SETTER
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getConsommation() {
		return consommation;
	}
	public void setConsommation(Double consommation) {
		this.consommation = consommation;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
}
