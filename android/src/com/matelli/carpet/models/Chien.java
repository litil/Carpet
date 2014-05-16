package com.matelli.carpet.models;

import java.util.List;

import com.matelli.carpet.config.CarpetConstantes;


/**
 * Un User a un Chien. Celui ci a :
 <pre>
 	- un nom
 	- une liste d'accessoires
 	- une humeur
 </pre>
 *
 */
public class Chien {
	
	private String nom;
	private List<Accessoire> accessoires;
	private String humeur = CarpetConstantes.HUMEUR_OK;
	
	
	
	/**
	 * Empty constructor
	 */
	public Chien() {
		super();
	}
	
	
	
	
	// GETTER / SETTER
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Accessoire> getAccessoires() {
		return accessoires;
	}
	public void setAccessoires(List<Accessoire> accessoires) {
		this.accessoires = accessoires;
	}
	public String getHumeur() {
		return humeur;
	}
	public void setHumeur(String humeur) {
		this.humeur = humeur;
	}

}
