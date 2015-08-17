package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import javax.faces.bean.RequestScoped;

import com.netbuilder.entities.DeliveryLine;

/**
 * 
 * @author llew
 *
 */
@RequestScoped
public interface DeliveryLineManager {

	// CREATE
	public void persistDeliveryLine(DeliveryLine deliveryLine);

	public void persistDeliveryLine(List<DeliveryLine> deliveryLines);

	// READ
	public DeliveryLine findByProductId(int productId);

	public DeliveryLine findByDeliveryId(int deliveryId);

	public List<DeliveryLine> findByQuantity(int quantity);

	public List<DeliveryLine> getDeliveryLine();

	// UPDATE
	public void updateDeliveryLine(DeliveryLine deliveryLine);

	// DELETE
	public void removeDeliveryLine(DeliveryLine deliveryLine);
}
