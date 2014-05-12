package net.azulite.RaganDrill;

public class ConvertBase
{
	protected String docroot;
	protected String delimiter;
	protected String dir_android;
	protected String dir_ios;

	public ConvertBase()
	{
		docroot = ".";
		delimiter = "\\";
		dir_android = "res";
		dir_ios = "ios_res";
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
}