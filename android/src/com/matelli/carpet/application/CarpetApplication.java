package com.matelli.carpet.application;

import android.app.Application;
import android.location.LocationManager;

import com.matelli.carpet.models.User;

public class CarpetApplication extends Application {

	User user = null;

	private LocationManager lm = null;

	// GETTER / SETTER

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public LocationManager getLm() {
		return lm;
	}

	public void setLm(LocationManager lm) {
		this.lm = lm;
	}
	
}
