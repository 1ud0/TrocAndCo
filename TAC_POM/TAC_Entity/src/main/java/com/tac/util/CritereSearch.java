package com.tac.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tac.entity.Localisation;

public class CritereSearch implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int KEYWORD_MIN_LENGTH = 2;
	
	private String intitule;
	private String cat;
	private String sousCat;
	private String departement;
	private List<String> lieux = new ArrayList<>();
	private String distanceMax;
	private List<String> valeurs = new ArrayList<>();
	private String etat;
	private Float rayonRecherche;
	private List<Localisation> localisations;
	
	public CritereSearch() {
	}
	
	public List<String> getKeyWords() {
		List<String> keywords = new ArrayList<>();
		if (intitule != null && !intitule.equals("")) {
			String[] tab = intitule.split(" ");
			for (int i = 0; i < tab.length; i++) {
				if (tab[i].length() > KEYWORD_MIN_LENGTH) {
					keywords.add(tab[i]);
				}
			}
		}
		return keywords;
	}
	
	public Integer getEtatCast() {
		try {
			return Integer.parseInt(etat);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	public List<Integer> getValeursCast() {
		List<Integer> idValeurs = new ArrayList<>();
		for (String val : valeurs) {
			try {
				idValeurs.add(Integer.parseInt(val));
			} catch (NumberFormatException e) {
				
			}
		}
		return idValeurs;
	}
	
	public Integer getCatCast() {
		try {
			return Integer.parseInt(cat);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	public Integer getSousCatCast() {
		try {
			return Integer.parseInt(sousCat);
		} catch (NumberFormatException e) {
			return null;
		}
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
		lieux = new ArrayList<>();
		distanceMax = null;
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

	public Float getRayonRecherche() {
		return rayonRecherche;
	}

	public void setRayonRecherche(Float rayonRecherche) {
		this.rayonRecherche = rayonRecherche;
	}

	public List<Localisation> getLocalisations() {
		return localisations;
	}

	public void setLocalisations(List<Localisation> localisations) {
		this.localisations = localisations;
	}
	
}
