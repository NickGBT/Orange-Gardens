package com.netbuilder.orange_dops;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import com.netbuilder.orange_dops_enums.GladosStatus;

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
	private JPanel assignOrder;
	private BufferedImage splash, title, background;
	private Timer splashTime;
	private Random randomGenerator;
	private ImageIcon splashIcon, nbLogo, backgroundIcon;
	private Dimension screenSize;
	private String[] topMessage, bottomMessage;
	private JButton getNewOrder, completeOrder, nextProduct;
	private GladosStatus gladosStatus;
	private int messageIndex;
	private GridBagLayout buttonLayout;
	private GridBagConstraints buttonLayoutConstraints;
	private Font buttonFont;
	private boolean isRunning;
	
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
		randomGenerator = new Random();
		splashLabel = new JLabel(); backgroundLabel = new JLabel();
		splashTime = new Timer();
		assignOrder = new JPanel();
		splashIcon = new ImageIcon(); backgroundIcon = new ImageIcon();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		getNewOrder = new JButton(); completeOrder = new JButton(); nextProduct = new JButton();
		splash = null; background = null;
		messageIndex = 0;
		topMessage = new String[11]; bottomMessage = new String[11];
		buttonLayout = new GridBagLayout();
		buttonLayoutConstraints = new GridBagConstraints();
		buttonFont = new Font("Arial", Font.BOLD, 18);
		isRunning = true;
		gladosStatus = GladosStatus.displaySplash;
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
        splashFrame.setTitle("Welcome to GLADOS");
        splashFrame.setSize(splashIcon.getIconWidth(), splashIcon.getIconHeight());  
        splashFrame.setUndecorated(true);
        splashFrame.setLocation((int)screenSize.getWidth() / 2 - splashIcon.getIconWidth() / 2, (int)screenSize.getHeight() / 2 - splashIcon.getIconHeight() / 2);
        splashFrame.setIconImage(gladosLogo);
		splashFrame.add(splashLabel, BorderLayout.CENTER);
		splashFrame.setVisible(true);
		splashTime.schedule(new deleteSplashTask(), 2000);
		logger.exiting(getClass().getName(), "displaySplash");
	}
	
	/**
	 * @author: JustinMabbutt
	 * Task to initialise main UI elements
	 */
	private void initUi()
	{
		logger.entering(getClass().getName(), "initUi");
		mainFrame = new JFrame("NB GLADOS")
		{
			public void paint(Graphics g)
			{
				super.paint(g);
				g.drawImage(background, 0, 0, null);
			}
		};
        mainFrame.setSize(500, 680);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        nbLogo = new ImageIcon("images/nb.png");
        mainFrame.setIconImage(gladosLogo);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
        while(isRunning)
        {
	        switch(gladosStatus)
	        {
	        case displayGetOrder:
	        	assignMessages();
	        	getNewOrder.setText("Assign yourself an order to process.");
	        	getNewOrder.setPreferredSize(new Dimension(350, 150));
	        	getNewOrder.setFont(buttonFont);
	        	getNewOrder.addActionListener(new ActionListener() 
	        	{
					public void actionPerformed(ActionEvent arg0) 
					{
						gladosStatus = GladosStatus.displayOrder;
					}
				});
	        	buttonLayoutConstraints.fill = buttonLayoutConstraints.CENTER;
	        	assignOrder.add(getNewOrder);
	        	buttonLayout.setConstraints(assignOrder, buttonLayoutConstraints);
	        	assignOrder.setLayout(buttonLayout);
	        	mainFrame.add(assignOrder);
	        	break;
	        case displayOrder:
	        	
	        	break;
	        case displayOrderComplete:
	        	
	        	break;
	    	default:
	    		break;
	        }
        }
		logger.exiting(getClass().getName(), "initUi");
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
   			gladosStatus = GladosStatus.displayGetOrder;				
			splashTime.cancel();
			initUi();
   		}
   	}
    
    /**
     * @author JustinMabbutt
     * Task to assign completed order messages
     */
    private void assignMessages()
    {
    	logger.entering(getClass().getName(), "assignMessages");
    	topMessage[0] = "Pick up gnome";
    	bottomMessage[0] = "Gnome goes in box";
    	topMessage[1] = "Don't just stand there";
    	bottomMessage[1] = "Pack stuff!";
    	topMessage[2] = "All your diseases";
    	bottomMessage[2] = "are like love to me";
    	topMessage[3] = "You got the touch";
    	bottomMessage[3] = "You got the pow-ah!";
    	topMessage[4] = "Are you even";
    	bottomMessage[4] = "still reading these?";
    	topMessage[5] = "Don't just stand there";
    	bottomMessage[5] = "Pack stuff!";
    	topMessage[6] = "You have no order assigned";
    	bottomMessage[6] = "Rectify this situation";
    	topMessage[7] = "Touch my face";
    	bottomMessage[7] = "Touch it!";
    	topMessage[8] = "Yaaaay";
    	bottomMessage[8] = "Yaaaaaaaaaay!";
    	topMessage[9] = "Lets get this";
    	bottomMessage[9] = "over with";
    	topMessage[10] = "Doobie Doobie";
    	bottomMessage[10] = "Doo da day!";
    	logger.exiting(getClass().getName(), "assignMessages");
    }
    
    /**
     * @author JustinMabbutt
     */
    private void drawMap()
    {
    	
    }
}