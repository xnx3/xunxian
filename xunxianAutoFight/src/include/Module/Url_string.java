package include.Module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * 输入网址\编码，返回其源码
 * （GBK\GB2312\...）
 */

public class Url_string {
	public static String getHtml(String path,String code) {
		StringBuffer str = new StringBuffer();
		URL u;
		BufferedReader in = null;
		try {
			u = new URL(path);
			in = new BufferedReader(
					new InputStreamReader(u.openStream(), code));
			String s = "";
			while ((s = in.readLine()) != null) {
				str.append(s);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return str.toString();
	}

	
	
}
