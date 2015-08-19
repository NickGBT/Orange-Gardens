package com.netbuilder.util;

import java.util.List;

import com.netbuilder.pathfinding.GladosNode;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class MessageHandler
{
	private List<Object> tempStore;
	
	public List<Object> getTempStore() 
	{
		return tempStore;
	}
	public void setTempProduct(List<Object> temp) 
	{
		this.tempStore = temp;
	}
}