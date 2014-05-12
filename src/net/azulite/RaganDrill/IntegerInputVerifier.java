package net.azulite.RaganDrill;

/**
 * Support input text( check number ).
 */

import java.awt.Color;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class IntegerInputVerifier extends InputVerifier
{
	@Override
	public boolean verify( JComponent c )
	{
		boolean verified = false;
		JTextField textField = (JTextField)c;
		try
		{
			Float.parseFloat( textField.getText() );
			verified = true;
			c.setBackground( Color.white );
		}catch( NumberFormatException e )
		{
			c.setBackground( Color.pink );
		}
		
		return verified;
	}
}
