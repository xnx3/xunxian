package action;

import Func.Com;
import Func.Press;
import Func.Sleep;
import include.Command;

/**
 * 捉宝宝，卓神兽打符
 * @author xnx3
 *
 */

public class ZhuoBaoBaoThread extends Thread{
	
	public void run(){
		Com com=new Com();
		com.createDm();
		
		Press press=new Press(com.activeDm);
		Sleep sleep=new Sleep();
		
		while(Command.mainThread){
			press.keyPress(49);	//1键
			sleep.sleep(300);	
			press.keyPress(50);	//2键
			sleep.sleep(300);	
			press.keyPress(51);	//3键
			sleep.sleep(300);	
		}
		
		com.releaseDm();
	}
	
}
