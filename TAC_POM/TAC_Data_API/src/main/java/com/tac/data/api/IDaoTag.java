package com.tac.data.api;

import java.util.List;

import com.tac.entity.Tag;

public interface IDaoTag {
	
	Tag addTag(Tag tag);
	Tag updateTag(Tag tag);
	void deleteTag(Tag tag);
	List<Tag> getTagsByIdCat (int idCat);
	List<Tag> getAllTag();


}
