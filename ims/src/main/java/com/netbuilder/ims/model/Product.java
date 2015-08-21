package com.netbuilder.ims.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/*
 *This class hold product attributes, values are taken from the
 *database, initially the threshold is set to 20 for each product 
 */

public class Product {
	private String productName;
	private double productPrice;
	private String imageLocation, description, category;
	private int length, width, height, weight;
	private String productId;
	private int productQuantity;
	private int orderThreshold;
	private Random rand;
	private boolean orderRequired;
	private String lastUpdated;
	private DateFormat dateFormat;
	private Date date;
	private ArrayList<Number> stockHistory; 
	
	public Product(){
		stockHistory = new ArrayList<Number>();
		rand = new Random();
		productName = "Gnome" + rand.nextInt(1000);
		productQuantity = rand.nextInt(100);

	}
	
	public Product(String productId, String productName, double productPrice, String imageLocation, String description, int length, int width, int height, int weight, String category, int productQuantity){		
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.imageLocation = imageLocation;
		this.description = description;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.category = category;
		this.productQuantity = productQuantity;
		this.orderThreshold = 20;
		
		rand = new Random();
		stockHistory = new ArrayList<Number>();
		for(int i = 0 ; i < 7 ; i++){
			stockHistory.add(rand.nextInt(100));
		}
	}
	
	public String getProductName(){
		return productName;
	}
	
	public int getProductQuantity(){
		return productQuantity;	
	}
	
	public int getOrderThreshold(){
		return orderThreshold;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}
	
	public void setProductQuantity(int productQuantity){
		this.productQuantity = productQuantity;
	}
	
	public void setOrderThreshold(int thres){
		this.orderThreshold = thres;
	}
	
	public void setOrderRequired(boolean orderReq){
		this.orderRequired = orderReq;
	}
	
	public boolean getOrderRequired(){
		return orderRequired;
	}
	
	public void setLastUpdated(){
		dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		date = new Date();
		this.lastUpdated = dateFormat.format(date);	
	}

	public String getLastUpdated(){
		return lastUpdated;
	}
	
	public ArrayList<Number> getStockHistory(){
		return stockHistory;
	}

	public String getProductID() {
		return productId;
	}

	public void setProductID(String productId) {
		this.productId = productId;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
