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
	private List<String> tempProduct;
	private List<GladosNode> tempPath;
	
	public List<String> getTempProduct() 
	{
		return tempProduct;
	}
	public void addTempProduct(String tempProduct) 
	{
		this.tempProduct.add(tempProduct);
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