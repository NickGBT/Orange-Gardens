package com.netbuilder.orange_gardens;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author llew
 */

@Entity
@Table (name = "Order")
public class Order {
	
	@Id
	@Column(name = "order_id", nullable = false)
	@NotNull
	private int orderID;
	
	@OneToMany
	@JoinColumn (name = "customer_id", nullable = false)
	private int customerID;
	
	@OneToMany
	@JoinColumn (name = "handler_id")
	private int handlerID;
	
	@Column (name = "status", nullable = false)
	@NotNull	
	private Status status;
	
	@Column (name = "date_placed", nullable = false)
	@NotNull
	private String datePlaced;
	
	@Column (name = "date_dispatched", nullable = false)
	@NotNull
	private String dateDispatched;
	
	@Column (name = "date_delivered", nullable = false)
	@NotNull
	private String dateDelivered;
	
	@Column (name = "time_to_deliver")
	private String timeToDeliver;
	
	@Column (name = "refund_available")
	private boolean refundAvaiable;
	
		
	public Order(int customerID, int handlerID, Status status,
			String datePlaced, String dateDispatched, String dateDelivered,
			String timeToDeliver, boolean refundAvaiable) {
		this.customerID = customerID;
		this.handlerID = handlerID;
		this.status = status;
		this.datePlaced = datePlaced;
		this.dateDispatched = dateDispatched;
		this.dateDelivered = dateDelivered;
		this.timeToDeliver = timeToDeliver;
		this.refundAvaiable = refundAvaiable;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getDatePlaced() {
		return datePlaced;
	}
	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}
	public String getTimeToDeliver() {
		return timeToDeliver;
	}
	public void setTimeToDeliver(String timeToDeliver) {
		this.timeToDeliver = timeToDeliver;
	}
	public boolean isRefundAvaiable() {
		return refundAvaiable;
	}
	public void setRefundAvaiable(boolean refundAvaiable) {
		this.refundAvaiable = refundAvaiable;
	}
	public String getDateDispatched() {
		return dateDispatched;
	}
	public void setDateDispatched(String dateDispatched) {
		this.dateDispatched = dateDispatched;
	}
	public String getDateDelivered() {
		return dateDelivered;
	}
	public void setDateDelivered(String dateDelivered) {
		this.dateDelivered = dateDelivered;
	}
	public int getOrderID() {
		return orderID;
	}
	
	public int getHandlerID(){
		return handlerID;
	}

	
	
}
