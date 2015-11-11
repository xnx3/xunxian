package action;

import Func.Sleep;
import include.Command;

/**
 * 系统相关
 * @author xnx3
 *
 */
public class SystemThread extends Thread {
	public void run(){
		Sleep sleep=new Func.Sleep();
		while(Command.mainThread){
			
			sleep.sleep(Command.systemSleep);	//每隔指定的几个小时执行一次
			Command.mainThread=false;
			
//			new UIFunc().showMessage(600, 400, 320, 150, "<div style=\"font-size:16px;\">["+Command.roleName+"]正在优化中，预计1分钟时间，请稍后……</div>");
			new Func.File().log(Command.roleName+"正在优化中，预计1分钟时间，请稍后……");
			
			//开启扫货/打怪主线程,首先判断当前运行状态是否是开启的
			if(Command.run){
				
				//等待线程结束运行，释放DM-COM组件
				int i = 0;
				for (; i < 4600; i++) {
					sleep.sleep(1000);
					if(!Command.bindWindow){	//判断窗口是否被释放。释放完毕之后及时跳出
						i=4650;
					}
				}
				sleep.sleep(1000);
				if(i!=4651){	//窗口没有正常释放
					new Func.File().log("检测到绑定窗口并未正确进行资源释放！");
					new Func.SendMail().send("检测窗口绑定异常", "绑定窗口进行资源释放时出现异常,建议上游戏看一下是否软件已结束运行，若是结束了，可再重新开启便可");
				}else{
					new Func.File().log("检测到COM组件已释放完毕");
				}
				System.gc();	//内存释放
				new Func.File().log(Command.roleName+"内存优化中……释放多于内存");
				sleep.sleep(2000);	//2秒
				
				switch (Command.runType) {
				case 1:		//自动打怪
					new Func.File().log("重新开启自动打怪");
					new Func.ThreadCommand().startDaGuaiThread();
					break;
				case 2:		//自动扫货
					new Func.File().log("重新开启自动扫货");
					new Func.ThreadCommand().startSaoHuoThread();
					break;
				default:
					break;
				}
			}
			
//			new UIFunc().hiddenMessage();
		}
		sleep=null;
	}
}
