package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import com.netbuilder.entities.Stock;

/**
 * 
 * @author JustinMabbutt
 *
 */

public interface StockManager 
{
	//CREATE
	public void persistStock(Stock stock);
	public void persistStock(List<Stock> stock);
	
	//READ
	public List<Stock> findByCriticalThreshold(int criticalThreshold);
	public List<Stock> findByRequiredStock(int requiredStock);
	public List<Stock> findByStockLevel(int stockLevel);
	public List<Stock> findByStockAvailable(int stockAvailable);
	public List<Stock> findByMaximumStock(int maxStock);
	public Stock findByProductID(int productID);
	public List<Stock> getStock();
	
	//UPDATE
	public void updateStock(Stock stock);
	
	//DELETE
	public void removeStock(Stock stock);
}