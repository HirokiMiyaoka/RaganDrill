package net.azulite.RaganDrill;

import java.io.File;

public class OutputOption
{
	private float dpi;
	private String dir;
	private boolean iosretina;

	public OutputOption( float dpi, String output, boolean iosretina )
	{
		this.dpi = dpi;
		dir = output;
		this.iosretina = iosretina;
	}

	public float getDPI(){ return dpi; }

	public String getDir(){ return dir; }

	public String getFilePath( String path, String delimiter )
	{
		File file = new File( path );
		String name = file.getName();
		int pos = name.lastIndexOf( '.' );
		if ( 0 < pos )
		{
			name = name.substring( 0, pos );
		}
		if ( iosretina )
		{
			name += "@2x";
		}
		return dir + delimiter + name + ".png";
	}
}
