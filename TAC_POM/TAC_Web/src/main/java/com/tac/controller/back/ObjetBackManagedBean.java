package com.tac.controller.back;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceEnvie;
import com.tac.business.api.IServiceFavori;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceProposition;
import com.tac.controller.IdentificationManagedBean;
import com.tac.entity.Categorie;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Valeur;
import com.tac.exception.DataAccessException;

@ViewScoped
@ManagedBean(name = "mbObjBack")
public class ObjetBackManagedBean {

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
	private Proposition obj;
	private Integer entryId;
	private List<Proposition> allPropositions;
	private Proposition selectedProp;

	private Categorie catSelect = new Categorie();
	private Categorie souCatSelect =  new Categorie();
	private Proposition ObjSelect = new Proposition();
	private Valeur valSelect = new Valeur();
	private Membre mbrSelect = new Membre();
	private String intituleSelect = "";

	@PostConstruct
	public void init() {
		System.out.println("dans post construct");
		loadAllPropositions();
	}

	// Charge toutes les propositions
	public List<Proposition> loadAllPropositions() {
		Date dbt = new Date();
		allPropositions = proxyProp.LoadAllPropositions();
		for (Proposition p : allPropositions) {
			p.setLocalisations(proxyLocalisation.getPropositionLocalisations(p));
		}
		Date fin = new Date();
		System.out.println("temps - " +( fin.getTime() - dbt.getTime()));
		return allPropositions;
	}

	// charge la proposition en cours et ses informations
	public String loadProposition(Proposition proposition) {
		String nav = "";
		selectedProp = proposition;
		if (selectedProp != null) {
			nav = "/fiche.xhtml?faces-redirect=true&id=" + selectedProp.getIdProposition();
		}
		return nav;
	}

	public String modifierInfosBack(){
		String infoModified = "";
		ObjSelect.setMembre(mbrSelect); 
		ObjSelect.setIntitule(intituleSelect);
		ObjSelect.setCategorie(catSelect);
		ObjSelect.setSousCategorie(souCatSelect);
		ObjSelect.setValeur(valSelect);
		ObjSelect = proxyProp.updateProposition(ObjSelect);
		return infoModified;
	}

	public void loadEntry() {
		if (entryId != null && entryId != 0) {
			try {
				selectedProp = proxyProp.getById(entryId);
			} catch (DataAccessException e) {
				String message = "Erreur lors du chargement de la page : " + e.getMessage();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
				selectedProp = null;
			}
		}
	}

	public void loadObject(Proposition prop) {
		obj = prop;
		System.out.println(obj.getIntitule());
	}

	public IServiceProposition getProxyProp() {
		return proxyProp;
	}

	public void setProxyProp(IServiceProposition proxyProp) {
		this.proxyProp = proxyProp;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}

	public IServiceEnvie getProxyEnvie() {
		return proxyEnvie;
	}

	public void setProxyEnvie(IServiceEnvie proxyEnvie) {
		this.proxyEnvie = proxyEnvie;
	}

	public IServiceEchange getProxyEchange() {
		return proxyEchange;
	}

	public void setProxyEchange(IServiceEchange proxyEchange) {
		this.proxyEchange = proxyEchange;
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

	public Proposition getObj() {
		return obj;
	}

	public void setObj(Proposition obj) {
		this.obj = obj;
	}

	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public List<Proposition> getAllPropositions() {
		return allPropositions;
	}

	public void setAllPropositions(List<Proposition> allPropositions) {
		this.allPropositions = allPropositions;
	}

	public Proposition getSelectedProp() {
		return selectedProp;
	}

	public void setSelectedProp(Proposition selectedProp) {
		this.selectedProp = selectedProp;
	}

}
