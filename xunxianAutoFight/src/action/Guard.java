package action;

import com.jacob.activeX.ActiveXComponent;
import Func.Color;
import Func.File;
import Func.FindPic;
import Func.Mouse;
import Func.Position;
import Func.Press;
import Func.Sleep;
import Func.XinNuo;
import include.Command;

/**
 * 辅助
 * @author xnx3
 *
 */
public class Guard{
	ActiveXComponent activeDm=null;
	XinNuo xinNuo=null;		//信诺答题
	Color color=null;
	FindPic findPic=null;
	Mouse mouse=null;
	Press press=null;
	Sleep sleep=null;
	Position position=null;
	File file=null;
	private boolean myOver=true;	//人物是否死亡，死亡检测时第一次死亡截图记录，此时标注为false。若是死亡后没有找到死亡原因（死亡返回）则等待下一次检测,下一次检测时不进行截图。检测完毕之后初始化为true，等待下一次死亡
	private int myoverNum=0;	//在COM创建期间，我的死亡次数。超过3此自动发信提醒
	
	public Guard(ActiveXComponent activeDm) {
		this.activeDm=activeDm;
		this.color=new Color(this.activeDm);
		this.findPic=new FindPic(this.activeDm);
		this.mouse=new Mouse(this.activeDm);
		this.press=new Press(this.activeDm);
		this.sleep=new Sleep();
		this.position=new Position(this.activeDm);
		this.file=new Func.File(this.activeDm);
		
		this.xinNuo=new XinNuo(this.activeDm);
	}

	/**
	 * 监视
	 * @return int 正常返回0,人物死亡返回1
	 */
	public int run() {
		int xnx3_result=0;
		
		if(Command.mainThread){
			
			//血条开始点血颜色是否有血
			if(!color.findColor(Command.myXueXStart, Command.myXueY, Command.myXueColor)){
				boolean myOver=true;	//初始化默认为死亡了
				
				//判断是否出现了验证码
				int[] yanzheng=findPic.findPicEPosition(460,255,620,300, "ShenFaYanZhengMa.bmp");
				int[] yanzhengRefresh=findPic.findPicEPosition(484,475,526,489, "refresh.bmp");
				if(yanzheng[0]>-1||yanzhengRefresh[0]>-1){
					myOver=false;	//没有死亡
					//是否配置、开启了自动验证
					if(Command.autoDaTi){
						//终止所有线程（为了终止打怪线程，M键点击答题走动可能会影响答题）
//						ThreadCommand.stop();
						xinNuo.autoDaTi();
//						new ThreadCommand().startDaGuaiThread();
					}else{	//没开启
						//解除dm绑定,结束运行,软件初始化至未开启状态
						Init.runEnd();
						int i=0;
						while(i++<6){
							file.play("YanZhengMa.mp3", 10000);
							//60秒
						}
					}
				}
				yanzheng=null;
				yanzhengRefresh=null;
				
				
				//判断是否有人发出交易请求
				if(findPic.findPicE(367,294,660,462, "requestTrade.bmp")){
					myOver=false;	//没有死亡
					if(Command.screenLog){
						file.screenImage("恶意交易记录");
						file.log("发现恶意交易申请");
						
						//查取消按钮所在图片
						int[] jiaoyi=findPic.findPicEPosition(501,368,630,505, "cancel.bmp");
						if(jiaoyi[0]!=-1){
							mouse.mouseClick(jiaoyi[1]+23, jiaoyi[2]+7, true);
							
						}else{
							mouse.mouseClick(547,415, true);
							file.log("发现恶意交易申请，取消时未发现按钮所在！进行默认点击");
						}
						jiaoyi=null;
						
						sleep.sleep(300);
					}
				}
				
				//判断是否有人发出决斗请求
				if(findPic.findPicE(367,294,660,462, "requestFight.bmp")){
					myOver=false;	//没有死亡
					if(Command.screenLog){
						file.screenImage("恶意决斗记录");
						file.log("发现决斗申请");
						
						//查取消按钮所在图片
						int[] juedou=findPic.findPicEPosition(501,368,630,505, "cancel.bmp");
						if(juedou[0]!=-1){
							mouse.mouseClick(juedou[1]+23, juedou[2]+7, true);
						}else{
							mouse.mouseClick(547,415, true);
							file.log("发现恶意决斗申请，取消时未发现按钮所在！进行默认点击");
						}
						juedou=null;
						
						sleep.sleep(300);
					}
				}
				
				//是否开启人物死亡监控
				if(Command.overGuard){
					//是否是死亡了
					if(myOver){
						//截图记录，第一时间截图
						if(this.myOver){
							this.myOver=false;		//只有第一次死亡的时候记录
							if(Command.screenLog){
								file.screenImage("人物死亡");
							}
							//死亡后因宝宝、坐骑而掉落的属性文字，等待文字消失
							sleep.sleep(20000);	
						}
						
						
						//判断是否出现了死亡图
//						479,277,550,290
						int over[]=findPic.findPicEPosition(400, 200, 600, 300, "over.bmp|over2.bmp");
						if(over[0]!=-1){		//找到图了
							this.myOver=true;		//初始化
							//实时声音提醒
							file.play("myOver.mp3",8000);
							
							//实时邮件提醒
							if(Command.emailRemind){
								if(this.myoverNum++>=3){
									new Func.SendMail().send("一段时间内死亡达到四次提醒", "在"+Command.dmComLastCreateTime+"到"+include.Module.Now_date.xnx3_time()+"期间，死亡次数达到4次！特发邮件提醒，请及时疗伤，并建议到较低等级的区域内挂机");
								}
							}
							
							//点击死亡返回，返回继续打
							mouse.mouseClick(over[1]+30, over[2]+5, true);
							sleep.sleep(10000);	//10秒，避免卡屏
							
							file.log("人物死亡--避免被仇家恶意刷死亡，结束线程运行，等待"+(Command.myOverTime/1000)+"秒继续开启");
							sleep.sleep(Command.myOverTime);		
							
							
							
							//打怪模式1或者2，在水底打，需要匹配坐标
							if(Command.directSet){
								
								//打开M地图走到空旷的地点进行坐标识别
								press.keyPress(77);
								sleep.sleep(1000);
								mouse.mouseClick(533,523, true);
								press.keyPress(77);
								sleep.sleep(1000);
								press.keyPress(48);	//0键自动寻路
								sleep.sleep(30000);

								//到指定的地点后进行小地图方向识别
								angleInit();
								position.mapArrowsInit();
								
								//调整俯视
								angleInit();
								
								press.keyPress(56);
								file.log("召唤坐骑");
								sleep.sleep(20000);
							}else{
								//普通打怪模式或者高级打怪模式
							}
							
							//标记人物死亡，传回
							xnx3_result=1;
							
						}else{
							//掉线的情况，进行判断
							file.log("出现意外事故，但未检测到死亡，等待下次检测");
						}
					}
				}
				
			}
			
			//是否开启了血条监控喝红、回生水
			if(Command.helpHongUse){
				//判断是否选择喝红
				if(!color.findColor((int)(Command.helpArray[Command.helpHongNum]*Command.myXuePercent+Command.myXueXStart)+1, Command.myXueY, Command.myXueColor)){
					press.keyPress(Command.keyArray[Command.helpHongKey]);
					sleep.sleep(Command.keySleep[Command.helpHongTime]);
				}
				
				//首先判断是否选择喝回生水
				if(!color.findColor((int)(Command.helpArray[Command.helpHuiShengShuiNum]*Command.myXuePercent+Command.myXueXStart)+1, Command.myXueY, Command.myXueColor)){
					press.keyPress(Command.keyArray[Command.helpHuiShengShuiKey]);
					sleep.sleep(Command.keySleep[Command.helpHuiShengShuiTime]);
				}
			}
			
			//判断是否选择喝蓝
			if(Command.helpLanUse){		//职业选择，喝蓝监控是否开启
				if(!color.findColor((int)(Command.helpArray[Command.helpLanNum]*Command.myLanPercent+Command.myLanXStart)+1, Command.myLanY, Command.myLanColor)){
					press.keyPress(Command.keyArray[Command.helpLanKey]);
					sleep.sleep(Command.keySleep[Command.helpLanTime]);
				}
			}
			
			//是否释放技能1
			if(Command.helpJiNeng1Use){
				if(!color.findColor((int)(Command.helpArray[Command.helpJiNeng1Num]*Command.myXuePercent+Command.myXueXStart)+1, Command.myXueY, Command.myXueColor)){
					press.keyPress(Command.keyArray[Command.helpJiNeng1Key]);
					sleep.sleep(Command.keySleep[Command.helpJiNeng1Time]);
				}
			}
			//是否释放技能2
			if(Command.helpJiNeng2Use){
				if(!color.findColor((int)(Command.helpArray[Command.helpJiNeng2Num]*Command.myXuePercent+Command.myXueXStart)+1, Command.myXueY, Command.myXueColor)){
					press.keyPress(Command.keyArray[Command.helpJiNeng2Key]);
					sleep.sleep(Command.keySleep[Command.helpJiNeng2Time]);
				}
			}
			
		}
		
		return xnx3_result;
	}
	
	/**
	 * 设置角度为俯视
	 */
	public void angleInit(){
		//设置视角为最上方往下看
		press.keyDown(104);
		file.log("调整角度为俯视");
		sleep.sleep(3000);
		press.keyUp(104);
	}
}
