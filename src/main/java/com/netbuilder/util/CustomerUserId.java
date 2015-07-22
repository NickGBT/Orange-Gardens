package com.netbuilder.util;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class CustomerUserId 
{
	private static int uid;
	
	public static void setUid(int loginUid)
	{
		uid = loginUid;
	}
	
	public static int getUid()
	{
		return uid;
	}
}