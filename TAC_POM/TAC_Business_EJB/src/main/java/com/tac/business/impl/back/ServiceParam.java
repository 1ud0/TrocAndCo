package com.tac.business.impl.back;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.back.IServiceParam;
import com.tac.data.api.IDaoEchange;
import com.tac.data.api.IDaoMembre;
import com.tac.data.api.IDaoProposition;

@Remote(IServiceParam.class)
@Stateless
public class ServiceParam implements IServiceParam{

	@EJB
	IDaoProposition proxyProp;
	@EJB
	IDaoMembre proxyMembre;
	@EJB
	IDaoEchange proxyDaoEchange;
	
	@Override
	public List<Object[]> getAllEchangeFinisByMois() {
		return proxyDaoEchange.getAllEchangeFinisByMois();
	}
	
	@Override
	public List<Object[]> getAllPropsByCatMere() {
		
		return proxyProp.getAllPropsByCatMere();
	}
	@Override
	public List<Object[]> getAllMembreByMois() {
	
		return proxyMembre.getAllMembreByMois();
	}

	@Override
	public List<Object[]> getAllPropsByMois() {
		
		return proxyProp.getAllPropsByMois();
	}
	public IDaoProposition getProxyProp() {
		return proxyProp;
	}

	public void setProxyProp(IDaoProposition proxyProp) {
		this.proxyProp = proxyProp;
	}
	public IDaoMembre getProxyMembre() {
		return proxyMembre;
	}
	public void setProxyMembre(IDaoMembre proxyMembre) {
		this.proxyMembre = proxyMembre;
	}




}
