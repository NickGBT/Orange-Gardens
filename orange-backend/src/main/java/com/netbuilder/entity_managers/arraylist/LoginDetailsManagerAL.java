package com.netbuilder.entity_managers.arraylist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.util.LoginDetailsToolkit;

/**
 * 
 * @author Alexander Neil
 *
 */
@Alternative
@SessionScoped
public class LoginDetailsManagerAL implements LoginDetailsManager, Serializable {

	private ArrayList<LoginDetails> loginDetails = new ArrayList<LoginDetails>();

	public void persistLoginDetails(LoginDetails details) {

		System.out.println("Pesist login Details: " + details);
		loginDetails.add(details);
	}

	public LoginDetails findByUsername(String username) {

		for (LoginDetails ld : loginDetails) {
			;
			if (ld.getUsername().equals(username))
				return ld;
		}
		return null;
	}

	public LoginDetails findByEmail(String email) {

		for (LoginDetails ld : loginDetails) {
			if (ld.getEmail().equals(email))
				return ld;
		}
		return null;
	}

	public LoginDetails findByUserId(int userId) {
		for (LoginDetails ld : loginDetails) {
			if (ld.getUserId() == userId)
				return ld;
		}
		return null;
	}

	public List<LoginDetails> getAllLoginDetails() {
		return loginDetails;
	}

	public int checkPassword(String name, String password) {
		LoginDetails result;

		if (LoginDetailsToolkit.isEmail(name)) {
			result = findByEmail(name);
		} else {
			result = findByUsername(name);
			System.out.println("Check username: " + name);
		}

		if (result != null) {
			if (LoginDetailsToolkit.checkPassword(result, password))
				return 1; // result.getUserId();
		}
		return -1;

	}

	public void updateLoginDetails(LoginDetails details) {
		for (LoginDetails ld : loginDetails) {
			if (ld.getUserId() == details.getUserId()) {
				loginDetails.set(loginDetails.indexOf(ld), details);
				return;
			}
		}

	}

	public void deleteLoginDetails(LoginDetails details) {
		loginDetails.remove(details);

	}

}
