package com.netbuilder.util;

import java.util.ArrayList;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 * 
 * @author JustinMabbutt llew
 *
 */
@ManagedBean(name = "userDetails")
@SessionScoped
public class UserDetails
{
	private ArrayList<String> name;
	private ArrayList<String> password;
	private ArrayList<Integer> uid;
	
	public UserDetails(){
		Random rand = new Random();
		
		name = new ArrayList<String>();
		password = new ArrayList<String>();
		uid = new ArrayList<Integer>();
		
		name.add("test");
		password.add("test");
		uid.add(rand.nextInt());
		
	}
	
	public UserDetails(String name, String password) 
	{
		this.setName(name);
		this.setPassword(password);
	}

	public ArrayList<String> getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name.add(name);
	}

	public ArrayList<String> getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password.add(password);
	}

	public ArrayList<Integer> getUid() 
	{
		return uid;
	}

	public void setUid(int uid) 
	{
		this.uid.add(uid);
	}
	
	
}