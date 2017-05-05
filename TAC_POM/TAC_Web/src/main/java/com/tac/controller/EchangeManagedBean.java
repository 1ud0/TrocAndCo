package com.tac.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceProposition;
import com.tac.business.api.IServiceValeur;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Valeur;

@ManagedBean (name="mbEchange")
@SessionScoped
public class EchangeManagedBean {

	@ManagedProperty(value="#{mbObjet}")
	private ObjetManagedBean objetSelectedBean;
	
	@ManagedProperty(value="#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	
	@EJB
	IServiceProposition proxyProposition;
	
	@EJB
	IServiceValeur proxyValeur;
	
	@EJB
	IServiceEchange proxyEchange;
	
	private Membre membreCourant;
	private Proposition selectedProp;	
	private List<Proposition> propositionsMembre;
	private Proposition propositionPourEchange;	
	private List<Valeur> valeurs;
	private Valeur valeurPourEchange;
	private boolean prixFixe=false;
	
	private Echange echangePropose;
	
	public String loadPropositionEtMembre(){
		membreCourant=identifBean.getMembreConnected();
		selectedProp=objetSelectedBean.getSelectedProp();
		
		echangePropose = new Echange();
		valeurPourEchange = new Valeur();
		propositionPourEchange = new Proposition();
		
		String nav = "";
		if (selectedProp != null) {
			nav = "/echangeInitAcquereur.xhtml?faces-redirect=true";
		}
		return nav;
	}
	
	

	public String redirigerEchange(){
		return "/fiche.xhtml?faces-redirect=true&id=" + selectedProp.getIdProposition();
	}
	
	
	public void parametragePrixEchange(){
		if(prixFixe){
			echangePropose.setPrix(selectedProp.getValeur().getValeur());			
		}else{
			echangePropose.setPrix(valeurPourEchange.getValeur());
		}
	}
	
	public String ajouterEchange(){
		echangePropose.setProposition(selectedProp);
		echangePropose.setMembre(membreCourant);
		echangePropose = proxyEchange.initierEchange(echangePropose);
		return "/echangeAttenteValidation.xhtml?faces-redirect=true";
	}

	
	
	//GETTER SETTER
	public Membre getMembreCourant() {
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public Proposition getSelectedProp() {
		return selectedProp;
	}

	public void setSelectedProp(Proposition selectedProp) {
		this.selectedProp = selectedProp;
	}

	public ObjetManagedBean getObjetSelectedBean() {
		return objetSelectedBean;
	}

	public void setObjetSelectedBean(ObjetManagedBean objetSelectedBean) {
		this.objetSelectedBean = objetSelectedBean;
	}

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public IServiceProposition getProxyProposition() {
		return proxyProposition;
	}

	public void setProxyProposition(IServiceProposition proxyProposition) {
		this.proxyProposition = proxyProposition;
	}

	public List<Proposition> getPropositionsMembre() {
		propositionsMembre = proxyProposition.getByMembre(membreCourant);
		return propositionsMembre;
	}

	public void setPropositionsMembre(List<Proposition> propositionsMembre) {
		this.propositionsMembre = propositionsMembre;
	}

	public Proposition getPropositionPourEchange() {
		return propositionPourEchange;
	}

	public void setPropositionPourEchange(Proposition propositionPourEchange) {
		this.propositionPourEchange = propositionPourEchange;
	}

	public IServiceValeur getProxyValeur() {
		return proxyValeur;
	}

	public void setProxyValeur(IServiceValeur proxyValeur) {
		this.proxyValeur = proxyValeur;
	}

	public List<Valeur> getValeurs() {
		valeurs = proxyValeur.getAllValeur();
		return valeurs;
	}

	public void setValeurs(List<Valeur> valeurs) {
		this.valeurs = valeurs;
	}

	public Valeur getValeurPourEchange() {
		return valeurPourEchange;
	}

	public void setValeurPourEchange(Valeur valeurPourEchange) {
		this.valeurPourEchange = valeurPourEchange;
	}

	public Boolean getPrixFixe() {
		return prixFixe;
	}

	public void setPrixFixe(Boolean prixFixe) {
		this.prixFixe = prixFixe;
	}

	public Echange getEchangePropose() {
		echangePropose.setProposition(selectedProp);
		echangePropose.setMembre(membreCourant);
		return echangePropose;
	}

	public void setEchangePropose(Echange echangePropose) {
		this.echangePropose = echangePropose;
	}

	
	public void setPrixFixe(boolean prixFixe) {
		this.prixFixe = prixFixe;
	}

	public IServiceEchange getProxyEchange() {
		return proxyEchange;
	}

	public void setProxyEchange(IServiceEchange proxyEchange) {
		this.proxyEchange = proxyEchange;
	}
	
	
}
