package com.netbuilder.orange_gardens;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Entity
@Table(name = "stock")
public class Stock 
{
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	@NotNull
	private Product product;
	@Column(name = "stock_level", nullable = false)
	@NotNull
	private int stockLevel;
	@Column(name = "stock_available", nullable = false)
	@NotNull
	private int stockAvailable;
	@Column(name = "location", nullable = true, length = 20)
	@Null
	@Size(min = 2, max = 20)
	private String location;
	@Column(name = "maximum_stock", nullable = false)
	@NotNull
	private int maxStock;
	@Column(name = "critical_threshold", nullable = false)
	@NotNull
	private int criticalThreshold;
	@Column(name = "required_stock", nullable = false)
	@NotNull
	private int requiredStock;
	
	public Stock(Product product, int stockLevel, int stockAvailable, String location, int maxStock, int criticalThreshold, int requiredStock) 
	{
		this.product = product;
		this.stockLevel = stockLevel;
		this.stockAvailable = stockAvailable;
		this.location = location;
		this.maxStock = maxStock;
		this.criticalThreshold = criticalThreshold;
		this.requiredStock = requiredStock;
	}
	
	public Product getProductID()
	{
		return product;
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