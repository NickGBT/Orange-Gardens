package com.netbuilder.orange_dops;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.jms.JMSException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netbuilder.jms.Receiver;
import com.netbuilder.jms_tools.DopsOrder;
import com.netbuilder.pathfinding.GladosFactory;
import com.netbuilder.pathfinding.GladosNode;
import com.netbuilder.pathfinding.WarehouseMap;
import com.netbuilder.util.OrderData;

/**
 * 
 * @author JustinMabbutt 
 *
 */
public class GladosGui 
{
	private static final Logger logger = LogManager.getLogger();
	private OrderData orderData;
	private JFrame mainFrame, splashFrame;
	private Image gladosLogo, splash, background;
	private JLabel splashLabel, backgroundLabel;
	private JLabel[][] mapLabel;
	private JPanel assignOrder, orderButtons, orderPanel, mapPanel, loginPanel, fillPanel;
	private Timer splashTimer;
	private ImageIcon splashIcon, nbLogo, backgroundIcon;
	private Dimension screenSize;
	private JButton getNewOrder, completeOrder, nextProduct, login, logout;
	private GridBagConstraints buttonLayoutConstraints;
	private ImagePanel backgroundPanel;
	private Font gladosFont;
	private int[][] baseMap;
	private JTextField productName, quantity, boxSize;
	private LoginTextField username;
	private JPasswordField password;
	private List<GladosNode> testPath;
	private WarehouseMap<GladosNode> warehouseMap;
	private String user, pass;
	private Thread ui;
	private Receiver receiver;
	private DopsOrder order;
	private Boolean gdz = false;

	/**
	 * Initialise appearance
	 */
	public GladosGui()
	{
		try 
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName())) 
				{
					UIManager.setLookAndFeel(info.getClassName());
				}
			}
		} 
		catch (UnsupportedLookAndFeelException ue) 
		{
			logger.error("Unsupported format", ue);
		} 
		catch (ClassNotFoundException ce) 
		{
			logger.error("Class not found", ce);
		} 
		catch (InstantiationException ie) 
		{
			logger.error("Instantiation exception", ie);
		} 
		catch (IllegalAccessException iae)
		{
			logger.error("Illegal access exception", iae);
		}
		splashFrame = new JFrame();
		splashLabel = new JLabel(); backgroundLabel = new JLabel();
		mapLabel = new JLabel[20][20];
		assignOrder = new JPanel(); orderButtons = new JPanel(); orderPanel = new JPanel(); 
		fillPanel = new JPanel(); mapPanel = new JPanel(); loginPanel = new JPanel();
		splashIcon = new ImageIcon(); backgroundIcon = new ImageIcon();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		getNewOrder = new JButton(); completeOrder = new JButton(); nextProduct = new JButton();
		login = new JButton(); logout = new JButton();
		productName = new JTextField(35); quantity = new JTextField(35); boxSize = new JTextField(35);
		username = new LoginTextField("Username:");
		password = new JPasswordField(11);
		splash = null; background = null;
		user = ""; pass = "";
		splashTimer = new Timer();
		warehouseMap = new WarehouseMap<GladosNode>(20, 20, new GladosFactory());        
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
    	assignActionListeners();
    	testPath = null;
		initMap();
		testPath = warehouseMap.findPath(0, 0, 0, 0);
		buttonLayoutConstraints = new GridBagConstraints();
		gladosFont = new Font("Arial", Font.BOLD, 18);
		ui = new Thread()
		{
			@Override
			public void run() 
			{
				while (true)
				{
					username.repaint();
					password.repaint();
					login.repaint();
					getNewOrder.repaint();
					logout.repaint();
					orderButtons.repaint();
					orderPanel.repaint();
					mapPanel.repaint();
					try 
					{
						Thread.sleep(100);
					} 
					catch (InterruptedException ie) 
					{
						logger.error("Thread Interrupted", ie);
					}
				}
			}
		};
		ui.start();
	}

	/**
	 * Assign action listeners
	 */
	/**
	 * @author mwatson
	 */
	private void assignActionListeners()
	{
		getNewOrder.addActionListener(new ActionListener() 
    	{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{

				logger.info("Order Being Assigned");
				System.out.println("Order Being Assigned");

				try {
					System.out.println("Before Receiver");
					receiver = new Receiver("127.0.0.1");
					System.out.println("After Receiver");
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					System.out.println("Receiver not created");
					logger.error("Receiver not created" , e1);
					e1.printStackTrace();
				} catch (Exception e) {
					System.out.println("Receiver");
				}
				
				try {
					System.out.println("Before Message");
					order = (DopsOrder) receiver.getMessage("dops_queue");
					logger.info("Order: " + order.getDopsOrder().get(0).getProductName());
					orderData = new OrderData(order);
					logger.info("Received Following Order: " + order.getDopsOrder().get(0).getProductName());
					logger.info("Received message correctly from broker");
					System.out.println("Received message correctly from broker");
				} catch (JMSException e2) {
					// TODO Auto-generated catch block
					logger.error("Cannot receive message from broker", e2);
					System.out.println("Cannot receive message from broker");
					e2.printStackTrace();
				} catch(Exception e) {
					logger.error("Cannot retrieve correct information from order sent");
					System.out.println("Message Error");
					e.printStackTrace();
				}
					if(order == null)
					{	
						JOptionPane.showMessageDialog(mainFrame, "No pending orders available", "No outstanding orders!", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						completeOrder.setEnabled(false);
						displayMap();			
					}
		
			}
		});
		
		login.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(username.getText().equals("") || username.getText().equals("Username:") || password.getPassword().toString().equals("") || password.getPassword().toString().equals("Password:"))
				{
					JOptionPane.showMessageDialog(mainFrame, "Please enter a valid username and password", "Invalid entry!", JOptionPane.ERROR_MESSAGE);
				}
				else if(username.getText().equals("JSmith") || password.getPassword().toString().equals("password"))
				{
					user = username.getText();
					pass = password.getPassword().toString();
					mainFrame.setTitle("NB GLADOS - " + user);
					displayGetOrder();
				}
			}			
		});
		
		completeOrder.addActionListener(new ActionListener() 
    	{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(orderData.isOrdersComplete())
				{
					displayGetOrder();
				}
				else
				{
					JOptionPane.showMessageDialog(mainFrame, "Please complete order processing", "Order not yet complete!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		logout.addActionListener(new ActionListener()
    	{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				logout();
			}
		});
		
		nextProduct.addActionListener(new ActionListener() 
    	{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(orderData.getProductIncrement() < (order.getDopsOrder().size() - 1))
				{
					orderData.setProductIncrement(orderData.getProductIncrement() + 1);
					getNewRoute();				
				}
				else if(orderData.getProductIncrement() == (order.getDopsOrder().size() - 1) && orderData.isGdz() == false)
				{
					orderData.setGdz(true);
					getNewRoute();
				}
				if(orderData.isGdz() == true)
				{
					getGdzRoute();
				}
			}
		});
	}
	
	/**
	 * Gets a new route
	 */
	public void getNewRoute()
	{
		initMap();
		if(orderData.getProductIncrement() > 0)
    	{
	    	orderData.setxStart(orderData.getxProductLocation()[orderData.getProductIncrement()]);
	    	orderData.setyStart(orderData.getyProductLocation()[orderData.getProductIncrement()]);
    	}
    	testPath = warehouseMap.findPath(orderData.getxStart(), orderData.getyStart(), 
    			orderData.getxProductLocation()[orderData.getProductIncrement()], 
    			orderData.getyProductLocation()[orderData.getProductIncrement()]);
    	nextProduct.setEnabled(true);
    	displayMap();
	}
	
	/**
	 * Gets route to GDZ
	 */
	public void getGdzRoute()
	{
		initMap();
		if(orderData.getProductIncrement() > 0)
    	{
	    	orderData.setxStart(orderData.getxProductLocation()[orderData.getProductIncrement()]);
	    	orderData.setyStart(orderData.getyProductLocation()[orderData.getProductIncrement()]);
    	}
    	testPath = warehouseMap.findPath(orderData.getxStart(), orderData.getyStart(), orderData.getxGdz(), orderData.getyGdz());
    	orderData.setOrdersComplete(true);
    	nextProduct.setEnabled(false);
    	completeOrder.setEnabled(true);
    	displayMap();
	}
	
	/**
	 * Display opening splash screen
	 */
	public void displaySplash() 
	{
		splash = Toolkit.getDefaultToolkit().getImage("images/splash.jpg");
		background = Toolkit.getDefaultToolkit().getImage("images/background.png");
		splashIcon.setImage(splash);
		backgroundIcon.setImage(background);
		splashLabel.setIcon(splashIcon);
		backgroundLabel.setIcon(backgroundIcon);
		splashFrame = new JFrame();
		splashFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		nbLogo = new ImageIcon("images/nb.png");
		gladosLogo = nbLogo.getImage();
		splashFrame.setResizable(false);
		splashFrame.setTitle("Welcome to NB GLADOS");
		splashFrame.setSize(splashIcon.getIconWidth(), splashIcon.getIconHeight());
		splashFrame.setUndecorated(true);
		splashFrame.setLocation((int) screenSize.getWidth() / 2 - splashIcon.getIconWidth() / 2, (int) screenSize.getHeight() / 2 - splashIcon.getIconHeight() / 2);
		splashFrame.setIconImage(gladosLogo);
		splashFrame.add(splashLabel, BorderLayout.CENTER);
		splashFrame.setVisible(true);
		splashTimer.schedule(new deleteSplashTask(), 2000);
	}

	/**
	 * Task to initialise main UI elements
	 */
	private void initUi()
	{
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
		displayLogin();
	}

	/**
	 * Task to display and authenticate employee login
	 */
	public void displayLogin()
	{
		mainFrame.remove(assignOrder);
		mainFrame.remove(mapPanel);
		mainFrame.remove(orderButtons);
		mainFrame.remove(orderPanel);
		mainFrame.remove(fillPanel);
		mainFrame.invalidate();
		username.setFont(gladosFont);
		username.setPreferredSize(new Dimension(200, 30));
		buttonLayoutConstraints.gridx = 0;
		buttonLayoutConstraints.gridy = 0;
		loginPanel.add(username, buttonLayoutConstraints);
		password.setFont(gladosFont);
		password.setPreferredSize(new Dimension(200, 30));
		buttonLayoutConstraints.gridx = 1;
		buttonLayoutConstraints.gridy = 0;
		loginPanel.add(password, buttonLayoutConstraints);
		login.setText("Login");
		login.setPreferredSize(new Dimension(180, 50));
		login.setFont(gladosFont);
		buttonLayoutConstraints.gridx = 0;
		buttonLayoutConstraints.gridy = 1;
		loginPanel.add(login, buttonLayoutConstraints);
		loginPanel.setBackground(new Color(0, 0, 0, 0));
		fillPanel.setPreferredSize(new Dimension(screenSize.width, 680 / 3));
		fillPanel.setBackground(new Color(0, 0, 0, 0));
		mainFrame.getContentPane().add(fillPanel, BorderLayout.NORTH);
		mainFrame.getContentPane().add(loginPanel, BorderLayout.CENTER);
		mainFrame.revalidate();
		mainFrame.repaint();
	}

	/**
	 * Task to display the order screen with map
	 */
	private void displayGetOrder() 
	{
		mainFrame.getContentPane().remove(orderPanel);
		mainFrame.getContentPane().remove(mapPanel);
		mainFrame.getContentPane().remove(orderButtons);
		mainFrame.getContentPane().remove(loginPanel);
		mainFrame.getContentPane().remove(fillPanel);
		mainFrame.invalidate();
		fillPanel.setPreferredSize(new Dimension(screenSize.width, 680 / 3));
		fillPanel.setBackground(new Color(0, 0, 0, 0));
    	getNewOrder.setText("Assign yourself an order to process.");
    	getNewOrder.setPreferredSize(new Dimension(350, 100));
    	getNewOrder.setFont(gladosFont);
    	logout.setText("Log out");
    	logout.setPreferredSize(new Dimension(200, 100));
    	logout.setFont(gladosFont);
    	assignOrder.setBackground(new Color(0, 0, 0, 0));
    	buttonLayoutConstraints.gridx = 0;
    	buttonLayoutConstraints.gridy = 0;
    	assignOrder.add(getNewOrder, buttonLayoutConstraints);
    	buttonLayoutConstraints.gridx = 0;
    	buttonLayoutConstraints.gridy = 1;
    	assignOrder.add(logout, buttonLayoutConstraints);
    	mainFrame.getContentPane().add(fillPanel, BorderLayout.NORTH);
    	mainFrame.getContentPane().add(assignOrder, BorderLayout.CENTER);
    	mainFrame.revalidate();
    	mainFrame.repaint();
    }
    
    /**
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
     * Task to log the employee out
     */
    private void logout()
    {
    	mainFrame.setTitle("NB GLADOS");
    	username.setText("");
    	password.setText("");
    	displayLogin();
    }
    
    /**
     * Task to populate the map with nodes
     */
    private void buildMap()
    {
    	mapPanel.removeAll();
    	if(testPath.size() > 0 && testPath != null)
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
	    			    mapLabel[i][j] = new JLabel("*", SwingConstants.CENTER);//beginning
	    			    mapLabel[i][j].setForeground(Color.BLACK);
	    			    mapPanel.add(mapLabel[i][j]);
	    				break;
	    			case 2:
	    				mapLabel[i][j] = new JLabel("S", SwingConstants.CENTER);//shelf
	    				mapLabel[i][j].setForeground(Color.BLUE);
	    				mapPanel.add(mapLabel[i][j]);
	    				break;
	    			case 3:
	    				mapLabel[i][j] = new JLabel("G", SwingConstants.CENTER);//GDZ
	    				mapLabel[i][j].setForeground(Color.ORANGE);
	    				mapPanel.add(mapLabel[i][j]);
	    				break;
	    			case 4:
	    				mapLabel[i][j] = new JLabel("X", SwingConstants.CENTER);//route
	    				mapLabel[i][j].setForeground(Color.RED);
	    				mapPanel.add(mapLabel[i][j]);
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
	    			    mapLabel[i][j] = new JLabel("*", SwingConstants.CENTER);//beginning
	    			    mapLabel[i][j].setForeground(Color.BLACK);
	    			    mapPanel.add(mapLabel[i][j]);
	    				break;
	    			case 2:
	    				mapLabel[i][j] = new JLabel("S", SwingConstants.CENTER);//shelf
	    				mapLabel[i][j].setForeground(Color.BLUE);
	    				mapPanel.add(mapLabel[i][j]);
	    				break;
	    			case 3:
	    				mapLabel[i][j] = new JLabel("G", SwingConstants.CENTER);//GDZ
	    				mapLabel[i][j].setForeground(Color.ORANGE);
	    				mapPanel.add(mapLabel[i][j]);
	    				break;
	    			}
	    		}
	    	}
    	}
    }
    
    /**
     * Task to re/initialise the map
     */
    private void initMap()
    {
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
    }
    
    /**
     * Task to draw the map
     */
    /**
     * @author mwatson
     */
   	private void displayMap()
    {
   		mainFrame.getContentPane().remove(assignOrder);
    	mainFrame.getContentPane().remove(loginPanel);
    	mainFrame.getContentPane().remove(fillPanel);
   		mainFrame.invalidate();
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
   
    	
    	if(orderData.getProductIncrement() == order.getDopsOrder().size()){
    		testPath = warehouseMap.findPath(0, 0, orderData.getxProductLocation()[orderData.getProductIncrement()], orderData.getyProductLocation()[orderData.getProductIncrement()]);
    	}
    	if(orderData.getProductIncrement() <= order.getDopsOrder().size())
    	{
    		productName.setText("Product Name: " + orderData.getTestNames()[orderData.getProductIncrement()]);
    		quantity.setText("Quantity: " + orderData.getTestQuantities()[orderData.getProductIncrement()]  + "	Remaining Products: (" + (order.getDopsOrder().size() - orderData.getProductIncrement() - 1) + ")");
    		boxSize.setText("Box Type: " + orderData.getTestBoxes()[orderData.getProductIncrement()]);
    	}
    	if(orderData.isGdz())
    	{
    		productName.setText("Take products to GDZ");
        	quantity.setText("");
        	boxSize.setText("");
    	}
    	
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
    	orderButtons.add(completeOrder);
    	nextProduct.setText("Route to next Product");
    	nextProduct.setPreferredSize(new Dimension(240, 80));
    	nextProduct.setFont(gladosFont);
    	orderButtons.add(nextProduct);
    	mainFrame.getContentPane().add(orderPanel, BorderLayout.NORTH);
    	mainFrame.getContentPane().add(mapPanel, BorderLayout.CENTER);
    	mainFrame.getContentPane().add(orderButtons, BorderLayout.SOUTH);
    	mainFrame.revalidate();
    	mainFrame.repaint();
    }
}