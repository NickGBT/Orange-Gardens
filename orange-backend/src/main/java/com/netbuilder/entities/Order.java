package com.netbuilder.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.netbuilder.enums.OrderStatus;

/**
 * @author llew
 */

@Entity
@Table(name = "Order")
@NamedQueries({
		@NamedQuery(name = Order.FIND_BY_ORDER_ID, query = "SELECT o FROM Order o WHERE o.orderId = :order_id"),
		@NamedQuery(name = Order.FIND_BY_STATUS_AND_ID, query = "SELECT o FROM Order o WHERE o.status = :status AND o.customerId = :customerId"),
		@NamedQuery(name = Order.FIND_BY_DATE_DISPATCHED, query = "SELECT o FROM Order o WHERE o.dateDispatched = :date_dispatched"),
		@NamedQuery(name = Order.FIND_BY_DATE_PLACED, query = "SELECT o FROM Order o WHERE o.datePlaced = :date_placed"),
		@NamedQuery(name = Order.FIND_BY_DATE_DELIVERED, query = "SELECT o FROM Order o WHERE o.dateDelivered = :date_delivered"),
		@NamedQuery(name = Order.FIND_BY_TWO_DATES_PLACED, query = "SELECT o FROM Order o WHERE o.datePlaced BETWEEN :fDate AND :sDate"),
		@NamedQuery(name = Order.FIND_BY_TWO_DATES_DISPATCHED, query = "SELECT o FROM Order o WHERE o.dateDispatched BETWEEN :fDate AND :sDate"),
		@NamedQuery(name = Order.FIND_BY_TWO_DATES_DELIVERED, query = "SELECT o FROM Order o WHERE o.dateDelivered BETWEEN :fDate AND :sDate"),
		@NamedQuery(name = Order.FIND_BY_CUSTOMER_ID, query = "SELECT o FROM Order o WHERE o.customerId = :customer_id"),
		@NamedQuery(name = Order.FIND_BY_EMPLOYEE_ID, query = "SELECT o FROM Order o WHERE o.employeeId = :employee_id"),
		@NamedQuery(name = Order.GET_ALL, query = "SELECT o FROM Order o"),
		@NamedQuery(name = Order.FIND_BY_STATUS, query = "SELECT o FROM Order o WHERE o.status = :status")})
public class Order implements Serializable {
	
	public static final String FIND_BY_ORDER_ID = "Order.findByOrderId";
	public static final String FIND_BY_STATUS_AND_ID = "Order.findByStatusAndId";
	public static final String FIND_BY_STATUS = "Order.findByStatus";
	public static final String FIND_BY_DATE_DISPATCHED = "Order.findByDateDispatched";
	public static final String FIND_BY_DATE_PLACED = "Order.findByDatePlaced";
	public static final String FIND_BY_DATE_DELIVERED = "Order.findByDateDelivered";
	public static final String FIND_BY_TWO_DATES_PLACED = "Order.findByTwoDatesOrderPlaced";
	public static final String FIND_BY_TWO_DATES_DISPATCHED = "Order.findByTwoDatesOrderDispatched";
	public static final String FIND_BY_TWO_DATES_DELIVERED = "Order.findByTwoDatesOrderDelivered";
	public static final String FIND_BY_CUSTOMER_ID = "Order.findByCustomerId";
	public static final String FIND_BY_EMPLOYEE_ID = "Order.findByEmployeeId";
	public static final String GET_ALL = "Order.getAllOrders";

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