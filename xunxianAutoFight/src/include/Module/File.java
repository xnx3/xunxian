package include.Module;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class File {
	/**
	 *  复制文件
	 *  例如:copyFile("E:\\a.txt", "E:\\aa.txt");
	 * @param sourceFile
	 * @param targetFile
	 */
    public static void copyFile(String sourceFile, String targetFile){
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        }catch (Exception e) {
			e.printStackTrace();
		}finally {
			 // 关闭流
            if (inBuff != null)
				try {
					inBuff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            if (outBuff != null)
				try {
					outBuff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}  
        }
    }
    public static void main(String[] args) {
		copyFile("E:\\a.txt", "E:\\aa.txt");
	}
    
    
    
}
