package com.tac.business.impl.back;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.back.IServiceEchangeBO;
import com.tac.data.api.IDaoEchange;
import com.tac.entity.Echange;
@Remote(IServiceEchangeBO.class)
@Stateless
public class ServiceEchangeBO implements IServiceEchangeBO{
	@EJB
	IDaoEchange proxyEchange;
	
	
	@Override
	public List<Echange> getAll() {
		
		return proxyEchange.getAll();
	}

}
