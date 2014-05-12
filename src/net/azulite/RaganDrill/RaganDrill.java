package net.azulite.RaganDrill;

/**
 * GUI
 */

import java.awt.BorderLayout;
import java.awt.dnd.DropTarget;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

class RaganDrill
{
	// Main
	private JFrame frame;
	private JTabbedPane tab;

	// Tab
	TabIcon tabicon;
	TabImage tabimage;
	Tab9Patch tab9patch;

	public static void main (String[] args)
	{
		RaganDrill rd = new RaganDrill();
		if ( args.length == 0 )
		{
			rd.InitGUI();
		}
	}

	public RaganDrill()
	{
	}

	public void InitGUI()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		DropImageFiles imgfiles = new DropImageFiles();
		
		tab = new JTabbedPane();

		frame.setLayout( new BorderLayout() );

		// Add tab page.
		tabicon = new TabIcon( imgfiles );
		tabimage = new TabImage( imgfiles );
		tab9patch = new Tab9Patch( imgfiles );
		
		tab.addTab( "Icon", tabicon.createTab( frame ) );
		tab.addTab( "Image", tabimage.createTab( frame ) );
		tab.addTab( "9Patch", tab9patch.createTab( frame ) );

		frame.setDropTarget( new DropTarget( frame, imgfiles ) );
		frame.getContentPane().add( BorderLayout.CENTER, tab );

		frame.setTitle( "RaganDrill" );

		frame.pack();
		frame.setLocationRelativeTo( null );

		frame.setVisible( true );
	}

}

