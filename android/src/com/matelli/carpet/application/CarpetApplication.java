package com.matelli.carpet.application;

import android.app.Application;

import com.matelli.carpet.models.User;

public class CarpetApplication extends Application {

	private User user = null;
	
	
	// GETTER / SETTER

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
