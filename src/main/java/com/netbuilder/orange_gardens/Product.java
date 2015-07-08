package com.netbuilder.orange_gardens;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * 
 * 
 * @author mwatson
 *
 */

@Entity
@Table(name = "product")

public class Product {

	@Column(name = "image_location", nullable = true, length = 100)
	@Null
	@Size(min = 1, max = 100)
	private String imageLocation;

	@Id
	@Column(name = "product_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int productId;

	@Column(name = "product_name", nullable = false, length = 45)
	@NotNull
	@Size(min = 4, max = 45)
	private String productName;

	@Column(name = "product_price", nullable = false)
	@NotNull
	private double productPrice;

	@Column(name = "width", nullable = false)
	@NotNull
	private int width;

	@Column(name = "height", nullable = false)
	@NotNull
	private int height;

	@Column(name = "length", nullable = false)
	@NotNull
	private int length;

	@Column(name = "weight", nullable = false)
	@NotNull
	private double weight;

	@Column(name = "description", nullable = false, length = 1000)
	@NotNull
	@Size(min = 20, max = 1000)
	private String description;

	public Product(String imageLocation, int productId, String productName, double productPrice, int width, int height,
			int length, double weight, String description) {
		this.imageLocation = imageLocation;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.width = width;
		this.height = height;
		this.length = length;
		this.weight = weight;
		this.description = description;
	}

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

}
