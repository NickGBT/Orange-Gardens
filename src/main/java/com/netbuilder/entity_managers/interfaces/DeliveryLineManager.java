package com.netbuilder.entity_managers.interfaces;

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

	public ArrayList<DeliveryLine> findByQuantity(int quantity);

	public ArrayList<DeliveryLine> getDeliveryLine();

	// UPDATE
	public void updateDeliveryLine(DeliveryLine deliveryLine);

	// DELETE
	public void removeDeliveryLine(DeliveryLine deliveryLine);
}
