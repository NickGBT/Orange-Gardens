package com.netbuilder.entity_managers.interfaces;

import java.util.ArrayList;

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
	public void persistStock(ArrayList<Stock> stock);
	
	//READ
	public ArrayList<Stock> findByCriticalThreshold(int criticalThreshold);
	public ArrayList<Stock> findByRequiredStock(int requiredStock);
	public ArrayList<Stock> findByStockLevel(int stockLevel);
	public ArrayList<Stock> findByStockAvailable(int stockAvailable);
	public ArrayList<Stock> findByMaximumStock(int maxStock);
	public Stock findByProductID(int productID);
	public ArrayList<Stock> getStock();
	
	//UPDATE
	public void updateStock(Stock stock);
	
	//DELETE
	public void removeStock(Stock stock);
}