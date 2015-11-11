package Func;

import include.Command;
import action.Init;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Variant;

/**
 * 初始化时自动创建ComThread.initSTA
 * @author xnx3
 *
 */
public class Com {
	public ActiveXComponent activeDm=null;		//大漠
	public ActiveXComponent activeDb_MouseKey=null;	//大兵键鼠对象
	public ActiveXComponent activeDb_Window=null;		//大兵窗口对象
	
	public Com() {
		ComThread.InitSTA();
	}

	
	/**
	 * 创建DM并进行绑定
	 */
	public boolean createDm(){
		boolean xnx3_result=false;	
		
		for (int i = 0; i < 30; i++) {
			try {
				this.activeDm=new ActiveXComponent("dm.dmsoft");		//创建大漠对象
				
				//设置当前资源路径
				int setPath=activeDm.invoke("SetPath", Command.thisFilePath+"\\"+Command.resource).getInt();
				if(setPath==0){
					new Func.Message().showMessageDialog("设置当前资源路径出错！");
				}
				
				//进行dm窗口绑定
				Variant[] var=new Variant[5];
				var[0]=new Variant(Command.hwnd);
				var[1]=new Variant("dx");
				var[2]=new Variant("dx");
				var[3]=new Variant("dx");
				var[4]=new Variant(0);
				int bindWindow=activeDm.invoke("BindWindow",var).getInt();
				var=null;
				
				if(bindWindow==0){
					new File().log("窗口绑定失败,强制解除上次窗口的绑定，再次尝试中……");
					this.activeDm.invoke("ForceUnBindWindow",Command.hwnd);
					new Sleep().sleep(60000);
					xnx3_result=false;
				}else{	//绑定成功
					//加载点阵字库
					this.activeDm.invoke("SetDict",new Variant(0),new Variant("elseSimpleDict.txt"));	//自动扫货的“出售价格”,ffd800-88888,
					this.activeDm.invoke("SetDict",new Variant(1),new Variant("mapPositionDict.txt"));
					this.activeDm.invoke("SetDict",new Variant(2),new Variant("PanJunDict.txt"));
					this.activeDm.invoke("SetDict",new Variant(3),new Variant("elseDict.txt"));		//宠物壳子的“神兽侍宠蛋”、宝宝的名字等dfdfdf-333333
					this.activeDm.invoke("SetDict",new Variant(4),new Variant("tanMoneyNumDict.txt"));		//自动扫货的摊位放上后提示的价格、购买后确认的价格,bea102-333333|efca00-222222|8ea7a7-444444|d7efef-444444
					this.activeDm.invoke("SetDict",new Variant(5),new Variant("buyNumDict.txt"));		//自动扫货确认购买后购买的数量,bea102-333333|efca00-222222|8ea7a7-444444|d7efef-444444
					this.activeDm.invoke("SetDict",new Variant(6),new Variant("stoneGuaDict.txt"));		//自动扫货摊位上扫描有卦象的八卦灵石,ff0000-222222|cc0000-000000
					this.activeDm.invoke("SetDict",new Variant(7),new Variant("stoneDict.txt"));		//自动扫货摊位上扫描有卦象的八卦灵石,35bfff-555555|00ff00-555555|acf003-555555|00ffff-555555
					this.activeDm.invoke("SetDict",new Variant(8),new Variant("stoneNaiJiuDict.txt"));		//八卦灵石读取耐久度  ff0000-333333|d30707-666666|ffffff-222222|efefef-555555|9f9d9b-333333|00ff00-333333|03d008-555555

					if(Command.useOptimizeCpu){
						//降低CPU占用
						this.activeDm.invoke("DownCpu",50);
					}
					
					xnx3_result=true;
					Command.bindWindow=true;			//dm窗口已绑定
					Command.dmComLastCreateTime=include.Module.Now_date.xnx3_time();	//记录此次创建COM接口的时间
					
					i=30;
				}
			} catch (Exception e) {
				xnx3_result=false;
				e.printStackTrace();
				new Func.File().log("DM初始化Func.dmInit()异常捕获:"+e.getMessage());
			}
			
		}
		
		if(xnx3_result){
			//成功
		}else{		
			if(Command.run){		//如果是在运行过冲中意外绑定失败，发送邮件,结束软件运行！
//				绑定窗口失败后报警，待加入
				
				new Func.SendMail().send("窗口绑定失败", "窗口绑定失败，请关闭游戏后重新打开！(游戏运行一段时间寻仙游戏客户端就容易出现各种错误，最常见的就是弹出错误英文框、卡屏、等等,需关闭后重新登录游戏)");
				new Func.File().log("绑定窗口失败!软件已结束运行。请重新登录游戏");
				Init.runEnd();
			}
		}
		
		System.out.println("DM-COM开启");
		return xnx3_result;
	} 
	
	
	/**
	 * 释放DM
	 */
	public void releaseDm(){
		try {
			//解除绑定钱将窗口设置为当前活动窗口
			this.activeDm.invoke("SetWindowState", Command.hwnd,1);
			
			int getResult=this.activeDm.invoke("UnBindWindow").getInt();;
			if(getResult==0){	//解除绑定失败，使用强制接触绑定
				this.activeDm.invoke("ForceUnBindWindow",Command.hwnd);
			}
			
			new Func.File().log("解除对窗口的绑定，进行资源释放");
			System.out.println("COM-DM解除窗口绑定");
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("DM窗口解除绑定时异常捕获:"+e.getMessage());
		}
		
		ComThread.RemoveObject(this.activeDm);
		release();
		this.activeDm=null;
		System.out.println("DM-COM释放");
		
		//如果结束，则还原UI界面为运行前状态
		if(!Command.run){
			Init.runEndUI();
		}
		
	}
	
	
	/**
	 * 创建大漠Com对象
	 */
	public boolean createDmCom(){
		boolean xnx3_result=false;
		try {
			this.activeDm=new ActiveXComponent("dm.dmsoft");		//创建大漠对象
			xnx3_result=true;
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("创建大漠Com对象时异常捕获:"+e.getMessage());
		}
		return xnx3_result;
	}
	
	/**
	 * 创建大兵键鼠Com对象
	 */
	public boolean createDb_MouseKeyCom(){
		boolean xnx3_result=false;
		try {
			this.activeDb_MouseKey=new ActiveXComponent("DBSoft.DBSoft_MouseKey");
			xnx3_result=true;
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("创建大兵键鼠Com对象时异常捕获:"+e.getMessage());
		}
		
		return xnx3_result;
	}
	
	/**
	 * 创建大兵窗口Com对象
	 */
	public boolean createDb_WindowCom(){
		boolean xnx3_result=false;
		try {
			this.activeDb_Window=new ActiveXComponent("DBSoft.DBSoft_Window");
			xnx3_result=true;
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("创建大兵窗口Com对象时异常捕获:"+e.getMessage());
		}
		
		return xnx3_result;
	}
	
	
	/**
	 * 释放资源
	 */
	public void release(){
		ComThread.Release();
		new Func.File().log("COM释放完毕,资源释放完毕！");
		Command.bindWindow=false;		//dm对窗口解除绑定,预示着可以进行下一次绑定了
	}
	
	
}
