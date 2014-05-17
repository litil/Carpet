package com.matelli.carpet.utils;

import com.matelli.carpet.config.CarpetConstantes;
import com.matelli.carpet.models.Chien;
import com.matelli.carpet.models.User;
import com.matelli.carpet.models.Voiture;

public class FakeDataHelper {
	
	private static final String USER_LOGIN = "John Doe";
	private static final String USER_PASSWORD = "carpet";
	private static final int USER_SCORE = 3198;
	
	private static final Double VOITURE_CONSOMMATION = 3.8;
	private static final String VOITURE_TYPE = "berline";
	private static final String VOITURE_COULEUR = "rouge";
	
	private static final String CHIEN_NOM = "Bobby";
	

	/**
	 * This method creates an instance of User, 
	 * with fake data.
	 * 
	 * @return User
	 */
	public static User createFakeUser(){
		User user = new User();
		
		user.setLogin(USER_LOGIN);
		user.setPassword(USER_PASSWORD);
		user.setScore(USER_SCORE);
		user.setChien(createFakeChien());
		user.setVoiture(createFakeVoiture());
		
		return user;
	}
	
	
	
	/**
	 * This method creates an instance of Voiture, 
	 * with fake data.
	 * 
	 * @return Voiture
	 */
	public static Voiture createFakeVoiture(){
		Voiture voiture = new Voiture();
		
		voiture.setConsommation(VOITURE_CONSOMMATION);
		voiture.setType(VOITURE_TYPE);
		voiture.setCouleur(VOITURE_COULEUR);
		
		return voiture;
	}
	
	
	/**
	 * This method creates an instance of Chien, 
	 * with fake data.
	 * 
	 * @return Chien
	 */
	public static Chien createFakeChien(){
		Chien chien = new Chien();
		
		chien.setHumeur(CarpetConstantes.HUMEUR_OK);
		chien.setNom(CHIEN_NOM);
		
		return chien;
	}
	
}
