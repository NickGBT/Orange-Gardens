package com.netbuilder.ims.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/*
 * This class contains methods to connect, add, update, delete
 * in the database.
 */

public class DatabaseConnection {
	
	private Random rnd;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";//"jdbc:mysql://10.50.15.12/IMS";
	static final String USER = "root";//"root";
	static final String PASS = "root";//"root";
	
	private ArrayList<Integer> productID;
	private ArrayList<String> productName;
	private ArrayList<Integer> productQuantity;
	private Statement stmt;
	private Connection conn;
	
	public DatabaseConnection(){
		productID = new ArrayList<Integer>();
		productName = new ArrayList<String>();
		productQuantity = new ArrayList<Integer>();
		
		rnd = new Random();
	}
	
	public void accessDB(){ 
		
		
		conn = null;
		stmt = null;
		
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to db");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void closeDB(){
		try{
			if(stmt != null)
				conn.close();
		}catch(SQLException se){
				se.printStackTrace();
			}
		try{
			if (conn != null)
				conn.close();		
			System.out.println("DB connection closed");
		}catch(SQLException se){
			se.printStackTrace();			
			}
		
		
	}

	
	public void readDB(){
		System.out.println("Creating statement...");
		try {
			stmt = conn.createStatement();
			String sql = "SELECT product_id, product_name FROM product";
			String sql2 = "SELECT stock_level, product_id FROM stock";
			ResultSet rs = stmt.executeQuery(sql);
			int i = 0;
			while(rs.next()){
				productID.add(rs.getInt("product_id"));
				productName.add(rs.getString("product_name"));
				i++;
			}
			rs.close();
			rs = stmt.executeQuery(sql2);
			i = 0;
			while(rs.next()){
				if (rs.getInt("product_id") == productID.get(i))
				{
					productQuantity.add(rs.getInt("stock_level"));
				}
				System.out.println(productID.get(i) + " " + 
				productName.get(i) + " " + productQuantity.get(i));
				i++;
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDB(int productID, int productQuantity){
		System.out.println("Updating quantity...");
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE stock " + "SET stock_level = " + productQuantity + "  WHERE product_id = " + productID ;
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertToDb(String productName, double productPrice, String imageLocation, String description, int length, int width, int height, int weight, String category, int productQuantity){
		System.out.println("Inserting tables...");
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO product (product_name, product_price, image_location, description, length, width, height, weight, product_category) VALUES ('" + productName +"', " + productPrice + ", '" + imageLocation + "', '" + description + "', " + length + ", " + width + ", " + height + ", " + weight + ", '" + category + "')";
			String sql2 = "INSERT INTO stock (stock_level, stock_available, critical_stock, required_stock, maximum_stock, location, product_id) VALUES (" + productQuantity + ", 50, 10, 50, 100, 'In the warehouse', (SELECT product_id from product WHERE product_name='" + productName + "'))";
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteRow(){
		System.out.println("Deleting from db...");
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM product " + "WHERE ProductID = 30";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Integer> getProductIDs(){
		return productID;
	}
	
	public ArrayList<String> getProductNames(){
		return productName;
	}
	
	public ArrayList<Integer> getProductQuantities(){
		return productQuantity;
	}
	
}
