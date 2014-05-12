package net.azulite.RaganDrill;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ConvertIcon extends ConvertBase
{
	private ArrayList<Integer> iconlist;

	public ConvertIcon()
	{
		super();

		iconlist = new ArrayList<Integer>();
	}

	/**
	 * 出力アイコンの設定。
	 * @param type IconListの設定。
	 */
	public void addOutput( int type )
	{
		iconlist.add( type );
	}

	public void convert( String icon )
	{
		// TODO:createdirectory
		BufferedImage img;
		try
		{
			img = ImageIO.read( new File( icon ) );
			for ( int i = 0 ; i < iconlist.size() ; ++i )
			{
				convert( img, iconlist.get( i ) );
			}
		} catch (IOException e) {}
	}

	private void convert( BufferedImage img, int type )
	{
		int size = IconList.getIconSize( type );
		BufferedImage output = new BufferedImage( size, size, BufferedImage.TYPE_4BYTE_ABGR );
		Graphics g = output.getGraphics();
		g.drawImage( img, 0, 0, size, size, null );
		g.dispose();
		try
		{
			ImageIO.write( output, "PNG", new File( docroot + delimiter + IconList.getIconPath( type, delimiter ) ) );
		} catch ( IOException e ) {}
	}

}
