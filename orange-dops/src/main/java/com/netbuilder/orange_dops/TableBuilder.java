package com.netbuilder.orange_dops;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;


/**
 * 
 * @author JustinMabbutt
 *
 */

public class TableBuilder
{
	private static final Logger logger = Logger.getLogger(TableBuilder.class.getName());
	
	/**
	 * @author JustinMabbutt
	 * Build table model from result set
	 * @param rs the result set of the query
	 * @return the table model for use in the GUI
	 */
	public DefaultTableModel buildTableModel(ResultSet rs)
	{
		logger.entering(getClass().getName(), "buildTableModel");
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<String> columnNames = new Vector<String>();	
		try 
		{
			ResultSetMetaData metaData = rs.getMetaData();			
			
			int columnCount = metaData.getColumnCount();
			for(int column = 1; column <= columnCount; column++)
			{
				columnNames.add(metaData.getColumnName(column));
			}		
			while(rs.next())
			{
				Vector<Object> vector = new Vector<Object>();
				for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++)
				{
					vector.add(rs.getObject(columnIndex));
				}
				data.add(vector);
			}
		}
		catch (SQLException se) 
		{
			logger.log(Level.SEVERE, se.getMessage(), se);
		}
		logger.exiting(getClass().getName(), "buildTableModel");
		return new DefaultTableModel(data, columnNames);
	}
}