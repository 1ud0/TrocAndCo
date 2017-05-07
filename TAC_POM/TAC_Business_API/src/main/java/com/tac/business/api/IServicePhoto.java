package com.tac.business.api;

import java.util.List;

import com.tac.entity.Photo;
import com.tac.entity.Proposition;

public interface IServicePhoto {

	List<Photo> getByProposition(Proposition proposition);
}
