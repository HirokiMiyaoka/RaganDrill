package net.azulite.RaganDrill;

public class IconList
{
	static final int PLAYSTORE = 0;
	
	static final int ANDROID_LDPI   = 10;
	static final int ANDROID_MDPI   = 11;
	static final int ANDROID_HDPI   = 12;
	static final int ANDROID_XDPI   = 13;
	static final int ANDROID_XHDPI  = 13;
	static final int ANDROID_XXHDPI = 14;

	static final int APPSTORE_LDPI = 100;
	static final int APPSTORE_HDPI = 101;

	static final int IOS_6_LDPI       = 200;
	static final int IOS_6_HDPI       = 201;
	static final int IOS_6_SMALL_LDPI = 202;
	static final int IOS_6_SMALL_HDPI = 203;
	static final int IOS_7_DPI        = 204;
	static final int IOS_7_SMALL      = 205;

	static final int IPAD_6_LDPI       = 300;
	static final int IPAD_6_HDPI       = 301;
	static final int IPAD_6_SMALL_LDPI = 302;
	static final int IPAD_6_SMALL_HDPI = 303;
	static final int IPAD_7_LDPI       = 304;
	static final int IPAD_7_HDPI       = 305;
	static final int IPAD_7_SMALL_LDPI = 306;
	static final int IPAD_7_SMALL_HDPI = 307;

	private static final int ICON_PLAYSTORE      = 512;

	private static final int ICON_ANDROID_LDPI   = 36;
	private static final int ICON_ANDROID_MDPI   = 48;
	private static final int ICON_ANDROID_HDPI   = 72;
	private static final int ICON_ANDROID_XDPI   = 96;
	//private static final int ICON_ANDROID_XHDPI  = 96;
	private static final int ICON_ANDROID_XXHDPI = 144;

	private static final int ICON_APPSTORE_LDPI = 512;
	private static final int ICON_APPSTORE_HDPI = 1024;

	private static final int ICON_IOS_6_LDPI       = 57;
	private static final int ICON_IOS_6_HDPI       = 114;
	private static final int ICON_IOS_6_SMALL_LDPI = 29;
	private static final int ICON_IOS_6_SMALL_HDPI = 58;
	private static final int ICON_IOS_7_DPI        = 120;
	private static final int ICON_IOS_7_SMALL      = 80;

	private static final int ICON_IPAD_6_LDPI       = 72;
	private static final int ICON_IPAD_6_HDPI       = 144;
	private static final int ICON_IPAD_6_SMALL_LDPI = 50;
	private static final int ICON_IPAD_6_SMALL_HDPI = 100;
	private static final int ICON_IPAD_7_LDPI       = 76;
	private static final int ICON_IPAD_7_HDPI       = 152;
	private static final int ICON_IPAD_7_SMALL_LDPI = 40;
	private static final int ICON_IPAD_7_SMALL_HDPI = 80;

	static public int getIconSize( int type )
	{
		switch ( type )
		{
		case PLAYSTORE:
			return ICON_PLAYSTORE;
		case ANDROID_LDPI:
			return ICON_ANDROID_LDPI;
		case ANDROID_MDPI:
			return ICON_ANDROID_MDPI;
		case ANDROID_HDPI:
			return ICON_ANDROID_HDPI;
		case ANDROID_XDPI:
			return ICON_ANDROID_XDPI;
		case ANDROID_XXHDPI:
			return ICON_ANDROID_XXHDPI;
		case APPSTORE_LDPI:
			return ICON_APPSTORE_LDPI;
		case APPSTORE_HDPI:
			return ICON_APPSTORE_HDPI;
		case IOS_6_LDPI:
			return ICON_IOS_6_LDPI;
		case IOS_6_HDPI:
			return ICON_IOS_6_HDPI;
		case IOS_6_SMALL_LDPI:
			return ICON_IOS_6_SMALL_LDPI;
		case IOS_6_SMALL_HDPI:
			return ICON_IOS_6_SMALL_HDPI;
		case IOS_7_DPI:
			return ICON_IOS_7_DPI;
		case IOS_7_SMALL:
			return ICON_IOS_7_SMALL;
		case IPAD_6_LDPI:
			return ICON_IPAD_6_LDPI;
		case IPAD_6_HDPI:
			return ICON_IPAD_6_HDPI;
		case IPAD_7_LDPI:
			return ICON_IPAD_7_LDPI;
		case IPAD_7_HDPI:
			return ICON_IPAD_7_HDPI;
		case IPAD_6_SMALL_LDPI:
			return ICON_IPAD_6_SMALL_LDPI;
		case IPAD_6_SMALL_HDPI:
			return ICON_IPAD_6_SMALL_HDPI;
		case IPAD_7_SMALL_LDPI:
			return ICON_IPAD_7_SMALL_LDPI;
		case IPAD_7_SMALL_HDPI:
			return ICON_IPAD_7_SMALL_HDPI;
		}
		return 1024;
	}

	static public String getIconName( int type )
	{
		switch ( type )
		{
		case PLAYSTORE:
			return "PlayStore";
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
		case APPSTORE_LDPI:
			return "AppStore";
		case APPSTORE_HDPI:
			return "AppStore(Big)";
		case IOS_6_LDPI:
			return "iPhone6(Home)";
		case IOS_6_HDPI:
			return "iPhone6(RetinaHome)";
		case IOS_6_SMALL_LDPI:
			return "iPhone6(Spotlight)";
		case IOS_6_SMALL_HDPI:
			return "iPhone6(Spotlight,Big)";
		case IOS_7_DPI:
			return "iPhone7(Home)";
		case IOS_7_SMALL:
			return "iPhone7(Spotlight)";
		case IPAD_6_LDPI:
			return "iPad6(Home)";
		case IPAD_6_HDPI:
			return "iPad6(RetinaHome)";
		case IPAD_7_LDPI:
			return "iPad7(Home)";
		case IPAD_7_HDPI:
			return "iPad7(RetinaHome)";
		case IPAD_6_SMALL_LDPI:
			return "iPad6(Spotlight)";
		case IPAD_6_SMALL_HDPI:
			return "iPad6(RetinaSpotlight)";
		case IPAD_7_SMALL_LDPI:
			return "iPad7(Spotlight)";
		case IPAD_7_SMALL_HDPI:
			return "iPad7(RetinaSotlight)";
		}
		return "Unknown";
	}

	static public boolean isAnroid( int type )
	{
		return type < APPSTORE_LDPI;
	}

	static public boolean is2x( int type )
	{
		switch ( type )
		{
		case IOS_6_HDPI:
		case IOS_6_SMALL_HDPI:
		case IOS_7_DPI:
		case IOS_7_SMALL:
		case IPAD_6_HDPI:
		case IPAD_7_HDPI:
		case IPAD_6_SMALL_HDPI:
		case IPAD_7_SMALL_HDPI:
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
		return "icon";
	}

	static public String getIconPath( int type, String delimiter )
	{
		switch ( type )
		{
		case PLAYSTORE:
			return "icon" + delimiter + "icon.png";
		case ANDROID_LDPI:
			return "drawable-ldpi" + delimiter + "ic_launcher.png";
		case ANDROID_MDPI:
			return "drawable-mdpi" + delimiter + "ic_launcher.png";
		case ANDROID_HDPI:
			return "drawable-hdpi" + delimiter + "ic_launcher.png";
		case ANDROID_XDPI:
			return "drawable-xhdpi" + delimiter + "ic_launcher.png";
		case ANDROID_XXHDPI:
			return "drawable-xxhdpi" + delimiter + "ic_launcher.png";
		case APPSTORE_LDPI:
			return "icon" + delimiter + "icon.png";
		case APPSTORE_HDPI:
			return "icon" + delimiter + "iTunesArtwork";
		case IOS_6_LDPI:
			return "ios_res" + delimiter + "icon.png";
		case IOS_6_HDPI:
			return "ios_res" + delimiter + "icon@2x.png";
		case IOS_6_SMALL_LDPI:
			return "ios_res" + delimiter + "icon-small.png";
		case IOS_6_SMALL_HDPI:
			return "ios_res" + delimiter + "icon-small@2x.png";
		case IOS_7_DPI:
			return "ios_res" + delimiter + "icon-60@2x.png";
		case IOS_7_SMALL:
			return "ios_res" + delimiter + "icon-small-40@2x.png";
		case IPAD_6_LDPI:
			return "ios_res" + delimiter + "icon-72.png";
		case IPAD_6_HDPI:
			return "ios_res" + delimiter + "icon-72@2x.png";
		case IPAD_7_LDPI:
			return "ios_res" + delimiter + "icon-76.png";
		case IPAD_7_HDPI:
			return "ios_res" + delimiter + "icon-76@2x.png";
		case IPAD_6_SMALL_LDPI:
			return "ios_res" + delimiter + "icon-small-50.png";
		case IPAD_6_SMALL_HDPI:
			return "ios_res" + delimiter + "icon-small-50@2x.png";
		case IPAD_7_SMALL_LDPI:
			return "ios_res" + delimiter + "icon-small-40.png";
		case IPAD_7_SMALL_HDPI:
			return "ios_res" + delimiter + "icon-small-40@2x.png";
		}
		return "Unknown";
	}
}
