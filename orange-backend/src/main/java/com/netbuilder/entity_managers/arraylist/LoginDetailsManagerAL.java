package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
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
@Stateful
public class LoginDetailsManagerAL implements LoginDetailsManager {

	private ArrayList<LoginDetails> loginDetails = new ArrayList<LoginDetails>();
	
	public void persistLoginDetails(LoginDetails details) {
		
		System.out.println("Pesist login Details: " + details);
		loginDetails.add(details);
	}

	public LoginDetails findByUsername(String username) {
		
		for(LoginDetails ld: loginDetails){
			if(ld.getUsername().equals(username)) return ld;
		}
		return null;
	}

	public LoginDetails findByEmail(String email) {

		for(LoginDetails ld: loginDetails){
			if(ld.getEmail().equals(email)) return ld;
		}
		return null;
	}

	public LoginDetails findByUserId(int userId) {
		for(LoginDetails ld: loginDetails){
			if(ld.getUserId() == userId) return ld;
		}
		return null;
	}
	
	public List<LoginDetails> getAllLoginDetails()
	{
		System.out.println("getting: " + loginDetails);
		return loginDetails;
	}

	public int checkPassword(String name, String password) {
		System.out.println("Check Name: " + name);
		System.out.println("Check password" + password);
		LoginDetails result;
		
		if(LoginDetailsToolkit.isEmail(name)){
			result = findByEmail(name);
		}
		else{
			result = findByUsername(name);
		}
		
		if(result != null){
			if(LoginDetailsToolkit.checkPassword(result, password)) return result.getUserId();
		}
		return -1;

	}

	public void updateLoginDetails(LoginDetails details){
		for(LoginDetails ld: loginDetails){
			if(ld.getUserId() == details.getUserId()){
				loginDetails.set(loginDetails.indexOf(ld),details);
				return;
			}
		}
		
	}

	public void deleteLoginDetails(LoginDetails details) {
		loginDetails.remove(details);

	}

}
