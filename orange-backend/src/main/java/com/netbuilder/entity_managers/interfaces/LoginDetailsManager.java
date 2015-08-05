package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import com.netbuilder.entities.LoginDetails;

/**
 * 
 * @author Alexander Neil
 *
 */

@Named
@RequestScoped
public interface LoginDetailsManager {
	//CREATE
	public void persistLoginDetails(LoginDetails details);
	
	//READ
	public LoginDetails findByUsername(String username);
	public LoginDetails findByEmail(String email);
	public LoginDetails findByUserId(int userId);
	public int checkPassword(String name, String password);
	public List<LoginDetails> getAllLoginDetails();
	
	//UPDATE
	public void updateLoginDetails(LoginDetails details);
	
	//DELETE
	public void deleteLoginDetails(LoginDetails details);
}
