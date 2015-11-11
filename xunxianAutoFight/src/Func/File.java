package Func;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;

import include.Command;

public class File {
	private ActiveXComponent activeDm=null;
	public File(ActiveXComponent active) {
		this.activeDm=active;
	}
	public File() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 播放声音
	 * 需定义播放文件：
	 * @param playFile:声音文件所在路径
	 * @param playTime:声音播放时间
	 */
	public void play(String playFile,int playTime){
		if(Command.playMusic){
			Command.playFile=playFile;
			Command.playTime=playTime;
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						int play=activeDm.invoke("Play",Command.playFile).getInt();
						new Func.Sleep().sleep(Command.playTime);
						if(play==0){
//							System.out.println("声音["+Command.playFile+"]播放失败！");
						}else{
							activeDm.invoke("Stop",play);
						}
						log("声音播放-"+(play==0? "失败":"成功"));
					} catch (Exception e) {
						log("声音播放异常捕获"+e.getMessage());
					}
				}
			}).start();
		}
	}
	
	/**
	 * 日志记录
	 */
	public void log(String log){
		try {
			if(Command.realtimeRemind){
				Command.JForm.logTextArea.setText(Command.JForm.logTextArea.getText().toString()+"\n"+log+"\t"+include.Module.Now_date.xnx3_time());
			}
			Command.logBuffer.append(Command.lineNotePad+log+"\t"+include.Module.Now_date.xnx3_time()+"  ");		//2个空格，用于正则匹配用。从txt读取时将2个空各替换为换行符
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 截图保存日志记录,同时添加时间
	 * @param message
	 */
	public void screenImage(String message){
		try {
			int enableDisplayDebug=activeDm.invoke("EnableDisplayDebug",1).getInt();
			if(enableDisplayDebug==0){
				log("EnableDisplayDebug-截图开启失败");
			}
			
			Variant[] var=new Variant[5];
			var[0]=new Variant(0);
			var[1]=new Variant(0);
			var[2]=new Variant(1024);
			var[3]=new Variant(768);
			var[4]=new Variant(Command.thisFilePath+"\\"+Command.screenNoteFile+"\\"+message+"-"+include.Module.Now_date.xnx3_time().replaceAll(":", "：")+".bmp");
			activeDm.invoke("CapTure",var);
			int capTurePre=activeDm.invoke("CapturePre",var[4]).getInt();
			var=null;
//			log("截图-->"+(capTurePre==0? "失败":"成功"));
			
			activeDm.invoke("EnableDisplayDebug",0);
		} catch (Exception e) {
			log("截图保存日志Func.screenImage()异常捕获:"+e.getMessage());
		}
	}
	
	/**
	 * 保存出bmp格式图片
	 * @param message:截图
	 * @param filePath
	 */
	public void screenImage(String message,int xStart,int yStart,int xEnd,int yEnd){
		try {
			int enableDisplayDebug=activeDm.invoke("EnableDisplayDebug",1).getInt();
			if(enableDisplayDebug==0){
				log("EnableDisplayDebug-截图开启失败");
			}
			
			Variant[] var=new Variant[5];
			var[0]=new Variant(xStart);
			var[1]=new Variant(yStart);
			var[2]=new Variant(xEnd);
			var[3]=new Variant(yEnd);
			var[4]=new Variant(Command.thisFilePath+"\\"+Command.screenNoteFile+"\\"+message+".bmp");
			activeDm.invoke("CapTure",var);
			int capTurePre=activeDm.invoke("CapturePre",var[4]).getInt();
			var=null;
//			log(message+"截图-->"+(capTurePre==0? "失败":"成功"));
			
			activeDm.invoke("EnableDisplayDebug",0);
		} catch (Exception e) {
			log("截图保存日志Func.screenImage()异常捕获:"+e.getMessage());
		}
	}
	
	/**
	 * 删除单个文件，java操作
	 * @param fileName 文件名，包含路径。如E:\\a\\b.txt
	 * @return boolean true：删除成功
	 */
	public boolean deleteFile(String fileName){
		boolean xnx3_result=false;
		
		java.io.File f=new java.io.File(fileName);
		if(f.isFile()&&f.exists()){
			f.delete();
			xnx3_result=true;
		}
		
		return xnx3_result;
	}
	
}
