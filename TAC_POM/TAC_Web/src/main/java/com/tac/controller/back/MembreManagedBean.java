package com.tac.controller.back;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.back.IServiceMembreBO;
import com.tac.entity.Membre;

@ManagedBean(name = "mbBackMembre")
@ViewScoped
public class MembreManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private IServiceMembreBO proxyMembre;

	@EJB
	private IServiceLocalisation proxyLocalisation;

	private Integer entryId;
	private Membre selectedMembre = new Membre();

	public List<Membre> getAllMembresActifs() {
		List<Membre> membres = proxyMembre.getAllActif();
		for (Membre membre : membres) {
			membre.setLocalisations(proxyLocalisation.getMembreLocalisations(membre));
			
		}
		
		return membres;

	}

	public List<Membre> getAllMembresRadies() {
		return proxyMembre.getAllRadie();
	}
	
	public Membre getMembre(){
		return proxyMembre.getMembre(selectedMembre);
	}

	@PostConstruct
	public void init() {
		System.out.println("dans lePC MembreManagedBean");
		getAllMembresActifs();
		getAllMembresRadies();
	}

	public String loadMembre(Membre membre) {
		String nav = "";
		selectedMembre = membre;
		if (selectedMembre != null) {
			nav = "/backOffice/gestionMembre-Profil.xhtml?faces-redirect=true&id=" + selectedMembre.getIdMembre();
		}
		System.out.println(selectedMembre.getNom());
		return nav;
	}

	public void loadEntry() {
		if (entryId != null && entryId != 0) {
			selectedMembre = proxyMembre.getIdMembre(entryId);

		}
	}

	public void testMembre() {
		System.out.println(selectedMembre.getPseudo());
	}
	
	public IServiceMembreBO getProxyMembre() {
		return proxyMembre;
	}

	public void setProxyMembre(IServiceMembreBO proxyMembre) {
		this.proxyMembre = proxyMembre;
	}

	public Membre getSelectedMembre() {
		selectedMembre.setLocalisations(proxyLocalisation.getMembreLocalisations(selectedMembre));
		return selectedMembre;
	}

	public void setSelectedMembre(Membre selectedMembre) {
		this.selectedMembre = selectedMembre;
	}

	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}

}
