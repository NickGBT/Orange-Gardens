package com.netbuilder.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
	@NamedQuery(name = Stock.FIND_BY_CRITICAL_THRESHOLD, query = "SELECT s FROM Stock s WHERE s.criticalThreshold = :criticalThreshold"),
	@NamedQuery(name = Stock.FIND_BY_REQUIRED_STOCK, query = "SELECT s FROM Stock s WHERE s.requiredStock = :requiredStock"),
	@NamedQuery(name = Stock.FIND_BY_STOCK_LEVEL, query = "SELECT s FROM Stock s WHERE s.stockLevel = :stockLevel"),
	@NamedQuery(name = Stock.FIND_BY_MAX_STOCK, query = "SELECT s FROM Stock s WHERE s.maxStock = :maximumStock"),
	@NamedQuery(name = Stock.FIND_BY_STOCK_AVAILABLE, query = "SELECT s FROM Stock s WHERE s.stockAvailable = :stockAvailable"),
	@NamedQuery(name = Stock.FIND_BY_PRODUCT, query = "SELECT s FROM Stock s WHERE s.product = :product"),
	@NamedQuery(name = Stock.GET_ALL, query = "SELECT s FROM Stock s")})
public class Stock implements Serializable 
{
	public static final String GET_ALL = "Stock.getStock";
	public static final String FIND_BY_STOCK_LEVEL = "Stock.findByStockLevel";
	public static final String FIND_BY_REQUIRED_STOCK = "Stock.findByRequiredStock";
	public static final String FIND_BY_CRITICAL_THRESHOLD = "Stock.findByCriticalThreshold";
	public static final String FIND_BY_MAX_STOCK = "Stock.findByMaximumStock";
	public static final String FIND_BY_STOCK_AVAILABLE = "Stock.findByStockAvailable";
	public static final String FIND_BY_PRODUCT = "Stock.findByProductId";

	@ManyToOne
	@Id
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
	@Column(name = "warehouse_x", nullable = false)
	@NotNull
	private int warehouseX;
	@Column(name = "warehouse_y", nullable = false)
	@NotNull
	private int warehouseY;

	public Stock(Product product, int stockLevel, int stockAvailable,
			String location, int maxStock, int criticalThreshold,
			int requiredStock, int warehouseX, int warehouseY) 
	{
		this.product = product;
		this.stockLevel = stockLevel;
		this.stockAvailable = stockAvailable;
		this.location = location;
		this.maxStock = maxStock;
		this.criticalThreshold = criticalThreshold;
		this.requiredStock = requiredStock;
		this.warehouseX = warehouseX;
		this.warehouseY = warehouseY;
	}
	
	public Stock(){}

	public Product getProduct() 
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

	/**
	 * @return the warehouseX
	 */
	public int getWarehouseX() 
	{
		return warehouseX;
	}

	/**
	 * @param warehouseX the warehouseX to set
	 */
	public void setWarehouseX(int warehouseX)
	{
		this.warehouseX = warehouseX;
	}

	/**
	 * @return the warehouseY
	 */
	public int getWarehouseY() 
	{
		return warehouseY;
	}

	/**
	 * @param warehouseY the warehouseY to set
	 */
	public void setWarehouseY(int warehouseY) 
	{
		this.warehouseY = warehouseY;
	}
}