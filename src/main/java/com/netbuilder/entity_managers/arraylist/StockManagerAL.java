package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import com.netbuilder.entities.Stock;
import com.netbuilder.entity_managers.interfaces.StockManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class StockManagerAL implements StockManager
{
	private ArrayList<Stock> stock = new ArrayList<Stock>();
	
	public void persistStock(Stock stock)
	{
		this.stock.add(stock);
	}

	public void persistStock(ArrayList<Stock> stock)
	{
		this.stock.addAll(stock);
	}

	public Stock findByCriticalThreshold(int criticalThreshold) 
	{
		for(Stock s: stock)
		{
			if(s.getCriticalThreshold() == criticalThreshold)
			{
				return s;
			}
		}
		return null;
	}

	public Stock findByRequiredStock(int requiredStock) 
	{
		for(Stock s: stock)
		{
			if(s.getRequiredStock() == requiredStock)
			{
				return s;
			}
		}
		return null;
	}

	public Stock findByStockLevel(int stockLevel)
	{
		for(Stock s: stock)
		{
			if(s.getStockLevel() == stockLevel)
			{
				return s;
			}
		}
		return null;
	}

	public Stock findByStockAvailable(int stockAvailable)
	{
		for(Stock s: stock)
		{
			if(s.getStockAvailable() == stockAvailable)
			{
				return s;
			}
		}
		return null;
	}

	public Stock findByMaximumStock(int maxStock)
	{
		for(Stock s: stock)
		{
			if(s.getMaxStock() == maxStock)
			{
				return s;
			}
		}
		return null;
	}
	
	public Stock findByProductID(int productID)
	{
		for(Stock s: stock)
		{
			if(s.getProduct().getProductId() == productID)
			{
				return s;
			}
		}
		return null;
	}

	public ArrayList<Stock> getStock() 
	{
		ArrayList<Stock> results = new ArrayList<Stock>();
		return null;
	}

	public void updateStock(Stock stock) 
	{
		for(Stock s: this.stock)
		{
			if(s.getProduct().getProductId() == stock.getProduct().getProductId())
			{
				this.stock.set(this.stock.indexOf(s), stock);
			}
		}
	}

	public void removeStock(Stock stock) 
	{
		for(Stock s: this.stock)
		{
			if(s.getProduct().getProductId() == stock.getProduct().getProductId())
			{
				this.stock.remove(this.stock.indexOf(s));
			}
		}
	}
}
