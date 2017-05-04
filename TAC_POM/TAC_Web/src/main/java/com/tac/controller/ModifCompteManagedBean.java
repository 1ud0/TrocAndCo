package com.tac.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import com.tac.business.api.IServiceCompte;
import com.tac.business.api.IServiceLocalisation;
import com.tac.entity.Membre;

@ManagedBean(name = "mbModifCompte")
@RequestScoped
public class ModifCompteManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifSession;

	@EJB
	private IServiceCompte proxyCompte;
	


	private Part file1;

	private String messageModif;
	
	private String ancienMdp;
	private String nouveauMdp;
	
	private boolean showAlertPwd;
	private boolean showAlertModif;
	
	

	public void onload() {
	}

	public String upload() {
		String path = Thread.currentThread().getContextClassLoader().getResource("bidon.txt").getPath();
		System.out.println(path);
		path = path.split("WEB-INF")[0] + "img/";
		path = path.substring(1);
		System.out.println(path);
		try {
			file1.write(path + getFilename(file1));
			identifSession.getMembreConnected().setAvatar("img/" + getFilename(file1));
			System.out.println(identifSession.getMembreConnected().getAvatar());
			proxyCompte.majDonnees(identifSession.getMembreConnected());
		} catch (IOException e) {
			System.out.println("souci d'écriture de fichier");
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

	public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
		List<FacesMessage> msgs = new ArrayList<FacesMessage>();
		Part file = (Part) value;
		String contentType = file.getContentType();
		System.out.println(contentType);
		if (file.getSize() > 500*1024) {
			msgs.add(new FacesMessage("fichier trop volumineux"));
		}
		if (!"image/gif".equals(contentType) && !"image/jpeg".equals(contentType) && !"image/png".equals(contentType)){
			msgs.add(new FacesMessage("pas une image"));
		}
		if (!msgs.isEmpty()) {
			throw new ValidatorException(msgs);
		}
	}
	
	
	public void majDonnees() {
		proxyCompte.majDonnees(identifSession.getMembreConnected());
		messageModif = "Modifications enregistrées";
		showAlertModif = true;
	}
	
	
	public void modifPwd() {
		showAlertPwd = false;
		if (identifSession.getMembreConnected().getPassword().equals(ancienMdp)){
			identifSession.getMembreConnected().setPassword(nouveauMdp);
			proxyCompte.majDonnees(identifSession.getMembreConnected());
			showAlertPwd = true;
		}
	}
	

	public Part getFile1() {
		return file1;
	}

	public void setFile1(Part file1) {
		this.file1 = file1;
	}

	public IdentificationManagedBean getIdentifSession() {
		return identifSession;
	}

	public void setIdentifSession(IdentificationManagedBean identifSession) {
		this.identifSession = identifSession;
	}

	public IServiceCompte getProxyCompte() {
		return proxyCompte;
	}

	public void setProxyCompte(IServiceCompte proxyCompte) {
		this.proxyCompte = proxyCompte;
	}

	public String getMessageModif() {
		return messageModif;
	}

	public void setMessageModif(String messageModif) {
		this.messageModif = messageModif;
	}

	public String getAncienMdp() {
		return ancienMdp;
	}

	public void setAncienMdp(String ancienMdp) {
		this.ancienMdp = ancienMdp;
	}

	public String getNouveauMdp() {
		return nouveauMdp;
	}

	public void setNouveauMdp(String nouveauMdp) {
		this.nouveauMdp = nouveauMdp;
	}

	public boolean isShowAlertPwd() {
		return showAlertPwd;
	}

	public void setShowAlertPwd(boolean showAlertPwd) {
		this.showAlertPwd = showAlertPwd;
	}

	public boolean isShowAlertModif() {
		return showAlertModif;
	}

	public void setShowAlertModif(boolean showAlertModif) {
		this.showAlertModif = showAlertModif;
	}


	
	
	
	

}
