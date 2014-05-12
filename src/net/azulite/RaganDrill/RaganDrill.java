package net.azulite.RaganDrill;

/**
 * GUI
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

class RaganDrill
{
	private JFrame frame;
	private JTabbedPane tab;
	public DirectoryChooser[] dirchooser;
	public ImageFileChooser imgchooser;
	public IconFileChooser iconchooser;
	public DPISelecter dpiselecter;
	public IconSelecter iconselecter;
	public JTextField dpi;
	public DropImageFiles imgfiles;
	public NinePatchCanvas canvas;

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
		dirchooser = new DirectoryChooser[ 3 ];
	}

	public void InitGUI()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		imgfiles = new DropImageFiles();
		
		tab = new JTabbedPane();

		frame.setLayout( new BorderLayout() );

		tab.addTab( "Icon", this.addTabIcon() );
		tab.addTab( "Image", this.addTabImage() );
		tab.addTab( "9Patch", this.addTab9Patch() );

		frame.setDropTarget( new DropTarget( frame, imgfiles ) );
		frame.getContentPane().add( BorderLayout.CENTER, tab );

		frame.setTitle( "RaganDrill" );

		frame.pack();
		frame.setLocationRelativeTo( null );

		frame.setVisible( true );
	}

	private JPanel addTabImage()
	{
		JPanel ret = new JPanel();
		ret.setLayout( new BorderLayout() );

		JPanel panel = new JPanel();
		panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );

		this.addDirButton( panel, 0 );
		this.addImageButton( panel );
		this.addInDPI( panel );
		this.addOutDPI( panel );

		ret.add( BorderLayout.NORTH, panel );
		ret.add( BorderLayout.SOUTH, new ConvertButton() );

		return ret;
	}

	private JPanel addTabIcon()
	{
		JPanel ret = new JPanel();
		ret.setLayout( new BorderLayout() );

		JPanel panel = new JPanel();
		panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );

		this.addDirButton( panel, 1 );
		this.addIconButton( panel );
		this.addOutIcon( panel );

		ret.add( BorderLayout.NORTH, panel );
		ret.add( BorderLayout.SOUTH, new ConvertButton() );

		return ret;
	}

	private JPanel addTab9Patch()
	{
		JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );

		canvas = new NinePatchCanvas();

		JPanel option = new JPanel();
		option.setLayout( new BoxLayout( option, BoxLayout.Y_AXIS ) );
		this.addDirButton( option, 2 );
		option.add( new JLabel( "Input" ) );
		option.add( canvas.getImageFileChooser( frame ) );
		this.addInDPI( option );
		this.addOutDPI( option );

		JPanel udpanel = new JPanel();
		udpanel.setLayout( new BorderLayout() );
		udpanel.add( BorderLayout.NORTH, canvas.getSlider( 0 ) );
		udpanel.add( BorderLayout.SOUTH, canvas.getSlider( 1 ) );
		udpanel.add( BorderLayout.CENTER, canvas );

		JPanel lrpanel = new JPanel();
		lrpanel.setLayout( new BorderLayout() );
		lrpanel.add( BorderLayout.WEST, canvas.getSlider( 2 ) );
		lrpanel.add( BorderLayout.EAST, canvas.getSlider( 3 ) );
		lrpanel.add( BorderLayout.NORTH, option );
		lrpanel.add( BorderLayout.CENTER, udpanel );

		panel.add( BorderLayout.CENTER, lrpanel );
		return panel;
	}

	private void addDirButton( JPanel mainpanel, int target )
	{
		JTextField field = new JTextField();
		dirchooser[ target ] = new DirectoryChooser( "Output Directory", frame, field );

		JPanel buttonPanel = new JPanel();
		buttonPanel.add( dirchooser[ target ] );

		JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );

		panel.add( BorderLayout.CENTER, field );
		panel.add( BorderLayout.EAST, dirchooser[ target ] );

		mainpanel.add( new JLabel( "Output" ) );
		mainpanel.add( panel );
	}

	private void addImageButton( JPanel mainpanel )
	{
		JTextField field = new JTextField();
		imgchooser = new ImageFileChooser( "Image file(PNG)", frame, field, imgfiles );
		JPanel buttonPanel = new JPanel();
		buttonPanel.add( imgchooser );

		JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );

		panel.add( BorderLayout.CENTER, field );
		panel.add( BorderLayout.EAST, imgchooser );

		mainpanel.add( new JLabel( "Input" ) );
		mainpanel.add( panel );
	}

	private void addIconButton( JPanel mainpanel )
	{
		JTextField field = new JTextField();
		iconchooser = new IconFileChooser( "Icon file(PNG)", frame, field );
		JPanel buttonPanel = new JPanel();
		buttonPanel.add( iconchooser );

		JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );

		panel.add( BorderLayout.CENTER, field );
		panel.add( BorderLayout.EAST, iconchooser );

		mainpanel.add( new JLabel( "Input" ) );
		mainpanel.add( panel );
	}

	private void addInDPI( JPanel mainpanel )
	{
		dpi = new JTextField();
		dpi.setText( "160" );
		dpi.setHorizontalAlignment( JTextField.RIGHT );
		dpi.setInputVerifier( new IntegerInputVerifier() );

		mainpanel.add( new JLabel( "InputDPI" ) );
		mainpanel.add( dpi );
	}

	private void addOutDPI( JPanel mainpanel )
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

	private void addOutIcon( JPanel mainpanel )
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

	@SuppressWarnings("serial")
	class ConvertButton extends JButton implements ActionListener
	{

		public ConvertButton()
		{
			super( "Convert" );
			this.addActionListener( this );
		}

		@Override
		public void actionPerformed( ActionEvent arg0 )
		{
			ConvertImage convert = new ConvertImage();
			//convert.setInputDPI( dpi );
			convert.setDelimiter( "\\" );
			//convert.setDocumentRoot(path);
		}
		
	}
}

