package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author jtaylor
 *
 */

@Entity
@Table (name = "Box")
public class Box 
{
	@Column(name = "box_type", nullable = false)
	@NotNull
	private String boxType;
	
	@Column (name = "box_length", nullable = false)
	@NotNull	
	private float boxLength;
	
	@Column (name = "box_width", nullable = false)
	@NotNull	
	private float boxWidth;
	
	@Column (name = "box_height", nullable = false)
	@NotNull	
	private float boxHeight;
}
