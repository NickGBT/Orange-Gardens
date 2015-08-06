package com.netbuilder.pathfinding;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class Map<gladosNode extends Node> implements Serializable
{
	private static final long serialVersionUID = 4082015;

	private static final Logger logger = Logger.getLogger(Map.class.getName());
    
	protected static boolean CANMOVEDIAGONALLY = true;
    
    private gladosNode[][] nodes;

    protected int width;
    protected int height;

    private NodeFactory nodeFactory;
    private Map<GladosNode> warehouseMap;
    private List<GladosNode> path;

    public Map(int width, int height, NodeFactory nodeFactory)
    {
    	logger.entering(getClass().getName(), "Map");
        this.nodeFactory = nodeFactory;        
        nodes = (gladosNode[][])new Node[width][height];
        this.width = width - 1;
        this.height = height - 1;
        initEmptyNodes();
        logger.exiting(getClass().getName(), "Map");
    }

    private void initEmptyNodes()
    {
    	logger.entering(getClass().getName(), "initEmptyNodes");
        for(int i = 0; i <= width; i++)
        {
            for(int j = 0; j <= height; j++)
            {
                nodes[i][j] = (gladosNode)nodeFactory.createNode(i, j);
            }
        }
        logger.exiting(getClass().getName(), "initEmptyNodes");
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
    	logger.entering(getClass().getName(), "drawMap");
        for(int i = 0; i <= width; i++) 
        {
        	print(" _");
        }
        print("\n");

        for(int j = height; j >= 0; j--)
        {
            print("|");
            for(int i = 0; i <= width; i++)
            {
                if(nodes[i][j].isWalkable()) 
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

        for(int i = 0; i <= width; i++)
        {
        	print(" _");
        }
        logger.exiting(getClass().getName(), "drawMap");
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
    	logger.entering(getClass().getName(), "findPath");
        openList = new LinkedList<gladosNode>();
        closedList = new LinkedList<gladosNode>();
        openList.add(nodes[oldX][oldY]);

        done = false;
        gladosNode current;
        while(!done) 
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
                if(!openList.contains(currentAdj)) 
                {
                    currentAdj.setPrevious(current);
                    currentAdj.sethCosts(nodes[newX][newY]);
                    currentAdj.setgCosts(current);
                    openList.add(currentAdj);
                } 
                else 
                {
                    if(currentAdj.getgCosts() > currentAdj.calculategCosts(current)) 
                    {
                        currentAdj.setPrevious(current);
                        currentAdj.setgCosts(current);
                    }
                }
            }

            if(openList.isEmpty()) 
            {
                return new LinkedList<gladosNode>();
            }
        }
        logger.exiting(getClass().getName(), "findPath");
        return null;        
    }

    private List<gladosNode> calcPath(gladosNode start, gladosNode goal)
    {
    	logger.entering(getClass().getName(), "calcPath");
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
        logger.exiting(getClass().getName(), "calcPath");
        return path;
    }

    private gladosNode lowestFInOpen() 
    {
    	logger.entering(getClass().getName(), "lowestFInOpen");
        gladosNode cheapest = openList.get(0);
        for (int i = 0; i < openList.size(); i++)
        {
            if (openList.get(i).getfCosts() < cheapest.getfCosts())
            {
                cheapest = openList.get(i);
            }
        }
        logger.exiting(getClass().getName(), "lowestFInOpen");
        return cheapest;
    }

    private List<gladosNode> getAdjacent(gladosNode node) 
    {
    	logger.entering(getClass().getName(), "getAdjacent");
        int x = node.getxPosition();
        int y = node.getyPosition();
        List<gladosNode> adj = new LinkedList<gladosNode>();

        gladosNode temp;
        if(x > 0) 
        {
            temp = this.getNode((x - 1), y);
            if (temp.isWalkable() && !closedList.contains(temp)) 
            {
                temp.setIsDiagonaly(false);
                adj.add(temp);
            }
        }

        if(x < width) 
        {
            temp = this.getNode((x + 1), y);
            if (temp.isWalkable() && !closedList.contains(temp))
            {
                temp.setIsDiagonaly(false);
                adj.add(temp);
            }
        }

        if(y > 0)
        {
            temp = this.getNode(x, (y - 1));
            if (temp.isWalkable() && !closedList.contains(temp))
            {
                temp.setIsDiagonaly(false);
                adj.add(temp);
            }
        }

        if(y < height) 
        {
            temp = this.getNode(x, (y + 1));
            if (temp.isWalkable() && !closedList.contains(temp)) 
            {
                temp.setIsDiagonaly(false);
                adj.add(temp);
            }
        }

        if(CANMOVEDIAGONALLY) 
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

            if(x < width && y > 0) 
            {
                temp = this.getNode((x + 1), (y - 1));
                if (temp.isWalkable() && !closedList.contains(temp)) 
                {
                    temp.setIsDiagonaly(true);
                    adj.add(temp);
                }
            }
        }
        logger.exiting(getClass().getName(), "getAdjacent");
        return adj;
    }
}