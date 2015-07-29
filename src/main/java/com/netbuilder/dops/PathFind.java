package com.netbuilder.dops;

import java.util.PriorityQueue;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class PathFind 
{
	private int n = 20; //horizontal size of the map
	private int m = 20; //vertical size size of the map
	static int map[][];
	static int closedNodesMap[][]; //map of closed (tried-out) nodes
	static int openNodesMap[][]; //map of open (not-yet-tried) nodes
	static int dirMap[][]; // map of directions
	static int dir = 8; // number of possible directions to go at any position
	static int dx[] = {1, 1, 0, -1, -1, -1, 0, 1};
	static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public PathFind()
	{
		map = new int[n][m];
		closedNodesMap = new int[n][m];
		openNodesMap = new int[n][m];
		dirMap = new int[n][m];
	}
	
	
	//A* algorithm - The route returned is a string of direction digits.
	public String pathFind(int xStart, int yStart, int xFinish, int yFinish)
	{
		PriorityQueue<Node> pq = new PriorityQueue<Node>(2);
		Node n0;
		Node m0;
		int i, j, x = 0, y, xdx, ydy;
		char c;
		String path = "";
		
		//reset the node maps
		for(y = 0; y < m; y++)
		{
			for(x = 0; x < n; x++)
			{
				closedNodesMap[x][y] = 0;
				openNodesMap[x][y] = 0;
			}
		}
		
		//create start node and push it into list of open nodes
		n0 = new Node(xStart, yStart, 0, 0);
		n0.updatePriority(xFinish, yFinish);
		pq.add(n0);
		//mark it on the open nodes map
		openNodesMap[x][y] = n0.getPriority();
		
		//A* search
		while(!pq.isEmpty())
		{
			//get the current node with the highest priority from the list of open nodes
			n0 = new Node(pq.peek().getXPos(), pq.peek().getYPos(), pq.peek().getLevel(), pq.peek().getPriority());
			x = n0.getXPos(); y = n0.getYPos();
			
			//remove the node from the open list
			pq.remove();
			openNodesMap[x][y] = 0;
			//mark it on the closed nodes map
			closedNodesMap[x][y] = 1;
			
			//quit searching when the goal state is reached
			if(x == xFinish && y == yFinish)
			{
				//generate path from finish to start by following the directions
				path = "";
				while(!(x == xStart && y == yStart))
				{
					j = dirMap[x][y];
					c = (char) ('0' + (j + dir / 2) % dir);
					path = c + path;
					x += dx[j];
					y += dy[j];
				}
			}
			//empty the leftover nodes
			while(!pq.isEmpty()) pq.remove();
			return path;
		}
		
		//generate moves (child nodes) in all possible directions
		for(i = 0; i < dir; i++)
		{
			xdx = x + dx[i]; ydy = y + dy[i];
			if(!(xdx < 0 || xdx > n - 1 || ydy < 0 || ydy > m - 1 || map[xdx][ydy] == 1 || closedNodesMap[xdx][ydy] == 1))
			{
				//generate a child node
				m0 = new Node(xdx, ydy, n0.getLevel(), n0.getPriority());
				m0.nextLevel(i);
				m0.updatePriority(xFinish, yFinish);
				
				//if it is not in the open list than add into that
				if(openNodesMap[xdx][ydy] == 0)
				{
					openNodesMap[xdx][ydy] = m0.getPriority();
					pq.add(m0);
					//mark its parent node direction
					dirMap[xdx][ydy] = (i + dir / 2) % dir;
				}
				else if(openNodesMap[xdx][ydy] > m0.getPriority())
				{
					//update the priority info
					openNodesMap[xdx][ydy] = m0.getPriority();
					//update the parent direction info
					dirMap[xdx][ydy] = (i + dir / 2) % dir;
					//replace the node by emptying one pq into the other one except the node 
					//to be replaced will be ignored and the new one will be pushed in instead
					while(!(pq.peek().getXPos() == xdx && pq.peek().getYPos() == ydy))
					{
						pq.add(pq.peek());
						pq.remove();
					}
					pq.add(m0);
				}
			}
		}
		return ""; //no route found
	}
}