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
import javax.swing.JTextField;

public class TabIcon extends TabBase
{
	private IconFileChooser iconchooser;
	private IconSelecter iconselecter;
	private JPanel imgpanel;

	public TabIcon( DropImageFiles imgfiles )
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
		panel.add( this.addIconButton( frame ) );

		this.addOutIcon( panel );

		imgpanel = new JPanel();
		imgpanel.setLayout( new BorderLayout() );
		imgpanel.add( BorderLayout.CENTER, new JLabel( "no image." ) );

		mainpanel.add( BorderLayout.NORTH, panel );
		mainpanel.add( BorderLayout.CENTER, imgpanel );
		mainpanel.add( BorderLayout.SOUTH, new ConvertButton() );

		return mainpanel;
	}

	public void convert()
	{
	}

	private JPanel addIconButton( JFrame frame )
	{
		JTextField field = new JTextField();
		iconchooser = new IconFileChooser( "Icon file(PNG)", frame, field );
		JPanel buttonPanel = new JPanel();
		buttonPanel.add( iconchooser );

		JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );

		panel.add( BorderLayout.CENTER, field );
		panel.add( BorderLayout.EAST, iconchooser );

		return panel;
	}

	protected void addOutIcon( JPanel mainpanel )
	{
		iconselecter = new IconSelecter();

		mainpanel.add( new JLabel( "Output icon" ) );

		JPanel panel = new JPanel();
		panel.setLayout( new FlowLayout() );
		panel.add( iconselecter.addItem( IconList.PLAYSTORE ) );
		panel.add( iconselecter.addItem( IconList.APPSTORE_LDPI ) );
		panel.add( iconselecter.addItem( IconList.APPSTORE_HDPI ) );
		mainpanel.add( panel );

		panel = new JPanel();
		panel.setLayout( new FlowLayout() );
		panel.add( iconselecter.addItem( IconList.ANDROID_LDPI ) );
		panel.add( iconselecter.addItem( IconList.ANDROID_MDPI ) );
		panel.add( iconselecter.addItem( IconList.ANDROID_HDPI ) );
		panel.add( iconselecter.addItem( IconList.ANDROID_XDPI ) );
		panel.add( iconselecter.addItem( IconList.ANDROID_XXHDPI ) );
		mainpanel.add( panel );

		panel = new JPanel();
		panel.setLayout( new FlowLayout() );
		panel.add( iconselecter.addItem( IconList.IOS_6_LDPI ) );
		panel.add( iconselecter.addItem( IconList.IOS_6_HDPI ) );
		panel.add( iconselecter.addItem( IconList.IOS_6_SMALL_LDPI ) );
		panel.add( iconselecter.addItem( IconList.IOS_6_SMALL_HDPI ) );
		mainpanel.add( panel );

		panel = new JPanel();
		panel.setLayout( new FlowLayout() );
		panel.add( iconselecter.addItem( IconList.IOS_7_DPI ) );
		panel.add( iconselecter.addItem( IconList.IOS_7_SMALL ) );
		mainpanel.add( panel );

		panel = new JPanel();
		panel.setLayout( new FlowLayout() );
		panel.add( iconselecter.addItem( IconList.IPAD_6_LDPI ) );
		panel.add( iconselecter.addItem( IconList.IPAD_6_HDPI ) );
		panel.add( iconselecter.addItem( IconList.IPAD_6_SMALL_LDPI ) );
		panel.add( iconselecter.addItem( IconList.IPAD_6_SMALL_HDPI ) );
		mainpanel.add( panel );

		panel = new JPanel();
		panel.setLayout( new FlowLayout() );
		panel.add( iconselecter.addItem( IconList.IPAD_7_LDPI ) );
		panel.add( iconselecter.addItem( IconList.IPAD_7_HDPI ) );
		panel.add( iconselecter.addItem( IconList.IPAD_7_SMALL_LDPI ) );
		panel.add( iconselecter.addItem( IconList.IPAD_7_SMALL_HDPI ) );
		mainpanel.add( panel );
	}

	public void dropAction()
	{
	}
}
