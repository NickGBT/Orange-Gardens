package com.netbuilder.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
public class LoginController implements Serializable {

	@ManagedProperty(value = "#{userDetails}")
	private UserDetails userDetails;

	@Inject
	private LoginDetailsManager ldm;

	private String name;
	private String password;
	private int userExists;
	private boolean loggedIn = false;
	
	private static final Logger logger = LogManager.getLogger();

	@Inject
	private UserId userId;

	// private String logout = "index.html";

	public String login() {

		userExists = ldm.checkPassword(name, password);
		System.out.println("User exists? : " + userExists);
		if (userExists >= 0) {
			userId.setUsername(name);
			userId.setUid(userExists);
			loggedIn = true;
			logger.info("Username: " + userId.getUsername());
			return "account.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Incorrect username/password combination!"));
			loggedIn = false;
			return "customerlogin.xhtml";
		}
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		loggedIn = false;
		return "webstorefront.xhtml";
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
		if (loggedIn == true) {
			return "account.xhtml";
		} else
			return "login.xhtml";
	}

	/*
	 * public String getLogout() { return logout; }
	 * 
	 * public void setLogout(String logout) { this.logout = logout; }
	 */
}