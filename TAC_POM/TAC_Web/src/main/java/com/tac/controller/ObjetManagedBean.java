package com.tac.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceEnvie;
import com.tac.business.api.IServiceFavori;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceProposition;
import com.tac.entity.Envie;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@ManagedBean(name = "mbObjet")
@SessionScoped
public class ObjetManagedBean {

	@EJB
	private IServiceProposition proxyProp;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	
	@EJB
	private IServiceEnvie proxyEnvie;
	
	@EJB
	private IServiceEchange proxyEchange;
	@EJB
	private IServiceFavori proxyFavori;

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;

	private Proposition selectedProp;
	private Membre selectedMembre;
	private Membre membreCourant;

	private Integer entryId;

	public boolean dejaFavori() {
		membreCourant = identifBean.getMembreConnected();
		if (membreCourant != null) {
			for (Proposition proposition : proxyFavori.getFavorisMembre(membreCourant)) {
				if (proposition.getIdProposition() == selectedProp.getIdProposition()) {
					return true;
				}
			}
		}
		return false;
	}

	public String ajouterFavori() {
		membreCourant = identifBean.getMembreConnected();
		if (membreCourant != null) {
			proxyFavori.addToFavoris(selectedProp, membreCourant);
		}
		String nav = "";
		return nav;
	}

	public String deleteFavori() {
		membreCourant = identifBean.getMembreConnected();
		if (membreCourant != null) {
			proxyFavori.deleteFavori(selectedProp, membreCourant);
		}
		String nav = "";
		return nav;

	}

	public String loadProposition(Proposition proposition) {
		String nav = "";
		selectedProp = proposition;
		if (selectedProp != null) {
			nav = "/fiche.xhtml?faces-redirect=true&id=" + selectedProp.getIdProposition();
		}
		return nav;
	}

	public String LoadMembre(Membre membre) {
		String nav = "";
		selectedMembre = membre;
		if (selectedMembre != null) {
			nav = "/profil.xhtml?faces-redirect=true";
		}
		return nav;
	}
	
	public boolean NoteVide(Membre membre){
		if(proxyEchange.getNoteMoyenne(membre)==-1.0){
			return true;
		}
		return false;
	}
	
	public double getNoteMoyenne(Membre membre){
		return proxyEchange.getNoteMoyenne(membre);
	}
	
	public List<Envie> getEnviesAutreMembre(Membre membre){
		return proxyEnvie.getByMembre(membre);
	}
	
	public List<Localisation> getLocalisationByMembre(Membre membre){
		return proxyLocalisation.getMembreLocalisations(membre);
	}
	

	public void loadEntry() {
		System.out.println(entryId);
		// selectedProp = proxyProp
	}

	public IServiceProposition getProxyProp() {
		return proxyProp;
	}

	public void setProxyProp(IServiceProposition proxyProp) {
		this.proxyProp = proxyProp;
	}

	public Proposition getSelectedProp() {

		return selectedProp;
	}

	public void setSelectedProp(Proposition selectedProp) {
		this.selectedProp = selectedProp;
	}

	public Membre getSelectedMembre() {
		return selectedMembre;
	}

	public void setSelectedMembre(Membre selectedMembre) {
		this.selectedMembre = selectedMembre;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}

	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public IServiceFavori getProxyFavori() {
		return proxyFavori;
	}

	public void setProxyFavori(IServiceFavori proxyFavori) {
		this.proxyFavori = proxyFavori;
	}

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public Membre getMembreCourant() {
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

}
