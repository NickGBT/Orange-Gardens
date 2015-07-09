package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import com.netbuilder.entities.DeliveryLine;
import com.netbuilder.entity_managers.interfaces.DeliveryLineManager;

/**
 * 
 * @author llew
 *
 */

public class DeliveryLineManagerAL implements DeliveryLineManager{

	private ArrayList<DeliveryLine> deliveryLines = new ArrayList<DeliveryLine>();
	
	public void persistDeliveryLine(DeliveryLine deliveryLine) {
		deliveryLines.add(deliveryLine);
		
	}

	public void persistDeliveryLine(ArrayList<DeliveryLine> deliveryLines) {
		this.deliveryLines.addAll(deliveryLines);
		
	}

	public DeliveryLine findByProductID(int productID) {
		for (DeliveryLine dl : deliveryLines){		
			if(dl.getProduct().getProductId() == productID){
				return dl;
			}
		}
		return null;
	}

	public DeliveryLine findByDeliveryID(int deliveryID) {
		for (DeliveryLine dl : deliveryLines){		
			if(dl.getDelivery().getDeliveryID() == deliveryID){
				return dl;
			}
		}
		return null;
	}

	public ArrayList<DeliveryLine> findByQuantity(int quantity) {
		ArrayList<DeliveryLine> dLines = new ArrayList<DeliveryLine>();
		for (DeliveryLine dl : deliveryLines){		
			if(dl.getQuantity() == quantity){
				dLines.add(dl);
			}
		}
		if (dLines.isEmpty())
			return null;
		else
			return dLines;
					
		
	}

	public ArrayList<DeliveryLine> getDeliveryLine() {
		return deliveryLines;
	}

	public void updateDeliveryLine(DeliveryLine deliveryLine) {
		for(DeliveryLine dl : deliveryLines){
			if(dl.getDelivery().getDeliveryID() == deliveryLine.getDelivery().getDeliveryID()){
				deliveryLines.set(deliveryLines.indexOf(dl), deliveryLine);
			}
		}
		
	}

	public void removeDeliveryLine(DeliveryLine deliveryLine) {
		for(DeliveryLine dl : deliveryLines){
			if(dl.getDelivery().getDeliveryID() == deliveryLine.getDelivery().getDeliveryID()){
				deliveryLines.remove(deliveryLines.indexOf(dl));
			}
		}
		
		
	}

}
