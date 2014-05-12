package net.azulite.RaganDrill;

/**
 * GUI Tab base.
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TabImage extends TabBase
{
	private ImageFileChooser imgchooser;
	private JTextField dpi;
	private DPISelecter dpiselecter;
	private JScrollPane imgpanel;

	public TabImage( DropImageFiles imgfiles )
	{
		super( imgfiles );
	}

	public JPanel createTab( JFrame frame )
	{
		super.createTab( frame );

		mainpanel.setLayout( new BorderLayout() );

		JPanel panel = new JPanel();
		panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );

		panel.add( new JLabel( "Output" ) );
		panel.add( this.addDirButton( frame ) );

		panel.add( new JLabel( "Input" ) );
		panel.add( this.addImageButton( frame ) );

		dpi = this.addInDPI();
		panel.add( new JLabel( "InputDPI" ) );
		panel.add( dpi );

		this.addOutDPI( panel );

		panel.add( new JLabel( "Images" ) );


		mainpanel.add( BorderLayout.NORTH, panel );
		mainpanel.add( BorderLayout.CENTER, this.addImagePane() );
		mainpanel.add( BorderLayout.SOUTH, new ConvertButton() );

		return mainpanel;
	}

	public void convert()
	{
	}

	private JPanel addImageButton( JFrame frame )
	{
		JTextField field = new JTextField();
		imgchooser = new ImageFileChooser( "Image file(PNG)", frame, field, imgfiles );
		JPanel buttonPanel = new JPanel();
		buttonPanel.add( imgchooser );

		JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );

		panel.add( BorderLayout.CENTER, field );
		panel.add( BorderLayout.EAST, imgchooser );

		return panel;
	}

	protected void addOutDPI( JPanel mainpanel )
	{
		dpiselecter = new DPISelecter();

		mainpanel.add( new JLabel( "Output image dpi" ) );

		JPanel panel = new JPanel();
		panel.setLayout( new FlowLayout() );
		panel.add( dpiselecter.addItem( DPIList.ANDROID_LDPI ) );
		panel.add( dpiselecter.addItem( DPIList.ANDROID_MDPI ) );
		panel.add( dpiselecter.addItem( DPIList.ANDROID_HDPI ) );
		panel.add( dpiselecter.addItem( DPIList.ANDROID_XDPI ) );
		panel.add( dpiselecter.addItem( DPIList.ANDROID_XXHDPI ) );
		mainpanel.add( panel );

		panel = new JPanel();
		panel.setLayout( new FlowLayout() );
		panel.add( dpiselecter.addItem( DPIList.IOS_LDPI ) );
		panel.add( dpiselecter.addItem( DPIList.IOS_HDPI ) );
		mainpanel.add( panel );
	}

	protected JScrollPane addImagePane()
	{
		imgpanel = new JScrollPane( new JLabel( "no image." ) );
		return imgpanel;
	}

	public void dropAction()
	{
	}
}

