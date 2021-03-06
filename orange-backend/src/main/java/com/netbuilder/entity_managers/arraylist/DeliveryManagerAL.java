package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.Delivery;
import com.netbuilder.entity_managers.interfaces.DeliveryManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Alternative
public class DeliveryManagerAL implements DeliveryManager {
	private ArrayList<Delivery> deliveries = new ArrayList<Delivery>();

	public void persistDelivery(Delivery delivery) {
		deliveries.add(delivery);
	}

	public void persistDeliveries(List<Delivery> deliveries) {
		this.deliveries.addAll(deliveries);
	}

	public List<Delivery> findByDatePlaced(String datePlaced) {
		List<Delivery> results = new ArrayList<Delivery>();
		for (Delivery d : deliveries) {
			if (d.getDatePlaced().contains(datePlaced)) {
				results.add(d);
			}
		}
		if (results.isEmpty()) {
			return null;
		} else {
			return results;
		}
	}

	public Delivery findByDeliveryId(int deliveryId) {
		for (Delivery d : deliveries) {
			if (d.getDeliveryId() == deliveryId) {
				return d;
			}
		}
		return null;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void updateDelivery(Delivery delivery) {
		for (Delivery d : deliveries) {
			if (d.getDeliveryId() == delivery.getDeliveryId()) {
				deliveries.set(deliveries.indexOf(d), delivery);
			}
		}
	}

	public void removeDelivery(Delivery delivery) {
		deliveries.remove(delivery);
	}
}