package com.tac.business.impl.back;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.back.IServiceParam;
import com.tac.data.api.IDaoProposition;

@Remote(IServiceParam.class)
@Stateless
public class ServiceParam implements IServiceParam{

	@EJB
	IDaoProposition proxyProp;
	
	@Override
	public List<Object[]> getAllPropsByCatMere() {
		System.out.println("coucou c'est nous !");
		return proxyProp.getAllPropsByCatMere();
	}

	public IDaoProposition getProxyProp() {
		return proxyProp;
	}

	public void setProxyProp(IDaoProposition proxyProp) {
		this.proxyProp = proxyProp;
	}

}
