package com.tac.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


import com.tac.business.api.IServiceProposition;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@ManagedBean(name="mbCompteObjet")

public class CompteObjetsManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IServiceProposition proxyObjet;
	
	private List<Proposition> proposDuMembre;
	private Membre membreCourant;
	private Proposition propositionSelected;
	
	
	@ManagedProperty(value="#{mbIdentif}")
	private IdentificationManagedBean identifBean;	

	public List<Proposition> getProposDuMembre() {
		membreCourant = identifBean.getMembreConnected();
		proposDuMembre = proxyObjet.getByMembre(membreCourant);
		return proposDuMembre;
	}
	
	



	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public Proposition getPropositionSelected() {
		return propositionSelected;
	}



	public void setPropositionSelected(Proposition propositionSelected) {
		this.propositionSelected = propositionSelected;
	}


	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}



	public void setProposDuMembre(List<Proposition> proposDuMembre) {
		this.proposDuMembre = proposDuMembre;
	}



	public Membre getMembreCourant() {
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}
	
	
			
	
	
}
