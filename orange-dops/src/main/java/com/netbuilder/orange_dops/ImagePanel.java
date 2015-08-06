package com.netbuilder.orange_dops;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class ImagePanel extends JPanel
{
	private static final long serialVersionUID = -4377283619239711907L;
	
	private Image img;
	private static final Logger logger = Logger.getLogger(ImagePanel.class.getName());

	public ImagePanel(String img)
	{
		this(new ImageIcon(img).getImage());
	}
	
	public ImagePanel(Image img)
	{
		logger.entering(getClass().getName(), "ImagePanel");
		this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	    logger.exiting(getClass().getName(), "ImagePanel");
	}
	
	public void paintComponent(Graphics g)
	{
		logger.entering(getClass().getName(), "paintComponent");
	    g.drawImage(img, 0, 0, null);
	    logger.exiting(getClass().getName(), "paintComponent");
	}
}