package com.tac.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceLocalisation;
import com.tac.entity.Echange;
import com.tac.entity.Membre;

@ManagedBean(name="mbCompteEvaluation")
@RequestScoped
public class compteEvaluationManagedBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@EJB
	private IServiceEchange proxyEchange;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;

	private Membre membreCourant;
	
	private double noteMoyenne;
	
	private List<Echange> echangesQuandChercheur  = new ArrayList<>();
	private List<Echange> echangesQuandDonneur  = new ArrayList<>();
	
	@PostConstruct
	void init(){
		membreCourant = identifBean.getMembreConnected();
		noteMoyenne = proxyEchange.getNoteMoyenne(membreCourant);
		echangesQuandChercheur = proxyEchange.getByMembreChercheurFini(membreCourant);
		echangesQuandDonneur = proxyEchange.getByMembreDonneurFini(membreCourant);
	}
	
	public int getNombreNoteValeur(int noteATester) {
		
		int nombreDeFois =0;
		int total=0;
		int pourcentage=0;
		for (Echange echange : echangesQuandChercheur) {
			if(echange.getNoteChercheur()==noteATester){
				nombreDeFois = nombreDeFois+1;
			}
			total = total+1;
		}
		for (Echange echange : echangesQuandDonneur) {
			if(echange.getNoteChercheur()==noteATester){
				nombreDeFois = nombreDeFois+1;
			}
			total = total+1;
		}
		
		
		if(total!=0){
			pourcentage = (int)((nombreDeFois * 100) / total);
			
		}
		return pourcentage;
	}
	

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public List<Echange> getEchangesQuandDonneur(Membre membre) {
		return proxyEchange.getByMembreDonneurFini(membre);
	}

	public List<Echange> getEchangesQuandAcheteur(Membre membre) {
		return proxyEchange.getByMembreChercheurFini(membre);
	}

	public Membre getMembreCourant() {
		membreCourant = identifBean.getMembreConnected();
		membreCourant.setLocalisations(proxyLocalisation.getMembreLocalisations(membreCourant));
		List<Echange> echanges = proxyEchange.getByMembre(membreCourant);
		membreCourant.setEchanges(echanges);
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public IServiceEchange getProxyEchange() {
		return proxyEchange;
	}

	public void setProxyEchange(IServiceEchange proxyEchange) {
		this.proxyEchange = proxyEchange;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}
	

	public double getNoteMoyenne() {
		return noteMoyenne;
	}


	public void setNoteMoyenne(double noteMoyenne) {
		this.noteMoyenne = noteMoyenne;
	}




	public List<Echange> getEchangesQuandChercheur() {
		return echangesQuandChercheur;
	}




	public void setEchangesQuandChercheur(List<Echange> echangesQuandChercheur) {
		this.echangesQuandChercheur = echangesQuandChercheur;
	}




	public List<Echange> getEchangesQuandDonneur() {
		return echangesQuandDonneur;
	}




	public void setEchangesQuandDonneur(List<Echange> echangesQuandDonneur) {
		this.echangesQuandDonneur = echangesQuandDonneur;
	}
	
	

}
