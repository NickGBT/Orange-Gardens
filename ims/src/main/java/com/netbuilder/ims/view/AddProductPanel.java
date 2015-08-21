package com.netbuilder.ims.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 *This panel sets the layout in the Add Product window. 
 */

public class AddProductPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTextField productId, productName, productPrice, imageLocation, description, length, weight, productQuantity, tempHeight, tempWidth;
	private String selectedCategory;
	private JLabel name, price, location, pdescription, plength, pwidth, pheight, pweight, pcategory, quantity;
	private JButton addProduct, cancel;
	int selectionInteger;
	
	public AddProductPanel(){
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		name = new JLabel("Product Name : ");
		c.gridx = 0;
		c.gridy = 1;
		this.add(name, c);
		
		productName = new JTextField(20);
		c.gridx = 1;
		c.gridy = 1;
		this.add(productName, c);
		
		location = new JLabel("Image Location : ");
		c.gridx = 0;
		c.gridy = 2;
		this.add(location, c);
		
		imageLocation = new JTextField(20);
		c.gridx = 1;
		c.gridy = 2;
		this.add(imageLocation, c);
		
		pdescription = new JLabel("Description : ");
		c.gridx = 0;
		c.gridy = 3;
		this.add(pdescription, c);
		
		description = new JTextField(40);
		c.gridx = 1;
		c.gridy = 3;
		this.add(description, c);
		
		plength = new JLabel("Length : ");
		c.gridx = 0;
		c.gridy = 4;
		this.add(plength, c);
		
		length = new JTextField(5);
		c.gridx = 1;
		c.gridy = 4;
		this.add(length, c);
		
		pwidth = new JLabel("Width : ");
		c.gridx = 0;
		c.gridy = 5;
		this.add(pwidth, c);
		
		tempWidth = new JTextField(5);
		c.gridx = 1;
		c.gridy = 5;
		this.add(tempWidth, c);
		
		pheight = new JLabel("Height : ");
		c.gridx = 0;
		c.gridy = 6;
		this.add(pheight, c);
		
		tempHeight = new JTextField(5);
		c.gridx = 1;
		c.gridy = 6;
		this.add(tempHeight, c);
		
		pweight = new JLabel("Weight : ");
		c.gridx = 0;
		c.gridy = 7;
		this.add(pweight, c);
		
		weight = new JTextField(5);
		c.gridx = 1;
		c.gridy = 7;
		this.add(weight, c);
		
		pcategory = new JLabel("Category : ");
		c.gridx = 0;
		c.gridy = 8;
		this.add(pcategory, c);
		
		String[] categoryStrings = {"Choose Category" ,"Accessory", "Gnome", "Tool", "Furniture", "Building"};

		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox categoryList = new JComboBox(categoryStrings);
		categoryList.setSelectedIndex(0);
		c.gridx = 1;
		c.gridy = 8;
		categoryList.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	JComboBox cb = (JComboBox)e.getSource();
                selectedCategory = (String)cb.getSelectedItem();
                setSelectionInteger(cb.getSelectedIndex());
            }
        });  
		this.add(categoryList, c);
		
		price = new JLabel("Product Price : ");
		c.gridx = 0;
		c.gridy = 9;
		this.add(price, c);
		
		productPrice = new JTextField(10);
		c.gridx = 1;
		c.gridy = 9;
		this.add(productPrice, c);
		
		quantity = new JLabel("Product Quantity : ");
		c.gridx = 0;
		c.gridy = 10;
		this.add(quantity, c);
		
		productQuantity = new JTextField(5);
		c.gridx = 1;
		c.gridy = 10;
		this.add(productQuantity, c);
		
		addProduct = new JButton("Add Product");
		c.insets = new Insets(10,10,10,10);
		c.gridx = 1;
		c.gridy = 11;
		this.add(addProduct, c);
		
		cancel = new JButton("Close");
		c.gridx = 2;
		c.gridy = 11;
		this.add(cancel, c);
		
	}
	
	public void addProductListener(ActionListener al){
			addProduct.addActionListener(al);
	}
	
	public void addCancelListener(ActionListener al){
		cancel.addActionListener(al);
	}
	
	public String getProductName(){
		return productName.getText();
	}
	
	public int getProductQuantity(){
		return Integer.parseInt(productQuantity.getText());
	}
	
	public String getSelectedCategory(){
		return selectedCategory;
	}
	
	public Double getProductPrice() {
		return Double.parseDouble(productPrice.getText());
	}

	public String getImageLocation() {
		return imageLocation.getText();
	}

	public String getDescription() {
		return description.getText();
	}

	public int getLength() {
		return Integer.parseInt(length.getText());
	}

	public int getWeight() {
		return Integer.parseInt(weight.getText());
	}
	
	public String getProductId() {
		return productId.getText();
	}

//	public int getWidth() {
//		return Integer.parseInt(width.getText());
//	}
//
//	public int getHeight() {
//		return Integer.parseInt(height.getText());
//	}
	
	public int getTempWidth(){
		return Integer.parseInt(tempWidth.getText());
	}
	
	public int getTempHeight(){
		return Integer.parseInt(tempHeight.getText());
	}

	public int getSelectionInteger() {
		return selectionInteger;
	}

	public void setSelectionInteger(int selectionInteger) {
		this.selectionInteger = selectionInteger;
	}
}
