package com.netbuilder.controllers;

import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;

/**
 * 
 * @author Alexander Neil
 *
 */

@ManagedBean(name="login")
@Stateful
@SessionScoped
public class LoginController {
	
	@Inject
	private LoginDetailsManager ldm;
	private String name;
	private String password;
	private int userId;
	private boolean loggedIn = true;

	public String login(){
		
		userId = ldm.checkPassword(name, password);
		
		if(userId >= 0){
			
			return "account.xhtml";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incorrect username/password combination!"));
			return "login.xhtml";
		}
	}
	
	public String getName() { return name; }
	public String getPassword() { return password; }
	public void setName(String name) { this.name = name; }
	public void setPassword(String password) { this.password = password; }

	public void logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}