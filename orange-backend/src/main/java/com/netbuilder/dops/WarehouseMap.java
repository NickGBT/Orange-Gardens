package com.netbuilder.dops;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class WarehouseMap<gladosNode extends Node>
{
	protected static boolean CANMOVEDIAGONALLY = true;

	private gladosNode[][] nodes;

	protected int width;
	protected int height;

	private NodeFactory nodeFactory;

	private WarehouseMap<GladosNode> warehouseMap;
	private List<GladosNode> path;

	@SuppressWarnings("unchecked")
	public WarehouseMap(int width, int height, NodeFactory nodeFactory)
	{
		this.nodeFactory = nodeFactory;
		nodes = (gladosNode[][])new Node[width][height];
		this.width = width - 1;
		this.height = height - 1;
		initEmptyNodes();
	}

	@SuppressWarnings("unchecked")
	private void initEmptyNodes()
	{
		for (int i = 0; i <= width; i++)
		{
			for (int j = 0; j <= height; j++) 
			{
				nodes[i][j] = (gladosNode)nodeFactory.createNode(i, j);
			}
		}
		buildMap();
	}

	private WarehouseMap<GladosNode> buildMap() 
	{
		warehouseMap = new WarehouseMap<GladosNode>(20, 20, new GladosFactory());
		for (int i = 2; i < 18; i++) 
		{
			warehouseMap.setWalkable(2, i, false);
			warehouseMap.setWalkable(5, i, false);
			warehouseMap.setWalkable(8, i, false);
			warehouseMap.setWalkable(11, i, false);
			warehouseMap.setWalkable(14, i, false);
			warehouseMap.setWalkable(17, i, false);
		}
		return warehouseMap;
	}

	public void setWalkable(int x, int y, boolean bool)
	{
		nodes[x][y].setWalkable(bool);
	}

	public final gladosNode getNode(int x, int y) 
	{
		return nodes[x][y];
	}

	public void drawMap()
	{
		for (int i = 0; i <= width; i++) 
		{
			print(" _");
		}
		print("\n");

		for (int j = height; j >= 0; j--) 
		{
			print("|");
			for (int i = 0; i <= width; i++)
			{
				if (nodes[i][j].isWalkable()) 
				{
					print("  ");
				} 
				else
				{
					print(" #");
				}
			}
			print("|\n");
		}

		for (int i = 0; i <= width; i++)
		{
			print(" _");
		}
	}

	private void print(String s) 
	{
		System.out.print(s);
	}

	private List<gladosNode> openList;
	private List<gladosNode> closedList;
	private boolean done = false;

	public final List<gladosNode> findPath(int oldX, int oldY, int newX, int newY) 
	{
		openList = new LinkedList<gladosNode>();
		closedList = new LinkedList<gladosNode>();
		openList.add(nodes[oldX][oldY]);

		done = false;
		gladosNode current;
		while (!done)
		{
			current = lowestFInOpen();
			closedList.add(current);
			openList.remove(current);

			if ((current.getxPosition() == newX) && (current.getyPosition() == newY))
			{
				return calcPath(nodes[oldX][oldY], current);
			}

			List<gladosNode> adjacentNodes = getAdjacent(current);
			for (int i = 0; i < adjacentNodes.size(); i++)
			{
				gladosNode currentAdj = adjacentNodes.get(i);
				if (!openList.contains(currentAdj)) 
				{
					currentAdj.setPrevious(current);
					currentAdj.sethCosts(nodes[newX][newY]);
					currentAdj.setgCosts(current);
					openList.add(currentAdj);
				}
				else 
				{
					if (currentAdj.getgCosts() > currentAdj.calculategCosts(current)) {
						currentAdj.setPrevious(current);
						currentAdj.setgCosts(current);
					}
				}
			}

			if (openList.isEmpty()) 
			{
				return new LinkedList<gladosNode>();
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private List<gladosNode> calcPath(gladosNode start, gladosNode goal)
	{
		LinkedList<gladosNode> path = new LinkedList<gladosNode>();

		gladosNode curr = goal;
		boolean done = false;
		while (!done) {
			path.addFirst(curr);
			curr = (gladosNode)curr.getPrevious();

			if (curr.equals(start)) 
			{
				done = true;
			}
		}
		return path;
	}

	private gladosNode lowestFInOpen()
	{
		gladosNode cheapest = openList.get(0);
		for (int i = 0; i < openList.size(); i++)
		{
			if (openList.get(i).getfCosts() < cheapest.getfCosts()) 
			{
				cheapest = openList.get(i);
			}
		}
		return cheapest;
	}

	private List<gladosNode> getAdjacent(gladosNode node)
	{
		int x = node.getxPosition();
		int y = node.getyPosition();
		List<gladosNode> adj = new LinkedList<gladosNode>();

		gladosNode temp;
		if (x > 0) {
			temp = this.getNode((x - 1), y);
			if (temp.isWalkable() && !closedList.contains(temp)) 
			{
				temp.setIsDiagonaly(false);
				adj.add(temp);
			}
		}

		if (x < width)
		{
			temp = this.getNode((x + 1), y);
			if (temp.isWalkable() && !closedList.contains(temp)) 
			{
				temp.setIsDiagonaly(false);
				adj.add(temp);
			}
		}

		if (y > 0) 
		{
			temp = this.getNode(x, (y - 1));
			if (temp.isWalkable() && !closedList.contains(temp))
			{
				temp.setIsDiagonaly(false);
				adj.add(temp);
			}
		}

		if (y < height) 
		{
			temp = this.getNode(x, (y + 1));
			if (temp.isWalkable() && !closedList.contains(temp)) 
			{
				temp.setIsDiagonaly(false);
				adj.add(temp);
			}
		}

		if (CANMOVEDIAGONALLY) 
		{
			if (x < width && y < height)
			{
				temp = this.getNode((x + 1), (y + 1));
				if (temp.isWalkable() && !closedList.contains(temp)) 
				{
					temp.setIsDiagonaly(true);
					adj.add(temp);
				}
			}

			if (x > 0 && y > 0)
			{
				temp = this.getNode((x - 1), (y - 1));
				if (temp.isWalkable() && !closedList.contains(temp)) 
				{
					temp.setIsDiagonaly(true);
					adj.add(temp);
				}
			}

			if (x > 0 && y < height)
			{
				temp = this.getNode((x - 1), (y + 1));
				if (temp.isWalkable() && !closedList.contains(temp))
				{
					temp.setIsDiagonaly(true);
					adj.add(temp);
				}
			}

			if (x < width && y > 0) 
			{
				temp = this.getNode((x + 1), (y - 1));
				if (temp.isWalkable() && !closedList.contains(temp)) 
				{
					temp.setIsDiagonaly(true);
					adj.add(temp);
				}
			}
		}
		return adj;
	}
}