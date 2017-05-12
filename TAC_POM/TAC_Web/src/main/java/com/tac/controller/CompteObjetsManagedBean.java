package com.tac.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

import com.tac.business.api.IServiceCategorie;
import com.tac.business.api.IServiceEtat;
import com.tac.business.api.IServiceFavori;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceLocaliserProposition;
import com.tac.business.api.IServicePhoto;
import com.tac.business.api.IServiceProposition;
import com.tac.business.api.IServiceValeur;
import com.tac.entity.Categorie;
import com.tac.entity.Etat;
import com.tac.entity.Localisation;
import com.tac.entity.Photo;
import com.tac.entity.Proposition;
import com.tac.entity.Valeur;

@ManagedBean(name = "mbCompteObjet")
@ViewScoped
public class CompteObjetsManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private IServiceProposition proxyObjet;
	@EJB
	private IServiceCategorie proxyCategorie;
	@EJB
	private IServiceEtat proxyEtat;
	@EJB
	private IServiceValeur proxyValeur;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	@EJB
	private IServiceLocaliserProposition proxyLocaliserProposition;
	@EJB
	private IServiceFavori proxyFavori;

	@EJB
	private IServicePhoto proxyPhoto;

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	@ManagedProperty(value = "#{mbRecherche}")
	private RechercheManagedBean rechercheBean;

	private List<Proposition> proposDuMembre;
	private List<Localisation> adressesSelected = new ArrayList<>();
	private List<String> idAdressesSelected = new ArrayList<>();
	private List<Categorie> sousCategoriesSelected;
	private Categorie categorieSelectedNouveauObjet;
	private Categorie sousCategorieSelectedNouveauObjet;
	private Integer idCatSelected;
	private Valeur valeurSelected;
	private Etat etatSelected;
	private Proposition propositionSelected;
	private String intituleSelected;
	private String descriptionSelected;
	private Part file1;
	private Part file2;
	private Part file3;
	private List<Categorie> allCategories;
	private List<Valeur> allValeurs;
	private List<Etat> allEtats;
	private List<Localisation> adressesDuMembre;
	private List<Photo> photoDeLaNouvelleProp;

	// METHODES

	@PostConstruct
	public void loadPropositionDuMembre() {
		System.out.println("dans le construct compte objet");
		proposDuMembre = proxyObjet.getPropDispoByMembre(identifBean.getMembreConnected());
		allCategories = rechercheBean.getCategoriesMere();
		allValeurs = rechercheBean.getValeurs();
		allEtats = rechercheBean.getEtats();
		adressesDuMembre = rechercheBean.getAdresses();

	}

	public void listenerChargementSousCat() {
		for (Categorie cat : allCategories) {
			if (idCatSelected == cat.getIdCategorie()) {
				categorieSelectedNouveauObjet = cat;
				sousCategoriesSelected = categorieSelectedNouveauObjet.getSousCategories();
				break;
			}
		}
	}

	public void listenerInitObjet() {
		idCatSelected = 1;
		propositionSelected = new Proposition();
		categorieSelectedNouveauObjet = new Categorie();
		sousCategorieSelectedNouveauObjet = new Categorie();
		valeurSelected = new Valeur();
		etatSelected = new Etat();
		intituleSelected = "";
		descriptionSelected = "";
	}

	public void listnerSelectionObjet(Proposition proposition) {
		propositionSelected = proposition;
		idCatSelected = propositionSelected.getCategorie().getIdCategorie();
		listenerChargementSousCat();
		idAdressesSelected = getidAdresseProp();
	}

	public String ajoutProposition() {
		propositionSelected.setMembre(identifBean.getMembreConnected());
		propositionSelected.setLocalisations(adressesSelected);
		propositionSelected.setCategorie(categorieSelectedNouveauObjet);
		propositionSelected.setSousCategorie(sousCategorieSelectedNouveauObjet);
		propositionSelected.setValeur(valeurSelected);
		propositionSelected.setEtat(etatSelected);
		propositionSelected.setDescription(descriptionSelected);
		propositionSelected.setIntitule(intituleSelected);
		propositionSelected = proxyObjet.addProposition(propositionSelected);
		adressesSelected = GetListAdressesSelected(idAdressesSelected);
		for (Localisation newLocalisation : adressesSelected) {
			proxyLocaliserProposition.addLocalisationAUneProposition(propositionSelected, newLocalisation);
		}
		photoDeLaNouvelleProp = new ArrayList<>();
		propositionSelected.setPhotos(photoDeLaNouvelleProp);
		if (file1 != null) {
			uploadPhoto1();
		}
		if (file2 != null) {
			uploadPhoto2();
		}
		if (file3 != null) {
			uploadPhoto3();
		}
		return "";
	}

	private void updateLocalisationProposition() {
		for (Localisation oldLocalisation : getAdresseByProposition(propositionSelected)) {
			proxyLocaliserProposition.deleteLocalisationAUneProposition(propositionSelected, oldLocalisation);
		}
		adressesSelected = GetListAdressesSelected(idAdressesSelected);
		for (Localisation newLocalisation : adressesSelected) {
			proxyLocaliserProposition.addLocalisationAUneProposition(propositionSelected, newLocalisation);
		}
	}

	public String updateObjet() {
		updateLocalisationProposition();
		propositionSelected = proxyObjet.updateProposition(propositionSelected);
		return "";
	}

	private List<String> getidAdresseProp() {
		List<Localisation> adressesProp = getAdresseByProposition(propositionSelected);
		List<String> idAdressesPropString = new ArrayList<>();
		for (Localisation adresse : adressesProp) {
			idAdressesPropString.add(adresse.getIdLocalisation().toString());
		}
		return idAdressesPropString;
	}

	public List<Localisation> GetListAdressesSelected(List<String> idAdressesSelected) {
		Localisation adresseSelected = new Localisation();
		int idAdresseInt;
		for (String idLocalisation : idAdressesSelected) {
			idAdresseInt = Integer.parseInt(idLocalisation);
			adresseSelected = proxyLocalisation.getById(idAdresseInt);
			adressesSelected.add(adresseSelected);
		}
		return adressesSelected;
	}

	public List<Localisation> getAdresseByProposition(Proposition propositionSelected) {
		List<Localisation> localisationsPropo = proxyLocalisation.getPropositionLocalisations(propositionSelected);
		return localisationsPropo;
	}

	// suppression d'une proposition
	public void listnerSelectionObjetPourSuppression(Proposition proposition) {
		propositionSelected = proposition;
	}

	public void suppressionProposition() {
		for (Localisation oldLocalisation : getAdresseByProposition(propositionSelected)) {
			proxyLocaliserProposition.deleteLocalisationAUneProposition(propositionSelected, oldLocalisation);
		}
		proxyFavori.deleteAllFavori(propositionSelected);

		proxyObjet.deleteProposition(propositionSelected);
	}

	// upload des photos
	public void uploadPhoto1() {
		uploadPhoto(file1);
	}

	public void uploadPhoto2() {
		uploadPhoto(file2);
	}

	public void uploadPhoto3() {
		uploadPhoto(file3);
	}

	public String uploadPhoto(Part fileAUploader) {
		String path = Thread.currentThread().getContextClassLoader().getResource("bidon.txt").getPath();
		path = path.split("WEB-INF")[0] + "img/imgProposition/";
		path = path.substring(1);
		int positionImage = 0;
		try {
			fileAUploader.write(path + getFilename(fileAUploader));
			if (fileAUploader.equals(file1)) {
				positionImage = 1;
			} else if (fileAUploader.equals(file2)) {
				positionImage = 2;
			} else {
				positionImage = 3;
			}
			System.out.println("position image : " + positionImage);
			System.out.println("taille liste photo : " + propositionSelected.getPhotos().size());
			if (positionImage > propositionSelected.getPhotos().size() || propositionSelected.getPhotos().size() == 0) {
				Photo photoAAjouter = new Photo();
				photoAAjouter.setUrl("img/imgProposition/" + getFilename(fileAUploader));
				photoAAjouter.setProposition(propositionSelected);
				propositionSelected.getPhotos().add(photoAAjouter);
				proxyPhoto.addPhoto(photoAAjouter);
			} else {
				Photo photoAUpdater = propositionSelected.getPhotos().get(positionImage - 1);
				photoAUpdater.setUrl("img/imgProposition/" + getFilename(fileAUploader));
				proxyPhoto.updatePhoto(photoAUpdater);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE
																													// fix.
			}
		}
		return null;
	}

	// GETTER SETTER
	public IServiceProposition getProxyObjet() {
		return proxyObjet;
	}

	public void setProxyObjet(IServiceProposition proxyObjet) {
		this.proxyObjet = proxyObjet;
	}

	public IServiceCategorie getProxyCategorie() {
		return proxyCategorie;
	}

	public void setProxyCategorie(IServiceCategorie proxyCategorie) {
		this.proxyCategorie = proxyCategorie;
	}

	public IServiceEtat getProxyEtat() {
		return proxyEtat;
	}

	public void setProxyEtat(IServiceEtat proxyEtat) {
		this.proxyEtat = proxyEtat;
	}

	public IServiceValeur getProxyValeur() {
		return proxyValeur;
	}

	public void setProxyValeur(IServiceValeur proxyValeur) {
		this.proxyValeur = proxyValeur;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}

	public IServiceLocaliserProposition getProxyLocaliserProposition() {
		return proxyLocaliserProposition;
	}

	public void setProxyLocaliserProposition(IServiceLocaliserProposition proxyLocaliserProposition) {
		this.proxyLocaliserProposition = proxyLocaliserProposition;
	}

	public IServiceFavori getProxyFavori() {
		return proxyFavori;
	}

	public void setProxyFavori(IServiceFavori proxyFavori) {
		this.proxyFavori = proxyFavori;
	}

	public IServicePhoto getProxyPhoto() {
		return proxyPhoto;
	}

	public void setProxyPhoto(IServicePhoto proxyPhoto) {
		this.proxyPhoto = proxyPhoto;
	}

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public RechercheManagedBean getRechercheBean() {
		return rechercheBean;
	}

	public void setRechercheBean(RechercheManagedBean rechercheBean) {
		this.rechercheBean = rechercheBean;
	}

	public List<Proposition> getProposDuMembre() {
		return proposDuMembre;
	}

	public void setProposDuMembre(List<Proposition> proposDuMembre) {
		this.proposDuMembre = proposDuMembre;
	}

	public List<Localisation> getAdressesSelected() {
		return adressesSelected;
	}

	public void setAdressesSelected(List<Localisation> adressesSelected) {
		this.adressesSelected = adressesSelected;
	}

	public List<String> getIdAdressesSelected() {
		return idAdressesSelected;
	}

	public void setIdAdressesSelected(List<String> idAdressesSelected) {
		this.idAdressesSelected = idAdressesSelected;
	}

	public List<Categorie> getSousCategoriesSelected() {
		return sousCategoriesSelected;
	}

	public void setSousCategoriesSelected(List<Categorie> sousCategoriesSelected) {
		this.sousCategoriesSelected = sousCategoriesSelected;
	}

	public Proposition getPropositionSelected() {
		return propositionSelected;
	}

	public void setPropositionSelected(Proposition propositionSelected) {
		this.propositionSelected = propositionSelected;
	}

	public Part getFile1() {
		return file1;
	}

	public void setFile1(Part file1) {
		this.file1 = file1;
	}

	public Part getFile2() {
		return file2;
	}

	public void setFile2(Part file2) {
		this.file2 = file2;
	}

	public Part getFile3() {
		return file3;
	}

	public void setFile3(Part file3) {
		this.file3 = file3;
	}

	public List<Categorie> getAllCategories() {
		return allCategories;
	}

	public void setAllCategories(List<Categorie> allCategories) {
		this.allCategories = allCategories;
	}

	public List<Valeur> getAllValeurs() {
		return allValeurs;
	}

	public void setAllValeurs(List<Valeur> allValeurs) {
		this.allValeurs = allValeurs;
	}

	public List<Etat> getAllEtats() {
		return allEtats;
	}

	public void setAllEtats(List<Etat> allEtats) {
		this.allEtats = allEtats;
	}

	public List<Localisation> getAdressesDuMembre() {
		return adressesDuMembre;
	}

	public void setAdressesDuMembre(List<Localisation> adressesDuMembre) {
		this.adressesDuMembre = adressesDuMembre;
	}

	public Categorie getCategorieSelectedNouveauObjet() {
		return categorieSelectedNouveauObjet;
	}

	public void setCategorieSelectedNouveauObjet(Categorie categorieSelectedNouveauObjet) {
		this.categorieSelectedNouveauObjet = categorieSelectedNouveauObjet;
	}

	public Valeur getValeurSelected() {
		return valeurSelected;
	}

	public void setValeurSelected(Valeur valeurSelected) {
		this.valeurSelected = valeurSelected;
	}

	public Etat getEtatSelected() {
		return etatSelected;
	}

	public void setEtatSelected(Etat etatSelected) {
		this.etatSelected = etatSelected;
	}

	public Categorie getSousCategorieSelectedNouveauObjet() {
		return sousCategorieSelectedNouveauObjet;
	}

	public void setSousCategorieSelectedNouveauObjet(Categorie sousCategorieSelectedNouveauObjet) {
		this.sousCategorieSelectedNouveauObjet = sousCategorieSelectedNouveauObjet;
	}

	public List<Photo> getPhotoDeLaNouvelleProp() {
		return photoDeLaNouvelleProp;
	}

	public void setPhotoDeLaNouvelleProp(List<Photo> photoDeLaNouvelleProp) {
		this.photoDeLaNouvelleProp = photoDeLaNouvelleProp;
	}

	public String getIntituleSelected() {
		return intituleSelected;
	}

	public void setIntituleSelected(String intituleSelected) {
		this.intituleSelected = intituleSelected;
	}

	public String getDescriptionSelected() {
		return descriptionSelected;
	}

	public void setDescriptionSelected(String descriptionSelected) {
		this.descriptionSelected = descriptionSelected;
	}

	public Integer getIdCatSelected() {
		return idCatSelected;
	}

	public void setIdCatSelected(Integer idCatSelected) {
		this.idCatSelected = idCatSelected;
	}

}
