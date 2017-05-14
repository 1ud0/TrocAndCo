package com.tac.business.api.back;

import java.util.List;

public interface IServiceParam {
	
	List<Object[]> getAllPropsByCatMere();
	List<Object[]> getAllMembreByMois();
	List<Object[]> getAllPropsByMois();
	List<Object[]> getAllEchangeFinisByMois();

}
