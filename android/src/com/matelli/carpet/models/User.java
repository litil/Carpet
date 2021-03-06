package com.matelli.carpet.models;


/**
 * La classe User permet de stocker 
 <pre>
 	- login / password
 	- modele de voiture
 		- consommation, ... recuperes de l'API Vinci
 	- lien vers le chien
 
 
 </pre>
 *
 */
public class User {
	
	private String login;
	private String password;
	private Chien chien;
	private Voiture voiture;
	private int score;
	
	
	/**
	 * Empty constructor
	 */
	public User() {
		
	}
	
	private final static User Instance = new User("John Doe", 42);

    public static User getInstance()
    {
        return Instance;
    }

    private User(String login, int score)
    {
        this.setLogin(login);
        this.setScore(score);
    }
	public static User createFakeUser(){
		User user = new User();
		
		user.setLogin("John Doe");
        user.setScore(4500);
		
		return user;
	}
	
	
	// GETTER / SETTER
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Chien getChien() {
		return chien;
	}
	public void setChien(Chien chien) {
		this.chien = chien;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	

}
