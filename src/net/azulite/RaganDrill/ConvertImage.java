package net.azulite.RaganDrill;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ConvertImage extends ConvertBase
{
	private float dpi;
	private ArrayList<OutputOption> dpilist;
	private ArrayList<String> imglist;

	public ConvertImage()
	{
		super();
		dpi = 160.0f;

		dpilist = new ArrayList<OutputOption>();
		imglist = new ArrayList<String>();
	}

	/**
	 * DPIの設定。
	 * @param newdpi 読み込む画像のDPI。
	 */
	public void setInputDPI( float newdpi )
	{
		dpi = newdpi;
	}

	/**
	 * 出力DPIの設定。
	 * DPIListの定数を利用する。
	 * @param dpilist_type DPIListの定数。
	 */
	public void addOutputDPI( int dpilist_type )
	{
		String dir;
		boolean iosretina = false;

		if ( DPIList.isAnroid( dpilist_type ) )
		{
			dir = dir_android;
		} else
		{
			dir = dir_ios;
			if ( DPIList.is2x( dpilist_type ) ){ iosretina = true; }
		}

		OutputOption opt = new OutputOption(
				DPIList.getDPI( dpilist_type ),
				dir + delimiter + DPIList.getAndroidPath( dpilist_type ),
				iosretina );

		dpilist.add( opt );
	}

	/**
	 * 入力画像の追加。
	 * @param path 画像ファイルへのパス。
	 */
	public void addInputImage( String path )
	{
		imglist.add( path );
	}

	public void convert()
	{
		// TODO:createdirectory
		for ( int i = 0 ; i < imglist.size() ; ++i )
		{
			BufferedImage img;
			try
			{
				img = ImageIO.read( new File( imglist.get( i ) ) );
				for ( int j = 0 ; j < dpilist.size() ; ++j )
				{
					convert( img, imglist.get( i ), dpilist.get( j ) );
				}
			} catch (IOException e) {}
		}
	}

	private void convert( BufferedImage img, String name, OutputOption opt )
	{
		int w = convertSize( img.getWidth(), opt.getDPI() );
		int h = convertSize( img.getHeight(), opt.getDPI() );
		BufferedImage output = new BufferedImage( w, h, BufferedImage.TYPE_4BYTE_ABGR );
		Graphics g = output.getGraphics();
		g.drawImage( img, 0, 0, w, h, null );
		g.dispose();
		try
		{
			ImageIO.write( output, "PNG", new File( docroot + delimiter + opt.getFilePath( name, delimiter ) ) );
		} catch ( IOException e ) {}
	}

	/**
	 * 出力サイズを返す、
	 * @param size 元画像のサイズ。
	 * @param dpi 出力DPI。
	 */
	private int convertSize( int size, float dpi )
	{
		return Math.round( dpi / this.dpi * size );
	}
}

