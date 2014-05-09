package net.azulite.RaganDrill;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ConvertIcon
{
	private String docroot;
	private String dir_android;
	private String dir_ios;
	private String delimiter;
	private ArrayList<Integer> iconlist;


	public ConvertIcon()
	{
		docroot = ".";
		dir_android = "res";
		dir_ios = "ios_res";
		delimiter = "/";
		iconlist = new ArrayList<Integer>();
	}

	/**
	 * 出力ディレクトリ。
	 * 出力ディレクトリ以下にres/やios_res/などのディレクトリを生成する。
	 * @param path 出力ディレクトリ。
	 */
	public void setDocumentRoot( String path )
	{
		docroot = path;
	}

	/**
	 * パスの区切りの設定。
	 * @param newdelimiter 区切り文字。
	 */
	public void setDelimiter( String newdelimiter )
	{
		delimiter = newdelimiter;
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
