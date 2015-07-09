package com.netbuilder.entity_managers;

import java.util.ArrayList;
import com.netbuilder.entities.BasketLine;

/**
 * @author ngilbert
 */

public interface BasketLineManager {

	// CREATE
	public void persistBasketLine(BasketLine basketLine);

	public void persistBasket(ArrayList<BasketLine> basketLines);

	// READ
	public BasketLine findByCustomerID(int customerID);

	public BasketLine getBasketLine();

	// UPDATE
	public void updateBasket(BasketLine basketLine);

	// DELETE
	public void removeBasket(BasketLine basketLine);
}
