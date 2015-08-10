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
	private String[] tempProduct;
	private List<GladosNode> tempPath;
	
	public String[] getTempProduct() 
	{
		return tempProduct;
	}
	public void setTempProduct(String[] tempProduct) 
	{
		this.tempProduct = tempProduct;
	}
	public List<GladosNode> getTempPath()
	{
		return tempPath;
	}
	public void setTempPath(List<GladosNode> tempPath)
	{
		this.tempPath = tempPath;
	}
}