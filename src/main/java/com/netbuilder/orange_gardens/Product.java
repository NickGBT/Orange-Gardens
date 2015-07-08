package com.netbuilder.orange_gardens;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * 
 * @author mwatson
 *
 */

public class Product {



	public Product(String imageLocation, int productId, String productName, double productPrice,
			Boolean isPorouswareable, int width, int height, int length, double weight, String description,
			double porouswarePrice) {
		this.imageLocation = imageLocation;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.isPorouswareable = isPorouswareable;
		this.width = width;
		this.height = height;
		this.length = length;
		this.weight = weight;
		this.description = description;
		this.porouswarePrice = porouswarePrice;
	}

	@Column(name = "image_location", nullable = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String imageLocation;
	
	
	private int productId;
	private String productName;
	private double productPrice;
	private Boolean isPorouswareable;
	private int width;
	private int height;
	private int length;
	private double weight;
	private String description;
	private double porouswarePrice;

	/**
	 * @return the imageLocation
	 */
	public String getImageLocation() {
		return imageLocation;
	}

	/**
	 * @param imageLocation
	 *            the imageLocation to set
	 */
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 *            the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the isPorouswareable
	 */
	public Boolean getIsPorouswareable() {
		return isPorouswareable;
	}

	/**
	 * @param isPorouswareable
	 *            the isPorouswareable to set
	 */
	public void setIsPorouswareable(Boolean isPorouswareable) {
		this.isPorouswareable = isPorouswareable;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the porouswarePrice
	 */
	public double getPorouswarePrice() {
		return porouswarePrice;
	}

	/**
	 * @param porouswarePrice
	 *            the porouswarePrice to set
	 */
	public void setPorouswarePrice(double porouswarePrice) {
		this.porouswarePrice = porouswarePrice;
	}

}
