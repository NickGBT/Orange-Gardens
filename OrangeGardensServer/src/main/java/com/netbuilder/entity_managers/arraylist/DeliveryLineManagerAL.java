package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.DeliveryLine;
import com.netbuilder.entity_managers.interfaces.DeliveryLineManager;

/**
 * 
 * @author llew
 *
 */

@Alternative
public class DeliveryLineManagerAL implements DeliveryLineManager{

	private ArrayList<DeliveryLine> deliveryLines = new ArrayList<DeliveryLine>();
	
	public void persistDeliveryLine(DeliveryLine deliveryLine) {
		deliveryLines.add(deliveryLine);
		
	}

	public void persistDeliveryLine(List<DeliveryLine> deliveryLines) {
		this.deliveryLines.addAll(deliveryLines);
		
	}

	public DeliveryLine findByProductId(int productId) {
		for (DeliveryLine dl : deliveryLines){		
			if(dl.getProduct().getProductId() == productId){
				return dl;
			}
		}
		return null;
	}

	public DeliveryLine findByDeliveryId(int deliveryId) {
		for (DeliveryLine dl : deliveryLines){		
			if(dl.getDelivery().getDeliveryId() == deliveryId){
				return dl;
			}
		}
		return null;
	}

	public List<DeliveryLine> findByQuantity(int quantity) {
		List<DeliveryLine> dLines = new ArrayList<DeliveryLine>();
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

	public List<DeliveryLine> getDeliveryLine() {
		return deliveryLines;
	}

	public void updateDeliveryLine(DeliveryLine deliveryLine) {
		for(DeliveryLine dl : deliveryLines){
			if(dl.getDelivery().getDeliveryId() == deliveryLine.getDelivery().getDeliveryId()){
				deliveryLines.set(deliveryLines.indexOf(dl), deliveryLine);
			}
		}
		
	}

	public void removeDeliveryLine(DeliveryLine deliveryLine) {
		for(DeliveryLine dl : deliveryLines){
			if(dl.getDelivery().getDeliveryId() == deliveryLine.getDelivery().getDeliveryId()){
				deliveryLines.remove(deliveryLines.indexOf(dl));
			}
		}
		
		
	}

}
