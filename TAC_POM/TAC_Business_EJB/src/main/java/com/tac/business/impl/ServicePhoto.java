package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServicePhoto;
import com.tac.data.api.IDaoPhoto;
import com.tac.entity.Photo;
import com.tac.entity.Proposition;

@Remote(IServicePhoto.class)
@Stateless
public class ServicePhoto implements IServicePhoto {

	@EJB
	private IDaoPhoto proxyPhoto;
	
	@Override
	public List<Photo> getByProposition(Proposition proposition) {
		return proxyPhoto.getByProposition(proposition);
	}

	@Override
	public Photo addPhoto(Photo photoAAjouter) {
		Photo photo = proxyPhoto.addPhoto(photoAAjouter);
		return photo;
	}

	@Override
	public Photo updatePhoto(Photo photoAUpdater) {
		Photo photo = proxyPhoto.updatePhoto(photoAUpdater);
		return photo;
	}
	
	

}
