package com.tac.data.api;

import java.util.List;

import com.tac.entity.Photo;
import com.tac.entity.Proposition;

public interface IDaoPhoto {

	Photo getById(int idPhoto);
	Photo addPhoto(Photo photo);
	Photo updatePhoto(Photo photo);
	void deletePhoto(Photo photo);
	List<Photo> getByProposition(Proposition proposition);
}
