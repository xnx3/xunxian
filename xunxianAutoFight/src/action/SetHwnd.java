package action;

import javax.security.auth.callback.ConfirmationCallback;

import include.Command;

public class SetHwnd {
	
	public static void setHwnd(){
		new Func.Message().showMessageDialog("点击确定后有1秒时间将鼠标<br/>指向要进行后台卦级的游戏窗口");
		try {
			new Func.Sleep().sleep(1000);
			Command.hwnd= Command.activeDm.invoke("GetMousePointWindow").getInt();
			String title=Command.activeDm.invoke("GetWindowTitle",Command.hwnd)+"";
			if(title.indexOf("寻仙")>-1){
				if(title.indexOf(Command.title)>-1){		//再次判断获取的不能为当前辅助软件窗口
					Command.hwnd=0;	//不是寻仙窗口，还原句柄
					if(new Func.Message().showConfirmDialog("失败！本次获取的为当前软件的窗口！<br/>请点击[获取目标窗口]按钮然后点了[确定]后<br/>将鼠标放到要挂机的寻仙游戏的窗口上。<br/><br/>是否要查看此操作详细说明？")==ConfirmationCallback.YES){
						Command.browser.loadUrl("http://www.xnx3.com/xunxian/xxautofight/20130626/41.html",200,200,800,600);
					}
				}else{		//获取正确
					Command.JForm.setHwndjLabel.setText("窗口句柄:"+Command.hwnd+",窗口名:"+title);
				}
			}else{
				if(new Func.Message().showConfirmDialog("获取窗口错误,不是寻仙窗口!<br/>点击获取目标窗口后将鼠标指向寻仙游戏<br/><br/>是否要查看此操作详细说明？")==ConfirmationCallback.YES){
					System.out.println("--");
					Command.browser.loadUrl("http://www.xnx3.com/xunxian/xxautofight/20130626/41.html",200,200,800,600);
				}
				Command.hwnd=0;	//不是寻仙窗口，还原句柄
				Command.JForm.setHwndjLabel.setText("请点击前面按钮获取目标窗口");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 成功，返回true
	 */
	public static boolean bindWindow(){
		boolean xnx3_result=false;		//进行绑定时用到
		if(Command.bindWindow){
			new Func.File().log("进行窗口解除绑定");
			boolean unBind=new Func.Dm().unBindWindow();
			if(unBind){
				Command.bindWindow=false;
				Command.JForm.getHwndjButton.setVisible(true);
				xnx3_result=true;
			}
		}else{
			new Func.File().log("进行窗口绑定");
			//没有绑定，进行绑定操作
			boolean dmBind=new Func.Dm().createDm();
			if(dmBind){
				Command.JForm.getHwndjButton.setVisible(false);
				Command.bindWindow=true;
				xnx3_result=true;
			}else{
				new Func.File().log("窗口绑定失败！");
			}
		}
		new Func.File().log("窗口操作:"+(xnx3_result? "成功":"失败"));
		return xnx3_result;
	}
	
}
