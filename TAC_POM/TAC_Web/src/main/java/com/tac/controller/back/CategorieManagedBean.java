package com.tac.controller.back;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="mbCategorie")
@ViewScoped
public class CategorieManagedBean {
	@ManagedProperty(value="#{mbCnx}")
	private ConnectionManagedBean mbConnect;
	public String connection(){
	return mbConnect.getUserConnected().getNom();
	}
	public String httpSession(){
		HttpSession session =(HttpSession) 
				FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		ConnectionManagedBean mbCnx = (ConnectionManagedBean) session.getAttribute("mbCnx");
		return mbCnx.getUserConnected().getNom();
	}
	public ConnectionManagedBean getMbConnect(){
		return mbConnect;
	}
	public void setMbConnect(ConnectionManagedBean mbConnect){
		this.mbConnect = mbConnect;
	}
	

}
