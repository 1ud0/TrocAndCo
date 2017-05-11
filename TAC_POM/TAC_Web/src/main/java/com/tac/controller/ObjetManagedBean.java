package com.tac.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceEnvie;
import com.tac.business.api.IServiceFavori;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceProposition;
import com.tac.entity.Envie;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.exception.DataAccessException;

@ManagedBean(name = "mbObjet")
@ViewScoped
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

	@PostConstruct
	public void init() {
		System.out.println("dans post construct");
		loadAllPropositions();
	}
	
	private Proposition selectedProp;
	private Proposition obj;
	private Membre selectedMembre;
	private Membre membreCourant;
	private Integer entryId;
	private List<Proposition> allPropositions;

	public List<Proposition> getAllPropositions() {
		return allPropositions;
	}

	public void setAllPropositions(List<Proposition> allPropositions) {
		this.allPropositions = allPropositions;
	}

	/**
	 * Permet de savoir si l'objet qui est affiché est déja dans les favoris du
	 * membre en session
	 * 
	 * @return false pas dans les favoris // true est dans les favoris
	 */
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

	/**
	 * permet d'ajouter l'objet visualisé aux favoris du membre en session
	 * 
	 * @return
	 */
	public String ajouterFavori() {
		membreCourant = identifBean.getMembreConnected();
		System.out.println("ajout" + membreCourant.getNom() + selectedProp.getIntitule());
		if (membreCourant != null) {
			proxyFavori.addToFavoris(selectedProp, membreCourant);
		}
		return "";
	}

	/**
	 * permet de retirer l'objet visualisé aux favoris du membre en session
	 * 
	 * @return
	 */
	public String deleteFavori() {
		membreCourant = identifBean.getMembreConnected();
		if (membreCourant != null) {
			proxyFavori.deleteFavori(selectedProp, membreCourant);
		}
		return "";

	}

	/**
	 * charge la proposition en cours et ses informations
	 * 
	 * @param proposition
	 * @return
	 */
	public String loadProposition(Proposition proposition) {
		String nav = "";
		selectedProp = proposition;
		if (selectedProp != null) {
			nav = "/fiche.xhtml?faces-redirect=true&id=" + selectedProp.getIdProposition();
		}
		return nav;
	}

	//////// Test_Ayda pr le back
	public List<Proposition> loadAllPropositions() {
		Date dbt = new Date();
		allPropositions = proxyProp.LoadAllPropositions();
		for (Proposition p : allPropositions) {
			p.setLocalisations(proxyLocalisation.getPropositionLocalisations(p)); // pr
																					// p
																					// ds
																					// la
																					// liste
																					// de
																					// propositions,
																					// va
																					// chercher
																					// chaque
																					// localisations
		}
		Date fin = new Date();
		System.out.println("temps - " +( fin.getTime() - dbt.getTime()));
		return allPropositions;
	}

	public void loadObject(Proposition prop) {
		obj = prop;
		System.out.println(obj.getIntitule());
		
	}

	/**
	 * charge les informations du membre qui possède l'objet visualisé
	 * 
	 * @param membre
	 * @return
	 */
	public String LoadMembre(Membre membre) {
		String nav = "";
		selectedMembre = membre;
		if (selectedMembre != null) {
			nav = "/profil.xhtml?faces-redirect=true";
		}
		return nav;
	}

	public boolean NoteVide(Membre membre) {
		if (proxyEchange.getNoteMoyenne(membre) == -1.0) {
			return true;
		}
		return false;
	}

	public void loadEntry() {
		System.out.println("coucou load entry");
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

	public double getNoteMoyenne(Membre membre) {
		return proxyEchange.getNoteMoyenne(membre);
	}

	public List<Envie> getEnviesAutreMembre(Membre membre) {
		return proxyEnvie.getByMembre(membre);
	}

	public List<Localisation> getLocalisationByMembre(Membre membre) {
		return proxyLocalisation.getMembreLocalisations(membre);
	}

	public IServiceProposition getProxyProp() {
		return proxyProp;
	}

	public void setProxyProp(IServiceProposition proxyProp) {
		this.proxyProp = proxyProp;
	}

	public Proposition getSelectedProp() {
		selectedProp.setLocalisations(proxyLocalisation.getPropositionLocalisations(selectedProp));

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

	public Proposition getObj() {
		return obj;
	}

	public void setObj(Proposition obj) {
		this.obj = obj;
	}

}
