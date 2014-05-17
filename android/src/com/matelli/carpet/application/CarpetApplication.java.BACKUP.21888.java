package com.matelli.carpet.application;

import android.app.Application;
import android.location.LocationManager;

import com.matelli.carpet.models.User;

public class CarpetApplication extends Application {

<<<<<<< HEAD
	User user = null;

	private LocationManager lm = null;

	public LocationManager getLm() {
		return lm;
	}

	public void setLm(LocationManager lm) {
		this.lm = lm;
=======
	private User user = null;
	
	
	// GETTER / SETTER

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
>>>>>>> 72c3a228ae7a4a34834f99fa420451989436faac
	}
	
}
