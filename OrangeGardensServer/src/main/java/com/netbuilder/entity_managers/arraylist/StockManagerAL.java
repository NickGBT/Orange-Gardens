package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.Stock;
import com.netbuilder.entity_managers.interfaces.StockManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Alternative
@Stateless
public class StockManagerAL implements StockManager
{
	private ArrayList<Stock> stock = new ArrayList<Stock>();
	
	public void persistStock(Stock stock)
	{
		this.stock.add(stock);
	}

	public void persistStock(List<Stock> stock)
	{
		this.stock.addAll(stock);
	}

	public List<Stock> findByCriticalThreshold(int criticalThreshold) 
	{
		List<Stock> results = new ArrayList<Stock>();
		for(Stock s: stock)
		{
			if(s.getCriticalThreshold() == criticalThreshold)
			{
				results.add(s);
			}
		}
		return results;
	}

	public List<Stock> findByRequiredStock(int requiredStock) 
	{
		List<Stock> results = new ArrayList<Stock>();
		for(Stock s: stock)
		{
			if(s.getRequiredStock() == requiredStock)
			{
				results.add(s);
			}
		}
		return results;
	}

	public List<Stock> findByStockLevel(int stockLevel)
	{
		List<Stock> results = new ArrayList<Stock>();
		for(Stock s: stock)
		{
			if(s.getStockLevel() == stockLevel)
			{
				results.add(s);
			}
		}
		return results;
	}

	public List<Stock> findByStockAvailable(int stockAvailable)
	{
		List<Stock> results = new ArrayList<Stock>();
		for(Stock s: stock)
		{
			if(s.getStockAvailable() == stockAvailable)
			{
				results.add(s);
			}
		}
		return results;
	}

	public List<Stock> findByMaximumStock(int maxStock)
	{
		List<Stock> results = new ArrayList<Stock>();
		for(Stock s: stock)
		{
			if(s.getMaxStock() == maxStock)
			{
				results.add(s);
			}
		}
		if(results.isEmpty())
		{
			return null;
		}
		else
		{
			return results;
		}	
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

	public List<Stock> getStock() 
	{
		return stock;
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
