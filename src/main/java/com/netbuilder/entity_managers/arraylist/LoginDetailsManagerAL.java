package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.util.LoginDetailsToolkit;

/**
 * 
 * @author Alexander Neil
 *
 */
@Alternative
@Stateless
public class LoginDetailsManagerAL implements LoginDetailsManager {

	private ArrayList<LoginDetails> loginDetails = new ArrayList<LoginDetails>();
	
	public void persistLoginDetails(LoginDetails details) {
		loginDetails.add(details);
	}

	public LoginDetails findByUsername(String username) {
		
		for(LoginDetails ld: loginDetails){
			if(ld.getUsername() == username) return ld;
		}
		return null;
	}

	public LoginDetails findByEmail(String email) {

		for(LoginDetails ld: loginDetails){
			if(ld.getEmail() == email) return ld;
		}
		return null;
	}

	public LoginDetails findByUserId(int userId) {
		for(LoginDetails ld: loginDetails){
			if(ld.getUserId() == userId) return ld;
		}
		return null;
	}

	public int checkPassword(String name, String password) {
		if(LoginDetailsToolkit.isEmail(name)){
			for(LoginDetails ld: loginDetails){
				if(name == ld.getEmail()){
					if(LoginDetailsToolkit.checkPassword(ld, password)) return ld.getUserId();
					else return -1;
				}
			}
		}
		else{
			for(LoginDetails ld: loginDetails){
				if(name == ld.getUsername()){
					if(LoginDetailsToolkit.checkPassword(ld, password)) return ld.getUserId();
					else return -1;
				}
			}
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
