package com.tac.business.api;

import java.util.List;

import com.tac.entity.Categorie;
import com.tac.entity.Tag;

public interface IServiceTag {
	
	Tag addTag(Tag tag);
	Tag updateTag(Tag tag);
	void deleteTag(Tag tag);
	List<Tag> getTagsForCat(Categorie cat);
	List<Tag> getAllTag();
}
