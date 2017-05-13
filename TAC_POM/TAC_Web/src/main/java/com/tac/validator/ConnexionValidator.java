package com.tac.validator;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.tac.business.api.IServiceIdentification;

@ManagedBean
@RequestScoped
public class ConnexionValidator implements Validator {

	@EJB
	private IServiceIdentification proxyIdentification;
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object submittedMail) throws ValidatorException {
		String mail = submittedMail.toString();

		UIInput uiInputPassword = (UIInput) component.getAttributes().get("pwd");
		String password = uiInputPassword.getSubmittedValue().toString();

		// Let required="true" do its job.
		if (mail == null || mail.isEmpty() || password == null || password.isEmpty()) {
			return;
		}

		if (proxyIdentification.identification(mail, password) == null) {
			uiInputPassword.setValid(false);
			throw new ValidatorException(new FacesMessage("Identifiants incorrects"));
		}
	}

}
