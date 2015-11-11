package Func;

import include.Command;
import com.jacob.com.Variant;

public class Dm {
	/**
	 * 开启运行，初始化DM插件
	 * 主要针对Command.activeDm
	 * <li>设置资源路径
	 * <li>绑定装口
	 * <li>加载点阵库
	 * 
	 * @return 成功返回true
	 */
	 
	public boolean createDm(){
		boolean xnx3_result=true;
		try {
			//设置当前资源路径
			int setPath=Command.activeDm.invoke("SetPath", Command.thisFilePath+"\\"+Command.resource).getInt();
			if(setPath==0){
				new Func.Message().showMessageDialog("设置当前资源路径出错！");
				xnx3_result=false;
			}
//			new Func.File().log("设置资源文件路径:"+Command.thisFilePath+"\\"+Command.resource);
			
			//进行dm窗口绑定
			Variant[] var=new Variant[5];
			var[0]=new Variant(Command.hwnd);
			var[1]=new Variant("dx");
			var[2]=new Variant("dx");
			var[3]=new Variant("dx");
			var[4]=new Variant(0);
			int bindWindow=Command.activeDm.invoke("BindWindow",var).getInt();
			var=null;
			if(bindWindow==0){
				new Func.Message().showMessageDialog("窗口绑定失败！");
				xnx3_result=false;
			}
			
			
			Command.bindWindow=true;
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("DM初始化Func.dmInit()异常捕获:"+e.getMessage());
		}
		System.out.println("initDm完毕:"+xnx3_result);
		return xnx3_result;
	}
	
	//解除DM窗口绑定,返回boolean
	public boolean unBindWindow(){
		boolean xnx3_result=true;
		try {
			int unBindWindow=Command.activeDm.invoke("UnBindWindow").getInt();
			xnx3_result=unBindWindow==1;
			Command.bindWindow=false;
		} catch (Exception e) {
			new Func.File().log("DM解除绑定Func.unBindWindow()异常捕获:"+e.getMessage());
		}
		return xnx3_result;
	}
	
}
