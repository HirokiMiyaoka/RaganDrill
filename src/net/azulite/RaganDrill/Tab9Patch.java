package net.azulite.RaganDrill;

/**
 * GUI Tab base.
 */

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tab9Patch extends TabImage
{
	private NinePatchCanvas canvas;
	private JTextField dpi;

	public Tab9Patch( DropImageFiles imgfiles )
	{
		super( imgfiles );
	}

	public JPanel createTab( JFrame frame )
	{
		super.createTab( frame );
		mainpanel.setLayout( new BorderLayout() );

		canvas = new NinePatchCanvas();

		JPanel panel = new JPanel();
		panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );

		panel.add( new JLabel( "Output" ) );
		panel.add( this.addDirButton( frame ) );

		panel.add( new JLabel( "Input" ) );
		panel.add( canvas.getImageFileChooser( frame, imgfiles ) );

		dpi = this.addInDPI();
		panel.add( new JLabel( "InputDPI" ) );
		panel.add( dpi );

		this.addOutDPI( panel );

		JPanel titlepanel = new JPanel();
		titlepanel.setLayout( new BorderLayout() );
		titlepanel.add( BorderLayout.CENTER, new JLabel( "9Patch" ) );
		titlepanel.add( BorderLayout.EAST, canvas.getSymmetry() );

		panel.add( titlepanel );

		JPanel udpanel = new JPanel();
		udpanel.setLayout( new BorderLayout() );
		udpanel.add( BorderLayout.NORTH, canvas.getSlider( 0 ) );
		udpanel.add( BorderLayout.SOUTH, canvas.getSlider( 1 ) );
		udpanel.add( BorderLayout.CENTER, canvas );

		JPanel lrpanel = new JPanel();
		lrpanel.setLayout( new BorderLayout() );
		lrpanel.add( BorderLayout.WEST, canvas.getSlider( 2 ) );
		lrpanel.add( BorderLayout.EAST, canvas.getSlider( 3 ) );
		lrpanel.add( BorderLayout.NORTH, panel );
		lrpanel.add( BorderLayout.CENTER, udpanel );

		mainpanel.add( BorderLayout.CENTER, lrpanel );
		mainpanel.add( BorderLayout.SOUTH, new ConvertButton() );

		return mainpanel;
	}

	public void convert()
	{
	}

	public void dropAction()
	{
		String file = imgfiles.getLast();
		try
		{
			FileInputStream is = new FileInputStream( file );
			canvas.addImage( ImageIO.read( is ) );
			canvas.repaint();
		} catch (FileNotFoundException e)
		{
		} catch (IOException e)
		{
		}
	}
}
