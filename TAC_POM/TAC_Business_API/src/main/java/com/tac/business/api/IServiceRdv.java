package com.tac.business.api;

import java.util.List;

import com.tac.entity.Rdv;

public interface IServiceRdv {
	
	Rdv addRdv(Rdv rdv);
	void deleteRdv(Rdv rdv);
	Rdv updateRdv(Rdv rdv);
	List<Rdv> getRdvByMembre(int idMembre);

}
