package com.tac.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceCategorie;
import com.tac.business.api.IServiceEtat;
import com.tac.business.api.IServiceLocalisation;
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
	
	@ManagedProperty(value="#{mbIdentif}")
	private IdentificationManagedBean identifBean;	
	
	private List<Proposition> proposDuMembre;
	private List<Localisation> adressesDuMembre;
	private Membre membreCourant ;
	private Proposition propositionSelected;
	
	

	public List<Localisation> getAdressesDuMembre() {
		return adressesDuMembre;
	}

	public void setAdressesDuMembre(List<Localisation> adressesDuMembre) {
		this.adressesDuMembre = adressesDuMembre;
	}

	public List<Proposition> getProposDuMembre() {	
		membreCourant = identifBean.getMembreConnected();
		proposDuMembre = proxyObjet.getByMembre(membreCourant);
		return proposDuMembre;
		
	}
	
	public void listnerSelectionObjet( Proposition proposition){
		propositionSelected = proposition;
	}
	
	public List<Categorie> getAllCategorie(){
		List<Categorie> categorie = proxyCategorie.getCategorieMere();
		return categorie;
	}
	
	public List<Categorie> getAllSousCategorie(int idCategorie){
		List<Categorie> sousCategorie = proxyCategorie.getCategorieFille(idCategorie);
		return sousCategorie;
	}
	
	public void updateObjet(){
		propositionSelected = proxyObjet.updateProposition(propositionSelected);
	}
	
	
	public List<Etat> getAllEtat(){
		List<Etat> listeEtat = proxyEtat.getAllEtat();
		return listeEtat;
	}
	
	public List<Valeur> getAllValeur(){
		List<Valeur> listeValeur = proxyValeur.getAllValeur();
		return listeValeur;
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



	public Membre getMembreCourant() {
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}
	
	
			
	
	
}
