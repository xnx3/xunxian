package Func;

import include.Command;
import java.lang.Thread.State;
import action.DaGuaiThread;
import action.LogThread;
import action.SaoHuoThread;
import action.SettledOpenThread;
import action.SystemThread;

public class ThreadCommand {
	/**
	 * 开启打怪线程
	 * 自动检索线程是否开启，若没开启，则全部重新开启。若开启后没有执行完毕，则继续使用
	 */
	public void startDaGuaiThread(){
		Command.mainThread=true;	//线程运行状态开启
		try {
			if(Command.logThread.getState()==State.TERMINATED){
				Command.logThread=null;
				Command.logThread=new LogThread();
				Command.logThread.start();
				new Func.File().log("日志线程启动");
			}
			if(Command.daGuaiThread.getState()==State.TERMINATED){
				Command.daGuaiThread=null;
				Command.daGuaiThread=new DaGuaiThread();
				Command.daGuaiThread.start();
				new Func.File().log("打怪主线程启动");
			}
			if(Command.systemThread.getState()==State.TERMINATED){
				Command.systemThread=null;
				Command.systemThread=new SystemThread();
				Command.systemThread.start();
				new Func.File().log("系统线程启动");
			}
		} catch (Exception e) {		//捕获异常，可能是线程未初始化，进行初始化线程并开启
			if(e.getMessage()!=null){
				new Func.File().log("线程初始化开启");
			}
			
			Command.daGuaiThread=new DaGuaiThread();
			Command.logThread=new LogThread();
			Command.systemThread=new SystemThread();
			
			Command.daGuaiThread.start();
			new Func.File().log("打怪主线程启动");
			Command.logThread.start();
			new Func.File().log("日志线程启动");
			Command.systemThread.start();
			new Func.File().log("系统线程启动");
		}
		
		
		Command.daGuaiThread.setPriority(1);	//打怪主线程优先级最低
		Command.logThread.setPriority(1);		//日志线程，最低
		Command.systemThread.setPriority(8);	//系统线程最高
		
		Command.daGuaiThread.setName("打怪主线程");
		Command.logThread.setName("日志线程");
		Command.systemThread.setName("系统线程");
	}
	
	/**
	 * 定点开鼓
	 */
	public void startSettledOpenGuThread(){
		Command.mainThread=true;	//线程运行状态开启
		try {
			if(Command.logThread.getState()==State.TERMINATED){
				Command.logThread=null;
				Command.logThread=new LogThread();
				Command.logThread.start();
				new Func.File().log("日志线程启动");
			}
			if(Command.settledOpenThread.getState()==State.TERMINATED){
				Command.settledOpenThread=null;
				Command.settledOpenThread=new SettledOpenThread();
				Command.settledOpenThread.start();
				new Func.File().log("定点扫描鼓主线程启动");
			}
			if(Command.systemThread.getState()==State.TERMINATED){
				Command.systemThread=null;
				Command.systemThread=new SystemThread();
				Command.systemThread.start();
				new Func.File().log("系统线程启动");
			}
		} catch (Exception e) {		//捕获异常，可能是线程未初始化，进行初始化线程并开启
			if(e.getMessage()!=null){
				new Func.File().log("线程初始化开启");
			}
			
			Command.settledOpenThread=new SettledOpenThread();
			Command.logThread=new LogThread();
			Command.systemThread=new SystemThread();
			
			Command.settledOpenThread.start();
			new Func.File().log("打怪主线程启动");
			Command.logThread.start();
			new Func.File().log("日志线程启动");
			Command.systemThread.start();
			new Func.File().log("系统线程启动");
		}
		
		
		Command.settledOpenThread.setPriority(1);	//打怪主线程优先级最低
		Command.logThread.setPriority(1);		//日志线程，最低
		Command.systemThread.setPriority(8);	//系统线程最高
		
		Command.settledOpenThread.setName("定点开鼓主线程");
		Command.logThread.setName("日志线程");
		Command.systemThread.setName("系统线程");
	}
	
	/**
	 * 自动扫货
	 */
	public void startSaoHuoThread(){
		Command.mainThread=true;
		try{
			if(Command.saoHuoThread.getState()==State.TERMINATED){
				Command.saoHuoThread=null;
				Command.saoHuoThread=new SaoHuoThread();
				Command.saoHuoThread.start();
				new Func.File().log("扫货主线程启动");
			}
			if(Command.logThread.getState()==State.TERMINATED){
				Command.logThread=null;
				Command.logThread=new LogThread();
				Command.logThread.start();
				new Func.File().log("日志线程启动");
			}
			if(Command.systemThread.getState()==State.TERMINATED){
				Command.systemThread=null;
				Command.systemThread=new SystemThread();
				Command.systemThread.start();
				new Func.File().log("系统线程启动");
			}
		}catch (Exception e) {
			if(e.getMessage()!=null){
				new Func.File().log("扫货线程开启异常捕获:"+e.getMessage());
			}
			
			Command.saoHuoThread=new SaoHuoThread();
			Command.saoHuoThread.start();
			new Func.File().log("扫货主线程启动");

			Command.logThread=new LogThread();
			Command.logThread.start();
			new Func.File().log("日志线程启动");
			
			Command.systemThread=new SystemThread();
			Command.systemThread.start();
			new Func.File().log("系统线程启动");

		}
		
		Command.saoHuoThread.setName("扫货主线程");
		Command.saoHuoThread.setPriority(7);		//监控优先级高！
		
		Command.logThread.setName("日志线程");
		Command.logThread.setPriority(1);			//日志线程最低
		
		Command.systemThread.setName("系统线程");
		Command.systemThread.setPriority(8);			//系统线程优先级最高
		
	}
	
	/**
	 * 终止所有线程运行
	 */
	public static void stop(){
		Command.mainThread=false;
	}
	
}
