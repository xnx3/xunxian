package action;

import Func.Com;
import Func.Sleep;
import include.Command;

public class SaoHuoThread extends Thread{
	public void run(){
		Sleep sleep=new Sleep();
		Com com=new Com();
		boolean createDm=com.createDm();
		
		while(Command.mainThread&&createDm){
			new SaoHuoFunc(com.activeDm).saoHuoAction();
			sleep.sleep(20000);
		}
		
		com.releaseDm();
		sleep=null;
	}
}
