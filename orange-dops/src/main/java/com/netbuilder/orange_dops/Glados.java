package com.netbuilder.orange_dops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.jms.JMSException;

import com.netbuilder.jms.Receiver;
import com.netbuilder.util.MessageHandler;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class Glados {
	private static final Logger logger = LogManager.getLogger();
	private static GladosGui gladosGui = new GladosGui();
	private static Receiver receiver ;
	private static MessageHandler messageHandler;

	/**
	 * Main entry point for program - loads splash screen
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("GLADOS startup");
		System.out.println("GLADOS startup...");
		gladosGui.displaySplash();
		
//		try {
//			receiver = new Receiver("127.0.0.1");
//		} catch (JMSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		messageHandler = new MessageHandler();
//		
//		try {
//			receiver.listenOnQueue("dops_queue", messageHandler);
//			logger.info("Message received from broker.");
//		} catch (JMSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}