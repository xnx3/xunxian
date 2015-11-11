package action;

import include.Command;

import Func.Com;

/**
 * 水低自动开鼓 ，定点
 * @author Administrator
 *
 */
public class SettledOpenThread extends Thread {
	public void run(){
		Com com=new Com();
		boolean createDm=com.createDm();
		DaGuaiFunc daguaiFunc=new DaGuaiFunc(com.activeDm);
		
		while(Command.mainThread&&createDm){
			daguaiFunc.kaiGuAction();
		}
		
		daguaiFunc.release();
		com.releaseDm();
	}
	
}
