package com.tac.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tac.entity.Categorie;
import com.tac.entity.Departement;
import com.tac.entity.Localisation;

/**
 * Objet servant au transport des critères de recherche
 * @author Ludo
 *
 */
public class CritereSearch implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int KEYWORD_MIN_LENGTH = 2;
	public static final String DEFAULT_DISTANCE_MAX = "0";
	public static final float DEGREE_PER_KM = 0.00898f;
	
	private String intitule;
	private Categorie cat;
	private Categorie sousCat;
	private String departement;
	private List<String> lieux = new ArrayList<>();
	private String distanceMax = "0";
	private List<String> valeurs = new ArrayList<>();
	private String etat = "0";
	private Float rayonRecherche = 0.0f;
	private List<Localisation> localisations;
	
	public CritereSearch() {
		valeurs.add("1");
		valeurs.add("2");
		valeurs.add("3");
		valeurs.add("4");
		valeurs.add("5");
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
	
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
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
		try {
			rayonRecherche = Integer.parseInt(distanceMax) * DEGREE_PER_KM;
		} catch (NumberFormatException e) {
			rayonRecherche = 0.0f;
		}
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

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	public Categorie getSousCat() {
		return sousCat;
	}

	public void setSousCat(Categorie sousCat) {
		this.sousCat = sousCat;
	}
	
}
