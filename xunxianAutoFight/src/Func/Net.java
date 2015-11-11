package Func;

import include.Command;

import com.jacob.activeX.ActiveXComponent;

public class Net {
	/**
	 * 再IE中打开网址
	 */
	public void openIE(String url){
		try {
			Command.activeDb_IE.invoke("OpenIE",url);
		} catch (Exception e) {
			new Func.File().log("打开网址-异常捕获:"+e.getMessage());
		}
	}
}
