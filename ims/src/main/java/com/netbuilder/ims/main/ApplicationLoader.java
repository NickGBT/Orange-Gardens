package com.netbuilder.ims.main;

import com.netbuilder.ims.controller.StockManagerController;
import com.netbuilder.ims.model.StockManager;
import com.netbuilder.ims.view.StockManagerFrame;


/*
 *Main class sets up the view and model, then sends the references to 
 *the controller.
 */
public class ApplicationLoader {

	public static void main(String[] args) {
		System.out.println("Hello");
		StockManagerFrame view = new StockManagerFrame();
		
		StockManager model = new StockManager();
		
		StockManagerController controller = new StockManagerController(model, view);
	}
}