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

	private Categorie selectedCategorie =new Categorie();
	private Tag selectedTag = new Tag();
	private Valeur selectedValeur= new Valeur();
	private Etat selectedEtat = new Etat();
	private String intituleSelectedCatM = "";
	private String intituleCatM="";
	/**
	 * Pour Graph
	 */
	private List<Categorie> listCategoriesGraph = new ArrayList<>();
	private List<Long> listLongGraph = new ArrayList<>();


	@PostConstruct
	public void init() {
		System.out.println("dans lePC MembreManagedBean");
		getAllCategoriesMere();
		getAllCategoriesFilles();
		getAllValeurs();
		getAllTag();
		getAllPropsByCatMere();
	}
	
	public String ajoutCategorieM(){
		selectedCategorie.setIntitule(intituleCatM);
		System.out.println(selectedCategorie.getIntitule());
		selectedCategorie = proxyCategorie.addCategorie(selectedCategorie);
		String nav = "";
		return nav;
	}
	
	public void getAllPropsByCatMere(){
		List<Object[]> objectsGraph = proxyParam.getAllPropsByCatMere();
		System.out.println(objectsGraph.size());
		for (Object[] object : objectsGraph) {
			listCategoriesGraph.add( (Categorie)object[0]);
			listLongGraph.add((Long) object[1]);
			
		}
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

}
