package action;

import javax.security.auth.callback.ConfirmationCallback;

import include.Command;
import Func.Dm;
import Func.Lang;

import com.jacob.com.Variant;

public class Init {
	
	/*
	 * 开启挂机运行初始化
	 */
	public static void startInit(){
		new Thread(new Runnable() {
			public void run() {
				
				boolean xnx3_result=true;
				//判断软件是否已注册，(免费模式下不需要注册,跳过)
				if(include.Command.register.get("use").equals("1")||Command.JForm.daGuaiModeljComboBox.getSelectedIndex()==3){
					
					//设置界面
					Command.JForm.runStartjButton.setVisible(false);
					Command.JForm.runEndjButton.setVisible(true);
					
					//权限判断
					if(include.Command.JForm.daGuaiModeljComboBox.getSelectedIndex()==0||include.Command.JForm.daGuaiModeljComboBox.getSelectedIndex()==1||include.Command.JForm.daGuaiModeljComboBox.getSelectedIndex()==6){
						//水底开鼓+打怪|水底只开鼓|水底定点开鼓
						if(Command.autoKaiGu){
							xnx3_result=true;
						}else{//如果没有开鼓权限，则退出
							xnx3_result=false;
							new Func.Message().showMessageDialog("此注册码没有使用[水底开鼓+打怪][水底自动开鼓]权限！<br/>想使用水底自动开鼓可联系我们购买");
						}
					}
					if(include.Command.JForm.daGuaiModeljComboBox.getSelectedIndex()==2){		//普通打怪模式
						if(Command.useDaguai){		//有打怪的权限
							xnx3_result=true;
						}else{
							xnx3_result=false;
							new Func.Message().showMessageDialog("此注册码没有[普通打怪模式]权限！<br/>想使用[普通打怪模式]可联系我们购买");
						}
					}
					if(include.Command.JForm.daGuaiModeljComboBox.getSelectedIndex()==4){		//自动扫货模式
						if(Command.useSaoHuo){		//有自动扫货的权限
							xnx3_result=true;
						}else{
							xnx3_result=false;
							new Func.Message().showMessageDialog("此注册码没有[交易自动扫货]权限！<br/>想使用可联系我们购买");
						}
					}
					if(include.Command.JForm.daGuaiModeljComboBox.getSelectedIndex()==7){		//高级打怪模式
						if(Command.useSFight){		//有高级打怪的权限
							xnx3_result=true;
						}else{
							xnx3_result=false;
							new Func.Message().showMessageDialog("此注册码没有[高级打怪功能]权限！<br/>想使用可联系我们购买");
						}
					}
					
					//是否绑定了电脑
					if(Command.bindComputer){	//绑定了电脑
						if(Command.myComputerSoleCode){
							//通过
							xnx3_result=true;
						}else{
							xnx3_result=false;
							new Func.Message().showMessageDialog("注册码并非绑定的本台机器！<br/>开启失败");
						}
					}
					
					
					if(xnx3_result){
						//首先判断当前窗口是否已绑定
						boolean bindWindow=false;
						if(Command.bindWindow){
							bindWindow=true;
						}else{
							bindWindow=SetHwnd.bindWindow();
						}
						
						if(Command.JForm.daGuaiModeljComboBox.getSelectedIndex()==3||Command.JForm.daGuaiModeljComboBox.getSelectedIndex()==5){
							//如果是捉宝宝或者自动按键鼠标模拟的话不做颜色初始化判断处理
						}else{
							if(bindWindow){
								try {
									//改变窗口大小
									int setWindowSize=Command.activeDm.invoke("SetClientSize", new Variant(Command.hwnd),new Variant(Command.clientWidth),new Variant(Command.clientHeight)).getInt();
									new Func.File().log("改变窗口大小:"+(setWindowSize==1? "成功":"失败"));
									if(setWindowSize!=1){
										new Func.Message().showMessageDialog("设置窗口大小出错！<br/>请联系作者!");
										xnx3_result=false;
									}
									
									//判断目标点血量X开始的颜色,从99以前先开始匹配
									Command.myXueY=52;
									Command.myLanY=60;
									String errorColor=Command.JForm.jComboBoxErrorXueStart.getSelectedIndex()==0? Command.colorErrorTwo:Command.colorErrorThree;
									int cmpColor=Command.activeDm.invoke("CmpColor", new Variant(Command.myXueXStart+10),new Variant(Command.myXueY),new Variant(Command.myXueColor+"-"+errorColor),new Variant(Command.doubleTen)).getInt();
									new Func.File().log("匹配我的血量开始的颜色:"+(cmpColor==0? "成功":"失败，自动调整至100级模式进行匹配"));
									
									if(cmpColor==1){
										//调整至100级的模式匹配
										Command.myXueY=54;
										Command.myLanY=62;
										int cmpColor100=Command.activeDm.invoke("CmpColor", new Variant(Command.myXueXStart+10),new Variant(Command.myXueY),new Variant(Command.myXueColor+"-"+errorColor),new Variant(Command.doubleTen)).getInt();
										new Func.File().log("匹配我的血量开始的颜色:"+(cmpColor100==0? "成功":"失败，自动调整至100级模式进行匹配"));
										
										if(cmpColor100==1){
											if(new Func.Message().showConfirmDialog("我的血量开始位置匹配失败！<br/>可能原因：<br/>1.游戏-系统设置没有按照我们说的设置！<br/>2.人物的血条被遮挡住了<br/><br/>是否打开指定设置图观看，并按照此图所示设置")==ConfirmationCallback.YES){
												Command.browser.loadUrl("http://www.xnx3.com/xunxian/fuzhu/gameSystemSet.html",200,200,530,555);
											}
											
											new Func.File().screenImage("软件开启血量不匹配记录",Command.myXueXStart+10,Command.myXueY,Command.myXueXStart+210,Command.myXueY+200);
											xnx3_result=false;
										}
										
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}else{
								xnx3_result=false;
							}
						}
						
					}
					
					
					if(xnx3_result){
						//匹配完毕，可以运行，加载数据，进行初始化
						Command.mainThread=true;	//定义主线程
						Command.run=true;			//运行状态
						
						modeInit();					//根据模式、选项进行初始化数据
						
						
						switch (Command.JForm.daGuaiModeljComboBox.getSelectedIndex()) {
						case 3:		//免费模式下并且是捉宝宝打符123键时
							SetHwnd.bindWindow();
							new Dm().unBindWindow();		//解除绑定
							new ZhuoBaoBaoThread().start();		//开启捉宝宝打符线程
							break;
						case 4:			//扫货
							//初始化
							if(new SaoHuoFunc(Command.activeDm).initTanWei()){
								new Dm().unBindWindow();		//解除绑定
								new Func.ThreadCommand().startSaoHuoThread();
							}else{
								xnx3_result=false;
							}
							break;
						case 5:		//模拟按键、鼠标点击
							new Dm().unBindWindow();		//解除绑定,使用动态COM
							new SkillThread().start();
							break;
						case 6:		//固定点只开鼓
							angleInit();
							Profession.dataInit();	//对应各职业，数据初始化
							new Dm().unBindWindow();		//解除绑定,使用动态COM
							
							new Func.ThreadCommand().startSettledOpenGuThread();
							
							break;
						default:	//打怪模式
							angleInit();
							
							Profession.dataInit();	//对应各职业，数据初始化
							
							new Dm().unBindWindow();		//解除绑定,使用动态COM
							
							new Func.ThreadCommand().startDaGuaiThread();
							break;
						}
						new Func.File().log("初始化数据完毕，开始执行");
					}

					if(!xnx3_result){
						new Func.File().log("初始化失败！结束运行！！");
						SetHwnd.bindWindow();
						
						//初始化失败，回滚设置界面
						Command.JForm.runStartjButton.setVisible(true);
						Command.JForm.runEndjButton.setVisible(false);
					}
				}else{
					xnx3_result=false;
					new Func.Message().showMessageDialog("软件没有注册还不能运行!<br/>"+include.Command.register.get("message"));
				}
			}
		}).start();
	}
	
	
	
	/**
	 * 模式、地图,自定义打怪\捉宝宝\扫货等模式
	 */
	public static void modeInit(){
		Command.runModel= Command.JForm.daGuaiModeljComboBox.getSelectedIndex();
		Command.runMap=Command.JForm.daGuaiMapjComboBox.getSelectedIndex();
		
		Lang lang=new Lang();
		Command.myEmail=Command.JForm.setMailjTextField.getText();	//获取设置的邮箱
		Command.roleName=Command.JForm.roleNamejTextField.getText();	//软件对应的角色名字
		Command.myOverTime=lang.Integer_(Command.JForm.jTextFieldMyOverTime.getText() , 600000);
		Command.systemSleep=Command.jComboBoxOptimizeArray[Command.JForm.jComboBoxOptimize.getSelectedIndex()]*60*60*1000;
		Command.autoXunLuTime=2000;	//默认2秒
		Command.autoXunLuChangeUse=true;		//默认开启自动寻路的大地图走动随机+1，开鼓时需要精确，故而关闭
		Command.useOptimizeCpu=Command.JForm.jCheckBoxUseOptimizeCpu.isSelected();	//是否开启CPU降频
		
		Command.overGuard=true;
		Command.helpJiNeng1Use=true;
		Command.helpJiNeng2Use=true;
		Command.helpHongUse=true;
		Command.helpLanUse=true;
		Command.readSmallPosition=false;		//关闭读取小地图坐标
		Command.autoTreatUse=false;				//关闭自动治疗
		Command.autoXiuLi=true;		//关闭自动修装备
		
		//对应Command.daguaiModeArray
		switch (Command.runModel) {
		case 0:			//水底打叛军+开鼓
			Command.runType=1;	//打怪模式
			Command.daguaiMode=1;
			Command.guaiHeadBmpS="QianNingHePanJun1.bmp|QianNingHePanJun2.bmp";
			Command.guaiHeadBmpSBoolean=true;
			Command.autoKaiGu=true;	//自动开鼓
			Command.directSet=true;	//死亡后小地图方向识别
			Command.readSmallPosition=true;		//开启读取小地图坐标
			Command.autoXunLuTime=5000;	//5秒，防止一走一停
			Command.autoXunLuChangeUse=false;	//关闭大地图自动寻路的随机+1
			
			//丞相大营
			if(Command.runMap==0){
				setMapData(0,80,20);
			}
			
			//水草盆地
			if(Command.runMap==1){
				setMapData(1,120,30);
			}
			
			break;
		case 1:			//只开鼓
			Command.runType=1;	//打怪模式
			Command.daguaiMode=1;
			Command.guaiHeadBmpS="logo.bmp";	//不打怪
			Command.guaiHeadBmpSBoolean=true;
			Command.autoKaiGu=true;	//自动开鼓
			Command.directSet=true;	//死亡后小地图方向识别
			Command.readSmallPosition=true;		//开启读取小地图坐标
			Command.autoXunLuTime=15000;	//15秒，防止一走一停
			Command.autoXunLuChangeUse=false;	//关闭大地图自动寻路的随机+1
			
			//丞相大营
			if(Command.runMap==0){
				setMapData(0,80,20);
			}
			
			//水草盆地
			if(Command.runMap==1){
				setMapData(1,120,30);
			}
			
			break;
		case 2:		//普通打怪模式
			Command.runType=1;	//打怪模式
			Command.daguaiMode=2;
			Command.guaiHeadBmpS="logo.bmp";	//打所有怪
			Command.guaiHeadBmpSBoolean=false;	//不指定怪类型，打所有
			Command.autoKaiGu=false;	//禁止自动开鼓
			Command.directSet=false;	//死亡后小地图方向识别禁用
			Command.autoXunLuChangeUse=true;	//开启大地图自动寻路的随机+1
			
			switch (Command.runMap) {
			case 0:
				setMapData(12, 3, 1);
				break;
			case 1:		//求仙镇-三家村
				setMapData(2, 10, 3);
				break;
			case 2:		//地府-无根地
				setMapData(3, 40, 5);
				break;
			case 3:		//茅山-乱坟岗
				setMapData(4, 20, 3);
				break;
			case 4:		//通天河-景阳冈
				setMapData(5, 13, 1);
				break;
			case 5:		//舍身台-天书崖
				setMapData(6, 10, 1);
				break;
			case 6:		//摩云山-风香原
				setMapData(7, 15, 1);
				break;
			case 7:		//摩云山-歌雨滩
				setMapData(8, 30, 1);
				break;
			case 8:		//摩云山-灵谷
				setMapData(9, 10, 1);
				break;
			case 9:		//摩云山-宸虎观
				setMapData(10, 10, 1);
				break;
			case 10:
				Command.daguaiMode=1;
				Command.guaiHeadBmpS="QianNingHePanJun1.bmp|QianNingHePanJun2.bmp";
				Command.guaiHeadBmpSBoolean=true;
				setMapData(0,80,3);
				break;
			case 11:
				Command.daguaiMode=1;
				Command.guaiHeadBmpS="QianNingHePanJun1.bmp|QianNingHePanJun2.bmp";
				Command.guaiHeadBmpSBoolean=true;
				break;
			case 12:		//摩云山-啸风州-精魄阵
				setMapData(11, 1, 1);
				break;
			default:
				break;
			}
			
			break;
		case 3:		//捉宝宝
			switch (Command.runMap) {
			case 0:			//自动打符123键
				//捉宝宝打符，不做处理
				break;
			default:
				break;
			}
			
			break;
		case 4:			//自动扫货
			Command.runType=2;	//扫货模式
			
//			将监控线程的喝红、蓝、回生水、自动释放保护机能不启用
			Command.helpJiNeng1Use=false;
			Command.helpJiNeng2Use=false;
			Command.helpHongUse=false;
			Command.helpLanUse=false;
			Command.overGuard=false;
			
			//载入界面设置的数据
			Command.saoHuoNowPosition=1;		//开始扫货的地点，默认为1号区域
			
			Command.saoHuoOneTongScanUse=Command.JframeSaoHuo.saoHuoOneTongjCheckBox.isSelected();
			Command.saoHuoStoneUse=Command.JframeSaoHuo.saoHuoStonejCheckBox.isSelected();
			Command.saoHuoPetUse=Command.JframeSaoHuo.saoHuoPetjCheckBox.isSelected();
			Command.saoHuoGroceriesUse=Command.JframeSaoHuo.saoHuoGroceriesjCheckBox.isSelected();
			Command.saoHuoFengWuZhiUse=Command.JframeSaoHuo.saoHuoFengWuZhijCheckBox.isSelected();	//风物志扫描是否开启
			Command.saoHuoLegendUse=Command.JframeSaoHuo.saoHuoLegendjCheckBox.isSelected();
			Command.saoHuoQiangLiJueUse=Command.JframeSaoHuo.saoHuoQiangLiJuejCheckBox.isSelected();
			Command.saoHuoTongShenJueUse=Command.JframeSaoHuo.saoHuoTongShenJuejCheckBox.isSelected();
			Command.saoHuoZhanHunUse=Command.JframeSaoHuo.saoHuoZhanHunjCheckBox.isSelected();
			
			//设置发送邮件默认第一次为开启发送邮件，第一次设为开启
			Command.emailMoneyNotEnoughFirst=true;
			
			//保存设置的数据
			File file=new File();
			file.saoHuoGroceriesSave();		
			file.saoHuoGroceriesLoad();		//杂货类加载最新数据
			
			file.saoHuoStoneSave();
			file.saoHuoStoneLoad();			//八卦灵石
			
			file.saoHuoPetSave();
			file.saoHuoPetLoad();			//宠物壳子
			
			file.saoHuoFengWuZhiSave();		//风物志
			file.saoHuoFengWuZhiLoad();
			
			file.saoHuoLegendSave();		//传奇配方
			file.saoHuoLegendLoad();
			
			file.saoHuoElseClassSave();		//其他分类
			file.saoHuoElseClassLoad();
			
			file=null;
			break;
		case 5:		//后台模拟键盘鼠标操作
			switch (Command.runMap) {
			case 0:			//后台模拟鼠标键盘操作
				new Skill().initData();
				break;
			default:
				break;
			}
			
			break;
		case 6:		//水底定点开鼓
			Command.runType=1;	//打怪模式
			Command.daguaiMode=1;
			Command.guaiHeadBmpS="logo.bmp";	//不打怪
			Command.guaiHeadBmpSBoolean=true;
			Command.autoKaiGu=true;	//自动开鼓
			Command.directSet=true;	//死亡后小地图方向识别
			Command.readSmallPosition=true;		//开启读取小地图坐标
			Command.autoXunLuTime=15000;	//15秒，防止一走一停
			
			//手动到固定出鼓点呆那等待开鼓
			if(Command.runMap==0){
				//待添加
			}
			
			break;
		case 7:		//高级打怪模式-收费的
			Command.runType=1;	//打怪模式
			Command.daguaiMode=3;	//使用模式三
			Command.guaiHeadBmpS="logo.bmp";	//打所有怪
			Command.guaiHeadBmpSBoolean=false;	//不指定怪类型，打所有
			Command.autoKaiGu=false;	//禁止自动开鼓
			Command.directSet=false;	//死亡后小地图方向识别禁用
			Command.autoXunLuChangeUse=true;	//开启大地图自动寻路的随机+1
			Command.autoTreatUse=true;		//开启自动治疗
			Command.autoXiuLi=true;		//开启自动修装备
			Command.xiuLi_UseMenPai=Command.JframeSeniorFight.jCheckBoxXiuLi_UseMenPai.isSelected();		//是使用门派的修理还是使用地图内的修理
			
			//SeniorFight.form
			Command.useLanAnswer=Command.JframeSeniorFight.jCheckBoxUseLanAnswer.isSelected();
			Command.serverIP=Command.JframeSeniorFight.jTextFieldServerIP.getText();
			Command.faqSendPort=Command.JframeSeniorFight.jTextFieldFaqSendPort.getText();
			Command.autoXiuLi=Command.JframeSeniorFight.jCheckBoxAutoXiuLi.isSelected();
			Command.autoEmptyParcel=Command.JframeSeniorFight.jCheckBoxAutoEmptyParcel.isSelected();
			Command.hoursStart=lang.Integer_(Command.JframeSeniorFight.jTextFieldHoursStart.getText(), 0);
			Command.hoursEnd=lang.Integer_(Command.JframeSeniorFight.jTextFieldHoursEnd.getText(), 23);
			Command.useLanIpIsOnline=Command.JframeSeniorFight.jCheckBoxLanIpIsOnline.isSelected();
			
			switch (Command.runMap) {
			case 0:		//京城-皇陵道
				setMapData(13, 6, 2);
				break;
			case 1:		//京城-坑牙洞门口前
				setMapData(14, 6, 2);
				break;
			case 2:		//京城坑牙洞内
				setMapData(15, 60, 2);
				break;
			case 3:		//毛衫乱坟岗
				setMapData(16, 6, 2);
				break;
			case 4:		//茅山-石门西郊
				setMapData(17, 5, 2);
				break;
			case 5:		//地府-忘川岸
				setMapData(18, 12, 2);
				break;
			case 6:		//地府-罗浮寨复活点
				setMapData(19, 6, 2);
				break;
			case 7:		//地府-无根地
				setMapData(20, 13, 2);
				break;
			case 8:		//摩云山-响石岭-精魄阵
				setMapData(21, 2, 2);
				break;
			case 9:		//五岳山麓-瓜田
				Command.daguaiMode=4;	//使用模式四，两管血
				setMapData(22, 12, 2);
				break;
			case 10:		//五岳山麓-高老庄
				Command.daguaiMode=4;	//使用模式四，两管血
				setMapData(23, 7, 2);
				break;	
			case 11:		//五岳山麓-福陵山
				Command.daguaiMode=4;	//使用模式四，两管血
				setMapData(24, 5, 2);
				break;	
			case 12:		//五岳山麓-子午岭
				Command.daguaiMode=4;	//使用模式四，两管血
				setMapData(25, 9, 2);
				break;	
			case 13:	//摩云山东部-精魄阵-小怪
				setMapData(26, 5, 2);
				break;
			case 14:	//摩云山东部-哭风岭
				setMapData(27, 6, 2);
				break;
			case 15:		//五岳山麓-白云观
				Command.daguaiMode=4;	//使用模式四，两管血
				setMapData(28, 3, 2);
				break;
			case 16:	//五岳山麓-子午岭瓜田
				Command.daguaiMode=4;	//使用模式四，两管血
				setMapData(29, 5, 2);
				break;
			default:
				break;
			}
			
			break;
		default:
			break;
		}

	}
	
	/**
	 * 服务于daguaiModeInit()，设定当前走动的地图
	 * <li>int i:数组下标
	 * <li>routeMapMax:大地图最大走动次数
	 * <li>positionMapMax:小地图最大走动次数
	 */
	public static void setMapData(int i,int routeMapMax,int positionMapMax){
		Command.routeMapX=Command.routeMapXArray[i];
		Command.routeMapY=Command.routeMapYArray[i];
		Command.targetPositionX=Command.targetPositionXArray[i];
		Command.targetPositionY=Command.targetPositionYArray[i];
		Command.routePositionLimit=Command.routePositionLimitArray[i];
		Command.routeMapMax=routeMapMax;
		Command.positionMapMax=positionMapMax;
		Command.rankMax=Command.routeMapX.length;
	}
	
	/**
	 * 设置角度为俯视
	 */
	public static void angleInit(){
		//设置视角为最上方往下看
		int keyDown=Command.activeDm.invoke("KeyDown",104).getInt();
		new Func.File().log("调整角度为俯视");
		new Func.Sleep().sleep(3000);
		Command.activeDm.invoke("KeyUp",104);
	}
	
	/**
	 * 点击结束按钮，结束软件运行
	 */
	public static void runEnd(){
		Command.run=false;				//结束运行状态
		Command.mainThread=false;		//结束打怪主线程

		Command.JForm.getHwndjButton.setVisible(true);		//获取目标窗口显示
		new Func.Message().showMessageDialog("正在结束运行，请稍后……<br/>预计一分钟后结束运行");
		
		//开启线程监控，避免卡住无法停止
	}
	
	/**
	 * 软件真正结束运行之后恢复UI运行前的设置
	 */
	public static void runEndUI(){
		Command.JForm.runStartjButton.setVisible(true);
		Command.JForm.runEndjButton.setVisible(false);
	}
}
