package com.netbuilder.util;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;

@Entity
public class serObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int height;
	private int width;
	
	public serObject() {
		this.height = 5;
		this.width = 5;
	}
	
	public serObject(int height, int width) {
		this.height = height;
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	
	
	
}
