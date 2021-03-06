package com.netbuilder.orange_dops;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class LoginTextField extends JTextField 
{
	private static final long serialVersionUID = 5878905683983754920L;

	public LoginTextField(final String promptText) 
	{
		super(promptText);
		addFocusListener(new FocusListener()
		{
			@Override
			public void focusLost(FocusEvent e) 
			{
				if (getText().isEmpty())
				{
					setText(promptText);
				}
			}

			@Override
			public void focusGained(FocusEvent e)
			{
				if (getText().equals(promptText))
				{
					setText("");
				}
			}
		});
	}
}