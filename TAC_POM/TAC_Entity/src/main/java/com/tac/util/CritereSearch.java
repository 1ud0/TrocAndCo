package com.tac.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CritereSearch implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String intitule;
	private String cat;
	private String sousCat;
	private String departement;
	private List<String> lieux = new ArrayList<>();
	private String distanceMax;
	private List<String> valeurs = new ArrayList<>();
	private String etat;
	
	public CritereSearch() {
	}
	
	
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getSousCat() {
		return sousCat;
	}
	public void setSousCat(String sousCat) {
		this.sousCat = sousCat;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public List<String> getLieux() {
		return lieux;
	}
	public void setLieux(List<String> lieux) {
		this.lieux = lieux;
	}
	public String getDistanceMax() {
		return distanceMax;
	}
	public void setDistanceMax(String distanceMax) {
		this.distanceMax = distanceMax;
	}
	public List<String> getValeurs() {
		return valeurs;
	}
	public void setValeurs(List<String> valeurs) {
		this.valeurs = valeurs;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
