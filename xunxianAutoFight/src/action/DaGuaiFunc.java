package action;
import Func.Color;
import Func.File;
import Func.FindPic;
import Func.FindStr;
import Func.Lang;
import Func.Mouse;
import Func.Position;
import Func.Press;
import Func.Sleep;
import Func.XinNuo;

import com.jacob.activeX.ActiveXComponent;

import include.Command;

public class DaGuaiFunc {
	ActiveXComponent activeDm=null;
	Mouse mouse=null;
	Sleep sleep=null;
	FindPic findPic=null;
	FindStr findStr=null;
	Lang lang=null;
	File file=null;
	Color color=null;
	Press press=null;
	Position position=null;
	XinNuo xinNuo=null;		//信诺答题
	Guard guard=null;		//监视
	
	private int positionOneChange=1;		//每次使用M键打开地图走位都会使X坐标+1或者+0，2次各不相同，避免终止寻路造成卡的现象
	
	public DaGuaiFunc() {
	}
	
	//增加地图后的调试配置快速定位，无实际作用
	public void switchConfigHelp(){
		repairEquip();	//修理装备
		overZhiLiao();	//死亡后调用的治疗
	}
	
	public DaGuaiFunc(ActiveXComponent activeDm){
		this.activeDm=activeDm;
		
		this.mouse=new Func.Mouse(this.activeDm);
		this.sleep=new Func.Sleep();
		this.findPic=new Func.FindPic(this.activeDm);
		this.findStr=new Func.FindStr(this.activeDm);
		this.lang=new Func.Lang();
		this.file=new Func.File(this.activeDm);
		this.color=new Func.Color(this.activeDm);
		this.press=new Func.Press(this.activeDm);
		this.position=new Func.Position(this.activeDm);
		
		this.guard=new Guard(this.activeDm);
	}
	
	/**
	 * 进入开始运行
	 */
	public void start(){
//		//TAB
		try {
			press.keyPress(9);
			sleep.sleep(400);
			if(isKilTarget()){
				daGuaiAction();
			}else{
				//没有找到怪，进行走动
				routeMap();
			}
			guard();
		} catch (Exception e) {
			e.printStackTrace();
			this.file.log(Command.daGuaiThread.getName()+"异常捕获:"+e.getMessage());
		}
		
		//检测修理装备
		this.repairEquip();
	}
	
	
	/**
	 * 打怪动作，直至怪锁定的人物没有血为止
	 * headPic:怪的头像。多个用|分割
	 */
	public void daGuaiAction(){
		boolean haveGuai=false;	//是否有怪,此怪是否是可值得攻击怪
		//首先根据打怪模式判断是否怪有血|有怪头像
		switch (Command.daguaiMode) {
		case 1:		//打怪模式1，水底,判断怪头像是否符合要求
			haveGuai=findPic.findPicE(Command.guaiHeadXStart, Command.guaiHeadYStart, Command.guaiHeadXEnd, Command.guaiHeadYEnd, Command.guaiHeadBmpS);
			break;
		case 2:		//打怪模式2，普通打怪模式，打所有一管血的怪
			haveGuai=color.findColor(Command.guaiXueXStart, Command.guaiXueY, Command.guaiXueColor);
			break;
		case 3:	//打怪模式3，高级打怪模式，打所有一管血的怪，同时不打可捕捉坐骑类型的怪
			boolean guaiHaveXue=color.findColor(Command.guaiXueXStart, Command.guaiXueY, Command.guaiXueColor);
			switch (Command.runMap) {
			case 0:	//京城皇陵
				haveGuai=guaiHaveXue&&!this.findPic.findPicE(378,17,462,98, "zuoQi_ShanWa.bmp|zuoQi_ShanChai.bmp|zuoQi_Lu.bmp|zuoQi_XieZi.bmp|uniteIronHead_PingHuGang.bmp|zuoQi_QingNiu.bmp|zuoQi_SiBuXiang.bmp");
				break;
			case 1:	//京城坑牙洞外
				haveGuai=guaiHaveXue&&!this.findPic.findPicE(378,17,462,98, "zuoQi_ShanWa.bmp|zuoQi_ShanChai.bmp|zuoQi_Lu.bmp|zuoQi_XieZi.bmp|uniteIronHead_PingHuGang.bmp|zuoQi_QingNiu.bmp|zuoQi_SiBuXiang.bmp");
				break;
			case 2:	//京城坑牙洞内
				haveGuai=guaiHaveXue&&!this.findPic.findPicE(378,17,462,98, "zuoQi_ShanWa.bmp|zuoQi_ShanChai.bmp|zuoQi_Lu.bmp|zuoQi_XieZi.bmp|uniteIronHead_PingHuGang.bmp|zuoQi_QingNiu.bmp|zuoQi_SiBuXiang.bmp");
				break;
			case 3:	//毛衫乱坟岗,团子虫
				haveGuai=guaiHaveXue&&!this.findPic.findPicE(378,17,462,98, "zuoQi_TuanZiChong.bmp");
				break;
			default:
				haveGuai=guaiHaveXue;
				break;
			}
		case 4:	//一管血两管血的怪都打
			haveGuai=color.findColor(Command.guaiXueXStart, Command.guaiXueY, Command.guaiXueColor)||color.findColor(Command.guaiXueXStart, Command.guaiXueY, Command.guaiXueColor2);
			break;
		default:
			break;
		}
		
		if(haveGuai&&Command.mainThread){
			//先打，拉仇恨，直到怪锁定了自己
			int i=0;
			while(!color.findColor(Command.guaiMyXueX, Command.guaiMyXueY,Command.guaiMyColor)&&isKilTarget()){
				press.keyPress(Command.jineng1Key);
				sleep.sleep(300);
				if(i++>10){	//超过10次还没有拉到仇恨，退出
					break;
				}
				guard();
			}
			
			//怪锁定了自己，开始正式打怪
			int da=0;	//避免颜色失误造成卡死现象
			while(ifGuaiOver()&&Command.mainThread&&da++<22){
				press.keyPress(Command.jineng1Key);
				sleep.sleep(200);
				
				if(ifGuaiOver()){
					press.keyPress(Command.jineng2Key);
					sleep.sleep(150);
					press.keyPress(Command.jineng3Key);
					sleep.sleep(150);
				}
				
				if(ifGuaiOver()){
					press.keyPress(69);
					sleep.sleep(150);
					press.keyPress(82);		//R键
					sleep.sleep(150);
					press.keyPress(81);		//Q键
					sleep.sleep(150);
				}
				
				guard();
			}
			
			//不正常，跳出循环，释放锁定角色
			if(da>=25){
				this.file.log("打怪出现锁定目标死循环，释放中……");
				System.out.println("打怪出现锁定目标死循环，释放中……");
				releaseHeadLock();
				releaseHeadLock();
				releaseHeadLock();
				releaseHeadLock();
				releaseHeadLock();
			}
			z();
		}
		
	}
	/**
	 * 确认是否怪已彻底死亡-->判断怪锁定的人物是否存在
	 * @return 怪未死，返回true
	 */
	public boolean ifGuaiOver(){
		boolean xnx3_result=false;
		
		//怪锁定的人物有血
		xnx3_result=color.findColor(Command.guaiMyXueX, Command.guaiMyXueY, Command.guaiMyColor);
		
		return xnx3_result;
	}
	
	/**
	 * 是否是指定要杀的怪,返回boolean，如果是，要杀，则返回1
	 * 	<ul>打怪模式int(Command.daguaiMode)
	 * 		<li>1.只打指定头像的怪,无论怪有几管血（判断怪头像）
	 * 		<li>2.打所有只有一管血的怪（判断怪的血开始点）
	 * 		<li>3.打一管血的怪，并且制定的怪头像不打
	 * 		
	 * @return 如果是要杀的怪，返回true
	 */
	public boolean isKilTarget(){
		boolean xnx3_result=false;
		
		switch (Command.daguaiMode) {
		case 1:
			xnx3_result=findPic.findPicE(Command.guaiHeadXStart, Command.guaiHeadYStart, Command.guaiHeadXEnd, Command.guaiHeadYEnd, Command.guaiHeadBmpS);
			break;
		case 2:
			xnx3_result=color.findColor(Command.guaiXueXStart, Command.guaiXueY, Command.guaiXueColor)&&color.findColor(Command.guaiXueXStart, Command.guaiXueY, Command.guaiXueColor);
			break;
		case 3:
			xnx3_result=color.findColor(Command.guaiXueXStart, Command.guaiXueY, Command.guaiXueColor)&&!this.findPic.findPicE(378,17,462,98, "zuoQi_ShanWa.bmp|zuoQi_ShanChai.bmp|zuoQi_Lu.bmp|zuoQi_XieZi.bmp|uniteIronHead_PingHuGang.bmp|zuoQi_TuanZiChong.bmp|zuoQi_QingNiu.bmp|zuoQi_SiBuXiang.bmp");
			break;
		case 4:	//一管血两管血的怪都打
			xnx3_result=this.color.findColor(Command.guaiXueXStart, Command.guaiXueY, Command.guaiXueColor)||this.color.findColor(Command.guaiXueXStart, Command.guaiXueY, Command.guaiXueColor2);
			break;
		default:
			break;
		}
		
		return xnx3_result;
	}
	
	/**
	 * 何红、喝蓝、判断是否死亡、是否出验证码
	 */
	public void guard(){
		
		//判断是否出现了拾取时需要绑定的物品
		if(this.findPic.findPicE(327,145,691,548, "titleBackground.bmp")){
			String readStr=this.findStr.readStr(376,305,660,474, "ffffff-111111|c0bfbd-444444", Command.doubleNine, 3);
//			【将与您绑定】，五个出现四个则视为出现了拾趣时要绑定的物品
			int result=0;
			if(readStr.indexOf("将")>0){
				result++;
			}
			if(readStr.indexOf("与")>0){
				result++;
			}
			if(readStr.indexOf("您")>0){
				result++;
			}
			if(readStr.indexOf("绑")>0){
				result++;
			}
			if(readStr.indexOf("定")>0){
				result++;
			}
			if(result>3){	//出现了四个或者以上，则视为出现了
				System.out.println("出现了绑定提示");
				int position[] =this.findPic.findPicEPosition(308,227,711,536, "enter.bmp");
				if(position[0]>-1){	//点击确定按钮
					this.mouse.mouseClick(position[1], position[2], true);
				}
			}
		}
		
		if(this.guard.run()==1){
			System.out.println("死亡了");
			//是否是死亡了
			if(Command.autoTreatUse){
				overZhiLiao();
			}
		}
	}
	
	/**
	 * 装备修理
	 */
	public void repairEquip(){
		//是否启用了自动修装备功能
		if(Command.autoXiuLi){
			//判断是否出现了需要修理装备的图片
			if(this.findPic.findPicE(932,347,953,371, "findEquipDamage.bmp|findEquipDamage_2.bmp|findEquipDamage_3.bmp|findEquipDamage_4.bmp|findEquipDamage_5.bmp")){
				//首先判断人物是否是处于战斗状态，若是不是战斗状态，则可以回门派,判断任务头像左下的战斗图标
				if(this.findPic.findPicE(6,74,32,96, "isFightState.bmp")){
					//当前是战斗状态，无法传送至门派
				}else{
					//使用的是门派的还是地图内的
					if(Command.xiuLi_UseMenPai){	//使用的门派
						
						/**回门派修理装备**/
						transferProp(272);
						
						//检查一遍，是否是开着其他的包裹啊啥的窗口
						windowClose();
						
						//回到门派广场修理装备，调整角度为俯视
						setLookDown();
						
						//M打开大地图
						this.press.keyPress(77);
						this.sleep.sleep(200);
						//找到大地图右侧的功能地点，点开下拉菜单
						this.mouse.mouseClick(814,174, true);
						this.sleep.sleep(200);
						//点击下拉菜单中的门派铁匠
						this.mouse.mouseClick(842,193, true);
						this.sleep.sleep(100);
						//关闭大地图
						this.press.keyPress(77);
						//0键寻路过去
						this.press.keyPress(48);
						//正常大概在15秒，多增加点，避免受伤时寻路时间增加
						this.sleep.sleep(11000);
						
						this.press.keyPress(32);
						this.sleep.sleep(400);
						this.press.keyPressTime(65, 400);
						
						//铁匠修理
						findTieJiangRepairAction("uniteIronHead.bmp");
						
						boolean rstrans=true;
						while(rstrans){
							//修理完毕，传送至门派广场，准备出去
							transferProp(272);
							this.file.log("修理完毕，传送至门派广场，准备出去");
							
							//点击入世阵，出去,通常进入门派时方位跟角度是固定的
							int rsI=0;
							//判断是否是选中了，点击点是否正确
							while(rsI++<8){
								if(this.findPic.findPicE(402,44,436,75, "ruShiZhen.bmp")){
									//是，没错
									this.mouse.mouseClick(623,(30+(rsI-1)*55), true);	//因执行了++，故而减一
									this.sleep.sleep(4000);
									//点击离开
									this.mouse.mouseClick(161,267, true);
									//延迟，避免卡住误认为是死亡了
									this.sleep.sleep(8000);
									rsI=22;
									rstrans=false;//退出while循环
								}else{
									//点击入世阵，出去,通常进入门派时方位跟角度是固定的
									this.mouse.mouseClick(623,(30+rsI*55), false);
									System.out.println("623,"+(30+rsI*55));
									
									//调整角度为俯视，为下一个回到门派广场准备
									setLookDown();
								}
							}
						}
						
						//打开地图进行判断
						this.press.keyPress(77);
						this.sleep.sleep(1000);
						if(this.findPic.findPicE(300,530,400,600, "isMenPai.bmp")){
							this.file.log("未能成功出门派！再次进行出门派动作");
							rstrans=true;
						}
						this.press.keyPress(77);
						this.sleep.sleep(1000);
						
					}else{
						System.out.println("地图内修理");
						//使用的小地图自己的,根据不同区域选择
						switch (Command.runMap) {
						case 0:	//京城皇陵
							repairPingHuGang();
							break;
						case 1:	//京城坑牙洞外
							repairPingHuGang();
							break;
						case 2:	//京城坑牙洞内
							repairPingHuGang();
							break;
						case 3:	//毛衫-乱坟岗
							repairMaoShan();
							break;
						case 4:	//茅山-石门西郊
							repairMaoShan();
							break;
						case 5:	//地府-忘川岸
							repairDiFu();
							break;
						case 6:	//地府-罗浮寨复活点
							repairDiFu();
							break;
						case 7:	//地府-无根地
							repairDiFu();
							break;
						case 8:// 摩云山-精魄阵
							repairJinXiaYi();
							break;
						case 9:	//五岳山麓-瓜田
							repairWuYueShanLuShanHaiXian(180);	//分钟
							break;
						case 10://五岳山麓-高老庄
							repairWuYueShanLuShanHaiXian(120);
							break;
						case 11://五岳山麓-福灵山
							repairWuYueShanLuShanHaiXian(160);
							break;
						case 12:	//五岳山麓-子午岭
							repairWuYueShanLuShanHaiXian(260);
							break;
						case 13:// 摩云山-精魄阵-小怪
							repairJinXiaYi();
							break;
						case 14:// 摩云山东部-哭风岭
							repairJinXiaYi();
							break;
						case 15:	//五岳山麓-白云观
							repairWuYueShanLuShanHaiXian(180);	//分钟
							break;
						case 16:	//五岳山麓-子午岭瓜田
							repairWuYueShanLuShanHaiXian(220);	//分钟
							break;
						default:
							break;
						}
						
						windowClose();	//再次检测关闭包裹
						releaseHeadLock();
						releaseHeadLock();
						releaseHeadLock();
					}
					
				}
				
			}else{
				//装备正常，不需要修理
			}
		}
		
	}
	
	/**
	 * 平湖岗修理装备
	 */
	public void repairPingHuGang(){
		System.out.println("repairPingHuGang");
		//按下7键打开指南符
		this.press.keyPress(55);
		this.sleep.sleep(200);
		
		//指南符传送平湖岗
		transferProp(300);
		//调整角度俯视
		setLookDown();
		
		findTieJiangRepairAction("uniteIronHead_PingHuGang.bmp");
	}
	
	/**
	 * 茅山-石门县门口的疗伤
	 */
	public void maoShanTreatAction(){
		setLookDown();

		//不要俯视，小键盘2调整角度
		this.press.keyPressTime(98, 200);
		
		//搜寻治疗
		findTreatAction("liao_ZaoWangYeHead.bmp");
	}
	
	/**
	 * 地府疗伤
	 * @param usezhiNanFu 是否使用指南符，使用指南符+1分钟等待，不用的话只有10秒等待
	 */
	public void diFuTreatAction(boolean usezhiNanFu){
		if(usezhiNanFu){
			//按下7键打开指南符
			this.press.keyPress(55);
			this.sleep.sleep(200);
			
			//指南符传送地府罗浮寨
			transferProp(359);
			//调整角度俯视
			setLookDown();
		}
		
		//M开地图
		this.press.keyPress(77);
		this.sleep.sleep(1000);
		this.mouse.mouseClick(277,354, true);
		//0寻路
		this.press.keyPress(48);
		this.sleep.sleep(500);
		this.press.keyPress(77);
		
		//延迟，等待走到治疗伤势的地点
		if(usezhiNanFu){
			this.sleep.sleep(60000);
		}else{
			this.sleep.sleep(10000);
		}
		
		//搜寻治疗
		findTreatAction("liao_LaoNaiNaiHead.bmp");
	}
	
	/**
	 * 摩云山东部-金亚益疗伤
	 */
	public void moYunJinYaYiAction(){
		//调整角度俯视
		setLookDown();
		
		//搜寻治疗
		findTreatAction("liao_xiaogehead.bmp");
	}
	
	/**
	 * 五岳山麓-瓜田疗伤，在子午岭
	 */
	public void wuYueShanLuGuaTianAction(){
		//调整角度俯视
		setLookDown();
		
		//搜寻治疗
		findTreatAction("liao_WuYueShanLuShanShen.bmp");
		
		releaseHeadLock();
		releaseHeadLock();
	}
	
	/**
	 * 五岳山麓公共的疗伤
	 * @param sleep 走到芭蕉洞山神那里需要的时间，毫秒
	 */
	public void wuYueShanLuPublicLiaoAction(int sleep){
		this.press.keyPress(77);	//M
		this.sleep.sleep(500);
		this.mouse.mouseClick(446,326, true);
		this.sleep.sleep(500);
		this.press.keyPress(77);	//M
		this.sleep.sleep(200);
		this.press.keyPress(48);	//M
		
		this.sleep.sleep(sleep);
		
		setLookDown();
		//调整角度大致为平视，略微俯视
		this.press.keyPressTime(98, 200);
		//搜寻治疗
		findTreatAction("liao_WuYueShanLuShanShen.bmp");
	}
	
	/**
	 * 地府修理
	 */
	public void repairDiFu(){
		//按下7键打开指南符
		this.press.keyPress(55);
		this.sleep.sleep(200);
		
		//指南符传送地府罗浮寨
		transferProp(359);
		//调整角度俯视
		setLookDown();
		
		//M开地图
		this.press.keyPress(77);
		this.sleep.sleep(1000);
		
		this.mouse.mouseClick(816,193, true);
		this.sleep.sleep(500);
		this.mouse.mouseClick(849,214, true);
		
		//0寻路
		this.press.keyPress(48);
		this.sleep.sleep(500);
		this.press.keyPress(77);
		
		this.sleep.sleep(50000);
		
		//不要俯视，小键盘2调整角度
		this.press.keyPressTime(98, 300);
		//搜寻
		findTieJiangRepairAction("uniteIronHead_DiFu.bmp");
	}
	
	/**
	 * 毛衫五宁宫修理
	 */
	public void repairMaoShan(){
		System.out.println("毛山修理装备-repairMaoShan");
		//按下7键打开指南符
		this.press.keyPress(55);
		this.sleep.sleep(200);
		
		//指南符传送五宁宫
		transferProp(330);
		//调整角度俯视
		setLookDown();
		
//		打开地图走至指定点
		this.press.keyPress(77);
		this.sleep.sleep(1000);
		this.mouse.mouseClick(276,359, true);
		this.sleep.sleep(500);
		this.press.keyPress(77);
		
		//自动寻路
		this.press.keyPress(48);
		this.sleep.sleep(30000);
		
		findTieJiangRepairAction("uniteIronHead_WuNingGong.bmp");
	}
	
	
	/**
	 * 五岳山麓-山海县内修理
	 * @param second int传入多少秒能从当前挂机点走到山海县修理的地点
	 */
	public void repairWuYueShanLuShanHaiXian(int second){
		System.out.println("山海县-repairMaoShan");
		
		//调整角度俯视
		setLookDown();
		
//		打开地图
		this.press.keyPress(77);
		this.sleep.sleep(1000);
		this.mouse.mouseClick(816,175, true);
		this.sleep.sleep(1000);
		this.mouse.mouseClick(835,213, true);
		this.sleep.sleep(500);
		//自动寻路
		this.press.keyPress(48);
		this.sleep.sleep(500);
		this.press.keyPress(77);	//关闭地图
		
		//等待200秒有足够时间到达
		this.sleep.sleep(second*1000);
		
		//按一下W键避免重叠无法点击铁匠
		this.press.keyPress(87);
		
		findTieJiangRepairAction("uniteIronHead_ShanHaiXian.bmp");
		
		//修理完毕之后回挂机点,打开地图
		this.press.keyPress(77);
		this.sleep.sleep(1000);
		this.mouse.mouseClick(136,401, true);	//山海县内，出县城，到护城河外
		this.sleep.sleep(500);
		//自动寻路
		this.press.keyPress(48);
		this.sleep.sleep(500);
		this.press.keyPress(77);	//关闭地图
		this.sleep.sleep(50000);	//50秒走出去
	}
	
	/**
	 * 摩云山东部-金峡益修理
	 */
	public void repairJinXiaYi(){
		System.out.println("金峡益修理装备-repairJinXiaYi");
		
		setLookDown();
		
//		打开地图走至指定点
		this.press.keyPress(77);
		this.sleep.sleep(1000);
		this.mouse.mouseClick(376,312, true);
		this.sleep.sleep(500);
		this.press.keyPress(77);
		
		//自动寻路
		this.press.keyPress(48);
		this.sleep.sleep(80000);	//80秒
		
		findTieJiangRepairAction("uniteIronHead_MoYunShanDongBuJinYaYi.bmp");
	}
	
	/**
	 * 调整角度为俯视
	 */
	public void setLookDown(){
		this.press.keyDown(104);
		this.sleep.sleep(3000);
		this.press.keyUp(104);
	}
	
	/*
	 * 找铁匠的过程,传入当前铁匠NPC的头像
	 */
	public void findTieJiangRepairAction(String headPic){

		/** 找铁匠 **/
//		找【门派铁匠】文字
//		int[] uniteIronArray=this.findStr.findStrE(103,101,891,651, "门|派|铁|匠", "ffffff-111111|c0bfbd-333333", Command.doubleNine, 3);
		//找门派铁匠的【铁】大图
		
		int i=0;
		while(i++<20&&include.Command.run){
			int uniteIronArray[]=this.findPic.findPicEPosition(50,101,891,651, "tieStr.bmp");
			
			System.out.println("-铁图片XY->"+uniteIronArray[1]+"|"+uniteIronArray[2]);
			this.file.log("-铁图片XY->"+uniteIronArray[1]+"|"+uniteIronArray[2]);
			if(uniteIronArray[0]==-1){
				//没找到【门派铁匠】文字，则有可能是被人物挡住，或者背景色偏差太小，转换方向再找
				System.out.println("没找到【铁】图片，则有可能是被人物挡住，或者背景色偏差太小，转换方向再找");
				this.file.log("没找到【铁】图片，则有可能是被人物挡住，或者背景色偏差太小，转换方向再找");
			}else{
				//找到了【铁】字样
				
				int tieI=0;
				int tieY=70;
				while(tieI++<10&&Command.run){
					//右键判断是否是选中了铁匠
					this.mouse.mouseClick(uniteIronArray[1]+25, uniteIronArray[2]+(tieY*tieI), false);
					System.out.println(tieI+"右键单击"+(uniteIronArray[1]+25)+"|"+(uniteIronArray[2]+(tieY*tieI)));
					this.sleep.sleep(400);
					
					//判断有没有找到铁匠的头像  uniteIronHead.bmp:门派铁匠     uniteIronHead_PingHuGang.bmp:京城平湖岗铁匠
					if(this.findPic.findPicE(387,24,453,88, headPic)){
						//找到了，无误,点开铁匠窗口
						this.mouse.mouseClick(uniteIronArray[1]+25, uniteIronArray[2]+(tieY*tieI), true);
						System.out.println(tieI+"左键单击"+(uniteIronArray[1]+25)+"|"+(uniteIronArray[2]+(tieY*tieI)));
						this.sleep.sleep(2000);
						//避免出现验证码
						this.guard.run();
						
						//等待，直到打开了铁匠窗口，看到上方的买卖标题为止
						int maiI=0;
						while(maiI++<20&&!this.findPic.findPicE(76,164,290,228, "maimai.bmp")){
							this.sleep.sleep(500);
							System.out.println("maimai.bmp->"+this.findPic.findPicE(76,164,290,228, "maimai.bmp"));
						}
						
						//点击全部修理装备
						this.mouse.mouseClick(111,520, true);
						this.sleep.sleep(1000);
						System.out.println("点击修理");
						
						//修理完毕，目的达到！完成
						System.out.println("修理完毕，目的达到！完成");
						this.file.log("修理完毕，目的达到！完成");
						
						//如果开启了自动卖出清空包裹的功能
						if(Command.autoEmptyParcel){
							emptyParcel();
						}
						
						//关闭因修改装备时打开的包裹
						this.press.keyPress(66);
						
						//检查一遍，是否真的关闭了
						windowClose();
						releaseHeadLock();
						releaseHeadLock();
						releaseHeadLock();
						releaseHeadLock();
						releaseHeadLock();
						releaseHeadLock();
						
						i=22;
						tieI=22;
					}else{
						System.out.println("没有锁定铁匠");
						this.file.log("没有锁定铁匠");
					}
					
				}
				
			}
			//按住小键盘的4键0.5秒，调整方向
			this.press.keyPressTime(100, 500);
			this.sleep.sleep(2000);
			
			uniteIronArray=null;
		}
	}
	
	/*
	 * 找治疗伤势的NPC的过程，找【疗】图片
	 */
	public void findTreatAction(String headPic){

		/** 找疗伤NPC **/
		//找疗伤的【疗】大图
		
		int i=0;
		while(i++<50&&include.Command.run){
			int uniteIronArray[]=this.findPic.findPicEPosition(103,101,891,651, "liaoStr.bmp");
			
			System.out.println("-【疗】图片XY->"+uniteIronArray[1]+"|"+uniteIronArray[2]);
			this.file.log("疗图片XY->"+uniteIronArray[1]+"|"+uniteIronArray[2]);
			if(uniteIronArray[0]==-1){
				//没找到【疗】文字，则有可能是被人物挡住，或者背景色偏差太小，转换方向再找
				System.out.println("没找到【疗】图片，则有可能是被人物挡住，或者背景色偏差太小，转换方向再找");
				this.file.log("没找到【疗】图片，则有可能是被人物挡住，或者背景色偏差太小，转换方向再找");
				//按住小键盘的4键0.5秒，调整方向
				this.press.keyPressTime(100, 200);
				this.sleep.sleep(1000);	//游戏界面的放大、缩小
			}else{
				//找到了【疗】字样
				//继而右键判断是否是选中了治疗的NPC
				this.mouse.mouseClick(uniteIronArray[1]+25, uniteIronArray[2]+90, false);
				//判断当前使用的疗伤方式NPC的头像
				
				//判断有没有找到疗伤的头像  
				if(this.findPic.findPicE(387,24,453,88, headPic)){
					//找到了，无误,点开治疗窗口
					this.mouse.mouseClick(uniteIronArray[1]+25, uniteIronArray[2]+90, true);
					this.sleep.sleep(2000);
					//避免出现验证码(治疗的应该没有验证码)
					this.guard.run();
					this.sleep.sleep(4000);	//避免延迟
					
					//等待，直到打开了疗伤窗口，看到中间进行治疗的白色图标为止
					//找治疗前面的白色小图
					int jinxingzhiliao[]=this.findPic.findPicEPosition(82,190,253,507, "jinXingZhiLiao.bmp");
					if(jinxingzhiliao[0]!=-1){
						//找到【进行治疗】前面的白色小图了，可以进行治疗
						System.out.println("//找到【进行治疗】前面的白色小图了，可以进行治疗");
						this.mouse.mouseClick(jinxingzhiliao[1]+20, jinxingzhiliao[2]+5, true);
						
						this.sleep.sleep(800);
						//点击了治疗，出来的一个对话框，确认治疗啊
						int zhiliaoButton[]=this.findPic.findPicEPosition(335,307,467,417, "zhiLiaoButton.bmp");
						if(zhiliaoButton[0]>-1){
							//点击[治疗]按钮
							this.mouse.mouseClick(zhiliaoButton[1]+3, zhiliaoButton[2]+2, true);
							this.sleep.sleep(200);
							
							releaseHeadLock();
							releaseHeadLock();
							releaseHeadLock();
							releaseHeadLock();
						}else{
							//没有发现治疗的按钮
							this.file.log("治疗时没有发现治疗的按钮");
						}
						
						//退出循环
						i=53;
					}else{
						this.file.log("没有找到进行治疗四个字前面的白色小图标");
					}
					
					i=52;
					
				}else{
					System.out.println("没有锁定疗伤NPC");
					this.file.log("没有锁定疗伤NPC");
					
					//按住小键盘的4键0.5秒，调整方向
					this.press.keyPressTime(100, 200);
					this.sleep.sleep(1000);	//游戏界面的放大、缩小
				}
			}
			uniteIronArray=null;
		}
		releaseHeadLock();
		releaseHeadLock();
		releaseHeadLock();
	}
		
	
	/**
	 * 修理装备的时候清理包裹
	 */
	public void emptyParcel(){
		int xStart=780;
		int xEnd=980;
		int yStart=300;
		int yEnd=540;
		
		//(980-780)/6
		int add=33;
		
		for(int yi=0;yi<7;yi++){
			for(int xi=0;xi<7;xi++){
				int x=xStart+xi*add;
				int y=yStart+yi*add;
				//判断哪些东西不能卖掉的,是这些东西的话跳过，不是才会卖掉，半径+33  妖怪精魄|风物志|破损的玉佩|火力之石|藏宝图|休闲钓鱼|休闲捕捉|锈蚀的铜圈|休闲副本-迷宫|八级红|八级蓝
				if(!this.findPic.findPicE(x-36, y-36, x+36, y+30, "yaoGuaiJingPo.bmp|buyFengWuZhiJueShi2.bmp|buyFengWuZhiJueShi1.bmp|buyFengWuZhiPuTong1.bmp|buyFengWuZhiPuTong2.bmp|buyFengWuZhiSiCang2.bmp|buyFengWuZhiSiCang1.bmp|buyFengWuZhiZhenQi2.bmp|buyFengWuZhiZhenQi1.bmp|buyPoSunDeYuPei.bmp|buyHuoLiZhiShi.bmp|emptyParcelCangBaoTu.bmp|emptyParcelDiaoYu.bmp|emptyParcelXiuShiDeTongQuan.bmp|emptyParcelMiGong.bmp|emptyParcel8Hong.bmp|emptyParcel8Lan.bmp|emptyParcelMiGong2.bmp|emptyParcel8Lan2.bmp|emptyParcelBuZhuo.bmp")){
					this.mouse.mouseClick(x, y, false);
					this.sleep.sleep(100);
				}
			}
		}
		
	}
	
	/**
	 * 找屏幕上出现的小窗口右上方有X叉号的按钮
	 */
	public void windowClose(){
		int[] close=this.findPic.findPicEPosition(10,30,1000,680, "closeIco.bmp");
		if(close[0]>-1){
			this.mouse.mouseClick(close[1]+7, close[2]+7, true);
		}
	}
	
	/**
	 * 用指南符传送,传入Y点的坐标
	 */
	public void transferProp(int y){
		//按下7键打开指南符
		this.press.keyPress(55);
		this.sleep.sleep(1000);
		//再打开的指南符里选上
		this.mouse.mouseClick(112,y, true);
		this.press.keyPress(87);	//按一下8键，如果正在自动寻路打断自动寻路
		this.sleep.sleep(100);
		//传送,点传送窗口右下方的出发按钮
		this.mouse.mouseClick(272,566,true);
		//避免卡屏以及延迟
		this.sleep.sleep(5000);

		xueDelay(20);
	}
	
	/**
	 * 暂停运行，只到发现血条开始点颜色正常为止，允许的最大暂停时间为second
	 * @param second
	 */
	public void xueDelay(int second){
		int i=0;
		while(!isMyXue()&&i++<second&&include.Command.run){
			this.sleep.sleep(1000);
		}
	}

	/**
	 * 释放游戏中角色任务的锁定
	 * 判断是否有锁定人物，人物血条有血，进行esc释放目标的锁定
	 * 只适用于一管血的乖
	 */
	public void releaseHeadLock(){
		if(color.findColor(Command.guaiXueXStart, Command.guaiXueY, Command.guaiXueColor)||color.findColor(Command.guaiXueXStart, Command.guaiXueY, Command.guaiXueColor2)){
			//有血，是锁定了人物，进行esc释放
			this.press.keyPress(27);
			this.sleep.sleep(800);
			System.out.println("releaseHeadLock_Success");
		}else{
			System.out.println("releaseHeadLock_Failure");
		}
	}
	
	/**
	 * 判断我的血条开始的颜色，用来判断是否传送完毕的状态
	 * @return boolean True：有血条，匹配成功
	 */
	public boolean isMyXue(){
		boolean xnx3_result=false;
		
		//判断目标点血量X开始的颜色,从99级以前先开始匹配
		Command.myXueY=52;
		boolean isXue=this.color.findColor(Command.myXueXStart+3, Command.myXueY, Command.myXueColor);
		
		if(isXue){
			xnx3_result=true;
			System.out.println("匹配99级一下的血条成功");
		}else{
			xnx3_result=false;
			
			System.out.println("调整至100级模式进行匹配");
			//调整至100级的模式匹配
			Command.myXueY=54;
			isXue=this.color.findColor(Command.myXueXStart+3, Command.myXueY, Command.myXueColor);
			
			if(isXue){
				System.out.println("匹配100级的血条成功");
				xnx3_result=true;
			}else{
				xnx3_result=false;
			}
			
		}
		
		return xnx3_result;
	}
	
	/**
	 * 死亡返回，治疗,使用土地爷城隍庙的治疗
	 */
	public void overZhiLiao(){
		//设定寻路为最初的第一个点
		Command.rank=0;
		
//		土地爷头像 tuDi_1.bmp
		String targetPic="";	//土地疗伤的目标头像集
		String targetStr="";	//土地的名字，可能性名字集合，两侧均有|，如"|京城土地|京土地|京土地|京城地|京城土|城土地|"
		if(Command.runModel==7){
			//高级打怪模式
			switch (Command.runMap) {
			case 0:	//京城-皇陵道-城隍复活疗伤	
				targetPic="tuDi_2.bmp";
				targetStr="|京城城隍|京城隍|城城隍|京城城|";
				break;
			case 1:		//京城-坑牙洞,洞外,  使用京城土地跟玉华山山神两个
				targetPic="tuDi_1.bmp|tuDi_3.bmp";
				targetStr="|京城土地|京土地|京土地|京城地|京城土|城土地|玉华山山神|玉山山神|玉华山神|玉华山山|华山山神|玉华山山|华山山神|";
				break;
			case 2:		//京城-坑牙洞,洞内  使用京城土地跟玉华山山神两个
				targetPic="tuDi_1.bmp|tuDi_3.bmp";
				targetStr="|京城土地|京土地|京土地|京城地|京城土|城土地|玉华山山神|玉山山神|玉华山神|玉华山山|华山山神|玉华山山|华山山神|";
				break;
			case 3:
				targetPic="tuDi_1.bmp";		//茅山-乱坟岗
				targetStr="|石门县土地|门县土地|石县土地|石门土地|石门县地|石门县土|";
				break;
			case 4:	//毛衫-石门西郊
				maoShanTreatAction();
				return;
			case 5:	//地府-忘川岸,不使用指南符
				diFuTreatAction(true);
				return;
			case 6:	//地府-罗浮寨复活点,不使用指南符
				diFuTreatAction(true);
				return;
			case 7:	//地府-无根地,使用传送符
				diFuTreatAction(true);
				return;
			case 8:
				moYunJinYaYiAction();
				routeMap();	//直接跑过去
				this.sleep.sleep(50000);	//等待时间，等待人物跑过去
				return;
			case 9:	//五岳山麓
				wuYueShanLuGuaTianAction();
				return;
			case 10:	//土地-高老庄
				wuYueShanLuPublicLiaoAction(120000);
				break;
			case 11:	//土地-福灵山
				wuYueShanLuPublicLiaoAction(120000);
				break;
			case 12:	//子午岭卦机
				wuYueShanLuPublicLiaoAction(200000);
				return;
			case 13:	//摩云山东部-精魄阵-小怪
				moYunJinYaYiAction();
				routeMap();	//直接跑过去
				this.sleep.sleep(5000);	//等待时间，等待人物跑过去
				return;
			case 14:	//摩云山东部-哭风岭
				moYunJinYaYiAction();
				routeMap();	//直接跑过去
				this.sleep.sleep(10000);	//等待时间，等待人物跑过去
				return;
			case 15:	//五岳山麓-白云观
				wuYueShanLuPublicLiaoAction(5000);
				return;
			case 16:	//五岳山麓-子午岭瓜田
				wuYueShanLuPublicLiaoAction(200000);
				return;
			default:
				break;
			}
		}else{
			//其他模式不用自动治疗
			return;
		}
		
		///调整俯视
		setLookDown();
		//调整角度大致为平视，略微俯视
		this.press.keyPressTime(98, 400);
		
		int i=0;
		while(i++<20&&Command.run){
			if(searchScreen(targetStr, true)){
				if(this.findPic.findPicE(382,18,457,103, targetPic)){
					//发现是京城土地爷的头像无误
					
					//4秒延迟，人物跑过去打开疗伤对话框
					this.sleep.sleep(4000);
					
					//找治疗前面的白色小图
					int jinxingzhiliao[]=this.findPic.findPicEPosition(82,190,253,507, "jinXingZhiLiao.bmp");
					if(jinxingzhiliao[0]!=-1){
						//找到【进行治疗】前面的白色小图了，可以进行治疗
						System.out.println("//找到【进行治疗】前面的白色小图了，可以进行治疗");
						this.mouse.mouseClick(jinxingzhiliao[1]+20, jinxingzhiliao[2]+5, true);
						
						this.sleep.sleep(800);
						//点击了治疗，出来的一个对话框，确认治疗啊
						int zhiliaoButton[]=this.findPic.findPicEPosition(335,307,467,417, "zhiLiaoButton.bmp");
						if(zhiliaoButton[0]>-1){
							//点击[治疗]按钮
							this.mouse.mouseClick(zhiliaoButton[1]+3, zhiliaoButton[2]+2, true);
							//点击完了，然后撤销对土地爷的锁定，esc
							this.sleep.sleep(200);
							this.press.keyPress(27);
							
						}else{
							//没有发现治疗的按钮
							this.file.log("治疗时没有发现治疗的按钮");
						}
						
						//退出循环
						i=23;
					}else{
						this.file.log("没有找到进行治疗四个字前面的白色小图标");
					}
					
				}else{
					System.out.println("没有发现土地爷的头像");
					this.file.log("没有发现土地爷的头像");
				}
			}else{
				//按住小键盘的4键1秒，调整方向
				this.press.keyPressTime(100, 1000);
			}
		}
	}
	
	/**
	 * 五岳山神治疗，无论在五岳山的何地，死了都可直接调用此方法。
	 * 治疗点再芭蕉洞东侧的山神
	 */
	public void wuYueShanShenZhiLiaoAction(){
//		打开地图走至指定点
		this.press.keyPress(77);
		this.sleep.sleep(1000);
		this.mouse.mouseClick(815,156, true);	//打开复活点
		this.sleep.sleep(1000);
		this.mouse.mouseClick(846,194, true);	//点击山神复活疗伤
		this.sleep.sleep(500);
		this.press.keyPress(77);
		
		this.press.keyPress(48);
		this.sleep.sleep(200000);	//200秒走动时间
		
		//搜寻治疗
		findTreatAction("liao_WuYueShanLuShanShen.bmp");
	}
	
	/**
	 * 搜索屏幕范围内的人物或者其他，看右下方的信息框的名字，只要符合，则鼠标右键或者左键点击
	 * @param findStr:查找要发现的文字,多个用"|"分割，要查找的必须在"|之内|"，可以传入"|京城土地|京土地|"
	 * @param mouseClick:鼠标点击，true为左键点击，false为右键点击
	 * @return boolean true:成功找到并且点击了<li>false:没有找到
	 */
	public boolean searchScreen(String findStr,boolean mouseClick){
		boolean xnx3_result=false;
		
		int xStart=30;
		int yStart=70;
		int xEnd=980;
		int yEnd=670;
		int addX=60;	//每次增加的数值
		int addY=60;
		
		for (int nowY=yStart; nowY <= yEnd&&Command.run; nowY=nowY+addY) {
			for (int nowX=xStart; nowX <= xEnd&&Command.run; nowX=nowX+addX) {
				String readStr=mouseReadName(nowX, nowY);
				System.out.println(nowX+"|"+nowY+"---"+readStr);
				if(findStr.indexOf("|"+readStr+"|")>-1){
					//找到了,进行鼠标点击
					System.out.println("//找到了,进行鼠标点击");
					this.mouse.mouseClick(mouseClick);
					xnx3_result=true;
					
					//退出循环
					nowX=1100;
					nowY=1100;
				}
			}
		}
		
		return xnx3_result;
	}
	
	/**
	 * 返回当前鼠标所指向的人物或者物品的名字（右下方出现的信息框，上方一行的文字）
	 * @param x:传入鼠标所在的X点
	 * @param y:传入鼠标所在的y点
	 * @return result
	 */
	public String mouseReadName(int x,int y){
		this.mouse.mouseMoveTo(x, y);
		this.sleep.sleep(200);
		String xnx3_result=this.findStr.readStr(928,530,1026,576, "00ff00-333333|02cd01-333333", Command.doubleNine, 3);
		return xnx3_result;
	}
	
	/**
	 * Z 一键拾取
	 */
	public void z(){
		press.keyPress(90);
		sleep.sleep(100);
		press.keyPress(90);
		sleep.sleep(Command.zTime+Command.delay);
		press.keyPress(90);
		sleep.sleep(100);
	}
	
	/*
  	走动路线
  	小地图中向北 
	上键，Y++
	下键，Y--
	右键，X--  
	左键，X++
	*/
	public void routeMap(){
		//当前小地图开启寻路的范围
		String[] limitArray=Command.routePositionLimit[Command.rank].split("\\|");
		int minX=Integer.parseInt(limitArray[0]);
		int minY=Integer.parseInt(limitArray[1]);
		int maxX=Integer.parseInt(limitArray[2]);
		int maxY=Integer.parseInt(limitArray[3]);
		limitArray=null;
		
	    //当前小地图的坐标
	    int nowX=0;
	    int nowY=0;
		if(Command.readSmallPosition){		//是否读取小地图坐标
			nowX=position.getMapPositionX();
			nowY=position.getMapPositionY();
		}
	    
	    //目的地坐标
	    int targetX=Command.targetPositionX[Command.rank];
	    int targetY=Command.targetPositionY[Command.rank];
		
	    //M开的大地图窗口内像素坐标
	    int mapX=Command.routeMapX[Command.rank];
	    int mapY=Command.routeMapY[Command.rank];
		
	    //是否使用小地图
		if(Command.usePosition){
			//若是当前进入了使用小地图的走动范围，则放弃M键宠物寻路，根据小地图坐标走位
			if(nowX<targetX){
				//D
				press.keyPressTime(68, Command.positionMoveTime);
			}
			if(nowY<targetY){
				//W
				press.keyPressTime(87, Command.positionMoveTime);
			}
			if(nowX>targetX){
				//A
				press.keyPressTime(65, Command.positionMoveTime);
			}
			if(nowY>targetY){
				//S
				press.keyPressTime(83, Command.positionMoveTime);
			}
			
			//相差4个坐标单位便开始进行开鼓扫描,以免有遗漏
	        if(Math.abs(nowX-targetX)<4 && Math.abs(nowY-targetY)<4){
	        	//相差2个坐标位为到达目的点
	        	if(Math.abs(nowX-targetX)<2 && Math.abs(nowY-targetY)<2){
	        		//到了目的点，重新设置下一个目的点的坐标
		            setNextRank();
		            //设置下次使用M键大地图走位
		            Command.usePosition=false;
		            Command.walkRunNum=0;//清空走动次数
	        	}
	        	
	        	//叛军战鼓扫描
	        	//是否开小鼓打
				if(Command.autoKaiGu){	//开鼓	            
	            	kaiGuAction();
	            	//开鼓扫描
				}
			}
	        
	        
	      //判断使用此已经多少次了,避免点阵出错造成死循环
	       if(Command.walkRunNum<Command.positionMapMax){
	    	   Command.walkRunNum++;
	       }else{
	    	   Command.usePosition=false;		//使用大地图
	    	   Command.walkRunNum=0;				//清空走动次数
	    	 //设置下一个目的点的坐标
	    	   setNextRank();
	       }
		}else{
			//使用大地图M键地图走位,用宝宝带路
			if(nowX>minX&&nowX<maxX&&nowY>minY&&nowY<maxY){
	            Command.usePosition=true;		//设置下次寻路时使用小地图坐标走位
	            Command.walkRunNum=0;		//清零小地图走位的次数
			}
			
			
			//动态改变随机+1的数值，使0键自动寻路不被打断
			if(Command.autoXunLuChangeUse){
				mapX=mapX+this.positionOneChange;
				
				if(this.positionOneChange==0){
					this.positionOneChange=1;
				}else{
					this.positionOneChange=0;
				}
			}
			
			//不使用小地图，使用M键大地图坐标
			press.keyPress(77);
			sleep.sleep(300);
			mouse.mouseMoveTo(mapX, mapY);
			sleep.sleep(100);
			mouse.mouseClick(true);
			sleep.sleep(100);
			press.keyPress(77);
			sleep.sleep(200);
			
			//0键寻路
			press.keyPress(48);
			press.keyPress(90);	//Z拾取
			sleep.sleep(100);
			press.keyPress(90);	//Z拾取
			sleep.sleep(Command.autoXunLuTime);
			
			
			if(Command.walkRunNum<Command.routeMapMax){
				Command.walkRunNum++;
			}else{
				Command.walkRunNum=0;
				setNextRank();
			}
		}
		
	//	Func.log((Command.usePosition? "小":"大")+"地图,走动"+Command.walkRunNum+"次,当前"+nowX+","+nowY);
	}
	/**
	 * 依附于routeMap
	 */
	public void setNextRank(){
	//	Func.log("转至下一个挂机点");
		Command.rank++;
		if(Command.rank>=Command.rankMax){
			Command.rank=0;
		}
	}

	
	
	/**
	 * 水底开小鼓
	 */
	public void kaiGuAction(){
//		Func.log("进行扫描小鼓操作");
		
		boolean xnx3_result = false;		//是否找到战鼓字样，并确定是
		int thisX=0;						//战鼓文字的x坐标,具体x坐标
		int thisY=0;						//战鼓文字的y坐标，找到鼓后进行动态匹配
		int errorNumX=100;					//设定误差，横坐标误差在errorNumX以内便是匹配成功
		int errorNumY=10;
		int findNum=0;						//记录【叛军型战鼓】文字发现了几个
		int[] xArray=new int[5];			//记录【叛军型战鼓】5个字出现的x坐标
		int[] yArray=new int[5];
		
		//进行逐个文字扫描【叛军型战鼓】，只有3个或者以上的匹配完毕，并且坐标无误，才确认有战鼓，进行开启
		int pan[]=this.findStr.findStrE(Command.guXStart, Command.guYStart, Command.guXEnd, Command.guYEnd, "叛", Command.mapPositionColor, Command.mapPositionSim, 2);
		if(pan[0]>-1){
			findNum++;
			xArray[0]=pan[1];
			yArray[0]=pan[2];
		}
		
		int jun[]=this.findStr.findStrE(Command.guXStart, Command.guYStart, Command.guXEnd, Command.guYEnd, "军", Command.mapPositionColor, Command.mapPositionSim, 2);
		if(jun[0]>-1){
			findNum++;
			xArray[1]=jun[1];
			yArray[1]=jun[2];
		}
		
		int xing[]=this.findStr.findStrE(Command.guXStart, Command.guYStart, Command.guXEnd, Command.guYEnd, "型", Command.mapPositionColor, Command.mapPositionSim, 2);
		if(xing[0]>-1){
			findNum++;
			xArray[2]=xing[1];
			yArray[2]=xing[2];
		}
		
		int zhan[]=this.findStr.findStrE(Command.guXStart, Command.guYStart, Command.guXEnd, Command.guYEnd, "战", Command.mapPositionColor, Command.mapPositionSim, 2);
		if(zhan[0]>-1){
			findNum++;
			xArray[3]=zhan[1];
			yArray[3]=zhan[2];
		}
		
		int gu[]=this.findStr.findStrE(Command.guXStart, Command.guYStart, Command.guXEnd, Command.guYEnd, "鼓", Command.mapPositionColor, Command.mapPositionSim, 2);
		if(gu[0]>-1){
			findNum++;
			xArray[4]=gu[1];
			yArray[4]=gu[2];
		}
		
		if(findNum<3){
			//如果5个字中找到小于3个，则不再判断，视战鼓不存在
		}else{
			int xnx3_num=0;
			if(pan[0]>-1&&matchPosition(xArray, yArray, pan, errorNumX, errorNumY)){
				xnx3_num++;
				thisX=pan[1]+35;
				thisY=pan[2];
			}
			if(jun[0]>-1&&matchPosition(xArray, yArray, jun, errorNumX, errorNumY)){
				xnx3_num++;
				thisX=jun[1]+20;
				thisY=jun[2];
			}
			if(xing[0]>=-1&&matchPosition(xArray, yArray, xing, errorNumX, errorNumY)){
				xnx3_num++;
				thisX=xing[1]-5;
				thisY=xing[2];
			}
			if(zhan[0]>-1&&matchPosition(xArray, yArray, zhan, errorNumX, errorNumY)){
				xnx3_num++;
				thisX=zhan[1]-22;
				thisY=zhan[2];
			}
			if(gu[0]>-1&&matchPosition(xArray, yArray, gu, errorNumX, errorNumY)){
				xnx3_num++;
				thisX=gu[1]-32;
				thisY=gu[2];
			}
			
			if(xnx3_num>=3){
				//有至少3个点匹配，定义为true，开鼓
				xnx3_result=true;
			}			
		}
		pan=null;
		jun=null;
		xing=null;
		zhan=null;
		gu=null;
		xArray=null;
		yArray=null;
		
		/*
		 * 扫描小鼓完毕
		 * 进行开鼓操作
		 */
		if(xnx3_result){
			this.file.log("发现叛军小鼓，进行开鼓操作");
			this.file.play("findPanJunGu.mp3",6000);
			//点击开鼓，进行30到150纵坐标范围判断
			int notKaiNum=0;
			while(notKaiNum++<12){
//				Func.log("智能扫描小鼓中……,当前第"+notKaiNum+"次");
				this.mouse.mouseClick(thisX, thisY+(notKaiNum*10), false);
				this.sleep.sleep(300);
				if(this.findPic.findPicE(Command.guaiHeadXStart, Command.guaiHeadYStart, Command.guaiHeadXEnd, Command.guaiHeadYEnd, "smallGuNotKaiHead.bmp")){
					thisY=thisY+(notKaiNum*10);
					notKaiNum=100;
//					Func.log("进行开鼓");
				}
			}
			this.mouse.mouseClick(thisX, thisY, true);
			this.sleep.sleep(300);
			this.press.keyPress(86);		//v键接近战鼓
			this.sleep.sleep(800);
			
			//175*100
			//点击“敲响战鼓，召唤队长”，首先读取关闭窗口的X按钮
			int getCloseX[]=this.findPic.findPicEPosition(280, 125, 500, 450, "closeX.bmp");
			int kaiI=0;
			while(getCloseX[0]!=-1&&kaiI<13){			//Y坐标每次递增5个像素进行点击开鼓
				this.mouse.mouseClick(getCloseX[1]-175,getCloseX[2]+100+(kaiI*5), true);
				this.sleep.sleep(100);
				kaiI++;
				
				getCloseX=null;
				getCloseX=this.findPic.findPicEPosition(280, 125, 500, 450, "closeX.bmp");
			}
			
			//判断是否走上方的while了，是否读出了closeX关闭按钮了,若是没有读出来或者没有在13次循环之内点开，则进行默认点击
			if(kaiI>12||kaiI==0){
				this.mouse.mouseClick(185, 298, true);
				this.sleep.sleep(300);
			}
			
			Command.guaiHeadBmpSBak=Command.guaiHeadBmpS;	//备份，同时将打怪头像指定为打叛军队长
			Command.guaiHeadBmpS="PanJunXiaoDuiZhang.bmp";
			for (int i = 0; i < 20; i++) {
				//TAB找怪
				this.press.keyPress(9);
				this.sleep.sleep(300);
				
				//查找怪头像，是否发现此怪
				if(this.findPic.findPicE(Command.guaiHeadXStart, Command.guaiHeadYStart, Command.guaiHeadXEnd, Command.guaiHeadYEnd, Command.guaiHeadBmpS)){
					daGuaiAction();
					
					z();	//两次拾取，避免错过
				}
			}
			Command.guaiHeadBmpS=Command.guaiHeadBmpSBak;	//打完队长，还原备份头像集，还原为原本的指定头像
		}
	}
	/**
	 * 	依附于开小鼓存在
	 * int[] dian:  pan[]、jun[]……
	 * 
	 * @return boolean
	 */
	public boolean matchPosition(int xArray[],int yArray[],int[] dian,int errorNumX,int errorNumY){
		boolean xnx3_result=false;
		int findStrNum=0;	//记录此点在x坐标匹配的数目
		int findNumMax=3;		//固定值，包含此点在内，至少需要3个点匹配
		if(dian[0]>-1){
			for (int i = 0; i < 5; i++) {
				if(xArray[i]>-1){		//有值
					if(Math.abs(dian[1]-xArray[i])<errorNumX){
						//x匹配，进一步进行y匹配
						if(Math.abs(dian[2]-yArray[i])<errorNumY){
							//当x、y皆匹配，才进行累计
							findStrNum++;
						}
					}
				}
			}
			if(findStrNum>=findNumMax){
				xnx3_result=true;
			}
		}
		xArray=null;
		yArray=null;
		dian=null;
		
		return xnx3_result;
	}
	
	
	
	/**
	 * 结束运行，释放资源，同时对游戏内进行结束操作，到安全挂机点
	 */
	public void release(){
		releaseHeadLock();
		releaseHeadLock();
		releaseHeadLock();
		windowClose();
		windowClose();
		windowClose();
		
		
		//运行结束,进行结束操作，游戏执行软件结束最后的操作
		if(Command.directSet){	//水底，需要匹配坐标,在结束的时候到安全地点
			//M打开大地图
			press.keyPress(77);
			sleep.sleep(1000);
			mouse.mouseClick(533,523, true);
			press.keyPress(77);
			sleep.sleep(1000);
			press.keyPress(48);	//0键自动寻路
			sleep.sleep(1000);
			press.keyPress(48);	//0键自动寻路,再点一次，避免卡而造成无法自动寻路
		}
		
		this.file.log("打怪线程释放，等待函数对象释放……");
		
		this.activeDm=null;
		
		this.mouse=null;
		this.sleep=null;
		this.findPic=null;
		this.findStr=null;
		this.lang=null;
		this.file=null;
		this.color=null;
		this.press=null;
		this.position=null;
	}
	
}
