package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceDepartement;
import com.tac.data.api.IDaoDepartement;
import com.tac.entity.Departement;

@Remote(IServiceDepartement.class)
@Stateless
public class ServiceDepartement implements IServiceDepartement {

	@EJB
	private IDaoDepartement proxyDep;
	
	@Override
	public List<Departement> getAllDepartements() {
		return proxyDep.getAllDept();
	}

}
