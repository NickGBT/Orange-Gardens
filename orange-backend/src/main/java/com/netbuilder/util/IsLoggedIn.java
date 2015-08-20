package com.netbuilder.util;

import java.io.Serializable;

//import javax.faces.bean.SessionScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 * 
 * @author ???????
 *
 */
@ManagedBean(name = "isLoggedIn")
@SessionScoped
public class IsLoggedIn implements Serializable {

	private static final long serialVersionUID = 5440963945386351267L;
	private boolean isLoggedIn = false;
	private int userId;
	
	public IsLoggedIn(){}

	public IsLoggedIn(boolean isLoggedIn, int userID) {
		this.isLoggedIn = isLoggedIn;
		this.userId = userID;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}