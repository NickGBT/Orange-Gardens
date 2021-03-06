package com.netbuilder.util;

import java.util.ArrayList;


import com.netbuilder.jms_tools.DopsOrder;
import com.netbuilder.jms_tools.DopsOrderline;
import com.netbuilder.jms_tools.GladosNode;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class OrderData 
{
	private String[] testNames, testQuantities, testBoxes;
	private int xStart, yStart, xGdz, yGdz, productIncrement;
	private int[] xProductLocation, yProductLocation;
	private String employeeUsername, employeePassword;
	private boolean gdz, ordersComplete;
	private ArrayList<GladosNode> path;
	
	
	public OrderData()
	{
		testNames = new String[3];
		testQuantities = new String[3];
		testBoxes = new String[3];
		xProductLocation = new int[3];
		yProductLocation = new int[3];
		xStart = 0; yStart = 0;
		xGdz = 2; yGdz = 18;
		productIncrement = 0;
		ordersComplete = false;
		gdz = false;
		
		testNames[0] = "Garden Light";
		testNames[1] = "Cool Gnome";
		testNames[2] = "Relaxation Chair";
		xProductLocation[0] = 10;
		xProductLocation[1] = 12;
		xProductLocation[2] = 6;
		yProductLocation[0] = 10;
		yProductLocation[1] = 16;
		yProductLocation[2] = 4;
		testQuantities[0] = "3";
		testQuantities[1] = "4";
		testQuantities[2] = "2";
		testBoxes[0] = "B4";
		testBoxes[1] = "B3";
		testBoxes[2] = "B2";
		employeeUsername = "JSmith";
		employeePassword = "password";
	}
	
	public OrderData(DopsOrder dopsObject) { 
		int i = 0;
		testNames = new String[dopsObject.getDopsOrder().size()];
		testQuantities = new String[dopsObject.getDopsOrder().size()];
		testBoxes = new String[dopsObject.getDopsOrder().size()];
		xProductLocation = new int[dopsObject.getDopsOrder().size()];
		yProductLocation = new int[dopsObject.getDopsOrder().size()];
		xStart = 0; yStart = 0;
		xGdz = 2; yGdz = 18;
		productIncrement = 0;
		ordersComplete = false;
		gdz = false;
		
		
		for(DopsOrderline d : dopsObject.getDopsOrder()) {		
			GladosNode productLocation = d.getProductLocation();
			testNames[i] = d.getProductName();
			testQuantities[i] = d.getQuantity();
			testBoxes[i] = d.getBoxSize();
			
			//System.out.println("OrderData::Line77::"+ productLocation.getxPosition() + ":" + productLocation.getyPosition());
			xProductLocation[i] = productLocation.getxPosition();
			//System.out.println("OrderData :: Line79 :: " + d.getProductName() + " :: Location is " + productLocation.getxPosition() + ":" + productLocation.getyPosition());
			yProductLocation[i] = productLocation.getyPosition();
			i++;		
		}
		
	}
	
	public int getxGdz()
	{
		return xGdz;
	}

	public void setxGdz(int xGdz)
	{
		this.xGdz = xGdz;
	}

	public int getyGdz()
	{
		return yGdz;
	}

	public void setyGdz(int yGdz)
	{
		this.yGdz = yGdz;
	}

	public String getEmployeeUsername()
{
		return employeeUsername;
	}

	public void setEmployeeUsername(String employeeUsername) 
	{
		this.employeeUsername = employeeUsername;
	}

	public String getEmployeePassword()
	{
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword)
	{
		this.employeePassword = employeePassword;
	}

	public int getxStart()
	{
		return xStart;
	}

	public void setxStart(int xStart)
	{
		this.xStart = xStart;
	}

	public int getyStart() 
	{
		return yStart;
	}

	public void setyStart(int yStart) 
	{
		this.yStart = yStart;
	}

	public int[] getxProductLocation()
	{
		return xProductLocation;
	}

	public void setxProductLocation(int[] xProductLocation)
	{
		this.xProductLocation = xProductLocation;
	}

	public int[] getyProductLocation()
	{
		return yProductLocation;
	}

	public void setyProductLocation(int[] yProductLocation)
	{
		this.yProductLocation = yProductLocation;
	}

	public String[] getTestNames()
	{
		return testNames;
	}
	
	public void setTestNames(String[] testNames)
	{
		this.testNames = testNames;
	}
	
	public String[] getTestQuantities() 
	{
		return testQuantities;
	}
	
	public void setTestQuantities(String[] testQuantities) 
	{
		this.testQuantities = testQuantities;
	}
	
	public String[] getTestBoxes() 
	{
		return testBoxes;
	}
	
	public void setTestBoxes(String[] testBoxes) 
	{
		this.testBoxes = testBoxes;
	}

	
	public int getProductIncrement() 
	{
		return productIncrement;
	}

	
	public void setProductIncrement(int productIncrement) 
	{
		this.productIncrement = productIncrement;
	}

	
	public boolean isOrdersComplete()
	{
		return ordersComplete;
	}

	
	public void setOrdersComplete(boolean ordersComplete) 
	{
		this.ordersComplete = ordersComplete;
	}

	
	public boolean isGdz() 
	{
		return gdz;
	}

	
	public void setGdz(boolean gdz)
	{
		this.gdz = gdz;
	}
}