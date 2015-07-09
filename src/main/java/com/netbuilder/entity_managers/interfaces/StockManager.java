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
	public Stock findByCriticalThreshold(int criticalThreshold);
	public Stock findByRequiredStock(int requiredStock);
	public Stock findByStockLevel(int stockLevel);
	public Stock findByStockAvailable(int stockAvailable);
	public Stock findByMaximumStock(int maxStock);
	public Stock findByProductID(int productID);
	public ArrayList<Stock> getStock();
	
	//UPDATE
	public void updateStock(Stock stock);
	
	//DELETE
	public void removeStock(Stock stock);
}