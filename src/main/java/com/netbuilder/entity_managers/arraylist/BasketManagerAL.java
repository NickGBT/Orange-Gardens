package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import com.netbuilder.entities.Basket;
import com.netbuilder.entities.Customer;
import com.netbuilder.entity_managers.interfaces.BasketManager;

/**
 * 
 * @author llew
 *
 */

public class BasketManagerAL implements BasketManager{

	private ArrayList<Basket> baskets = new ArrayList<Basket>();
	
	public void persistBasket(Basket basket) {
		baskets.add(basket);
		
	}

	public void persistBasket(ArrayList<Basket> baskets) {
		this.baskets.addAll(baskets);
		
	}

	public Basket findByCustomerID(Customer customerID) {
		for(Basket b: baskets){
			  if(b.equals(customerID.getCustomerID())){
				  return b;
			  }
		}
		return null;
	}

	public ArrayList<Basket> getBasket() {
		return baskets;
	}

	public void updateBasket(Basket basket) {
		for(Basket b: baskets){
			if(b.getCustomer().getCustomerID() == basket.getCustomer().getCustomerID()){
				baskets.set(baskets.indexOf(b), basket);
			}
		}
		
	}

	public void removeBasket(Basket basket) {
		for(Basket b: baskets){
			if(b.getCustomer().getCustomerID() == basket.getCustomer().getCustomerID()){
				baskets.remove(baskets.indexOf(b));
			}
		}
		
	}

}
