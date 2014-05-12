package net.azulite.RaganDrill;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI Tab base.
 */

public class TabBase
{
	protected JPanel mainpanel;
	protected DirectoryChooser dirchooser;
	protected DropImageFiles imgfiles;

	public TabBase( DropImageFiles imgfiles )
	{
		this.imgfiles = imgfiles;
	}

	public JPanel createTab( JFrame frame )
	{
		mainpanel =  new JPanel();
		return mainpanel;
	}

	public void convert()
	{
	}

	protected JPanel addDirButton( JFrame frame )
	{
		JTextField field = new JTextField();
		dirchooser = new DirectoryChooser( "Output Directory", frame, field );

		JPanel buttonPanel = new JPanel();
		buttonPanel.add( dirchooser );

		JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );

		panel.add( BorderLayout.CENTER, field );
		panel.add( BorderLayout.EAST, dirchooser );

		return panel;
	}

	protected JTextField addInDPI()
	{
		JTextField dpi = new JTextField();
		dpi.setText( "160" );
		dpi.setHorizontalAlignment( JTextField.RIGHT );
		dpi.setInputVerifier( new IntegerInputVerifier() );

		return dpi;
	}

	@SuppressWarnings("serial")
	protected class ConvertButton extends JButton implements ActionListener
	{
		public ConvertButton()
		{
			super( "Convert" );
			this.addActionListener( this );
		}
		@Override
		public void actionPerformed( ActionEvent arg0 )
		{
			convert();
		}
	}

	public void dropAction()
	{
	}
}
