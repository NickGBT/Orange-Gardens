package com.netbuilder.pathfinding;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class GladosNode extends Node
{
	private static final long serialVersionUID = -5240735361051754844L;

	public GladosNode(int xPosition, int yPosition)
	{
		super(xPosition, yPosition);
	}

	public void sethCosts(Node endNode) 
	{
		this.sethCosts((absolute(this.getxPosition() - endNode.getxPosition()) + 
				absolute(this.getyPosition() - endNode.getyPosition())) * BASICMOVEMENTCOST);
	}

	private int absolute(int a)
	{
		return a > 0 ? a : -a;
	}
}