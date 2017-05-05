package com.tac.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceCategorie;
import com.tac.business.api.IServiceEtat;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceLocaliserProposition;
import com.tac.business.api.IServiceProposition;
import com.tac.business.api.IServiceValeur;
import com.tac.entity.Categorie;
import com.tac.entity.Etat;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Valeur;

@ManagedBean(name="mbCompteObjet")
@ViewScoped
public class CompteObjetsManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IServiceProposition proxyObjet;
	
	@EJB
	private IServiceCategorie proxyCategorie;
	
	@EJB
	private IServiceEtat proxyEtat;
	
	@EJB
	private IServiceValeur proxyValeur;
	
	@EJB
	private IServiceLocalisation proxyLocalisation;
	
	@EJB
	private IServiceLocaliserProposition proxyLocaliserProposition;
	
	@ManagedProperty(value="#{mbIdentif}")
	private IdentificationManagedBean identifBean;	
	private String intituleSelected="";
	private Etat etatSelected = new Etat();
	private Valeur valeurSelected = new Valeur();
	private List<Proposition> proposDuMembre = new ArrayList<>();
	private List<Localisation> adressesDuMembre = new ArrayList<>();
	private List<Localisation> adressesSelected = new ArrayList<>();
	private List<String> idAdressesSelected = new ArrayList<>();
	private List<Categorie> sousCategoriesSelected;	
	private Categorie sousCategorieSelected = new Categorie();
	private List<Categorie> allCategories;
	private Membre membreCourant ;
	private Proposition propositionSelected;
	private Categorie categorieSelected = new Categorie();
	private String descriptionSelected ="";

	
	//METHODES
	
	public void listenerChargementSousCat(){
		sousCategoriesSelected = proxyCategorie.getCategorieFille(categorieSelected.getIdCategorie());
	}
	
	public List<Categorie> getAllCategorie(){
		allCategories = proxyCategorie.getCategorieMere();
		return allCategories;
	}
		
	
	public List<Proposition> getProposDuMembre() {	
		membreCourant = identifBean.getMembreConnected();
		proposDuMembre = proxyObjet.getByMembre(membreCourant);
		for (Proposition proposition:proposDuMembre) {
			proposition.setPhotos(proxyObjet.getByProposition(proposition));
			
		}
		
		return proposDuMembre;		
	}
	
	public void listnerSelectionObjet(Proposition proposition){
		propositionSelected = proposition;
		descriptionSelected =propositionSelected.getDescription();
		intituleSelected = propositionSelected.getIntitule();		
		categorieSelected = propositionSelected.getCategorie();
		sousCategorieSelected = propositionSelected.getSousCategorie();
		valeurSelected = propositionSelected.getValeur();
		etatSelected = propositionSelected.getEtat();
		listenerChargementSousCat();
	}
	
	private void updateLocalisationProposition(){
		System.out.println("l'id de la proposition est : " +propositionSelected.getIdProposition());

		for (Localisation oldLocalisation : getAdresseByProposition(propositionSelected)) {
			proxyLocaliserProposition.deleteLocalisationAUneProposition(propositionSelected, oldLocalisation);
			System.out.println("old"+propositionSelected.getIdProposition() +","+oldLocalisation.getIdLocalisation());
		}
		adressesSelected=GetListAdressesSelected(idAdressesSelected);
		for (Localisation newLocalisation : adressesSelected) {
			proxyLocaliserProposition.addLocalisationAUneProposition(propositionSelected, newLocalisation);
			System.out.println(propositionSelected.getIdProposition() +","+newLocalisation.getIdLocalisation());
		}		
	}	
	public String updateObjet(){
		updateLocalisationProposition();
		propositionSelected.setIntitule(intituleSelected);
		propositionSelected.setValeur(valeurSelected);
		propositionSelected.setEtat(etatSelected);
		propositionSelected.setCategorie(categorieSelected);
		propositionSelected.setSousCategorie(sousCategorieSelected);		
		propositionSelected.setLocalisations(adressesSelected);
		propositionSelected.setDescription(descriptionSelected);
		propositionSelected = proxyObjet.updateProposition(propositionSelected);		
		String nav = "";
		return nav;
	}
	
	public List<Localisation> GetListAdressesSelected(List<String> idAdressesSelected){		
		Localisation adresseSelected = new Localisation();
		int idAdresseInt;
		for (String idLocalisation : idAdressesSelected) {
			idAdresseInt = Integer.parseInt(idLocalisation);
			adresseSelected = proxyLocalisation.getById(idAdresseInt);
			adressesSelected.add(adresseSelected);
		}
		return adressesSelected;
	}	
	
	public List<Localisation> getAdresseByMembre(){
		membreCourant = identifBean.getMembreConnected();
		adressesDuMembre = proxyLocalisation.getMembreLocalisations(membreCourant);
		return adressesDuMembre;
	}	
	
	public List<Localisation> getAdresseByProposition(Proposition propositionSelected){
		List<Localisation> localisationsPropo = proxyLocalisation.getPropositionLocalisations(propositionSelected);
		return  localisationsPropo;
	}
	
	
	
	//GETTER SETTER
	
	
	public List<Localisation> getAdressesSelected() {
		return adressesSelected;
	}

	public void setAdressesSelected(List<Localisation> adressesSelected) {
		this.adressesSelected = adressesSelected;
	}

	public List<Etat> getAllEtat(){
		List<Etat> listeEtat = proxyEtat.getAllEtat();
		return listeEtat;
	}
	
	public List<Valeur> getAllValeur(){
		List<Valeur> listeValeur = proxyValeur.getAllValeur();
		return listeValeur;
	}

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public Proposition getPropositionSelected() {
		return propositionSelected;
	}



	public void setPropositionSelected(Proposition propositionSelected) {
		this.propositionSelected = propositionSelected;
	}


	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}



	public void setProposDuMembre(List<Proposition> proposDuMembre) {
		this.proposDuMembre = proposDuMembre;
	}


	public List<String> getIdAdressesSelected() {
		return idAdressesSelected;
	}

	public void setIdAdressesSelected(List<String> idAdressesSelected) {
		this.idAdressesSelected = idAdressesSelected;
	}

	public List<Localisation> getAdressesDuMembre() {
		return adressesDuMembre;
	}

	public void setAdressesDuMembre(List<Localisation> adressesDuMembre) {
		this.adressesDuMembre = adressesDuMembre;
	}


	public Membre getMembreCourant() {
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public IServiceProposition getProxyObjet() {
		return proxyObjet;
	}

	public void setProxyObjet(IServiceProposition proxyObjet) {
		this.proxyObjet = proxyObjet;
	}

	public IServiceCategorie getProxyCategorie() {
		return proxyCategorie;
	}

	public void setProxyCategorie(IServiceCategorie proxyCategorie) {
		this.proxyCategorie = proxyCategorie;
	}

	public IServiceEtat getProxyEtat() {
		return proxyEtat;
	}

	public void setProxyEtat(IServiceEtat proxyEtat) {
		this.proxyEtat = proxyEtat;
	}

	public IServiceValeur getProxyValeur() {
		return proxyValeur;
	}

	public void setProxyValeur(IServiceValeur proxyValeur) {
		this.proxyValeur = proxyValeur;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}

	public Categorie getSousCategorieSelected() {
		return sousCategorieSelected;
	}

	public void setSousCategorieSelected(List<Categorie> sousCategorieSelected) {
		this.sousCategoriesSelected = sousCategorieSelected;
	}

	public Categorie getCategorieSelected() {
		return categorieSelected;
	}

	public void setCategorieSelected(Categorie categorieSelected) {
		this.categorieSelected = categorieSelected;
	}

	public List<Categorie> getAllCategories() {
		return allCategories;
	}

	public void setAllCategories(List<Categorie> allCategories) {
		this.allCategories = allCategories;
	}

	public List<Categorie> getSousCategoriesSelected() {
		return sousCategoriesSelected;
	}

	public void setSousCategoriesSelected(List<Categorie> sousCategoriesSelected) {
		this.sousCategoriesSelected = sousCategoriesSelected;
	}

	public void setSousCategorieSelected(Categorie sousCategorieSelected) {
		this.sousCategorieSelected = sousCategorieSelected;
	}

	public String getIntituleSelected() {
		return intituleSelected;
	}

	public void setIntituleSelected(String intituleSelected) {
		this.intituleSelected = intituleSelected;
	}

	public Etat getEtatSelected() {
		return etatSelected;
	}

	public void setEtatSelected(Etat etatSelected) {
		this.etatSelected = etatSelected;
	}

	public Valeur getValeurSelected() {
		return valeurSelected;
	}

	public void setValeurSelected(Valeur valeurSelected) {
		this.valeurSelected = valeurSelected;
	}

	public String getDescriptionSelected() {
		return descriptionSelected;
	}

	public void setDescriptionSelected(String descriptionSelected) {
		this.descriptionSelected = descriptionSelected;
	}

	public IServiceLocaliserProposition getProxyLocaliserProposition() {
		return proxyLocaliserProposition;
	}

	public void setProxyLocaliserProposition(IServiceLocaliserProposition proxyLocaliserProposition) {
		this.proxyLocaliserProposition = proxyLocaliserProposition;
	}
	
	
			
	
	
}
