package com.netbuilder.orange_gardens;

/**
 * @author llew
 */

import java.util.ArrayList;

public class Basket {
	
	private int customerID;
	private ArrayList<BasketLine> basketLine;
	
	public Basket(){
		basketLine = new ArrayList<BasketLine>();
	}
	
	public int getCustomerID(){
		return customerID;
	}
	
	public void setCustomerID(int customerID){
		this.customerID = customerID;
	}
	
	public ArrayList<BasketLine> getProducts(){
		return basketLine;
	}
	
	public void setProducts(ArrayList<BasketLine> product){
		this.basketLine = product;
	}
	
	

}
