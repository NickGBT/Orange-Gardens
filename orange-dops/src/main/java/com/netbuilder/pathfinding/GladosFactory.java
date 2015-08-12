package com.netbuilder.pathfinding;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class GladosFactory implements NodeFactory
{
	@Override
	public Node createNode(int x, int y) 
	{
		return new GladosNode(x, y);
	}
}