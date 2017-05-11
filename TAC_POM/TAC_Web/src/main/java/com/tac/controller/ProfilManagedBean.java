package com.tac.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.tac.business.api.IServiceCompte;
import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceProposition;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@ManagedBean(name = "mbProfil")
@RequestScoped
public class ProfilManagedBean {

	@EJB
	private IServiceCompte proxyCompte;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	@EJB
	private IServiceProposition proxyProposition;
	@EJB
	private IServiceEchange proxyEchange;

	@ManagedProperty(value="#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	
	private Membre membreCourant;
	private Proposition selectedProp;

	public String loadProposition(Proposition proposition) {
		String nav = "";
		selectedProp = proposition;
		if (selectedProp != null) {
			nav = "/fiche.xhtml?faces-redirect=true";
		}
		return nav;
	}

	public IServiceCompte getProxyCompte() {
		return proxyCompte;
	}

	public void setProxyCompte(IServiceCompte proxyCompte) {
		this.proxyCompte = proxyCompte;
	}


	/**
	 * donne le membre courant
	 * et charge ses propositions
	 * @return
	 */
	public Membre getMembreCourant() {
		membreCourant = identifBean.getMembreConnected();
		membreCourant.setLocalisations(proxyLocalisation.getMembreLocalisations(membreCourant));
		List<Proposition> propositions = proxyProposition.getByMembre(membreCourant);
		for (Proposition proposition : propositions) {
			proposition.setPhotos(proxyProposition.getByProposition(proposition));
			proposition.setLocalisations(proxyLocalisation.getPropositionLocalisations(proposition));

		}

		membreCourant.setPropositions(propositions);

		return membreCourant;
	}

	public int getNombreNoteValeur(int noteATester, Membre membre) {
		int[] tableauNote = proxyEchange.getToutesLesNotes(membre);
		int taille = tableauNote.length;
		int nombreDeCetteNote = 0;
		int pourcentage =0;
		for (int i = 0; i < taille; i++) {
			if (tableauNote[i] == noteATester) {
				nombreDeCetteNote = nombreDeCetteNote + 1;
			}
		}
		if(taille!=0){
			pourcentage = (nombreDeCetteNote * 100) / taille;
			
		}
		return pourcentage;
	}

	public List<Echange> getEchangesQuandDonneur(Membre membre) {
		return proxyEchange.getByMembreDonneurFini(membre);
	}

	public List<Echange> getEchangesQuandAcheteur(Membre membre) {
		return proxyEchange.getByMembreChercheurFini(membre);
	}

	public int getCredit(Membre membre) {
		return proxyEchange.totalCredit(membre);
	}

	public int getNombreNote(Membre membre) {
		return proxyEchange.getTotalEchangeAvecNote(membre);
	}

	public int getNoteMoyenne(Membre membre) {
		return (int) proxyEchange.getNoteMoyenne(membre);
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}

	public IServiceProposition getProxyProposition() {
		return proxyProposition;
	}

	public void setProxyProposition(IServiceProposition proxyProposition) {
		this.proxyProposition = proxyProposition;
	}

	public IServiceEchange getProxyEchange() {
		return proxyEchange;
	}

	public void setProxyEchange(IServiceEchange proxyEchange) {
		this.proxyEchange = proxyEchange;
	}

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public Proposition getSelectedProp() {
		return selectedProp;
	}

	public void setSelectedProp(Proposition selectedProp) {
		this.selectedProp = selectedProp;
	}

}
