package com.netbuilder.orange_gardens;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Entity
@Table(name = "delivery")
public class Delivery
{
	@Id
	@Column(name = "delivery_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int deliveryID;
	@Column(name = "status", nullable = false)
	@NotNull
	private DeliveryStatus deliveryStatus;
	@Column(name = "date_placed", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45) //Needs changing once date format is known
	private String datePlaced;
	@Column(name = "delivery_date", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45) //Needs changing once date format is known
	private String dateToBeDelivered;
	@Column(name = "supplier", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String supplier;
	@Column(name = "price", nullable = false)
	@NotNull
	private BigDecimal price;
	
	public Delivery(String datePlaced, String dateToBeDelivered, String supplier, BigDecimal price) 
	{
		this.datePlaced = datePlaced;
		this.dateToBeDelivered = dateToBeDelivered;
		this.supplier = supplier;
		this.price = price;
	}
	
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