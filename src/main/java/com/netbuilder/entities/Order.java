package com.netbuilder.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.netbuilder.enums.OrderStatus;

/**
 * @author llew
 */

@Entity
@Table (name = "Order")
public class Order {
	
	@Id
	@Column(name = "order_id", nullable = false)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private int orderID;
	
	@OneToMany
	@NotNull
	@JoinColumn (name = "user_id", nullable = false)
	private LoginDetails customerID;
	
	@OneToMany
	@JoinColumn (name = "user_id")
	private LoginDetails employeeID;
	
	@OneToMany
	@JoinColumn
	private PaymentDetails paymentDetails;
	
	@Column (name = "status", nullable = false)
	@NotNull	
	private OrderStatus status;
	
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
	private boolean refundAvailable;
	
		
	public Order(LoginDetails customerID, LoginDetails employeeID, OrderStatus status,
			String datePlaced, String dateDispatched, String dateDelivered,
			String timeToDeliver, boolean refundAvailable, PaymentDetails paymentDetails) {
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.status = status;
		this.datePlaced = datePlaced;
		this.dateDispatched = dateDispatched;
		this.dateDelivered = dateDelivered;
		this.timeToDeliver = timeToDeliver;
		this.refundAvailable = refundAvailable;
		this.paymentDetails = paymentDetails;
	}
	
	public Order(LoginDetails customerID, OrderStatus status, PaymentDetails paymentDetails) {
		this.customerID = customerID;
		this.status = status;
		this.paymentDetails = paymentDetails;
	}

	public LoginDetails getCustomer() {
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
	public boolean isRefundAvailable() {
		return refundAvailable;
	}
	public void setRefundAvailable(boolean refundAvailable) {
		this.refundAvailable = refundAvailable;
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
	
	public void setOrderID(int id){
		orderID = id;
	}
	
	public OrderStatus getOrderStatus(){
		return status;
	}
	
	public LoginDetails getEmployee(){
		return employeeID;
	}
	
	public PaymentDetails getPaymentDetails(){
		return paymentDetails;
	}
}