package com.netbuilder.pathfinding;

import java.io.Serializable;

/**
 * 
 * @author JustinMabbutt
 *
 */
public abstract class Node implements Serializable
{
	private static final long serialVersionUID = -7277861797370571645L;
	protected static final int BASICMOVEMENTCOST = 10;
	protected static final int DIAGONALMOVEMENTCOST = 14;

	private int xPosition;
	private int yPosition;
	private boolean walkable;

	private Node previous;

	private boolean diagonally;

	private int movementPenalty;

	private int gCosts;

	private int hCosts;

	public Node() {};

	public Node(int xPosition, int yPosition) 
	{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.walkable = true;
		this.movementPenalty = 0;
	}

	public boolean isDiagonaly()
	{
		return diagonally;
	}

	public void setIsDiagonaly(boolean isDiagonaly)
	{
		this.diagonally = isDiagonaly;
	}

	public void setCoordinates(int x, int y)
	{
		this.xPosition = x;
		this.yPosition = y;
	}

	public int getxPosition() 
	{
		return xPosition;
	}

	public int getyPosition() 
	{
		return yPosition;
	}

	public boolean isWalkable()
	{
		return walkable;
	}

	public void setWalkable(boolean walkable)
	{
		this.walkable = walkable;
	}

	public Node getPrevious()
	{
		return previous;
	}

	public void setPrevious(Node previous) 
	{
		this.previous = previous;
	}

	public void setMovementPanelty(int movementPanelty) 
	{
		this.movementPenalty = movementPanelty;
	}

	public int getfCosts() 
	{
		return gCosts + hCosts;
	}

	public int getgCosts() 
	{
		return gCosts;
	}

	private void setgCosts(int gCosts) 
	{
		this.gCosts = gCosts + movementPenalty;
	}

	public void setgCosts(Node previousAbstractNode, int basicCost)
	{
		setgCosts(previousAbstractNode.getgCosts() + basicCost);
	}

	public void setgCosts(Node previousAbstractNode)
	{
		if (diagonally) 
		{
			setgCosts(previousAbstractNode, DIAGONALMOVEMENTCOST);
		} 
		else
		{
			setgCosts(previousAbstractNode, BASICMOVEMENTCOST);
		}
	}

	public int calculategCosts(Node previousAbstractNode) 
	{
		if (diagonally) 
		{
			return (previousAbstractNode.getgCosts() + DIAGONALMOVEMENTCOST + movementPenalty);
		} 
		else 
		{
			return (previousAbstractNode.getgCosts() + BASICMOVEMENTCOST + movementPenalty);
		}
	}

	public int calculategCosts(Node previousAbstractNode, int movementCost)
	{
		return (previousAbstractNode.getgCosts() + movementCost + movementPenalty);
	}

	public int gethCosts() 
	{
		return hCosts;
	}

	protected void sethCosts(int hCosts)
	{
		this.hCosts = hCosts;
	}

	public abstract void sethCosts(Node endAbstractNode);

	@Override
	public String toString()
	{
		return "(" + getxPosition() + ", " + getyPosition() + "): h: " + gethCosts() + " g: " + getgCosts() + " f: " + getfCosts();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) 
		{
			return false;
		}
		if (getClass() != obj.getClass()) 
		{
			return false;
		}
		final Node other = (Node) obj;
		if (this.xPosition != other.xPosition) 
		{
			return false;
		}
		if (this.yPosition != other.yPosition) 
		{
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() 
	{
		int hash = 3;
		hash = 17 * hash + this.xPosition;
		hash = 17 * hash + this.yPosition;
		return hash;
	}
}