package com.netbuilder.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;

/**
 * 
 * @author Alexander Neil
 *
 */
@Stateless
public class OrderLogWriter {

	@Inject
	OrderLineManager orderLineManager;
	
	private static final Logger logger = LogManager.getLogger();
	private static final Marker PRODUCT_MARKER = MarkerManager.getMarker("PRODUCT");

	
	public String logOrder(Order order){
		
		List<OrderLine> lines = orderLineManager.findByOrderId(order.getOrderId());
		
		for(OrderLine oL: lines){
			
			logger.log(Level.OFF, PRODUCT_MARKER, logLine(oL));
		}
		
		return null;
	}
	
	public String logLine(OrderLine oLine){
		Map<String,String> details = new HashMap<String,String>();
		
		details.put("productId", oLine.getProduct().getProductId() + "");
		details.put("productName", oLine.getProduct().getProductName());
		details.put("quantity", oLine.getQuantity() + "");
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonDetails = "";
		
		try {
			jsonDetails = mapper.writeValueAsString(details);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonDetails;
	}
}
