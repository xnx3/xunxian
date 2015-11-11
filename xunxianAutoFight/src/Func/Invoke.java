package Func;

import com.jacob.activeX.ActiveXComponent;

public class Invoke {
	private ActiveXComponent activeDm=null;
	public Invoke(ActiveXComponent active) {
		this.activeDm=active;
	}
	
	/**
	 * 传入一个参数的
	 * @param callAction
	 */
	public void invoke(String callAction){
		try {
			activeDm.invoke(callAction);
		} catch (Exception e) {
			new Func.File().log("Func.Invoke异常捕获:"+e.getMessage());
		}
	}
}
