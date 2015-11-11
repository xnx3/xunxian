package Func;

import com.jacob.activeX.ActiveXComponent;


public class Press {
	private ActiveXComponent activeDm=null;
	public Press(ActiveXComponent active) {
		this.activeDm=active;
	}
	public Press(){
		
	}
	/**
	 * 按下指定的键一定的时间后放开
	 * @param keyCode
	 * @param sleep
	 */
	public void keyPressTime(int keyCode,int sleep){
		try {
			activeDm.invoke("KeyDown",keyCode);
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			activeDm.invoke("KeyUp",keyCode);
		} catch (Exception e) {
			new Func.File().log("按下指定键一段时间异常捕获:"+e.getMessage());
		}
	}
	
	/**
	 * 按下某键
	 * <li>keyCode：传入按键码
	 */
	public void keyPress(int keyCode){
		try {
			activeDm.invoke("KeyPress",keyCode);
		} catch (Exception e) {
			new Func.File().log("按键异常捕获"+e.getMessage());
		}
	}
	
	
	/**
	 * 按住某键(按下某个键位并不弹起)搭配keyUp使用
	 * <li>keyCode:传入按键码
	 */
	public void keyDown(int keyCode){
		try {
			activeDm.invoke("KeyDown",keyCode);
		} catch (Exception e) {
			new Func.File().log("按键按住异常捕获"+e.getMessage());
		}
	}
	
	/**
	 * 按住某键(按下某个键位并不弹起)搭配keyDown使用
	 * <li>keyCode:传入按键码
	 */
	public void keyUp(int keyCode){
		try {
			activeDm.invoke("KeyUp",keyCode);
		} catch (Exception e) {
			new Func.File().log("按键弹起异常捕获"+e.getMessage());
		}
	}
	
	/**
	 * 将java.awt.event.KeyEvent.getKeyCode转换为dm用的按键码
	 * @param keyCode java.awt.event.KeyEvent
	 * @return DM用的按键码
	 */
	public int keyCodeTransform(int keyCode){
		switch(keyCode){
			case 45:		//-
				keyCode=189;
				break;
			case 61:		//=
				keyCode=187;
				break;
			case 10:		//Enter
				keyCode=13;
				break;
			case 91:		//[
				keyCode=219;
				break;
			case 93:		//]
				keyCode=221;
				break;
			case 92:		// \
				keyCode=220;
				break;
			case 59:		// ;
				keyCode=186;
				break;
			case 44:		// ,
				keyCode=188;
				break;
			case 46:		// .
				keyCode=190;
				break;
			case 47:		// /
				keyCode=191;
				break;
		}
		return keyCode;
	}
	
	/**
	 * 将某些不能输出显示的按键为正常文字可供用户看到
	 * @param keyCode 传入按键码,传入的为dm的按键码
	 * @param oldName 原本的名字,像是enter、空格键等，此传入会失效，返回最新的
	 * @return 返回键名，如Enter、BackSpace、空格、上……等
	 */
	public String keyCodeName(int keyCode,String oldName){
		String result=null;
		switch(keyCode){
			case 27:	
				result="Esc";
				break;
			case 112:		
				result="F1";
				break;
			case 113:		
				result="F2";
				break;
			case 114:		
				result="F3";
				break;
			case 115:		
				result="F4";
				break;
			case 116:		
				result="F5";
				break;
			case 117:		
				result="F6";
				break;
			case 118:		
				result="F7";
				break;
			case 119:		
				result="F8";
				break;
			case 120:		
				result="F10";
				break;
			case 121:		
				result="F11";
				break;
			case 122:		
				result="F12";
				break;
			case 145:		
				result="Scroll Lock";
				break;
			case 8:		
				result="BackSpace";
				break;
			case 20:		
				result="Caps Lock";
				break;
			case 16:		
				result="Shift";
				break;
			case 17:		
				result="Ctrl";
				break;
			case 18:		
				result="Alt";
				break;
			case 32:		
				result="空格";
				break;
			case 38:	
				result="上";
				break;
			case 40:	
				result="下";
				break;
			case 37:	
				result="左";
				break;
			case 39:	
				result="右";
				break;
			case 13:	
				result="Enter";
				break;
			default:
				result=oldName;
				break;
		}
		return result;
	}
}
