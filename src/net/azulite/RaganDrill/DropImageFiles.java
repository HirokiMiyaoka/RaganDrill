package net.azulite.RaganDrill;

/**
 * Support Drag & Drop.
 */

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DropImageFiles implements DropTargetListener
{
	private ArrayList<String> list;
	private RaganDrill gui;

	public DropImageFiles( RaganDrill gui )
	{
		list = new ArrayList<String>();
		this.gui = gui;
	}

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
			gui.dropAction();
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

	public String getLast()
	{
		return list.get( list.size() - 1 );
	}

	public void reset()
	{
		list = new ArrayList<String>();
	}

}