package com.tac.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.swing.plaf.SliderUI;

import com.tac.business.api.IServiceCompte;
import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceInscription;
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
	
	@EJB
	IServiceCompte proxyCompteMembre;
	
	private Membre membreCourant;
	private Membre membreAutre;
	
	
	private Proposition selectedProp;	
	private List<Proposition> propositionsMembre;
	private Proposition propositionPourEchange;	
	private List<Valeur> valeurs;
	private Valeur valeurPourEchange;
	private boolean prixFixe=false;
	private String codeRentre;
	
	private Echange echangePropose;
	
	private Echange echangeCourant;
	
	public String loadPropositionEtMembre(){
		membreCourant=identifBean.getMembreConnected();
		selectedProp=objetSelectedBean.getSelectedProp();
		membreAutre = selectedProp.getMembre();
		
		echangePropose = new Echange();
		valeurPourEchange = new Valeur();
		propositionPourEchange = new Proposition();
		
		String nav = "";
		if (selectedProp != null) {
			nav = "/echangeInitAcquereur.xhtml?faces-redirect=true";
		}
		return nav;
	}
	
	
	/**
	 *  a modifier
	 * @param echange
	 * @return
	 */
	public String loadEchangeAcquereur(Echange echange) {
		membreCourant=identifBean.getMembreConnected();
		selectedProp= echange.getProposition();
		membreAutre = selectedProp.getMembre();
		
		echangeCourant = echange;
		String nav = "";
		if (echange.getDateAnnul() != null || echange.getDateRefus() != null || (echange.getDateValidation() != null && echange.getComChercheur() != null)) {
			nav = "/echangeRecapAcquereur.xhtml?faces-redirect=true";
		}
		else if (echange.getDateValidation() != null) {
			nav = "/echangeEvaluation.xhtml?faces-redirect=true";
		}
		else if(echange.getDateAcceptation()!= null){
			nav = "/echangeCodeAcquereur.xhtml?faces-redirect=true";
		}
		else {
			nav = "/echangeAttenteValidation.xhtml?faces-redirect=true";
		}
		return nav;
	}
	
	public String loadEchangeDonneur(Echange echange) {
		membreCourant=identifBean.getMembreConnected();
		selectedProp= echange.getProposition();
		membreAutre = echange.getMembre();
		
		echangeCourant = echange;
		System.out.println("Date acceptation " + echangeCourant.getDateAcceptation());
		String nav = "";
		if (echange.getDateAnnul() != null || echange.getDateRefus() != null || (echange.getDateValidation() != null && echange.getComChercheur() != null)) {
			nav = "/echangeRecapDonneur.xhtml?faces-redirect=true";
		}
		else if (echange.getDateValidation() != null) {
			nav = "/echangeEvaluation.xhtml?faces-redirect=true";
		}
		else if(echange.getDateAcceptation()!= null){
			nav = "/echangeCodeDonneur.xhtml?faces-redirect=true";
		}
		else {
			nav = "/echangeInitDonneur.xhtml?faces-redirect=true";
		};
		return nav;
	}

	public String redirigerEchange(){
		return "/fiche.xhtml?faces-redirect=true&id=" + selectedProp.getIdProposition();
	}
	
	public String accepterEchange(){
		echangeCourant = proxyEchange.accepterEchange(echangeCourant);	
		return loadEchangeDonneur(echangeCourant);
	}
	
	public String refuserEchange(){
		echangeCourant = proxyEchange.refuserEchange(echangeCourant);
		System.out.println(echangeCourant.getDateRefus());
		return loadEchangeDonneur(echangeCourant);
	}
	
	public String annulerEchangeDonneur(){
		echangeCourant = proxyEchange.annulerEchange(echangeCourant);
		return loadEchangeDonneur(echangeCourant);
	}
	
	public String annulerEchangeAcquereur(){
		echangeCourant = proxyEchange.annulerEchange(echangeCourant);
		return loadEchangeAcquereur(echangeCourant);
	}
	
	public String validerCode(){
		String nav = "";	
		if (codeRentre != null){
			try {
				System.out.println("code" + codeRentre);
				int code = Integer.parseInt(codeRentre);
				if (code == echangeCourant.getCodeEchange()){
					echangeCourant = proxyEchange.validerEchange(echangeCourant);
					nav = loadEchangeDonneur(echangeCourant);
				}
			} catch(NumberFormatException e){
				
			};
		}
		return nav;
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


	public Echange getEchangeCourant() {
		return echangeCourant;
	}


	public void setEchangeCourant(Echange echangeCourant) {
		this.echangeCourant = echangeCourant;
	}


	public Membre getMembreAutre() {
		return membreAutre;
	}


	public void setMembreAutre(Membre membreAutre) {
		this.membreAutre = membreAutre;
	}


	public String getCodeRentre() {
		return codeRentre;
	}


	public void setCodeRentre(String codeRentre) {
		this.codeRentre = codeRentre;
	}
	
	
}
