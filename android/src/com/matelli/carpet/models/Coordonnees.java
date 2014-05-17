package com.matelli.carpet.models;

public class Coordonnees {

	double longitude;
	double latitude;
	float vitesse;
	
	public Coordonnees(double longitude, double latitude, float vitesse) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.vitesse = vitesse;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public float getVitesse() {
		return vitesse;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}
	
}
