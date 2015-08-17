package com.netbuilder.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.netbuilder.enums.DeliveryStatus;

/**
 * 
 * @author JustinMabbutt
 *
 */
@Entity
@Table(name = "delivery")
@NamedQueries({
	@NamedQuery(name = Delivery.FIND_BY_DATE_PLACED, query = "SELECT d FROM Delivery d WHERE d.datePlaced = :datePlaced"),
	@NamedQuery(name = Delivery.FIND_BY_DELIVERY_ID, query = "SELECT d FROM Delivery d WHERE d.deliveryId = :delivery_id"),
	@NamedQuery(name = Delivery.GET_ALL, query = "SELECT d FROM Delivery d")})
public class Delivery implements Serializable
{
	public static final String GET_ALL = "Deliery.getDeliveries";
	public static final String FIND_BY_DATE_PLACED = "Delivery.findByDatePlaced";
	public static final String FIND_BY_DELIVERY_ID = "Delivery.findByDeliveryId";
	
	@Id
	@Column(name = "delivery_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int deliveryId;
	@Column(name = "status", nullable = false)
	@NotNull
	private DeliveryStatus deliveryStatus;
	@Column(name = "date_placed", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String datePlaced;
	@Column(name = "delivery_date", nullable = false, length = 45)
	@Size(min = 2, max = 45)
	private String dateToBeDelivered;
	@Column(name = "supplier", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String supplier;
	@Column(name = "price", nullable = false)
	@NotNull
	private BigDecimal price;

	public Delivery(String datePlaced, String dateToBeDelivered,
			String supplier, BigDecimal price) {
		this.datePlaced = datePlaced;
		this.dateToBeDelivered = dateToBeDelivered;
		this.supplier = supplier;
		this.price = price;
	}
	
	public Delivery(){}

	public int getDeliveryId() {
		return deliveryId;
	}

	public String getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}

	public String getDateToBeDelivered() {
		return dateToBeDelivered;
	}

	public void setDateToBeDelivered(String dateToBeDelivered) {
		this.dateToBeDelivered = dateToBeDelivered;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}