package com.netbuilder.orange_gardens;
/**
 * @return Created by Nick Gilbert
 */
public class BasketLine {
		
	private int quantity;
	private boolean porousware;
	private int orderID;
	private int productID;
	
	public BasketLine(){
		
	}
	/**
	 * @param set the quantity
	 */
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity(){
		return quantity;
	}
	/**
	 * @param set the porous ware availability
	 */
	public void setPorousware(boolean pware){
		this.porousware = pware;
	}
	/**
	 * @return the porous ware availability
	 */
	public boolean getPorousware(){
		return porousware;
	}
	/**
	 * @param set the orderID
	 */
	public void setOrderID(int orderID){
		this.orderID = orderID;
	}
	/**
	 * @return the orderID
	 */
	public int getOrderID(){
		return orderID;
	}
	/**
	 * @param set the productID
	 */
	public void setProductID(int productID){
		this.productID = productID;
	}
	/**
	 * @return the productID
	 */
	public int getProductID(){
		return productID;
	}

}
