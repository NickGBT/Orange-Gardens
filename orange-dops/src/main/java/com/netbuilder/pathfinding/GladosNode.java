package com.netbuilder.pathfinding;

import java.io.Serializable;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class GladosNode extends Node implements Serializable
{
	private static final long serialVersionUID = 5;

	public GladosNode(int xPosition, int yPosition)
	{
        super(xPosition, yPosition);
    }

    public void sethCosts(Node endNode) 
    {
        this.sethCosts((absolute(this.getxPosition() - endNode.getxPosition())
                + absolute(this.getyPosition() - endNode.getyPosition()))
                * BASICMOVEMENTCOST);
    }

    private int absolute(int a) 
    {
        return a > 0 ? a : -a;
    }
}