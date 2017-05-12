package com.tac.controller.back;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceCategorie;
import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceEnvie;
import com.tac.business.api.IServiceFavori;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceProposition;
import com.tac.business.api.IServiceValeur;
import com.tac.controller.IdentificationManagedBean;
import com.tac.entity.Categorie;
import com.tac.entity.Etat;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Tag;
import com.tac.entity.Valeur;

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
	@EJB
	private IServiceCategorie proxyCat;
	@EJB
	private IServiceValeur proxyVal;

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;

	private Proposition obj;
	private List<Proposition> allPropositions;
	private Proposition selectedProp;
	// Pr la ddl
	private Categorie catSelect = new Categorie();
	private Categorie souCatSelect = new Categorie();
	private Proposition ObjSelect = new Proposition();
	private Valeur valSelect = new Valeur();
	private Membre mbrSelect = new Membre();
	private String intituleSelect = "";
	private List<Categorie> categoriesMere;
	private List<Categorie> categoriesFille;
	private List<Valeur> valeurs;

	@PostConstruct
	public void init() {
		System.out.println("dans post construct");
		loadAllPropositions();
		categoriesMere = proxyCat.getCategorieMere();
		valeurs = proxyVal.getAllValeur();
	}

	// Charge toutes les propositions
	public List<Proposition> loadAllPropositions() {
		allPropositions = proxyProp.LoadAllPropositions();
		for (Proposition p : allPropositions) {
			p.setLocalisations(proxyLocalisation.getPropositionLocalisations(p));
		}
		return allPropositions;
	}

	// pr enregistrer les modifs de la ddl
	public String modifierInfosBack() {
		String infoModified = "";
		ObjSelect.setMembre(mbrSelect);
		ObjSelect.setIntitule(intituleSelect);
		ObjSelect.setCategorie(catSelect);
		ObjSelect.setSousCategorie(souCatSelect);
		ObjSelect.setValeur(valSelect);
		ObjSelect = proxyProp.updateProposition(ObjSelect);
		System.out.println("modifierInfosBack est utilisé");
		return infoModified;
	}

	// listener pr la sous-categorie ds la ddl
	public void listenerSouCat() {
		categoriesFille = proxyCat.getCategorieFille(catSelect.getIdCategorie());
	}


	/////////////////////////////////////////////
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

	public List<Proposition> getAllPropositions() {
		return allPropositions;
	}

	public void setAllPropositions(List<Proposition> allPropositions) {
		this.allPropositions = allPropositions;
	}

	//// pr la ddl

	public Proposition getSelectedProp() {
		return selectedProp;
	}

	public void setSelectedProp(Proposition selectedProp) {
		this.selectedProp = selectedProp;
	}

	public Categorie getCatSelect() {
		return catSelect;
	}

	public void setCatSelect(Categorie catSelect) {
		this.catSelect = catSelect;
	}

	public Categorie getSouCatSelect() {
		return souCatSelect;
	}

	public void setSouCatSelect(Categorie souCatSelect) {
		this.souCatSelect = souCatSelect;
	}

	public Proposition getObjSelect() {
		return ObjSelect;
	}

	public void setObjSelect(Proposition objSelect) {
		ObjSelect = objSelect;
	}

	public Valeur getValSelect() {
		return valSelect;
	}

	public void setValSelect(Valeur valSelect) {
		this.valSelect = valSelect;
	}

	public Membre getMbrSelect() {
		return mbrSelect;
	}

	public void setMbrSelect(Membre mbrSelect) {
		this.mbrSelect = mbrSelect;
	}

	public String getIntituleSelect() {
		return intituleSelect;
	}

	public void setIntituleSelect(String intituleSelect) {
		this.intituleSelect = intituleSelect;
	}

	public IServiceCategorie getProxyCat() {
		return proxyCat;
	}

	public void setProxyCat(IServiceCategorie proxyCat) {
		this.proxyCat = proxyCat;
	}

	public IServiceValeur getProxyVal() {
		return proxyVal;
	}

	public void setProxyVal(IServiceValeur proxyVal) {
		this.proxyVal = proxyVal;
	}

	public List<Categorie> getCategoriesMere() {
		return categoriesMere;
	}

	public void setCategoriesMere(List<Categorie> categoriesMere) {
		this.categoriesMere = categoriesMere;
	}

	public List<Categorie> getCategoriesFille() {
		return categoriesFille;
	}

	public void setCategoriesFille(List<Categorie> categoriesFille) {
		this.categoriesFille = categoriesFille;
	}

	public List<Valeur> getValeurs() {
		return valeurs;
	}

	public void setValeurs(List<Valeur> valeurs) {
		this.valeurs = valeurs;
	}

}
