package com.netbuilder.dops;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class Map<map extends Node>
{
    protected static boolean CANMOVEDIAGONALY = true;

    private map[][] nodes;

    protected int width;
    protected int higth;

    private NodeFactory nodeFactory;
    private Map<GladosNode> warehouseMap;
    private List<GladosNode> path;

    public Map(int width, int higth, NodeFactory nodeFactory)
    {
        this.nodeFactory = nodeFactory;        
        nodes = (map[][])new Node[width][higth];
        this.width = width - 1;
        this.higth = higth - 1;
        initEmptyNodes();
    }

    private void initEmptyNodes()
    {
        for (int i = 0; i <= width; i++)
        {
            for (int j = 0; j <= higth; j++)
            {
                nodes[i][j] = (map)nodeFactory.createNode(i, j);
            }
        }
        buildMap();
    }
    
    private void buildMap()
    {
    	warehouseMap = new Map<GladosNode>(20, 20, new GladosFactory());        
        for(int i = 2; i < 18; i++)
        {
        	warehouseMap.setWalkable(2, i, false);
        	warehouseMap.setWalkable(5, i, false);
        	warehouseMap.setWalkable(8, i, false);
        	warehouseMap.setWalkable(11, i, false);
        	warehouseMap.setWalkable(14, i, false);
        	warehouseMap.setWalkable(17, i, false);
        }
    }

    public void setWalkable(int x, int y, boolean bool)
    {
        nodes[x][y].setWalkable(bool);
    }

    public final map getNode(int x, int y)
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

        for (int j = higth; j >= 0; j--)
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

    private List<map> openList;
    private List<map> closedList;
    private boolean done = false;

    public final List<map> findPath(int oldX, int oldY, int newX, int newY)
    {
        openList = new LinkedList<map>();
        closedList = new LinkedList<map>();
        openList.add(nodes[oldX][oldY]);

        done = false;
        map current;
        while (!done) 
        {
            current = lowestFInOpen();
            closedList.add(current);
            openList.remove(current);

            if ((current.getxPosition() == newX) && (current.getyPosition() == newY)) 
            {
                return calcPath(nodes[oldX][oldY], current);
            }

            List<map> adjacentNodes = getAdjacent(current);
            for (int i = 0; i < adjacentNodes.size(); i++) 
            {
                map currentAdj = adjacentNodes.get(i);
                if (!openList.contains(currentAdj)) 
                {
                    currentAdj.setPrevious(current);
                    currentAdj.sethCosts(nodes[newX][newY]);
                    currentAdj.setgCosts(current);
                    openList.add(currentAdj);
                } 
                else 
                {
                    if (currentAdj.getgCosts() > currentAdj.calculategCosts(current)) 
                    {
                        currentAdj.setPrevious(current);
                        currentAdj.setgCosts(current);
                    }
                }
            }

            if (openList.isEmpty()) 
            {
                return new LinkedList<map>();
            }
        }
        return null;
    }

    private List<map> calcPath(map start, map goal)
    {
        LinkedList<map> path = new LinkedList<map>();

        map curr = goal;
        boolean done = false;
        while (!done) {
            path.addFirst(curr);
            curr = (map)curr.getPrevious();

            if (curr.equals(start))
            {
                done = true;
            }
        }
        return path;
    }

    private map lowestFInOpen() 
    {
        map cheapest = openList.get(0);
        for (int i = 0; i < openList.size(); i++)
        {
            if (openList.get(i).getfCosts() < cheapest.getfCosts())
            {
                cheapest = openList.get(i);
            }
        }
        return cheapest;
    }

    private List<map> getAdjacent(map node) 
    {
        int x = node.getxPosition();
        int y = node.getyPosition();
        List<map> adj = new LinkedList<map>();

        map temp;
        if (x > 0) 
        {
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

        if (y < higth) 
        {
            temp = this.getNode(x, (y + 1));
            if (temp.isWalkable() && !closedList.contains(temp)) 
            {
                temp.setIsDiagonaly(false);
                adj.add(temp);
            }
        }

        if (CANMOVEDIAGONALY) 
        {
            if (x < width && y < higth)
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

            if (x > 0 && y < higth) 
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