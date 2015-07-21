package com.netbuilder.entity_managers.interfaces;

import com.netbuilder.entities.LoginDetails;

/**
 * 
 * @author Alexander Neil
 *
 */
public interface LoginDetailsManager {
	//CREATE
	public void persistLoginDetails(LoginDetails details);
	
	//READ
	public void findByUsername(String username);
	public void findByEmail(String email);
	public void findByUserId(int userId);
	public boolean checkPassword(String username, String password);
	public int getIdForResetString(String resetKey);
	
	//UPDATE
	public void setNewPassword(int userId, String oldPassword, String newPassword);
	public void setForgottenPassword(String resetKey, String password);
	public void generateForgottenPasswordKey(String email);
	
	//DELETE
	public void deleteDetails(LoginDetails details);
}
