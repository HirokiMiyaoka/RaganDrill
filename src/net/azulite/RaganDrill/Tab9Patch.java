package net.azulite.RaganDrill;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI Tab base.
 */

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
		panel.add( canvas.getImageFileChooser( frame ) );

		dpi = this.addInDPI();
		panel.add( new JLabel( "InputDPI" ) );
		panel.add( dpi );

		this.addOutDPI( panel );

		panel.add( new JLabel( "9Patch" ) );

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
		return mainpanel;
	}

	public void convert()
	{
	}
}
