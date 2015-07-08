package com.netbuilder.orange_gardens;

public class Order {
	
	/**
	 * @author llew
	 */
	
	private int customerID;
	private enum status{
		
	};
	private String datePlaced;
	private String timeToDeliver;
	private boolean refundAvaiable;
	private String dateDispatched;
	private String dateDelivered;
	private int orderID;
	
	public Order(){
		
	}
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	
	
}
