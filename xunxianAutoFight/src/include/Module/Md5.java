package include.Module;
 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*
 * 加密前自动将所有空白字符去掉
 */

public class Md5 {

	public static String md5(String plainText) {
		plainText=plainText.replaceAll("\\s", "");
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

		
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		}
		
		return buf.toString();
	}

	public static void main(String agrs[]) {
		System.out.println(md5(""));	//加密“寻仙”
	}

}
