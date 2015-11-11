package action;

import include.Command;
import Func.Com;

public class SkillThread extends Thread {
	public void run(){
		Com com=new Com();
		boolean createDm=com.createDm();
		SkillFunc skillFunc=new SkillFunc(com.activeDm);
		
		while(Command.mainThread&&createDm){
			skillFunc.action();
		}
		
		com.releaseDm();
		
	}
}