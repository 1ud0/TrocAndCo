package com.tac.util;

public class Distance {

	private String texte;
	private int valeur;
	
	public Distance() {
	}

	public Distance(String texte, int valeur) {
		super();
		this.texte = texte;
		this.valeur = valeur;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	
}
