package com.tac.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceRecherche;
import com.tac.data.api.IDaoCategorie;
import com.tac.data.api.IDaoLocalisation;
import com.tac.data.api.IDaoProposition;
import com.tac.data.api.IDaoSuggestion;
import com.tac.entity.Categorie;
import com.tac.entity.Envie;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Suggestion;
import com.tac.entity.Valeur;
import com.tac.util.CritereSearch;

@Remote(IServiceRecherche.class)
@Stateless
public class ServiceRecherche implements IServiceRecherche {

	public static final int GET_ALL_RESULTS = 0;
	public static final int GET_SUGGESTIONS = 4;
	
	@EJB
	private IDaoProposition proxyProposition;
	@EJB
	private IDaoLocalisation proxyLoc;
	@EJB
	private IDaoSuggestion proxySugg;
	@EJB
	private IDaoCategorie proxyCat;
	
	@Override
	public List<Proposition> getPropositionsBidon() {
		return proxyProposition.getNouveautes(20, null);
	}

	public List<Proposition> testseek(CritereSearch carac) {
		System.out.println("intitule : " + carac.getIntitule());
		System.out.println("cat : " + carac.getCat());
		System.out.println("souscat : " + carac.getSousCat());
		System.out.println("dep : " + carac.getDepartement());
		System.out.println("dist : " + carac.getDistanceMax());
		System.out.println("etat : " + carac.getEtat());
		for (String  elem : carac.getLieux()) {
			System.out.println("lieu : " + elem);
		}
		for (String coucou : carac.getValeurs()) {
			System.out.println("val : " + coucou);
		}
		return null;
	}

	@Override
	public List<Proposition> rechercher(CritereSearch carac, Membre membre) {
		Integer idMembre = membre == null ? null : membre.getIdMembre();
		List<Localisation> locs = new ArrayList<>();
		if (carac.getLieux().size() != 0) {
			//on recupère la liste des adresses de depart pour la recherche
			for (String lieu : carac.getLieux()) {
				try {
					locs.add(proxyLoc.getById(Integer.parseInt(lieu)));
				} catch (NumberFormatException e) { }
			}
		}
		carac.setLocalisations(locs);
		addToSuggestion(carac, membre);
		return proxyProposition.rechercher(carac, idMembre, GET_ALL_RESULTS);
	}

	private void addToSuggestion(CritereSearch carac, Membre membre) {
		if (membre != null) {
			Suggestion suggestion = proxySugg.getSuggestionByIdMembre(membre.getIdMembre());
			if (suggestion == null) {
				suggestion = new Suggestion();
				suggestion.setMembre(membre);
				setData(carac, suggestion);
				proxySugg.addSuggestion(suggestion);
			} else {
				setData(carac, suggestion);
				proxySugg.updateSuggestion(suggestion);
			}
		}
	}
	
	private void setData(CritereSearch carac, Suggestion suggestion) {
		suggestion.setCategorie(carac.getCat());
		suggestion.setSousCategorie(carac.getSousCat());
		suggestion.setIntitule(carac.getIntitule());
	}

	@Override
	public List<Proposition> getNewProps(int nombre, Membre membre) {
		Integer idMembre = membre == null ? null : membre.getIdMembre();
		return proxyProposition.getNouveautes(nombre, idMembre);
	}

	@Override
	public List<Proposition> findSuggestion(Membre membre) {
		if (membre != null) {
			Suggestion suggestion = proxySugg.getSuggestionByIdMembre(membre.getIdMembre());
			if (suggestion != null) {
				CritereSearch criteres = new CritereSearch();
				criteres.setCat(suggestion.getCategorie());
				criteres.setSousCat(suggestion.getSousCategorie());
				criteres.setIntitule(suggestion.getIntitule());
				return proxyProposition.rechercher(criteres, membre.getIdMembre(), GET_SUGGESTIONS);
			}
			
		}
		return null;
	}

	@Override
	public List<Proposition> rechercherEnvie(Envie envie) {
		Membre membre = envie.getListe().getMembre();
		Integer idMembre = membre == null ? null : membre.getIdMembre();
		CritereSearch carac = new CritereSearch();
		carac.setCat(envie.getCategorie());
		carac.setSousCat(envie.getSousCategorie());
		Integer distance = envie.getDistance();
		if (distance != null)
			carac.setDistanceMax(envie.getDistance().toString());
		carac.setValeurs(getListeValeur(envie));
		if (idMembre != null) {
			carac.setLocalisations(proxyLoc.getMembreLocalisations(idMembre));
		}
		return proxyProposition.rechercher(carac, idMembre, GET_SUGGESTIONS);
	}
	
	private List<String> getListeValeur(Envie envie) {
		List<String> valeurs = new ArrayList<>();
		Valeur val = envie.getValeur();
		Integer valeurMax;
		if (val == null) {
			valeurMax = 5;
		} else {
			valeurMax = val.getValeur();
		}
		for (Integer i = 1; i <= valeurMax; i++) {
			valeurs.add(i.toString());
		}
		return valeurs;
	}

}
