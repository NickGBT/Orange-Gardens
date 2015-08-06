package com.netbuilder.orange_dops;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import com.netbuilder.pathfinding.*;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class GladosGui 
{
	private static final Logger logger = Logger.getLogger(GladosGui.class.getName());
	private JFrame mainFrame, splashFrame;
	private Image gladosLogo;
	private JLabel splashLabel, backgroundLabel;
	private JPanel assignOrder, orderButtons, orderPanel, mapPanel;
	private BufferedImage splash, background;
	private Timer splashTimer;
	private ImageIcon splashIcon, nbLogo, backgroundIcon;
	private Dimension screenSize;
	private JButton getNewOrder, completeOrder, nextProduct;
	private GridBagLayout buttonLayout;
	private GridBagConstraints buttonLayoutConstraints;
	private ImagePanel backgroundPanel;
	private Font gladosFont;
	private int[][] baseMap;
	private JTextField productName, quantity, boxSize;
	private List<GladosNode> testPath;
	private Map<GladosNode> warehouseMap;
	
	/**
	 * @author JustinMabbutt
	 * Initialise appearance
	 */
	public GladosGui() 
	{
		logger.entering(getClass().getName(), "GladosGui");
		try
		{
			for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
				}
			}
		}
		catch (UnsupportedLookAndFeelException ue)
		{
			logger.log(Level.SEVERE, "Unsupported format", ue);
		}
		catch (ClassNotFoundException ce)
		{
			logger.log(Level.SEVERE, "Class not found", ce);
		}
		catch (InstantiationException ie)
		{
			logger.log(Level.SEVERE, "Instantiation exception", ie);
		}
		catch (IllegalAccessException iae)
		{
			logger.log(Level.SEVERE, "Illegal access exception", iae);
		}		
		splashFrame = new JFrame();
		splashLabel = new JLabel(); backgroundLabel = new JLabel();
		assignOrder = new JPanel(); orderButtons = new JPanel(); orderPanel = new JPanel(); mapPanel = new JPanel();
		splashIcon = new ImageIcon(); backgroundIcon = new ImageIcon();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		getNewOrder = new JButton(); completeOrder = new JButton(); nextProduct = new JButton();
		productName = new JTextField(35); quantity = new JTextField(35); boxSize = new JTextField(35);
		splash = null; background = null;
		splashTimer = new Timer();
		buttonLayout = new GridBagLayout();
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
    	initMap();
    	testPath = warehouseMap.findPath(0, 0, 10, 10);
		buttonLayoutConstraints = new GridBagConstraints();
		gladosFont = new Font("Arial", Font.BOLD, 18);
		Thread ui = new Thread()
		{
			@Override
			public void run()
			{
				while(true)
				{
					getNewOrder.repaint();
					mapPanel.repaint();
					orderButtons.repaint();
					orderPanel.repaint();
					mapPanel.repaint();
					try 
					{
						Thread.sleep(100);
					} 
					catch (InterruptedException ie)
					{
						logger.log(Level.SEVERE, "Thread Interrupted", ie);
					}
				}
			}
		};
		ui.start();
		logger.exiting(getClass().getName(), "GladosGui");
    }
	
	/**
	 * @author JustinMabbutt
	 * Display opening splash screen
	 */
	public void displaySplash()
	{
		logger.entering(getClass().getName(), "displaySplash");
		try 
		{
			splash = ImageIO.read(new File("C:/Users/justi_000/workspace/ee/Orange-Gardens/orange-dops/images/splash.jpg"));
			background = ImageIO.read(new File("C:/Users/justi_000/workspace/ee/Orange-Gardens/orange-dops/images/background.png"));
		} 
		catch (IOException ie) 
		{
			logger.log(Level.SEVERE, "Error loading images", ie);
		}
		splashIcon.setImage(splash); backgroundIcon.setImage(background);
		splashLabel.setIcon(splashIcon); backgroundLabel.setIcon(backgroundIcon);
		splashFrame = new JFrame();
		splashFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		nbLogo = new ImageIcon("images/nb.png");
        gladosLogo = nbLogo.getImage();
        splashFrame.setResizable(false);
        splashFrame.setTitle("Welcome to NB GLADOS");
        splashFrame.setSize(splashIcon.getIconWidth(), splashIcon.getIconHeight());  
        splashFrame.setUndecorated(true);
        splashFrame.setLocation((int)screenSize.getWidth() / 2 - splashIcon.getIconWidth() / 2, (int)screenSize.getHeight() / 2 - splashIcon.getIconHeight() / 2);
        splashFrame.setIconImage(gladosLogo);
		splashFrame.add(splashLabel, BorderLayout.CENTER);
		splashFrame.setVisible(true);
		splashTimer.schedule(new deleteSplashTask(), 2000);
		logger.exiting(getClass().getName(), "displaySplash");
	}
	
	/**
	 * @author: JustinMabbutt
	 * Task to initialise main UI elements
	 */
	private void initUi()
	{
		logger.entering(getClass().getName(), "initUi");
		mainFrame = new JFrame("NB GLADOS");
		backgroundPanel = new ImagePanel(backgroundIcon.getImage());
        mainFrame.setSize(500, 680);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        nbLogo = new ImageIcon("images/nb.png");
        mainFrame.setIconImage(gladosLogo);
        mainFrame.getContentPane().add(backgroundPanel);
        mainFrame.setVisible(true);
        displayGetOrder();
		logger.exiting(getClass().getName(), "initUi");
	}

    /**
     * @author JustinMabbutt
     * Task to display the order screen with map
     */
    private void displayGetOrder()
    {
    	logger.entering(getClass().getName(), "displayGetOrder");
    	mainFrame.getContentPane().remove(orderPanel);
    	mainFrame.getContentPane().remove(mapPanel);
    	mainFrame.getContentPane().remove(orderButtons);
   		mainFrame.invalidate();
    	getNewOrder.setText("Assign yourself an order to process.");
    	getNewOrder.setPreferredSize(new Dimension(350, 150));
    	getNewOrder.setFont(gladosFont);
    	getNewOrder.addActionListener(new ActionListener() 
    	{
			public void actionPerformed(ActionEvent arg0) 
			{
				displayMap();
			}
		});
    	buttonLayoutConstraints.fill = buttonLayoutConstraints.CENTER;
    	assignOrder.add(getNewOrder);
    	buttonLayout.setConstraints(assignOrder, buttonLayoutConstraints);
    	assignOrder.setLayout(buttonLayout);
    	mainFrame.getContentPane().add(assignOrder);
    	mainFrame.revalidate();
    	mainFrame.repaint();
    	logger.exiting(getClass().getName(), "displayGetOrder");
    }
    
    /**
     * @author JustinMabbutt
     * Task to delete the opening splash screen
     */
    private class deleteSplashTask extends TimerTask
   	{
   		public void run()
   		{
			splashFrame.dispose();
			initUi();
			splashTimer.cancel();
   		}
   	}
    
    /**
     * @author JustinMabbutt
     * Task to populate the map with nodes
     */
    private void buildMap()
    {
    	logger.entering(getClass().getName(), "buildMap");
    	mapPanel.removeAll();
    	mapPanel.invalidate();
    	if(testPath.size() > 0)
    	{
    		for(int i = 0; i < testPath.size(); i++)
    		{
    			baseMap[testPath.get(i).getyPosition()][testPath.get(i).getxPosition()] = 4;
    		}
	    	for (int i = 0; i < 20; i++) 
	    	{
	    		for(int j = 0; j < 20; j++)
	    		{
	    			switch(baseMap[i][j])
	    			{
	    			case 1:
	    			    JLabel possRoute = new JLabel("*", SwingConstants.CENTER);//beginning
	    			    possRoute.setForeground(Color.BLACK);
	    			    mapPanel.add(possRoute);
	    				break;
	    			case 2:
	    				JLabel shelf = new JLabel("S", SwingConstants.CENTER);//shelf
	    				shelf.setForeground(Color.BLUE);
	    				mapPanel.add(shelf);
	    				break;
	    			case 3:
	    				JLabel gdz = new JLabel("G", SwingConstants.CENTER);//GDZ
	    				gdz.setForeground(Color.ORANGE);
	    				mapPanel.add(gdz);
	    				break;
	    			case 4:
	    				JLabel route = new JLabel("X", SwingConstants.CENTER);//route
	    				route.setForeground(Color.RED);
	    				mapPanel.add(route);
	    				break;
	    			}
	    		}	    
	    	}
    	}
    	else
    	{
    		for (int i = 0; i < 20; i++) 
	    	{
	    		for(int j = 0; j < 20; j++)
	    		{
	    			switch(baseMap[i][j])
	    			{
	    			case 1:
	    			    JLabel possRoute = new JLabel("*", SwingConstants.CENTER);//beginning
	    			    possRoute.setForeground(Color.BLACK);
	    			    mapPanel.add(possRoute);
	    				break;
	    			case 2:
	    				JLabel shelf = new JLabel("S", SwingConstants.CENTER);//shelf
	    				shelf.setForeground(Color.BLUE);
	    				mapPanel.add(shelf);
	    				break;
	    			case 3:
	    				JLabel gdz = new JLabel("G", SwingConstants.CENTER);//GDZ
	    				gdz.setForeground(Color.ORANGE);
	    				mapPanel.add(gdz);
	    				break;
	    			}
	    		}
	    	}
    	}
    	mapPanel.revalidate();
    	logger.exiting(getClass().getName(), "buildMap");
    }
    
    /**
     * @author JustinMabbutt
     * Task to re/initialise the map
     */
    private void initMap()
    {
    	logger.entering(getClass().getName(), "initMap");
    	//1 = Possible route
    	//2 = Shelf
    	//3 = GDZ
    	baseMap = new int[][] { 
    			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
    			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    			{1, 1, 3, 1, 1, 3, 1, 1, 3, 1, 1, 3, 1, 1, 3, 1, 1, 3, 1, 1}
    	};
    	logger.exiting(getClass().getName(), "initMap");
    }
    
    /**
     * @author JustinMabbutt
     * Task to draw the map
     */
   	private void displayMap()
    {
   		logger.entering(getClass().getName(), "displayMap");
   		mainFrame.getContentPane().remove(assignOrder);
   		mainFrame.invalidate();
    	productName.setText("Product Name: ");// + theProductName
    	quantity.setText("Quantity: ");// + quantity
    	boxSize.setText("Box Size: ");// + boxSize
    	productName.setFont(gladosFont); 
    	productName.setPreferredSize(new Dimension(200, 30));
    	productName.setEditable(false);
    	productName.setMaximumSize(productName.getPreferredSize());
    	quantity.setFont(gladosFont); 
    	quantity.setPreferredSize(new Dimension(200, 30));
    	quantity.setEditable(false);
    	quantity.setMaximumSize(quantity.getPreferredSize());
    	boxSize.setFont(gladosFont); 
    	boxSize.setPreferredSize(new Dimension(200, 30));
    	boxSize.setEditable(false);
    	boxSize.setMaximumSize(boxSize.getPreferredSize());
    	orderPanel.add(productName);
    	orderPanel.add(quantity);
    	orderPanel.add(boxSize);
    	orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.PAGE_AXIS));
    	buildMap();
    	mapPanel.setLayout(new GridLayout(20, 20));
    	orderButtons.setLayout(new FlowLayout(FlowLayout.CENTER));	
    	completeOrder.setText("Complete order");
    	completeOrder.setPreferredSize(new Dimension(240, 80));
    	completeOrder.setFont(gladosFont);
    	completeOrder.addActionListener(new ActionListener() 
    	{
			public void actionPerformed(ActionEvent arg0) 
			{
				displayGetOrder();
			}
		});
    	orderButtons.add(completeOrder);
    	nextProduct.setText("Route to next Product");
    	nextProduct.setPreferredSize(new Dimension(240, 80));
    	nextProduct.setFont(gladosFont);
    	nextProduct.addActionListener(new ActionListener() 
    	{
			public void actionPerformed(ActionEvent arg0) 
			{
				//mapPanel.removeAll();
				//mapPanel.invalidate();
				//new route
			}
		});
    	orderButtons.add(nextProduct);
    	mainFrame.getContentPane().add(orderPanel, BorderLayout.NORTH);
    	mainFrame.getContentPane().add(mapPanel, BorderLayout.CENTER);
    	mainFrame.getContentPane().add(orderButtons, BorderLayout.SOUTH);
    	mainFrame.revalidate();
    	mainFrame.repaint();
    	logger.exiting(getClass().getName(), "displayMap");
    }
}