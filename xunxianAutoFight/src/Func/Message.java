package Func;

import javax.swing.JOptionPane;

public class Message {
	/**
	 * 弹出提示框
	 * <br/>表示换行
	 * &amp;lt;br/&amp;gt;表示换行
	 */
	public void showMessageDialog(String message){
		JOptionPane.showMessageDialog(null, message.replaceAll("<br/>", "\n").replaceAll("&amp;lt;br/&amp;gt;", "\n"));
	}
	
	/**
	 * 弹出选择、确认框
	 * <br/>表示换行
	 * &amp;lt;br/&amp;gt;表示换行
	 * return :int ->ConfirmationCallback.YES|NO|CENCEL
	 */
	public int showConfirmDialog(String message){
		return JOptionPane.showConfirmDialog(null,message.replaceAll("<br/>", "\n").replaceAll("&amp;lt;br/&amp;gt;", "\n"));
	}
	
	
	
}
