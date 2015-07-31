package com.netbuilder.orange_dops;

import java.awt.BorderLayout;
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
import java.sql.ResultSet;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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
	private JPanel assignOrder, orderButtons, orderPanel;
	private BufferedImage splash, background;
	private Timer splashTimer;
	private ImageIcon splashIcon, nbLogo, backgroundIcon;
	private Dimension screenSize;
	private JButton getNewOrder, completeOrder, nextProduct;
	private GridBagLayout buttonLayout;
	private GridBagConstraints buttonLayoutConstraints;
	private ImagePanel backgroundPanel;
	private Font gladosFont;
	private int mapCount;
	private JTextField productName, quantity, boxSize;
	
	/**
	 * @author JustinMabbutt
	 * Initialise appearance
	 */
	public GladosGui() 
	{
		logger.entering(getClass().getName(), "IMSGUI");
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
		assignOrder = new JPanel(); orderButtons = new JPanel(); orderPanel = new JPanel();
		splashIcon = new ImageIcon(); backgroundIcon = new ImageIcon();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		getNewOrder = new JButton(); completeOrder = new JButton(); nextProduct = new JButton();
		productName = new JTextField(35); quantity = new JTextField(35); boxSize = new JTextField(35);
		splash = null; background = null;
		splashTimer = new Timer();
		buttonLayout = new GridBagLayout();
		mapCount = 0;
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
					//completeOrder.repaint();
					//nextProduct.repaint();
					orderButtons.repaint();
					orderPanel.repaint();
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
		logger.exiting(getClass().getName(), "IMSGUI");
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
     * Task to draw the map
     */
   	private void displayMap()
    {
   		mainFrame.getContentPane().remove(assignOrder);
   		mainFrame.invalidate();
    	//1 = Beginning
    	//2 = Possible route
    	//3 = Shelf
    	//4 = Possible pickup location
    	//5 = GDZ
    	int[][] testMap = new int[][] { 
    			{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
    			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 4, 3, 4, 2},
    			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
    			{2, 2, 5, 2, 2, 5, 2, 2, 5, 2, 2, 5, 2, 2, 5, 2, 2, 5, 2, 2}
    	};
    	
    	for(int x = 0; x < 20; x++)
        {
    		if(mapCount >= 19)
    		{
    			System.out.println("\n");
    			mapCount = 0;
    		}
            for(int y = 0; y < 20; y++)
            {
                if(testMap[x][y] == 1)
                {
                	System.out.print("B ");//beginning
                	mapCount++;
                }            
                else if(testMap[x][y] == 2)
                {
                	System.out.print("* ");//possible route
                	mapCount++;
                }
                else if(testMap[x][y] == 3)
                {
                	System.out.print("S ");//shelf
                	mapCount++;
                }
                else if(testMap[x][y] == 4)
                {
                	System.out.print("P ");//possible pickup location
                	mapCount++;
                }
                else if(testMap[x][y] == 5)
                {
                    System.out.print("G ");//GDZ
                    mapCount++;
                }
            }
        }	
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
				
			}
		});
    	orderButtons.add(nextProduct);
    	mainFrame.getContentPane().add(orderPanel);
    	mainFrame.getContentPane().add(orderButtons, BorderLayout.SOUTH);
    	mainFrame.revalidate();
    	mainFrame.repaint();
    }
   	
   	/**
   	 * @author JustinMabbutt
   	 * 
   	 */
   	private void displayOrderComplete()
   	{
   		mainFrame.remove(orderPanel);
   		mainFrame.remove(orderButtons);
   		mainFrame.invalidate();
   	}
}