package com.netbuilder.util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class UserDetails {
	public String username;
	public String password;
	
	public UserDetails(String username, String password) {
		this.username = username;
		this.password = password;
	}
}