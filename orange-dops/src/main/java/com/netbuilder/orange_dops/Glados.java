package com.netbuilder.orange_dops;

import java.util.logging.Logger;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class Glados 
{
	private static final Logger logger = Logger.getLogger(Glados.class.getName());
	private static GladosGui gladosGui = new GladosGui();
	
	/**
     * Main entry point for program - loads splash screen
     * @param args
     */
    public static void main(String[] args)
    {
    	logger.entering(Glados.class.getName(), "main");
    	System.out.println("GLADOS startup..."); 
    	gladosGui.displaySplash();
    	logger.exiting(Glados.class.getName(), "main");
    }
}