package com.netbuilder.entity_managers.interfaces;

import java.util.ArrayList;

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
	public void persistDeliveries(ArrayList<Delivery> deliveries);
	
	//READ
	public Delivery findByDatePlaced(String datePlaced);
	public Delivery findByDeliveryID(int deliveryID);
	public ArrayList<Delivery> getDeliveries();
	
	//UPDATE
	public void updateDelivery(Delivery delivery);
	
	//DELETE
	public void removeDelivery(Delivery delivery);
}