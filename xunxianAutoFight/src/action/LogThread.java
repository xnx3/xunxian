package action;

import Func.Sleep;
import include.Command;
import include.Module.TextFile;

public class LogThread extends Thread {
	private Sleep sleep=null;
	
	public LogThread(){
		this.sleep=new Sleep();
		
		//将资源库中的文件转移至运行文件同目录，复制、并覆盖
		try {
			include.Module.File.copyFile(Command.thisFilePath+"\\"+Command.resource+"\\log.txt", Command.thisFilePath+"\\log.txt");
		} catch (Exception e) {
			new Func.File().log("将资源库中的文件转移至运行文件同目录，复制、并覆盖时异常捕获："+e.getMessage());
		}
	}
	
	@Override
	public void run() {
		while(Command.mainThread){
			this.sleep.sleep(Command.logThreadSleep);			//每10分钟一次日志保存

			boolean writeFile=false;
			try {
				TextFile textFile=new include.Module.TextFile();
//				String logOld=textFile.read(Command.thisFilePath+"\\log.txt", "UTF-8");
//				logOld.replaceAll("  ", "  "+Command.lineNotePad)
				textFile.write(Command.thisFilePath+"\\log.txt", Command.logBuffer.toString());
				textFile=null;
				writeFile=true;
			} catch (Exception e) {
				e.printStackTrace();
				new Func.File().log(Command.logThread.getName()+"异常捕获:"+e.getMessage());
			}
			
			if(writeFile){
				try {
					Command.JForm.logTextArea.setText("");
				} catch (Exception e) {
					new Func.File().log(Command.logThread.getName()+"异常捕获:"+e.getMessage());
				}
				
				//重新开始记录
//				Command.logBuffer=null;
//				Command.logBuffer=new StringBuffer();
			}else{
				new Func.File().log("日志线程记录log.txt保存失败！");
			}
		}
	}
	
	
}
