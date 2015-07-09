package com.netbuilder.entity_managers;

import java.util.ArrayList;

import com.netbuilder.entities.DeliveryLine;

/**
 * 
 * @author llew
 *
 */

public interface DeliveryLineManager {

	// CREATE
	public void persistDeliveryLine(DeliveryLine deliveryLine);

	public void persistDeliveryLine(ArrayList<DeliveryLine> deliveryLines);

	// READ
	public DeliveryLine findByProductID(int productID);
	public DeliveryLine findByDeliveryID(int deliveryID);
	public DeliveryLine findByQuantity(int quantity);

	public ArrayList<DeliveryLine> getDeliveryLine();

	// UPDATE
	public void updateDeliveryLine(DeliveryLine deliveryLines);

	// DELETE
	public void removeDeliveryLine(DeliveryLine deliveryLines);
}
