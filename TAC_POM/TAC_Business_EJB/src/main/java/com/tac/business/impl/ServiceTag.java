package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceTag;
import com.tac.data.api.IDaoTag;
import com.tac.entity.Categorie;
import com.tac.entity.Tag;

@Remote(IServiceTag.class)
@Stateless
public class ServiceTag implements IServiceTag {
	
	@EJB
	private IDaoTag proxyDaoTag;

	@Override
	public Tag addTag(Tag tag) {
		return proxyDaoTag.addTag(tag);
	}

	@Override
	public Tag updateTag(Tag tag) {
		return proxyDaoTag.updateTag(tag);
	}

	@Override
	public void deleteTag(Tag tag) {
		proxyDaoTag.deleteTag(tag);
		
	}

	@Override
	public List<Tag> getTagsForCat(Categorie cat) {
		return proxyDaoTag.getTagsByIdCat(cat.getIdCategorie());
	}
	
	

}
