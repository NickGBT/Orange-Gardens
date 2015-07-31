package com.netbuilder.orange_dops;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class Map extends JPanel
{
    public Map() 
    {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < 20; row++) 
        {
            for (int col = 0; col < 20; col++)
            {
                gbc.gridx = col;
                gbc.gridy = row;

                JPanel panel = new JPanel();
                Border border = null;
                if (row < 19)
                {
                    if (col < 19)
                    {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    }
                    else 
                    {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                }
                else 
                {
                    if (col < 19) 
                    {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } 
                    else
                    {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                panel.setBorder(border);
                add(panel, gbc);
            }
        }
    }
}