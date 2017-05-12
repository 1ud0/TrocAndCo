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
	private Membre owner;
	private Membre membreCourant;
	private Integer entryId;
	private boolean favori;
	private double noteMoyenneOwner;
	private List<Envie> enviesOwner;

	@PostConstruct
	public void init() {
		System.out.println("dans le construct objet");
	}

	public void toggleFavori() {
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
			nav = "/fiche.xhtml?faces-redirect=true&ref=" + selectedProp.getIdProposition();
		}
		return nav;
	}

	public boolean NoteVide() {
		if (noteMoyenneOwner == -1.0) {
			return true;
		}
		return false;
	}

	public void loadEntry() {
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			entryId = Integer.parseInt(request.getParameter("ref"));
		} catch (Exception e) {
			// catch misère
		}
		if (!FacesContext.getCurrentInstance().isPostback()) {
			if (entryId != null && entryId != 0) {
				try {
					selectedProp = proxyProp.getById(entryId);
					loadDataOwner();
					membreCourant = identifBean.getMembreConnected();
					if (membreCourant != null) {
						favori = proxyFavori.isFavorite(selectedProp, membreCourant);
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

	private void loadDataOwner() {
		if (selectedProp != null) {
			owner = selectedProp.getMembre();
			owner.setLocalisations(proxyLocalisation.getMembreLocalisations(owner));
			noteMoyenneOwner = proxyEchange.getNoteMoyenne(owner);
			enviesOwner = proxyEnvie.getByMembre(owner);
		}
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

	public Membre getOwner() {
		return owner;
	}

	public void setOwner(Membre owner) {
		this.owner = owner;
	}

	public double getNoteMoyenneOwner() {
		return noteMoyenneOwner;
	}

	public void setNoteMoyenneOwner(double noteMoyenneOwner) {
		this.noteMoyenneOwner = noteMoyenneOwner;
	}

	public List<Envie> getEnviesOwner() {
		return enviesOwner;
	}

	public void setEnviesOwner(List<Envie> enviesOwner) {
		this.enviesOwner = enviesOwner;
	}

}
