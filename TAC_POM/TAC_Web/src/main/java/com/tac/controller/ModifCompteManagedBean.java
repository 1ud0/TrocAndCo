package com.tac.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import com.tac.business.api.IServiceCompte;
import com.tac.entity.Membre;

@ManagedBean(name = "mbModifCompte")
@ViewScoped
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

	private Membre membreConnecte;

	public void onload() {
		membreConnecte = identifSession.getMembreConnected();
	}

	public String upload() {
		membreConnecte = identifSession.getMembreConnected();
		String path = Thread.currentThread().getContextClassLoader().getResource("bidon.txt").getPath();
		System.out.println(path);
		path = path.split("WEB-INF")[0] + "img/";
		path = path.substring(1);
		System.out.println(path);
		try {
			file1.write(path + getFilename(file1));
			membreConnecte.setAvatar("img/" + getFilename(file1));
			System.out.println(membreConnecte.getAvatar());
			proxyCompte.majDonnees(membreConnecte);
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
			msgs.add(new FacesMessage("file too big"));
		}
		if (!"image/gif".equals(contentType) && !"image/jpeg".equals(contentType) && !"image/png".equals(contentType)){
			msgs.add(new FacesMessage("pas une image"));
		}
		if (!msgs.isEmpty()) {
			throw new ValidatorException(msgs);
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

	public Membre getMembreConnecte() {
		return membreConnecte;
	}

	public void setMembreConnecte(Membre membreConnecte) {
		this.membreConnecte = membreConnecte;
	}

}
