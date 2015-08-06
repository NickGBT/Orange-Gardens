package com.netbuilder.controllers;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.util.UserDetails;
import com.netbuilder.util.UserId;

/**
 * 
 * @author Alexander Neil llew mwatson
 *
 */

@Named("loginController")
@SessionScoped
public class LoginController implements Serializable{
	
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
			System.out.println(userId.getUsername());
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