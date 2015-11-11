package action;

import Func.Com;
import include.Command;

public class DaGuaiThread extends Thread{
	@Override
	public void run() {
		Com com=new Com();
		boolean createDm=com.createDm();
		DaGuaiFunc daguaiFunc=new DaGuaiFunc(com.activeDm);
		
		while(Command.mainThread&&createDm){
			daguaiFunc.start();
		}
		
		daguaiFunc.release();
		com.releaseDm();
	}
}