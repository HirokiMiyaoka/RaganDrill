package net.azulite.RaganDrill;

/**
 * GUI parts( select icon type ).
 */

import java.util.ArrayList;

import javax.swing.JCheckBox;


public class IconSelecter
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
