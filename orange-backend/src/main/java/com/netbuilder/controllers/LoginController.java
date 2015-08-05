package com.netbuilder.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.util.UserDetails;
import com.netbuilder.util.UserId;

/**
 * 
 * @author Alexander Neil llew
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
	private int userExists;
	private boolean loggedIn = false;
	
	@Inject
	private UserId userId;
//	private String logout = "index.html";

	public String login(){
		System.out.println("Checking Password");
		System.out.println("UserName : " + name  + ", Password : " + password);

		System.out.println(ldm.getAllLoginDetails());
		userExists = ldm.checkPassword(name, password);
		System.out.println("User exists? : " + userExists);
		if(userExists >= 0){
			userId.setUsername(name);
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

/*	public String getLogout() {
		return logout;
	}

	public void setLogout(String logout) {
		this.logout = logout;
	}*/
}