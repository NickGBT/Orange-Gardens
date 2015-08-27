package com.netbuilder.orange_dops;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class ImagePanel extends JPanel 
{
	private static final long serialVersionUID = -4377283619239711907L;
	private Image img;
	private static final Logger logger = LogManager.getLogger();

	public ImagePanel(String img)
	{
		this(new ImageIcon(img).getImage());
	}

	/**
	 * draw custom panel with image background
	 * @param img background
	 */
	public ImagePanel(Image img)
	{
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g)
	{
		logger.info("Drawing background image", img);
		g.drawImage(img, 0, 0, null);
	}
}