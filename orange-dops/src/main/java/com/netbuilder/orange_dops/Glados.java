package com.netbuilder.orange_dops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class Glados
{
	private static final Logger logger = LogManager.getLogger();
	private static GladosGui gladosGui = new GladosGui();

	/**
	 * Main entry point for program - loads splash screen
	 * @param args
	 */
	public static void main(String[] args) 
	{
		logger.info("GLADOS startup...");
		gladosGui.displaySplash();
	}
}