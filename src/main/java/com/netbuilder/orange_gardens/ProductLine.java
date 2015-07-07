package com.netbuilder.orange_gardens;

public class ProductLine {
	
	private int quantity;
	private boolean porousware;
	private int orderID;
	private int productID;
	
	public ProductLine(){
		
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public void setPorousware(boolean pware){
		this.porousware = pware;
	}
	
	public boolean getPorousware(){
		return porousware;
	}
	
	public void setOrderID(int orderID){
		this.orderID = orderID;
	}
	
	public int getOrderID(){
		return orderID;
	}
	
	public void setProductID(int productID){
		this.productID = productID;
	}
	
	public int getProductID(){
		return productID;
	}

}
