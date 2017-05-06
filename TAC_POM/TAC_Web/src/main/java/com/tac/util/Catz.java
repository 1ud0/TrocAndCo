package com.tac.util;

import com.tac.entity.Categorie;

public class Catz {

	private Categorie categorie;
	private int occurence;
	
	public Catz() {
	}

	public Catz(Categorie categorie, int occurence) {
		this.categorie = categorie;
		this.occurence = occurence;
	}

	public void addOccurence() {
		occurence++;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public int getOccurence() {
		return occurence;
	}

	public void setOccurence(int occurence) {
		this.occurence = occurence;
	}
	
	
}
