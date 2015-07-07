package com.netbuilder.orange_gardens;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class Stock 
{
	private int productID;
	private int stockLevel;
	private int stockAvailable;
	private boolean hasPorousware;
	private String location;
	private int maxStock;
	private int criticalThreshold;
	private int requiredStock;
	
	public int getProductID()
	{
		return productID;
	}
	
	public boolean getPorousware()
	{
		return hasPorousware;
	}
	
	public int getStockLevel()
	{
		return stockLevel;
	}
	
	public void setStockLevel(int stockLevel)
	{
		this.stockLevel = stockLevel;
	}
	
	public int getStockAvailable()
	{
		return stockAvailable;
	}
	
	public void setStockAvailable(int stockAvailable)
	{
		this.stockAvailable = stockAvailable;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public int getMaxStock()
	{
		return maxStock;
	}
	
	public void setMaxStock(int maxStock)
	{
		this.maxStock = maxStock;
	}
	
	public int getRequiredStock()
	{
		return requiredStock;
	}
	
	public void setRequiredStock(int requiredStock)
	{
		this.requiredStock = requiredStock;
	}
	
	public int getCriticalThreshold()
	{
		return criticalThreshold;
	}
	
	public void setCriticalThreshold(int criticalThreshold)
	{
		this.criticalThreshold = criticalThreshold;
	}
}