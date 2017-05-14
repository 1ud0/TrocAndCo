package com.tac.controller.back;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.tac.business.api.IServiceCategorie;
import com.tac.business.api.IServiceEtat;
import com.tac.business.api.IServiceTag;
import com.tac.business.api.IServiceValeur;
import com.tac.business.api.back.IServiceParam;
import com.tac.entity.Categorie;
import com.tac.entity.Etat;
import com.tac.entity.Tag;
import com.tac.entity.Valeur;

@ManagedBean(name = "mbBackParam")
@SessionScoped
public class ParamManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IServiceEtat proxyEtat;
	@EJB
	private IServiceTag proxyTag;
	@EJB
	private IServiceCategorie proxyCategorie;
	@EJB
	private IServiceValeur proxyValeur;
	@EJB
	private IServiceParam proxyParam;

	private Categorie selectedCategorie = new Categorie();
	private Tag selectedTag = new Tag();
	private Valeur selectedValeur = new Valeur();
	private Etat selectedEtat = new Etat();
	private String intituleSelectedCatM = "";
	private String intituleCatM = "";
	/**
	 * Pour Graph
	 */
	private List<Categorie> listCategoriesGraph = new ArrayList<>();
	private List<Long> listLongGraph = new ArrayList<>();

	private List<Long> listLongNbMembreByMois = new ArrayList<>();
	private List<String> listStringNbMembreByMois = new ArrayList<>();

	private List<Long> listLongNbPropByMois = new ArrayList<>();
	private List<String> listStringNbPropByMois = new ArrayList<>();

	private List<Object[]> objectsMembre = new ArrayList<Object[]>();
	private List<Object[]> objectsProp = new ArrayList<Object[]>();
	
	
	private List<Long> listechangeGraph= new ArrayList<>();
	private List<String> listMoisEchange = new ArrayList<>();
	
	
	@PostConstruct
	public void init() {
		getAllCategoriesMere();
		getAllCategoriesFilles();
		getAllValeurs();
		getAllTag();

		getAllPropsByCatMere();

		getAllMembreByMois();
		getAllPropsByMois();
		getAllEchangeFinisByMois();
		
		
	}
	
	private void getAllEchangeFinisByMois() {
		List<Object[]> objectsGraph = proxyParam.getAllEchangeFinisByMois();
		for (Object[] object : objectsGraph) {
			listechangeGraph.add((Long) object[0]);
			listMoisEchange.add((String) object[1]);
		}

	}

	private void getAllPropsByMois() {
		objectsProp = proxyParam.getAllPropsByMois();
		 for (Object[] object : objectsProp) {
		 listLongNbPropByMois.add((Long) object[0]);
		 listStringNbPropByMois.add((String) object[1]);
		 }
	}

	private void getAllMembreByMois() {
		objectsMembre = proxyParam.getAllMembreByMois();
		 for (Object[] object : objectsMembre) {
		 listLongNbMembreByMois.add((Long) object[0]);
		 listStringNbMembreByMois.add((String) object[1]);
		 }
	}

	public void getAllPropsByCatMere() {
		List<Object[]> objectsGraph = proxyParam.getAllPropsByCatMere();
		for (Object[] object : objectsGraph) {
			listCategoriesGraph.add((Categorie) object[0]);
			listLongGraph.add((Long) object[1]);
		}
	}

	public String ajoutCategorieM() {
		selectedCategorie.setIntitule(intituleCatM);
		System.out.println(selectedCategorie.getIntitule());
		selectedCategorie = proxyCategorie.addCategorie(selectedCategorie);
		String nav = "";
		return nav;
	}

	public void loadCategorieM(Categorie categorie) {
		selectedCategorie = categorie;
	}

	public void loadCategorieF(Categorie categorie) {
		selectedCategorie = categorie;
	}

	public void loadValeur(Valeur valeur) {
		selectedValeur = valeur;
	}

	public void loadEtat(Etat etat) {
		selectedEtat = etat;
	}

	public List<Etat> getAllEtat() {
		return proxyEtat.getAllEtat();
	}

	public List<Tag> getAllTag() {

		return proxyTag.getAllTag();
	}

	public List<Categorie> getAllCategoriesMere() {
		return proxyCategorie.getCategorieMere();
	}

	public List<Categorie> getAllCategoriesFilles() {

		return proxyCategorie.getAllCategorieFille();
	}

	public List<Valeur> getAllValeurs() {
		return proxyValeur.getAllValeur();
	}

	public Categorie getSelectedCategorie() {
		return selectedCategorie;
	}

	public void setSelectedCategorie(Categorie selectedCategorie) {
		this.selectedCategorie = selectedCategorie;
	}

	public Tag getSelectedTag() {
		return selectedTag;
	}

	public void setSelectedTag(Tag selectedTag) {
		this.selectedTag = selectedTag;
	}

	public Valeur getSelectedValeur() {
		return selectedValeur;
	}

	public void setSelectedValeur(Valeur selectedValeur) {
		this.selectedValeur = selectedValeur;
	}

	public Etat getSelectedEtat() {
		return selectedEtat;
	}

	public void setSelectedEtat(Etat selectedEtat) {
		this.selectedEtat = selectedEtat;
	}

	public String getIntituleCatM() {
		return intituleCatM;
	}

	public void setIntituleCatM(String intituleCatM) {
		this.intituleCatM = intituleCatM;
	}

	public String getIntituleSelectedCatM() {
		intituleSelectedCatM = selectedCategorie.getIntitule();
		return intituleSelectedCatM;
	}

	public void setIntituleSelectedCatM(String intituleSelectedCatM) {
		this.intituleSelectedCatM = intituleSelectedCatM;
	}

	public IServiceEtat getProxyEtat() {
		return proxyEtat;
	}

	public void setProxyEtat(IServiceEtat proxyEtat) {
		this.proxyEtat = proxyEtat;
	}

	public IServiceTag getProxyTag() {
		return proxyTag;
	}

	public void setProxyTag(IServiceTag proxyTag) {
		this.proxyTag = proxyTag;
	}

	public IServiceCategorie getProxyCategorie() {
		return proxyCategorie;
	}

	public void setProxyCategorie(IServiceCategorie proxyCategorie) {
		this.proxyCategorie = proxyCategorie;
	}

	public IServiceValeur getProxyValeur() {
		return proxyValeur;
	}

	public void setProxyValeur(IServiceValeur proxyValeur) {
		this.proxyValeur = proxyValeur;
	}

	public IServiceParam getProxyParam() {
		return proxyParam;
	}

	public void setProxyParam(IServiceParam proxyParam) {
		this.proxyParam = proxyParam;
	}

	public List<Categorie> getListCategoriesGraph() {
		return listCategoriesGraph;
	}

	public void setListCategoriesGraph(List<Categorie> listCategoriesGraph) {
		this.listCategoriesGraph = listCategoriesGraph;
	}

	public List<Long> getListLongGraph() {
		return listLongGraph;
	}

	public void setListLongGraph(List<Long> listLongGraph) {
		this.listLongGraph = listLongGraph;
	}

	public List<Long> getListLongNbMembreByMois() {
		return listLongNbMembreByMois;
	}

	public void setListLongNbMembreByMois(List<Long> listLongNbMembreByMois) {
		this.listLongNbMembreByMois = listLongNbMembreByMois;
	}

	public List<String> getListStringNbMembreByMois() {
		return listStringNbMembreByMois;
	}

	public void setListStringNbMembreByMois(List<String> listStringNbMembreByMois) {
		this.listStringNbMembreByMois = listStringNbMembreByMois;
	}

	public List<Long> getListLongNbPropByMois() {
		return listLongNbPropByMois;
	}

	public void setListLongNbPropByMois(List<Long> listLongNbPropByMois) {
		this.listLongNbPropByMois = listLongNbPropByMois;
	}

	public List<String> getListStringNbPropByMois() {
		return listStringNbPropByMois;
	}

	public void setListStringNbPropByMois(List<String> listStringNbPropByMois) {
		this.listStringNbPropByMois = listStringNbPropByMois;
	}

	public List<Object[]> getObjectsMembre() {
		return objectsMembre;
	}

	public void setObjectsMembre(List<Object[]> objectsMembre) {
		this.objectsMembre = objectsMembre;
	}

	public List<Object[]> getObjectsProp() {
		return objectsProp;
	}

	public void setObjectsProp(List<Object[]> objectsProp) {
		this.objectsProp = objectsProp;
	}

	public List<Long> getListechangeGraph() {
		return listechangeGraph;
	}

	public void setListechangeGraph(List<Long> listechangeGraph) {
		this.listechangeGraph = listechangeGraph;
	}

	public List<String> getListMoisEchange() {
		return listMoisEchange;
	}

	public void setListMoisEchange(List<String> listMoisEchange) {
		this.listMoisEchange = listMoisEchange;
	}



}
