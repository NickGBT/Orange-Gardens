package com.netbuilder.dops;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class Node
{
	//current position
	int xPos;
	int yPos;
	//total distance already travelled to reach the node
	int level;
	//priority = level + remaining distance estimate
	//smaller = higher priority
	int priority; 
	
	public Node(int xp, int yp, int d, int p)
	{
		xPos = xp;
		yPos = yp;
		level = d;
		priority = p;
	}
	
	public int getXPos()
	{
		return xPos;
	}
	
	public int getYPos()
	{
		return yPos;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public int getPriority()
	{
		return priority;
	}
	
	public void updatePriority(int xDest, int yDest)
	{
		priority = level + estimate(xDest, yDest) * 10;
	}
	
	//give better priority to going straight ahead instead
	//i = direction
	public void nextLevel(int i)
	{
		level += (PathFind.dir==8?(i%2==0?10:14):10);
	}
	
	public int estimate(int xDest, int yDest)
	{
		int xd, yd, d;
		xd = xDest - xPos;
		yd = yDest - yPos;
		
		//Euclidian Distance
		d = (int)Math.sqrt(xd * xd + yd * yd);
		
		//Manhattan Distance
		//d = Math.abs(xd) + Math.abs(yd);
		
		//Chebyshev Distance
		//d = Math.max(Math.abs(xd), Math.abs(yd));
		
		return d;
	}
}