package com.tac.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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

	
	private Proposition selectedProp;
	private Membre selectedMembre;
	private Membre membreCourant;
	private Integer entryId;
	private boolean favori;

	@PostConstruct
	public void init() {
		
	}
	
	public void toggleFavori() {
		System.out.println("dans le toggle");
		if (favori) {
			proxyFavori.deleteFavori(selectedProp, membreCourant);
		} else {
			proxyFavori.addToFavoris(selectedProp, membreCourant);
		}
		favori = !favori;
	}

	public boolean indicationFavori(Proposition proposition) {
		Membre membreConnect = identifBean.getMembreConnected();
		if (membreConnect != null) {
			return proxyFavori.isFavorite(proposition, membreConnect);
		}
		return false;
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
		
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			entryId = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			// catch misère
		}
		if(!FacesContext.getCurrentInstance().isPostback()) {
		System.out.println("coucou load entry");
		if (entryId != null && entryId != 0) {
			try {
				selectedProp = proxyProp.getById(entryId);
				membreCourant = identifBean.getMembreConnected();
				if (membreCourant != null) {
					favori = proxyFavori.isFavorite(selectedProp, membreCourant);
					System.out.println(favori);
				}
			} catch (DataAccessException e) {
				String message = "Erreur lors du chargement de la page : " + e.getMessage();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
				selectedProp = null;
			}
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

	public boolean isFavori() {
		return favori;
	}

	public void setFavori(boolean favori) {
		this.favori = favori;
	}

}
