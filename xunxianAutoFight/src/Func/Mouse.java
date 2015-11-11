package Func;

import com.jacob.activeX.ActiveXComponent;

public class Mouse {
	private ActiveXComponent activeDm=null;
	private ActiveXComponent activeDBMouseKey=null;
	public Mouse(ActiveXComponent active) {
		this.activeDm=active;
	}
	public Mouse(ActiveXComponent activeDBMouseKey,ActiveXComponent activeDm){
		this.activeDBMouseKey=activeDBMouseKey;
		this.activeDm=activeDm;
	}
	
	
	/**
	 * 鼠标移动至某个坐标点点击鼠标左键
	 * @param click：boolean若是点左键为true，右键为false
	 */
	public void mouseClick(int x,int y,boolean click){
		try {
			activeDm.invoke("MoveTo",x,y);
			new Func.Sleep().sleep(300);	//避免卡屏
			if(click){
				activeDm.invoke("LeftClick");
			}else{
				activeDm.invoke("RightClick");
			}
		} catch (Exception e) {
			new Func.File().log("日志记录异常捕获:"+e.getMessage());
		}
	}
	
	/**
	 * 鼠标点击
	 * <li>左键点击传入true
	 * <li>右键点击传入false
	 */
	public void mouseClick(boolean leftClick){
		try {
			if(leftClick){
				activeDm.invoke("LeftClick");
			}else{
				activeDm.invoke("rightClick");
			}
		} catch (Exception e) {
			new Func.File().log("鼠标点击mouseClick异常捕获:"+e.getMessage());
		}
	}
	
	/**
	 * 鼠标移动到指定点
	 */
	public void mouseMoveTo(int x,int y){
		try {
			activeDm.invoke("MoveTo",x,y);
		} catch (Exception e) {
			new Func.File().log("鼠标移动捕获异常:"+e.getMessage());
		}
	}
	
	/**
	 * 按住鼠标左键
	 */
	public void leftDown(){
		try {
			activeDm.invoke("LeftDown");
		} catch (Exception e) {
			new Func.File().log("鼠标左键按住捕获异常:"+e.getMessage());
		}
	}
	
	/**
	 * 弹起鼠标左键
	 */
	public void leftUp(){
		try {
			activeDm.invoke("LeftUp");
		} catch (Exception e) {
			new Func.File().log("鼠标左键弹起捕获异常:"+e.getMessage());
		}
	}
	
	/**
	 * 获取鼠标当前的坐标（大屏幕坐标）
	 * 使用DBSoft
	 * 
	 * @return int[2]x、y坐标
	 * 			若是获取失败，返回坐标{-1,-1}
	 */
	public int[] getMousePosition(){
		int[] xnx3_result={-1,-1};
		
		int[] getArray=null;
		try {
			getArray=this.activeDBMouseKey.invoke("GetCursorXY").toSafeArray().toIntArray();
			xnx3_result[0]=getArray[0];
			xnx3_result[1]=getArray[1];
		} catch (Exception e) {
			xnx3_result[0]=-1;
			xnx3_result[0]=-1;
			e.printStackTrace();
			new Func.File().log("获取鼠标当前坐标异常捕获:"+e.getMessage());
		}finally{
			getArray=null;
		}
		
		return xnx3_result;
	}
}
