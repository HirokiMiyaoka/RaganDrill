package net.azulite.RaganDrill;

/**
 * GUI parts( select image file ).
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ImageFileChooser extends JButton implements ActionListener
{
	private String path;
	private JTextField field;
	private DropImageFiles drop;

	public ImageFileChooser( String str, JFrame frame, JTextField field, DropImageFiles drop )
	{
		super( str );
		this.addActionListener( this );

		path = "";
		this.field = field;
		this.drop = drop;

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
		dirchooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		// TODO: PNG Filter.

		int selected = dirchooser.showOpenDialog( this );
		if ( selected == JFileChooser.APPROVE_OPTION )
		{
			File file = dirchooser.getSelectedFile();
			path = file.getPath();
			this.printLabel();
			drop.add( path );
		}else if (selected == JFileChooser.CANCEL_OPTION)
		{
			// Cancel
		}else if (selected == JFileChooser.ERROR_OPTION)
		{
			// Error?
		}
	}

}