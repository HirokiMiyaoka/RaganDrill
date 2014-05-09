package net.azulite.RaganDrill;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
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
		dirchooser = new DirectoryChooser[ 2 ];
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

		JPanel imgpanel = new JPanel();
		imgpanel.setLayout( new BorderLayout() );
		imgpanel.add( BorderLayout.WEST, new JSlider( JSlider.VERTICAL ) );
		imgpanel.add( BorderLayout.EAST, new JSlider( JSlider.VERTICAL ) );

		panel.add( BorderLayout.CENTER, imgpanel );
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

@SuppressWarnings("serial")
class DirectoryChooser extends JButton implements ActionListener
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

@SuppressWarnings("serial")
class ImageFileChooser extends JButton implements ActionListener
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

@SuppressWarnings("serial")
class IconFileChooser extends JButton implements ActionListener
{
	private String path;
	private JTextField field;

	public IconFileChooser( String str, JFrame frame, JTextField field )
	{
		super( str );
		this.addActionListener( this );

		path = "";
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
		dirchooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		// TODO: PNG Filter.

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

class DropImageFiles implements DropTargetListener
{
	private ArrayList<String> list;

	public void add( String str )
	{
		list.add( str );
	}

	@Override
	public void dragEnter(DropTargetDragEvent arg0)
	{
		
	}
	@Override
	public void dragExit(DropTargetEvent arg0)
	{
		
	}
	@Override
	public void dragOver(DropTargetDragEvent arg0)
	{
		
	}

	@Override
	public void drop(DropTargetDropEvent arg0)
	{
		Transferable t = arg0.getTransferable();
		if ( t.isDataFlavorSupported( DataFlavor.javaFileListFlavor ) )
		{
			arg0.acceptDrop( DnDConstants.ACTION_COPY_OR_MOVE );
			try
			{
				@SuppressWarnings( "unchecked" )
				List<File> fileList = (List<File>)t.getTransferData( DataFlavor.javaFileListFlavor );
				for (File file : fileList)
				{
					list.add( file.getPath() );
				}
			} catch ( UnsupportedFlavorException ex )
			{
				throw new RuntimeException( ex );
			} catch ( IOException ex )
			{
				throw new RuntimeException(ex);
			}
		}
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent arg0)
	{
		
	}

	public String[] get()
	{
		return (String[])list.toArray();
	}
	public void reset()
	{
		list = new ArrayList<String>();
	}

}

class IntegerInputVerifier extends InputVerifier
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

class DPISelecter
{
	private ArrayList<JCheckBox> clist;
	private ArrayList<Integer> tlist;

	public DPISelecter()
	{
		clist = new ArrayList<JCheckBox>();
		tlist = new ArrayList<Integer>();
	}

	public JCheckBox addItem( int type )
	{
		JCheckBox checkbox = new JCheckBox( DPIList.getDPIName( type ) );
		checkbox.setSelected( true );
		clist.add( checkbox );
		tlist.add( type );

		return checkbox;
	}

	public int[] get( boolean target )
	{
		int i;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for ( i = 0 ; i < clist.size() ; ++i )
		{
			if ( clist.get( i ).isSelected() )
			{
				list.add( tlist.get( i ) );
			}
		}

		if ( list.size() <= 0 ){ return new int[ 0 ]; }

		int[] ret = new int[ list.size() ];
		for ( i = 0 ; i < list.size() ; ++i )
		{
			ret[ i ] = list.get( i );
		}

		return ret;
	}
}

class IconSelecter
{
	private ArrayList<JCheckBox> clist;
	private ArrayList<Integer> tlist;

	public IconSelecter()
	{
		clist = new ArrayList<JCheckBox>();
		tlist = new ArrayList<Integer>();
	}

	public JCheckBox addItem( int type )
	{
		JCheckBox checkbox = new JCheckBox( IconList.getIconName( type ) );
		checkbox.setSelected( true );
		clist.add( checkbox );
		tlist.add( type );

		return checkbox;
	}

	public int[] get( boolean target )
	{
		int i;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for ( i = 0 ; i < clist.size() ; ++i )
		{
			if ( clist.get( i ).isSelected() )
			{
				list.add( tlist.get( i ) );
			}
		}

		if ( list.size() <= 0 ){ return new int[ 0 ]; }

		int[] ret = new int[ list.size() ];
		for ( i = 0 ; i < list.size() ; ++i )
		{
			ret[ i ] = list.get( i );
		}

		return ret;
	}
}
