package com.netbuilder.entity_managers;

import java.util.ArrayList;
import com.netbuilder.entities.Basket;

/**
 * 
 * @author llew
 *
 */

public interface BasketManager {

	//CREATE
	public void persistBasket(Basket basket);
	public void persistBasket(ArrayList<Basket> baskets);
	
	//READ
	public Basket findByCustomerID(int customerID);
	public Basket getBasket();
	
	//UPDATE
	public void updateBasket(Basket basket);
	
	//DELETE
	public void removeBasket(Basket basket);
}
