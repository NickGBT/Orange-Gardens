package com.netbuilder.util;

//import javax.faces.bean.SessionScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "isLoggedIn")
@SessionScoped
public class IsLoggedIn {

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
