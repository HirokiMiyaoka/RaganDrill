package net.azulite.RaganDrill;

public class DPIList
{
	static final int ANDROID_LDPI   = 10;
	static final int ANDROID_MDPI   = 11;
	static final int ANDROID_HDPI   = 12;
	static final int ANDROID_XDPI   = 13;
	static final int ANDROID_XHDPI  = 13;
	static final int ANDROID_XXHDPI = 14;

	static final int IOS_LDPI       = 100;
	static final int IOS_HDPI       = 101;

	static final int IPHONE3G       = 200;
	static final int IPHONE3GS      = 201;
	static final int IPHONE4        = 202;
	static final int IPHONE4S       = 203;
	static final int IPHONE5        = 204;
	static final int IPHONE5S       = 205;
	static final int IPHONE5C       = 206;

	static final int IPAD           = 300;
	static final int IPAD2          = 301;
	static final int IPAD3          = 302;
	static final int IPAD4          = 303;
	static final int IPADMINI       = 304;

	private static final float DPI_ANDROID_LDPI   = 120.0f;
	private static final float DPI_ANDROID_MDPI   = 160.0f;
	private static final float DPI_ANDROID_HDPI   = 240.0f;
	private static final float DPI_ANDROID_XHDPI  = 320.0f;
	private static final float DPI_ANDROID_XXHDPI = 480.0f;

	private static final float DPI_IOS_LDPI       = 160.0f;
	private static final float DPI_IOS_HDPI       = 320.0f;

	private static final float DPI_IPHONE3        = 163.0f;
	private static final float DPI_IPHONE4        = 326.0f;
	private static final float DPI_IPAD           = 132.0f;
	private static final float DPI_IPAD3          = 264.0f;
	private static final float DPI_IPADMINI       = 163.0f;

	static public float getDPI( int type )
	{
		switch ( type )
		{
		case ANDROID_LDPI:
			return DPI_ANDROID_LDPI;
		case ANDROID_MDPI:
			return DPI_ANDROID_MDPI;
		case ANDROID_HDPI:
			return DPI_ANDROID_HDPI;
		case ANDROID_XHDPI:
			return DPI_ANDROID_XHDPI;
		case ANDROID_XXHDPI:
			return DPI_ANDROID_XXHDPI;
		case IOS_LDPI:
			return DPI_IOS_LDPI;
		case IOS_HDPI:
			return DPI_IOS_HDPI;
		case IPHONE3G:
		case IPHONE3GS:
			return DPI_IPHONE3;
		case IPHONE4:
		case IPHONE4S:
		case IPHONE5:
		case IPHONE5S:
		case IPHONE5C:
			return DPI_IPHONE4;
		case IPAD:
		case IPAD2:
			return DPI_IPAD;
		case IPAD3:
		case IPAD4:
			return DPI_IPAD3;
		case IPADMINI:
			return DPI_IPADMINI;
		}
		return 1.0f;
	}

	static public String getDPIName( int type )
	{
		switch ( type )
		{
		case ANDROID_LDPI:
			return "Android(ldpi)";
		case ANDROID_MDPI:
			return "Android(mdpi)";
		case ANDROID_HDPI:
			return "Android(hdpi)";
		case ANDROID_XDPI:
			return "Android(xhdpi)";
		case ANDROID_XXHDPI:
			return "Android(xxhdpi)";
		case IOS_LDPI:
			return "iOS";
		case IOS_HDPI:
			return "iOS(Retina)";
		case IPHONE3G:
			return "iPhone3G";
		case IPHONE3GS:
			return "iPhone3GS";
		case IPHONE4:
			return "iPhone4";
		case IPHONE4S:
			return "iPhone4S";
		case IPHONE5:
			return "iPhone4";
		case IPHONE5S:
			return "iPhone5S";
		case IPHONE5C:
			return "iPhone5C";
		case IPAD:
			return "iPad";
		case IPAD2:
			return "iPad2";
		case IPAD3:
			return "iPad3";
		case IPAD4:
			return "iPad4";
		case IPADMINI:
			return "iPad mini";
		}
		return "Unknown";
	}

	static public boolean isAnroid( int type )
	{
		return type < IOS_LDPI;
	}

	static public boolean is2x( int type )
	{
		switch ( type )
		{
		case IOS_HDPI:
		case IPHONE4:
		case IPHONE4S:
		case IPHONE5:
		case IPHONE5S:
		case IPHONE5C:
		case IPAD3:
		case IPAD4:
			return true;
		}
		return false;
	}

	static public String getAndroidPath( int type )
	{
		switch ( type )
		{
		case ANDROID_LDPI:
			return "drawable-ldpi";
		case ANDROID_MDPI:
			return "drawable-mdpi";
		case ANDROID_HDPI:
			return "drawable-hdpi";
		case ANDROID_XDPI:
			return "drawable-xhdpi";
		case ANDROID_XXHDPI:
			return "drawable-xxhdpi";
		}
		return "";
	}
}
