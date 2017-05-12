package com.tac.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.tac.business.api.IServiceCompte;
import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceEnvie;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceProposition;
import com.tac.entity.Echange;
import com.tac.entity.Envie;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@ManagedBean(name = "mbProfil")
@ViewScoped
public class ProfilManagedBean {

	@EJB
	private IServiceCompte proxyCompte;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	@EJB
	private IServiceProposition proxyProposition;
	@EJB
	private IServiceEchange proxyEchange;
	@EJB
	private IServiceEnvie proxyEnvie;

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;

	private Membre membreCourant;
	private Proposition selectedProp;
	private double noteMoyenneMembre;
	private List<Envie> enviesMembre;
	private List<Proposition> propositionsMembre;
	private List<Echange> echangesDonneur;
	private List<Echange> echangesAcheteur;
	private int credit;
	private int nbNote;
	private int[] tableauNote;


	public int getNoteMoyenne(Membre membre) {
		return (int) proxyEchange.getNoteMoyenne(membre);
	}

	public void loadingPage() {
		Integer idMembre = null;
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			idMembre = Integer.parseInt(request.getParameter("numero"));
		} catch (Exception e) {

		}
		if (!FacesContext.getCurrentInstance().isPostback()) {
			if (idMembre != null && idMembre != 0) {
				membreCourant = proxyCompte.getById(idMembre);
				noteMoyenneMembre = proxyEchange.getNoteMoyenne(membreCourant);
				enviesMembre = proxyEnvie.getByMembre(membreCourant);
				propositionsMembre = proxyProposition.getByMembre(membreCourant);
				echangesDonneur = proxyEchange.getByMembreDonneurFini(membreCourant);
				echangesAcheteur = proxyEchange.getByMembreChercheurFini(membreCourant);
				credit = proxyEchange.totalCredit(membreCourant);
				nbNote = proxyEchange.getTotalEchangeAvecNote(membreCourant);
				tableauNote = proxyEchange.getToutesLesNotes(membreCourant);
			}
		}

	}

	public String LoadMembre(Membre membre) {
		String nav = "";
		if (membre != null) {
			nav = "/profil.xhtml?faces-redirect=true&numero=" + membre.getIdMembre();
		}
		return nav;
	}

	public boolean NoteVide() {
		if (noteMoyenneMembre == -1.0) {
			return true;
		}
		return false;
	}

	public int getNombreNoteValeur(int noteATester) {
		int taille = tableauNote.length;
		int nombreDeCetteNote = 0;
		int pourcentage = 0;
		for (int i = 0; i < taille; i++) {
			if (tableauNote[i] == noteATester) {
				nombreDeCetteNote = nombreDeCetteNote + 1;
			}
		}
		if (taille != 0) {
			pourcentage = (nombreDeCetteNote * 100) / taille;

		}
		return pourcentage;
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

	public IServiceEnvie getProxyEnvie() {
		return proxyEnvie;
	}

	public void setProxyEnvie(IServiceEnvie proxyEnvie) {
		this.proxyEnvie = proxyEnvie;
	}

	public double getNoteMoyenneMembre() {
		return noteMoyenneMembre;
	}

	public void setNoteMoyenneMembre(double noteMoyenneMembre) {
		this.noteMoyenneMembre = noteMoyenneMembre;
	}

	public List<Envie> getEnviesMembre() {
		return enviesMembre;
	}

	public void setEnviesMembre(List<Envie> enviesMembre) {
		this.enviesMembre = enviesMembre;
	}

	public IServiceCompte getProxyCompte() {
		return proxyCompte;
	}

	public void setProxyCompte(IServiceCompte proxyCompte) {
		this.proxyCompte = proxyCompte;
	}

	public List<Proposition> getPropositionsMembre() {
		return propositionsMembre;
	}

	public void setPropositionsMembre(List<Proposition> propositionsMembre) {
		this.propositionsMembre = propositionsMembre;
	}

	public Membre getMembreCourant() {
		return membreCourant;
	}

	public List<Echange> getEchangesDonneur() {
		return echangesDonneur;
	}

	public void setEchangesDonneur(List<Echange> echangesDonneur) {
		this.echangesDonneur = echangesDonneur;
	}

	public List<Echange> getEchangesAcheteur() {
		return echangesAcheteur;
	}

	public void setEchangesAcheteur(List<Echange> echangesAcheteur) {
		this.echangesAcheteur = echangesAcheteur;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getNbNote() {
		return nbNote;
	}

	public void setNbNote(int nbNote) {
		this.nbNote = nbNote;
	}

}
