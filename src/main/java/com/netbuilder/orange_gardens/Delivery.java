package com.netbuilder.orange_gardens;

import java.math.BigDecimal;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class Delivery
{
	private int deliveryID;
	private enum deliveryStatus{Ordered, Delivered};
	private String datePlaced;
	private String dateToBeDelivered;
	private String supplier;
	private BigDecimal price;
	
	public int getDeliveryID()
	{
		return deliveryID;
	}

	public String getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(String datePlaced) 
	{
		this.datePlaced = datePlaced;
	}

	public String getDateToBeDelivered() 
	{
		return dateToBeDelivered;
	}

	public void setDateToBeDelivered(String dateToBeDelivered)
	{
		this.dateToBeDelivered = dateToBeDelivered;
	}

	public String getSupplier()
	{
		return supplier;
	}

	public void setSupplier(String supplier)
	{
		this.supplier = supplier;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}