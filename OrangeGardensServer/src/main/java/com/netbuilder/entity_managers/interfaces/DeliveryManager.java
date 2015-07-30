package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import com.netbuilder.entities.Delivery;

/**
 * 
 * @author JustinMabbutt
 *
 */

public interface DeliveryManager 
{
	//CREATE
	public void persistDelivery(Delivery delivery);
	public void persistDeliveries(List<Delivery> deliveries);
	
	//READ
	public List<Delivery> findByDatePlaced(String datePlaced);
	public Delivery findByDeliveryId(int deliveryId);
	public List<Delivery> getDeliveries();
	
	//UPDATE
	public void updateDelivery(Delivery delivery);
	
	//DELETE
	public void removeDelivery(Delivery delivery);
}