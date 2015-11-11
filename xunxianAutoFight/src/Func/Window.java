package Func;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;

public class Window {
	private ActiveXComponent activeDm=null;
	private ActiveXComponent activeDbWindow=null;
	public Window(ActiveXComponent activeDm){
		this.activeDm=activeDm;
	}
	public Window(ActiveXComponent activeDm,ActiveXComponent activeDb){
		this.activeDm=activeDm;
		this.activeDbWindow=activeDb;
	}
	
	/**
	 * 移动窗口到屏幕指定坐标点
	 * @param hwnd 移动窗口的句柄
	 * @return 成功:true
	 */
	public boolean MoveWindow(int hwnd,int x, int y){
		boolean xnx3_result=false;
		Variant[] var=new Variant[3];
		try {
			var[0]=new Variant(hwnd);
			var[1]=new Variant(x);
			var[2]=new Variant(y);
			int getResult=activeDm.invoke("MoveWindow",var).getInt();
			if(getResult==1){		//成功
				xnx3_result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("移动窗口时异常捕获:"+e.getMessage());
		}finally{
			var=null;
		}
		
		return xnx3_result;
	}
	
	/**
	 * 设置窗口状态
	 * @param  hwnd 操作的窗口句柄
	 * @param type
	 *  <li>0 : 关闭指定窗口
	 *	<li>1 : 激活指定窗口
	 *	<li>2 : 最小化指定窗口,但不激活
	 *	<li>3 : 最小化指定窗口,并释放内存,但同时也会激活窗口.
	 *	<li>4 : 最大化指定窗口,同时激活窗口.
	 *	<li>5 : 恢复指定窗口 ,但不激活
	 *	<li>6 : 隐藏指定窗口
	 *	<li>7 : 显示指定窗口
	 *	<li>8 : 置顶指定窗口
	 *	<li>9 : 取消置顶指定窗口
	 *	<li>10 : 禁止指定窗口
	 *	<li>11 : 取消禁止指定窗口
	 *	<li>12 : 恢复并激活指定窗口
	 *	<li>13 : 强制结束窗口所在进程.
	 */
	public boolean setWindowState(int hwnd,int type){
		boolean xnx3_result=false;
		try {
			int getResult=this.activeDm.invoke("SetWindowState",hwnd,type).getInt();
			if(getResult==1){
				xnx3_result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("设置窗口状态setWindowState异常捕获:"+e.getMessage());
		}
		return xnx3_result;
	}
	
	/**
	 * 屏幕坐标与窗口坐标互相转化
	 * 
	 * @param type 转换类型
	 * 		<li>0表示屏幕转化为窗口(整个窗口的范围矩形，窗口的边框、标题栏、滚动条及菜单等都在这个矩形内)
     * 		<li>1表示窗口转化成屏幕
     * 		<li>2表示屏幕转化为窗口客户区(不包括窗口的边框、标题栏、滚动条及菜单)
     * 		<li>3表示窗口客户区转化为屏幕
     * 		<li>4表示窗口转化为窗口客户区(不包括窗口的边框、标题栏、滚动条及菜单)
     * 		<li>5表示窗口客户区转化为窗口
     * 
     * @return int[2] 返回x、y坐标。若是出错，返回-1,-1
	 */
	public int[] windowPosition(int hwnd,int x,int y,int type){
		int[] xnx3_result={-1,-1};
		
		Variant[] var=new Variant[4];
		int[] getResult=null;
		try {
			var[0]=new Variant(hwnd);
			var[1]=new Variant(x);
			var[2]=new Variant(y);
			var[3]=new Variant(type);
			getResult=this.activeDbWindow.invoke("CoordinateFtoB",var).toSafeArray().toIntArray();
			xnx3_result[0]=getResult[0];
			xnx3_result[1]=getResult[1];
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("窗口坐标转换windowPosition异常捕获:"+e.getMessage());
		}finally{
			var=null;
			getResult=null;
		}
		
		return xnx3_result;
	}
	
	/**
	 * 设置指定窗口的大小
	 * @param hwnd 窗口句柄
	 * @param width 要设置成的宽度
	 * @param height 要设置成的高度
	 * @return 设置成功返回true
	 */
	public boolean setWindowSize(int hwnd,int width,int height){
		Variant[] var=new Variant[4];
		int result=0;
		try {
			var[0]=new Variant(hwnd);
			var[1]=new Variant(width);
			var[2]=new Variant(height);
			result=this.activeDm.invoke("SetClientSize",var).getInt();
		} catch (Exception e) {
		}finally{
			var=null;
		}
		return result==1; 
	}
}
