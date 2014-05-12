package net.azulite.RaganDrill;

/**
 * GUI parts( select output directory ).
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class DirectoryChooser extends JButton implements ActionListener
{
	private String path;
	private JTextField field;

	public DirectoryChooser( String str, JFrame frame, JTextField field )
	{
		super( str );
		this.addActionListener( this );

		path = new File( "." ).getAbsolutePath();
		this.field = field;

		this.printLabel();
	}
	private void printLabel()
	{
		field.setText( path );
	}

	public String getPath()
	{
		return path;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		JFileChooser dirchooser = new JFileChooser();
		dirchooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );

		int selected = dirchooser.showOpenDialog( this );
		if ( selected == JFileChooser.APPROVE_OPTION )
		{
			File file = dirchooser.getSelectedFile();
			path = file.getPath();
			this.printLabel();
		}else if (selected == JFileChooser.CANCEL_OPTION)
		{
			// Cancel
		}else if (selected == JFileChooser.ERROR_OPTION)
		{
			// Error?
		}
	}
}
