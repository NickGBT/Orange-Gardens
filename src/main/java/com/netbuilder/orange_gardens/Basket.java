package com.netbuilder.orange_gardens;

/**
 * @author llew
 */

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "basket")
public class Basket {
	
	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false)
	@NotNull
	private int customerID;
	
	
	private ArrayList<BasketLine> basketLine;
	

	
	public Basket(int customerID, ArrayList<BasketLine> basketLine) {
		this.customerID = customerID;
		this.basketLine = basketLine;
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
