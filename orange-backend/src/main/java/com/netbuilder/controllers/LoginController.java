package com.netbuilder.controllers;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.util.RegistrationDetails;
import com.netbuilder.util.UserDetails;

/**
 * 
 * @author Alexander Neil llew mwatson
 *
 */

@ManagedBean(name="loginController")
@SessionScoped
public class LoginController {
	
	@ManagedProperty(value="#{userDetails}")
	private UserDetails userDetails;

	@Inject
	private LoginDetailsManager ldm;
	
	private String name;
	private String password;
	private int userId;
	private boolean loggedIn = false;
//	private String logout = "index.html";

	public String login(){
		System.out.println("Checking Password");
		System.out.println("UserName : " + name  + ", Password : " + password);

		System.out.println(ldm.getAllLoginDetails());
		userId = ldm.checkPassword(name, password);
		System.out.println("User exists? : " + userId);
		if(userId >= 0){
			loggedIn = true;
			return "account.xhtml";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incorrect username/password combination!"));
			loggedIn = false;
			return "login.xhtml";
		}
	}
	
	public String getName() { return name; }
	public String getPassword() { return password; }
	public void setName(String name) { this.name = name; }
	public void setPassword(String password) { this.password = password; }

	public String logout(){
		System.out.println("4realm8");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		loggedIn = false;
		return "index.xhtml";
	}

	public boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public String checkLoginStatus() {
		if(loggedIn == true) {
			return "account.xhtml";
		}
		else 
		return "login.xhtml";
	}

/*	public String getLogout() {
		return logout;
	}

	public void setLogout(String logout) {
		this.logout = logout;
	}*/
}