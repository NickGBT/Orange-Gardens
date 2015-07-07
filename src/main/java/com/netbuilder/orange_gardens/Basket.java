package com.netbuilder.orange_gardens;

import java.util.ArrayList;

public class Basket {
	
	private int customerID;
	private ArrayList<Product> product;
	
	public Basket(){
		product = new ArrayList<Product>();
	}
	
	public int getCustomerID(){
		return customerID;
	}
	
	public void setCustomerID(int customerID){
		this.customerID = customerID;
	}
	
	public Product getProducts(){
		return product;
	}
	
	public void setProducts(Product product){
		this.product = product;
	}
	
	

}
