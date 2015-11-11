package action;

import include.Command;

/**
 * 辅助状态释放线程
 * @author xnx3
 *
 */
public class StateThread extends Thread {
	@Override
	public void run() {
		while(Command.mainThread){
//			new Func.Press().keyPress(Command.keyArray[Command.threadJiNengKey]);
			new Func.Sleep().sleep(Command.threadJiNengTime);
		}
	}
}
