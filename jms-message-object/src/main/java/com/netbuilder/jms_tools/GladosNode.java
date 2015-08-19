package com.netbuilder.jms_tools;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class GladosNode extends Node {
	private static final long serialVersionUID = 275286839230750238L;
	private int xPosition;
	private int yPosition;

	public GladosNode(int xPosition, int yPosition) {
		super(xPosition, yPosition);
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public void sethCosts(Node endNode) {
		this.sethCosts((absolute(this.getxPosition() - endNode.getxPosition()) + absolute(this
				.getyPosition() - endNode.getyPosition()))
				* BASICMOVEMENTCOST);
	}

	private int absolute(int a) {
		return a > 0 ? a : -a;
	}
	
	/**
	 * @return the xPosition
	 */
	public int getxPosition() {
		return xPosition;
	}

	/**
	 * @param xPosition the xPosition to set
	 */
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * @return the yPosition
	 */
	public int getyPosition() {
		return yPosition;
	}

	/**
	 * @param yPosition the yPosition to set
	 */
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
}