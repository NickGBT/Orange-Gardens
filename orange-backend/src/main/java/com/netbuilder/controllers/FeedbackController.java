package com.netbuilder.controllers;

import com.netbuilder.util.CustomerFeedback;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class FeedbackController {
	// @Inject
	private CustomerFeedback customerFeedback;
	private String notification;

	/**
	 * User cancels feedback
	 * 
	 * @return go to home page (store front)
	 */
	public String cancel() {
		customerFeedback.setUserFeedback(null);
		return "home";
	}

	/**
	 * User clicks send on feedback screen
	 * 
	 * @param the
	 *            user entry feedback
	 * @return go to home page (store front)
	 */
	public String sendFeedback(String feedback) {
		customerFeedback.setUserFeedback(feedback);
		notification = "Feedback sent, thank you.";
		return "home";
	}

	/**
	 * Get notification message string
	 * 
	 * @return notification message
	 */
	public String getNotification() {
		return notification;
	}
}