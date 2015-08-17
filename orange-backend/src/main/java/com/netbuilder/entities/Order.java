package com.netbuilder.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.netbuilder.enums.OrderStatus;

/**
 * @author llew
 */

@Entity
@Table(name = "Order")
public class Order implements Serializable {

	@Id
	@Column(name = "order_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int orderId;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "customer_id", nullable = false)
	private LoginDetails customerId;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private LoginDetails employeeId;

	@ManyToOne
	@JoinColumn(name = "payment_details")
	private PaymentDetails paymentDetails;

	@Column(name = "status", nullable = false)
	@NotNull
	private OrderStatus status;

	@Column(name = "date_placed", nullable = false)
	@NotNull
	private String datePlaced;

	@Column(name = "date_dispatched", nullable = false)
	private String dateDispatched;

	@Column(name = "date_delivered", nullable = false)
	private String dateDelivered;

	@Column(name = "time_to_deliver")
	private int timeToDeliver;

	@Column(name = "refund_available")
	private boolean refundAvailable;

	public Order(LoginDetails customerId, LoginDetails employeeId,
			OrderStatus status, String datePlaced,
			String dateDispatched, String dateDelivered, int timeToDeliver,
			boolean refundAvailable, PaymentDetails paymentDetails) {
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.status = status;
		this.datePlaced = datePlaced;
		this.dateDispatched = dateDispatched;
		this.dateDelivered = dateDelivered;
		this.timeToDeliver = timeToDeliver;
		this.refundAvailable = refundAvailable;
		this.paymentDetails = paymentDetails;
	}

	public Order(LoginDetails customerId, LoginDetails employeeId, OrderStatus status,
			PaymentDetails paymentDetails) {
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.status = status;
		this.paymentDetails = paymentDetails;
	}
	
	public Order(int orderId, LoginDetails customerID, OrderStatus status,
			PaymentDetails paymentDetails) {
		this.orderId = orderId;
		this.customerId = customerID;
		this.status = status;
		this.paymentDetails = paymentDetails;
	}
	
	public Order(){}

	public LoginDetails getCustomer() {
		return customerId;
	}

	public String getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}

	public int getTimeToDeliver() {
		return timeToDeliver;
	}

	public void setTimeToDeliver(int timeToDeliver) {
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
		return orderId;
	}

	public void setOrderID(int id) {
		orderId = id;
	}

	public OrderStatus getOrderStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public LoginDetails getEmployee() {
		return employeeId;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}
}