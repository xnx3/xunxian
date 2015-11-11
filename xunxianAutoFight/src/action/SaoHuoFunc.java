package action;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;
import include.Command;
import Func.Color;
import Func.File;
import Func.FindPic;
import Func.FindStr;
import Func.Lang;
import Func.Message;
import Func.Mouse;
import Func.Press;
import Func.Sleep;

public class SaoHuoFunc {
	ActiveXComponent activeDm=null;
	Mouse mouse=null;
	Sleep sleep=null;
	FindPic findPic=null;
	FindStr findStr=null;
	Lang lang=null;
	File file=null;
	Color color=null;
	Press press=null;
	Message message=null;
	private int refreshNum=0;		//刷新次数，刷新5此没发现存在新摊位就换一个地方。每隔1秒刷新一次
	private boolean run=true;		//扫货是否开启。每走一个地图控制new一个
	
	private int STONETYPE=1;	//获取自动扫货中Command存储的Map数据时使用，八卦灵石类
	private int PETTYPE=2;		//获取自动扫货中Command存储的Map数据时使用，宠物壳子类
	private int PETTYPE_SHENSHOU=21;	//神兽侍宠蛋
	private int PETTYPE_YUANXING=22;	//原型侍宠蛋
	private int GENERALTYPE=3;		//普通模式，根据图片扫描价格直接买进的模式
	private int QIANGLITYPE=4;		//强力诀
	private int ZHANHUNTYPE=5;		//侍宠战魂水晶
	private int FENGWUZHI=6;		//风物志
	private int CHUANQIPEIFANG=7;	//传奇装备图纸
	private int TONGSHENJUE=8;		//通神诀
	
	public SaoHuoFunc(ActiveXComponent active){
		this.activeDm=active;
		this.mouse=new Func.Mouse(this.activeDm);
		this.sleep=new Func.Sleep();
		this.findPic=new Func.FindPic(this.activeDm);
		this.findStr=new Func.FindStr(this.activeDm);
		this.lang=new Func.Lang();
		this.file=new Func.File(this.activeDm);
		this.color=new Func.Color(this.activeDm);
		this.press=new Func.Press(this.activeDm);
		this.message=new Func.Message();
	}
	
	public SaoHuoFunc() {
		this.mouse=new Func.Mouse(this.activeDm);
		this.sleep=new Func.Sleep();
		this.findPic=new Func.FindPic(this.activeDm);
		this.findStr=new Func.FindStr(this.activeDm);
		this.lang=new Func.Lang();
		this.file=new Func.File();
		this.color=new Func.Color(this.activeDm);
		this.press=new Func.Press(this.activeDm);
		this.message=new Func.Message();
	}
	
	/**
	 * release
	 */
	public void release(){
		this.mouse=null;
		this.sleep=null;
		this.findPic=null;
		this.findPic=null;
		this.lang=null;
		this.file=null;
		this.color=null;
		this.press=null;
		
		this.activeDm=null;
	}
	
//	tanMoneyNumDict.txt：bea102-333333|efca00-222222|8ea7a7-444444|d7efef-444444  查看摆摊卖、收的价格
	
	/**
	 * 初始化摊位，查找“周围摊位图片，并调整其位置”
	 */
	public boolean initTanWei(){
		boolean xnx3_result=false;
		
		//改变一下窗口的大小，避免找不到摊位图片
		new Func.Window(this.activeDm).setWindowSize(Command.hwnd, Command.clientWidth+10, Command.clientHeight+10);
		this.sleep.sleep(500);
		new Func.Window(this.activeDm).setWindowSize(Command.hwnd, Command.clientWidth, Command.clientHeight);
		this.sleep.sleep(1000);
		
		int getZhouWeiTanWei[]=findPic.findPicEPosition(0, 0, 1000, 600, "zhouWeiTanWei1.bmp|zhouWeiTanWei2.bmp","303030",0.7);
		if(getZhouWeiTanWei[0]!=-1){	//找到了
			//进行移动至指定的位置(移动至坐标500*200)
			this.mouse.mouseMoveTo(getZhouWeiTanWei[1]+70, getZhouWeiTanWei[2]+5);
			this.sleep.sleep(200);
			this.mouse.leftDown();
			this.sleep.sleep(200);
			this.mouse.mouseMoveTo(500,200);
			this.mouse.leftUp();
			//周围摊位移动完毕
			this.file.log("查看周围摊位窗口移动完毕");
//			150*180
			refresh();	//刷新摊位列表
			
			xnx3_result=true;
			
			this.mouse.mouseClick(414,254,true);		//点击第一个摊位，查看摊位
			this.sleep.sleep(5000);		//延迟3秒
			//进行调整查看摊位商品的窗口位置
			int getTargetTanWei[]=this.findPic.findPicEPosition(0,30,1000,700, "targetTanWei.bmp");
			if(getTargetTanWei[0]!=-1){		//找到目标摊位，进行移动，移动至200*160的坐标位置
				this.mouse.mouseMoveTo(getTargetTanWei[1]+150, getTargetTanWei[2]-180);
				this.sleep.sleep(200);
				this.mouse.leftDown();
				this.sleep.sleep(200);
				this.mouse.mouseMoveTo(200,160);
				this.mouse.leftUp();
				this.file.log("查看摊位摆摊信息窗口移动完毕");
				xnx3_result=true;
			}else{
				xnx3_result=false;
				new Func.Message().showMessageDialog("查看目标摊位未发现！<br/>目标摊位请勿遮挡");
			}
			getTargetTanWei=null;
			
		}else{	
			new Func.Message().showMessageDialog("“周围摊位”未发现，初始化失败！<br/>请根据即将打开的页面说明放置");
			Command.browser.loadUrl(
					"http://www.xnx3.com/xunxian/xxautofight/20140306/75.html", 200,
					200, 800, 600);
			xnx3_result=false;
		}
		getZhouWeiTanWei=null;
		
		this.file.log("摊位坐标初始化完毕！初始化"+(xnx3_result? "成功":"失败"));
		
		return xnx3_result;
	}
	
	/**
	 * 扫描特定物品，扫货主程序
	 */
	public void saoHuoAction(){
		System.out.println(Command.saoHuoElseClass.toString());
		//开启或是寻路20秒完毕，按一下w键打断走动
		this.press.keyPress(87);
		
		while(this.run&&Command.mainThread){
			
			refresh();		//刷新摊位列表
			int tan[]=this.color.findColor(384,246,574,262, "808080-000000", Command.doubleTen, Command.orderDir);
			boolean tanHave=this.findPic.findPicE(579,239,611,270, "tanFirstListHave.bmp");		//无论看过没看过，摊位列表第一个是否存在摊位
			if(tan[0]==-1&&tanHave){	//有摊位
				if(openFirstTanWei()){		//点击打开第一个摊位
					if(Command.saoHuoOneTongScanUse){		//是否扫描1铜的物品
						oneTongScan();
					}
					
					if(Command.saoHuoGroceriesUse){		//杂货类扫描是否开启
						findArticle(this.GENERALTYPE,"buyShiChongWanJu.bmp", "侍宠玩具", Command.saoHuoGroceriesDataMap.get("侍宠玩具"));
						findArticle(this.GENERALTYPE,"buyMiFaJieJing.bmp", "秘法结晶", Command.saoHuoGroceriesDataMap.get("秘法结晶"));
						findArticle(this.GENERALTYPE,"buyYouHanSuiLianShiSuiPian.bmp", "幽寒淬炼石碎片", Command.saoHuoGroceriesDataMap.get("幽寒淬炼石碎片"));
						findArticle(this.GENERALTYPE,"buyChiYanSuiLianShiSuiPian.bmp", "炽炎淬炼石碎片", Command.saoHuoGroceriesDataMap.get("炽炎淬炼石碎片"));
						findArticle(this.GENERALTYPE,"buyZiJingYunMu.bmp", "紫晶云母", Command.saoHuoGroceriesDataMap.get("紫晶云母"));
						findArticle(this.GENERALTYPE,"buyYaoGuaiHuangLi.bmp", "妖怪黄历", Command.saoHuoGroceriesDataMap.get("妖怪黄历"));
						findArticle(this.GENERALTYPE,"buyKongBaiFuZhi.bmp", "空白符纸", Command.saoHuoGroceriesDataMap.get("空白符纸"));
						findArticle(this.GENERALTYPE,"buyChiYanSuiLianShi.bmp", "炽炎淬炼石", Command.saoHuoGroceriesDataMap.get("炽炎淬炼石"));
						findArticle(this.GENERALTYPE,"buyMeiGuiHua.bmp", "玫瑰花", Command.saoHuoGroceriesDataMap.get("玫瑰花"));
						findArticle(this.GENERALTYPE,"buyQiZhiJing.bmp", "气之精", Command.saoHuoGroceriesDataMap.get("气之精"));
						findArticle(this.GENERALTYPE,"buyWuCaiLingShiSuiPian.bmp", "五彩灵石碎片", Command.saoHuoGroceriesDataMap.get("五彩灵石碎片"));
						findArticle(this.GENERALTYPE,"buyJuLingJingXiao.bmp", "聚灵晶（小）",Command.saoHuoGroceriesDataMap.get("聚灵晶（小）"));
						findArticle(this.GENERALTYPE,"buyLingXuJingSui.bmp", "灵虚精髓", Command.saoHuoGroceriesDataMap.get("灵虚精髓"));
						findArticle(this.GENERALTYPE,"buyTaiYiZhu.bmp", "太乙珠", Command.saoHuoGroceriesDataMap.get("太乙珠"));
						findArticle(this.GENERALTYPE,"buyLvShanHuiShi.bmp", "绿山辉石", Command.saoHuoGroceriesDataMap.get("绿山辉石"));
						findArticle(this.GENERALTYPE,"buyShiChongLianHuaFu.bmp", "侍宠炼化符",Command.saoHuoGroceriesDataMap.get("侍宠炼化符"));
						findArticle(this.GENERALTYPE,"buyQiChongLianHuaFu.bmp", "骑宠炼化符", Command.saoHuoGroceriesDataMap.get("骑宠炼化符"));
						findArticle(this.GENERALTYPE,"buyKunLingHanYu.bmp", "坤灵寒玉", Command.saoHuoGroceriesDataMap.get("坤灵寒玉"));
						findArticle(this.GENERALTYPE,"buyTianGangPoJieShi.bmp", "天罡破界石", Command.saoHuoGroceriesDataMap.get("天罡破界石"));
						findArticle(this.GENERALTYPE,"buyQiChongWanJu.bmp", "骑宠玩具", Command.saoHuoGroceriesDataMap.get("骑宠玩具"));
						findArticle(this.GENERALTYPE,"buyWuShuJieJing.bmp", "巫术结晶", Command.saoHuoGroceriesDataMap.get("巫术结晶"));
						findArticle(this.GENERALTYPE,"buyJingZhiJing.bmp", "精之晶", Command.saoHuoGroceriesDataMap.get("精之晶"));
						findArticle(this.GENERALTYPE,"buyBaiSeHunYu1.bmp|buyBaiSeHunYu2.bmp", "白色魂玉", Command.saoHuoGroceriesDataMap.get("白色魂玉"));
						findArticle(this.GENERALTYPE,"buyLvSeHunYu1.bmp|buyLvSeHunYu2.bmp", "绿色魂玉",Command.saoHuoGroceriesDataMap.get("绿色魂玉"));
						findArticle(this.GENERALTYPE,"buyPuSuDeJieZhi.bmp", "朴素的戒指", Command.saoHuoGroceriesDataMap.get("朴素的戒指"));
						findArticle(this.GENERALTYPE,"buyFuHunShi1.bmp|buyFuHunShi2.bmp", "附魂石", Command.saoHuoGroceriesDataMap.get("附魂石"));
						findArticle(this.GENERALTYPE,"buyHuoLiZhiShi.bmp", "火力之石", Command.saoHuoGroceriesDataMap.get("火力之石"));
						findArticle(this.GENERALTYPE,"buyDingHunShi1.bmp|buyDingHunShi2.bmp", "定魂石",Command.saoHuoGroceriesDataMap.get("定魂石"));
						findArticle(this.GENERALTYPE, "buyXianShouDan.bmp", "仙兽骑宠蛋",Command.saoHuoGroceriesDataMap.get("仙兽骑宠蛋"));
						
						//v2.4.4->v2.5.1更新
						findArticle(this.GENERALTYPE, "buyLeiJiZaoMuGanLie.bmp", "雷击枣木干裂", Command.saoHuoGroceriesDataMap.get("雷击枣木干裂"));
						findArticle(this.GENERALTYPE, "buyLeiJiZaoMu.bmp", "雷击枣木", Command.saoHuoGroceriesDataMap.get("雷击枣木"));
						findArticle(this.GENERALTYPE, "buyLiangYiShi.bmp", "两仪石", Command.saoHuoGroceriesDataMap.get("两仪石"));
						findArticle(this.GENERALTYPE, "buyPoSunDeYuPei.bmp", "破损的玉佩", Command.saoHuoGroceriesDataMap.get("破损的玉佩"));
						findArticle(this.GENERALTYPE, "buySanKong.bmp", "三孔", Command.saoHuoGroceriesDataMap.get("三孔"));
						findArticle(this.GENERALTYPE, "buySanKongSuiPian.bmp", "三孔碎片", Command.saoHuoGroceriesDataMap.get("三孔碎片"));
						findArticle(this.GENERALTYPE, "buyShenWeiYinJi.bmp", "神威印记", Command.saoHuoGroceriesDataMap.get("神威印记"));
						findArticle(this.GENERALTYPE, "buyWuXingFengZhenXuanTie.bmp", "五行封镇玄铁", Command.saoHuoGroceriesDataMap.get("五行封镇玄铁"));
						findArticle(this.GENERALTYPE, "buyWuXingFengZhenXuanTieSuiPian.bmp", "五行封镇玄铁碎片", Command.saoHuoGroceriesDataMap.get("五行封镇玄铁碎片"));
						findArticle(this.GENERALTYPE, "buyYouHanSuiLianShi.bmp", "幽寒碎炼石", Command.saoHuoGroceriesDataMap.get("幽寒碎炼石"));
						findArticle(this.GENERALTYPE, "buyTianGangPoJieShiSuiPian.bmp", "天罡破界石碎片", Command.saoHuoGroceriesDataMap.get("天罡破界石碎片"));
						findArticle(this.GENERALTYPE, "buyErJiFanXuFu.bmp", "二级返虚符", Command.saoHuoGroceriesDataMap.get("二级返虚符"));
						findArticle(this.GENERALTYPE, "buyNingYuanKeLi.bmp", "凝元颗粒", Command.saoHuoGroceriesDataMap.get("凝元颗粒"));
						findArticle(this.GENERALTYPE, "buyQianZiTianShu.bmp", "千字天书", Command.saoHuoGroceriesDataMap.get("千字天书"));
						
						//v2.5.4
						findArticle(this.GENERALTYPE, "buyZhenShengXueJing.bmp", "真圣血晶", Command.saoHuoGroceriesDataMap.get("真圣血晶"));
						findArticle(this.GENERALTYPE, "buyChuHaiJiaoLongPeiShi.bmp", "出海蛟龙配饰", Command.saoHuoGroceriesDataMap.get("出海蛟龙配饰"));
						findArticle(this.GENERALTYPE, "buyTianYuanShi.bmp", "天元石", Command.saoHuoGroceriesDataMap.get("天元石"));
						findArticle(this.GENERALTYPE, "buyFuMoLing.bmp", "伏魔令", Command.saoHuoGroceriesDataMap.get("伏魔令"));
						findArticle(this.GENERALTYPE, "buyKongBaiPeiShiFuMoFuZhi.bmp", "空白配饰附魔符纸", Command.saoHuoGroceriesDataMap.get("空白配饰附魔符纸"));
						findArticle(this.GENERALTYPE, "buyRuoShuiZhiJing.bmp", "弱水之精", Command.saoHuoGroceriesDataMap.get("弱水之精"));
						findArticle(this.GENERALTYPE, "buyNingQiShi.bmp", "凝气石", Command.saoHuoGroceriesDataMap.get("凝气石"));
						findArticle(this.GENERALTYPE, "buyShengLingDan.bmp", "圣灵丹", Command.saoHuoGroceriesDataMap.get("圣灵丹"));
						findArticle(this.GENERALTYPE, "buySiJiFanXuFu.bmp", "四级返虚符", Command.saoHuoGroceriesDataMap.get("四级返虚符"));
						findArticle(this.GENERALTYPE, "buyZhongJiLingXuFu.bmp", "中级灵虚符", Command.saoHuoGroceriesDataMap.get("中级灵虚符"));
						findArticle(this.GENERALTYPE, "buyWeiLingXianFen.bmp", "威灵仙粉", Command.saoHuoGroceriesDataMap.get("威灵仙粉"));
						findArticle(this.GENERALTYPE, "buyDuShanYu.bmp", "独山玉", Command.saoHuoGroceriesDataMap.get("独山玉"));
						findArticle(this.GENERALTYPE, "buyKunXianSheng.bmp", "捆仙绳", Command.saoHuoGroceriesDataMap.get("捆仙绳"));
						findArticle(this.GENERALTYPE, "buyJinLongSuo.bmp", "金龙梭", Command.saoHuoGroceriesDataMap.get("金龙梭"));
						findArticle(this.GENERALTYPE, "buyZiFuHuoYunZhen.bmp", "子午火云针", Command.saoHuoGroceriesDataMap.get("子午火云针"));
						findArticle(this.GENERALTYPE, "buyChuoMuZhu.bmp", "戳目珠", Command.saoHuoGroceriesDataMap.get("戳目珠"));
						findArticle(this.GENERALTYPE, "buyWuHuoQiQinShan.bmp", "五火七禽扇", Command.saoHuoGroceriesDataMap.get("五火七禽扇"));
						
						findArticle(this.GENERALTYPE, "buyZhanJiPiJiu.bmp", "炸鸡啤酒", Command.saoHuoGroceriesDataMap.get("炸鸡啤酒"));
						findArticle(this.GENERALTYPE, "buyLingQiJieJing.bmp", "灵气结晶", Command.saoHuoGroceriesDataMap.get("灵气结晶"));
						findArticle(this.GENERALTYPE, "buyJieBangYuJue.bmp", "解绑玉玦", Command.saoHuoGroceriesDataMap.get("解绑玉玦"));
						findArticle(this.GENERALTYPE, "buyMenPaiRenXianYinJi.bmp", "门派任贤印记", Command.saoHuoGroceriesDataMap.get("门派任贤印记"));
						findArticle(this.GENERALTYPE, "buyXianShuMoDian.bmp", "仙书魔典", Command.saoHuoGroceriesDataMap.get("仙书魔典"));
						findArticle(this.GENERALTYPE, "buyJianBing.bmp", "煎饼", Command.saoHuoGroceriesDataMap.get("煎饼"));
						
						findArticle(this.GENERALTYPE, "buyYanShiZhiShuBingJuan.bmp", "偃师之书丙卷", Command.saoHuoGroceriesDataMap.get("偃师之书丙卷"));
						findArticle(this.GENERALTYPE, "buyMiFaFuZhiJingHua.bmp", "秘法符纸精华", Command.saoHuoGroceriesDataMap.get("秘法符纸精华"));
						findArticle(this.GENERALTYPE, "buyPoJieJieJing.bmp", "破界结晶", Command.saoHuoGroceriesDataMap.get("破界结晶"));
						findArticle(this.GENERALTYPE, "buyNingHunZiJing.bmp", "凝魂紫晶", Command.saoHuoGroceriesDataMap.get("凝魂紫晶"));
						findArticle(this.GENERALTYPE, "buyQianKunDing.bmp", "乾坤鼎", Command.saoHuoGroceriesDataMap.get("乾坤鼎"));
						findArticle(this.GENERALTYPE, "buyChuJiPiaoYuXianDan.bmp", "初级飘羽仙丹", Command.saoHuoGroceriesDataMap.get("初级飘羽仙丹"));
						findArticle(this.GENERALTYPE, "buyRongBaoJingYuan.bmp", "融宝精元", Command.saoHuoGroceriesDataMap.get("融宝精元"));
						findArticle(this.GENERALTYPE, "buyChuJiNingQiDan.bmp", "初级凝气丹", Command.saoHuoGroceriesDataMap.get("初级凝气丹"));
						findArticle(this.GENERALTYPE, "buySiKong.bmp", "四孔", Command.saoHuoGroceriesDataMap.get("四孔"));
						
					}

					if(Command.saoHuoStoneUse){			//八卦灵石类扫描是否开启
						stoneScan();	
					}
					if(Command.saoHuoPetUse){			//宠物壳子扫描是否开启
						findArticle(this.PETTYPE_SHENSHOU, "buyShenShouPet1.bmp|buyShenShouPet2.bmp", "神兽侍宠蛋", 0);
						findArticle(this.PETTYPE_YUANXING, "buyYuanXingPet.bmp", "原形宠物蛋", 0);
					}
					if(Command.saoHuoFengWuZhiUse){			//风物志扫描是否开启
						findArticle(this.FENGWUZHI, "buyFengWuZhiZhenQi1.bmp|buyFengWuZhiZhenQi2.bmp|buyFengWuZhiSiCang1.bmp|buyFengWuZhiSiCang2.bmp|buyFengWuZhiPuTong1.bmp|buyFengWuZhiPuTong2.bmp|buyFengWuZhiJueShi1.bmp|buyFengWuZhiJueShi2.bmp", "风物志", 0);
					}
					if(Command.saoHuoLegendUse){		//传奇配方扫描是否开启
						findArticle(this.CHUANQIPEIFANG, "buyChuanQiFaShi.bmp|buyChuanQiFuZhou.bmp|buyChuanQiLiShi.bmp|buyChuanQiYouXia.bmp", "传奇装备图纸", 0);
					}
					if(Command.saoHuoQiangLiJueUse){	//强力诀
						findArticle(this.QIANGLITYPE, "buyQiangLiJue.bmp", "强力诀至尊属性", 0);	//强力诀
					}
					if(Command.saoHuoZhanHunUse){	//战魂
						findArticle(this.ZHANHUNTYPE, "buyZhanhun11.bmp|buyZhanhun12.bmp|buyZhanHun21.bmp|buyZhanhun22.bmp|buyZhanHun31.bmp|buyZhanhun32.bmp|buyZhanHun41.bmp|buyZhanhun42.bmp|buyZhanHun51.bmp|buyZhanhun52.bmp", "1-5级战魂", 0);				//1-5级战魂
						findArticle(this.ZHANHUNTYPE, "buyZhanHun71.bmp|buyZhanHun72.bmp|buyZhanHun81.bmp|buyZhanHun82.bmp|buyZhanHun91.bmp|buyZhanHun92.bmp", "7-10级战魂", 0);				//7-9级战魂
					}
					if(Command.saoHuoTongShenJueUse){	//通神诀
						findArticle(this.TONGSHENJUE, "buyTongShenJue.bmp", "秘法符咒", 0);	//通神诀
					}
					
					//点击关闭查看完的摊位窗口
					this.mouse.mouseClick(356,151, true);	//点击关闭
					this.sleep.sleep(100);
				}else{
					//第一个摊位没打开，原因可能是距离走太远或者起摊了
				}
			}else{		//没有摊位或者都看过了，走位
//				file.log("定点扫货完毕！");
				if(this.refreshNum++>2){
					Command.saoHuoNowPosition++;
					if(Command.saoHuoNowPosition>11){
						Command.saoHuoNowPosition=0;
					}
					
					//M开地图
					this.press.keyPress(77);
					this.sleep.sleep(1000);
					this.mouse.mouseClick(Command.saoHuoMapXArray[Command.saoHuoNowPosition],Command.saoHuoMapYArray[Command.saoHuoNowPosition], true);
					this.sleep.sleep(200);
					this.press.keyPress(77);
					this.sleep.sleep(200);
					this.press.keyPress(48);		//宝宝自动寻路，20秒时间，返回上级线程中进行等待
					this.run=false;
				}else{
					this.sleep.sleep(1000);	//等待1秒
				}
			}
			
			//是否有决斗、交易申请，避免打断
			guard();
			
			tan=null;
		}
		
	}
	
	/**
	 * 找指定的物品
	 * <li>type:对应着上面的this.STONETYPE……
	 * <li>bmp:该物品的bmp图片,多个用|分割
	 * <li>name:该物品的名字，用于购买后的日志记录
	 * <li>maxMoney:低于多少钱自动买进
	 */
	public void findArticle(int type,String bmp,String name,int maxMoney){
		if(Command.mainThread){		//线程是否开启
			try {
				//从整个摊位上扫描特定的物品图片
				Variant[] var=new Variant[8];
				var[0]=new Variant(102);
				var[1]=new Variant(260);
				var[2]=new Variant(350);
				var[3]=new Variant(521);
				var[4]=new Variant(bmp);
				var[5]=new Variant(Command.picColor);
				var[6]=new Variant(Command.picSim);
				var[7]=new Variant(Command.orderDir);
				String findPicE=activeDm.invoke("FindPicEx",var).getString();
				var=null;
				String[] getPic=findPicE.split("\\|");
				int getPicLength=getPic.length;
				if(getPicLength<2){		//少于2个，有可能没有找到，先进行判断
					String[] picSubArray=getPic[0].split(",");
					if(lang.Integer_(picSubArray[0], -1)>-1){		//找到了
						
						readTanMoney(lang.Integer_(picSubArray[1], 0),lang.Integer_(picSubArray[2], 0),type, maxMoney, name);
						
					}else{			
						//没有找到
					}
					picSubArray=null;
				}else{		//大于等于2个，一定是找到了，直接进行读取
					for (int i = 0; i < getPicLength; i++) {
						String[] picSubArray=getPic[i].split(",");
						readTanMoney(lang.Integer_(picSubArray[1], 0),lang.Integer_(picSubArray[2], 0),type, maxMoney, name);
						picSubArray=null;
					}
				}
				
				getPicLength=0;
				findPicE=null;
				getPic=null;
			} catch (Exception e) {
				e.printStackTrace();
				new Func.File().log("查找指定物品异常捕获:"+e.getMessage());
			}
		}
	}
	
	/**
	 * 读取当前物品的所属分类，如神兽宠物蛋、秘法符咒,读取的一律是白色文字dfdfdf-333333，使用elseDict.txt<br/>
	 * 当前状态为鼠标放上后查看物品的价格小窗口
	 * @param x 鼠标放到物品上查看物品，当前的x坐标
	 * @param y 鼠标放到物品上查看物品，当前的y坐标
	 * @param use 是否使用，是否开启读取物品的分类
	 * @param className 若是use为true，使用，则此处为读取的分类名字
	 * @param classNameXStart 读取分类名字的x开始处,距离传入的x的相对坐标，若是在其上，则为负数
	 * @param classNameYStart 读取分类名字的y开始处,距离传入的y的相对坐标，若是在其上，则为负数
	 * @param classNameXEnd 读取分类名字的x结束处，距离传入的x的相对坐标
	 * @param classNameYEnd 读取分类名字的y结束处,距离传入的y的相对坐标
	 * @param readThisNameBoolean 若use为true，此处生效。当大类的分类名字读出来了，继而是否开启判断当前的物品名字
	 * @param readThisName 若readThisNameBoolean为true，此处开启，判断读出的名字是否跟物品现在的名字一样
	 * @param type 待处理的模式、类型。<br/>
	 * 				<li>神兽宠物蛋为21(this.PETTYPE_SHENSHOU)
	 * 				<li>原型侍宠蛋为22(this.PETTYPE_YUANXING)
	 * 
	 * @return int 返回价格。如果是确定某样物品是否是属于这个分类，若是属于返回1，不属于返回-1
	 */
	public int readClassName(int x,int y,boolean use,String className,int classNameXStart,int classNameYStart,int classNameXEnd,int classNameYEnd, boolean readThisNameBoolean, String readThisName,int type){
		int xnx3_result=2;		//初始化为2铜
		if(use){
			//首先判断读取物品分类时传入的坐标，若是超过界限进行调整
			if(x+classNameXStart<0){
				classNameXStart=0-x;
			}
			if(y+classNameYStart<0){
				classNameYStart=0-y;
			}
			if(x+classNameXEnd>1024){
				classNameXEnd=1024-x;
			}
			if(y+classNameYEnd>768){
				classNameYEnd=768-y;
			}
			
			int getClassName[]=this.findStr.findStrE(x+classNameXStart, y+classNameYStart, x+classNameXEnd, y+classNameYEnd, className, "dfdfdf-666666", Command.doubleNine, 3);
			if(getClassName[0]!=-1){	//找到了
				
				if(readThisNameBoolean){	//是否开启了物品具体名字的读取
					switch (type) {
					case 21:	//神兽宠物蛋
						
						String getShenShouName = this.findStr.readStr(getClassName[1]+100, getClassName[2]+88, getClassName[1]+220, getClassName[2]+110, "dfdfdf-666666", Command.doubleNine, 3);
//						file.screenImage("神兽-"+getShenShouName+include.Module.Now_date.String_bunch(), getClassName[1]+100, getClassName[2]+88, getClassName[1]+220, getClassName[2]+110);
						//查找,获取到当前价格
						xnx3_result=getMapData(this.PETTYPE, getShenShouName);
						
						/**  更新时添加  **/
//						if(xnx3_result==1){
//							file.screenImage("神兽-"+getShenShouName+include.Module.Now_date.String_bunch(), getClassName[1]+100, getClassName[2]+88, getClassName[1]+220, getClassName[2]+110);
//						}
						
						getShenShouName=null;
						break;
					case 22:	//原型宠物蛋
						String getYuanXingName = this.findStr.readStr(getClassName[1]+90, getClassName[2]+87, getClassName[1]+185, getClassName[2]+108, "dfdfdf-666666", Command.doubleNine, 3);
//						file.screenImage("原形-"+getYuanXingName+include.Module.Now_date.String_bunch(), getClassName[1]+90, getClassName[2]+87, getClassName[1]+185, getClassName[2]+108);
						//查找,获取到当前价格
						xnx3_result=getMapData(this.PETTYPE, getYuanXingName);
						getYuanXingName=null;
						break;
					case 4:		//强力诀
						String getQiangLiAttribute=this.findStr.readStr(getClassName[1]-5, getClassName[2]+158, getClassName[1]+90, getClassName[2]+182, "00ee00-666666", Command.doubleNine, 3);
//						file.screenImage("强力诀-"+include.Module.Now_date.String_bunch(),getClassName[1]-5, getClassName[2]+158, getClassName[1]+90, getClassName[2]+182);
						if(getQiangLiAttribute.equals("至尊强力属性：")||getQiangLiAttribute.indexOf("至尊强力属性")!=-1){
							xnx3_result=Command.saoHuoElseClass.get("强力诀至尊属性");
						}else if (getQiangLiAttribute.equals("稀有强力属性：")||getQiangLiAttribute.indexOf("稀有强力属性")!=-1) {
							xnx3_result=Command.saoHuoElseClass.get("强力诀稀有属性");
						}else if (getQiangLiAttribute.equals("高级强力属性：")||getQiangLiAttribute.indexOf("高级强力属性")!=-1) {
							xnx3_result=Command.saoHuoElseClass.get("强力诀高级属性");
						}else if (getQiangLiAttribute.equals("中级强力属性：")||getQiangLiAttribute.indexOf("中级强力属性")!=-1) {
							xnx3_result=Command.saoHuoElseClass.get("强力诀中级属性");
						}else if (getQiangLiAttribute.equals("普通强力属性：")||getQiangLiAttribute.indexOf("普通强力属性")!=-1) {
							xnx3_result=Command.saoHuoElseClass.get("强力诀普通属性");
						}else{
							//不是至尊、稀有强力属性
//							file.screenImage("强力诀没找到-"+getQiangLiAttribute+include.Module.Now_date.String_bunch(),getClassName[1]-5, getClassName[2]+158, getClassName[1]+90, getClassName[2]+182);
						}
						
						/**  更新时使用  **/
//						if(xnx3_result==1){
//							file.screenImage("强力-"+include.Module.Now_date.String_bunch(), getClassName[1]-5, getClassName[2]+158, getClassName[1]+90, getClassName[2]+182);
//						}
						
//						file.screenImage("强力诀-"+getQiangLiAttribute+include.Module.Now_date.String_bunch(),getClassName[1]-5, getClassName[2]+158, getClassName[1]+90, getClassName[2]+182);
						getQiangLiAttribute=null;
						break;
					case 5:
						String getZhanHunName=this.findStr.readStr(getClassName[1]+130, getClassName[2]+130, getClassName[1]+277, getClassName[2]+160, "dfdfdf-666666", Command.doubleNine, 3);
						if(getZhanHunName.equals("战魂等级：5")){
							xnx3_result=Command.saoHuoElseClass.get("5级战魂");
						}else if (getZhanHunName.equals("战魂等级：6")) {
							xnx3_result=Command.saoHuoElseClass.get("6级战魂");
						}else if (getZhanHunName.equals("战魂等级：7")) {
							xnx3_result=Command.saoHuoElseClass.get("7级战魂");
						}else if (getZhanHunName.equals("战魂等级：8")) {
							xnx3_result=Command.saoHuoElseClass.get("8级战魂");
						}else if (getZhanHunName.equals("战魂等级：9")) {
							xnx3_result=Command.saoHuoElseClass.get("9级战魂");
						}else if (getZhanHunName.equals("战魂等级：10")) {
							xnx3_result=Command.saoHuoElseClass.get("10级战魂");
						}
						
//						/**  更新时使用  **/
//						if(xnx3_result==1){
//							file.screenImage("战魂-"+include.Module.Now_date.String_bunch(), getClassName[1]+130, getClassName[2]+130, getClassName[1]+277, getClassName[2]+160);
//						}
//						
						
						break;
					case 6:		//风物志
						String getFengWuZhiName=this.findStr.readStr(getClassName[1], getClassName[2]-41, getClassName[1]+171, getClassName[2], "00ffff-666666", Command.doubleNine, 3);
						xnx3_result=getMapData(this.FENGWUZHI, getFengWuZhiName);
						
						/**  更新时使用  **/
//						if(xnx3_result==1){
//							file.screenImage("风物志"+getFengWuZhiName+"-"+include.Module.Now_date.String_bunch(),getClassName[1], getClassName[2]-41, getClassName[1]+171, getClassName[2]);
//						}
						
						getFengWuZhiName=null;
						break;
					case 7:		//传奇图纸
						String getLegendName=this.findStr.readStr(getClassName[1]+80, getClassName[2]+40, getClassName[1]+320, getClassName[2]+77, "da44ff-555555", Command.doubleNine, 3);
						xnx3_result=getMapData(this.CHUANQIPEIFANG, getLegendName);
						
//						/**  更新时使用  **/
//						if(xnx3_result==1){
//							file.screenImage("传奇图纸-"+include.Module.Now_date.String_bunch(), getClassName[1]+80, getClassName[2]+40, getClassName[1]+320, getClassName[2]+77);
//						}
						
						
						getLegendName=null;
						break;
					case 8:		//通神诀
						String getFuLingAttribute=this.findStr.readStr(getClassName[1]-4, getClassName[2]+82, getClassName[1]+93, getClassName[2]+112, "00ee00-666666", Command.doubleNine, 3);
						if(getFuLingAttribute.equals("极品附灵属性：")||getFuLingAttribute.indexOf("极品附灵属性")!=-1){
							xnx3_result=Command.saoHuoElseClass.get("通神诀极品附灵属性");
						}else if (getFuLingAttribute.equals("稀有附灵属性：")||getFuLingAttribute.indexOf("稀有附灵属性")!=-1) {
							xnx3_result=Command.saoHuoElseClass.get("通神诀稀有附灵属性");
						}else if (getFuLingAttribute.equals("高级附灵属性：")||getFuLingAttribute.indexOf("高级附灵属性")!=-1) {
							xnx3_result=Command.saoHuoElseClass.get("通神诀高级附灵属性");
						}else if (getFuLingAttribute.equals("中级附灵属性：")||getFuLingAttribute.indexOf("中级附灵属性")!=-1) {
							xnx3_result=Command.saoHuoElseClass.get("通神诀中级附灵属性");
						}else if (getFuLingAttribute.equals("普通附灵属性：")||getFuLingAttribute.indexOf("普通附灵属性")!=-1) {
							xnx3_result=Command.saoHuoElseClass.get("通神诀普通附灵属性");
						}else{
							//没找到，记录,调试使用
//							file.screenImage("没找到-"+include.Module.Now_date.String_bunch(),getClassName[1]-4, getClassName[2]+82, getClassName[1]+93, getClassName[2]+112);
						}
						
						/**  更新时使用  **/
//						if(xnx3_result==1){
//							file.screenImage("通神-"+include.Module.Now_date.String_bunch(), getClassName[1]-4, getClassName[2]+82, getClassName[1]+93, getClassName[2]+112);
//						}
						
						getFuLingAttribute=null;
						break;
					default:
						break;
					}
				}
				
				getClassName=null;
			}else{	//没找到
				xnx3_result=-1;
//				file.screenImage("类名字没找到-"+include.Module.Now_date.String_bunch(),x+classNameXStart, y+classNameYStart, x+classNameXEnd, y+classNameYEnd);
//				this.message.showMessageDialog("没有找到【类名】，暂停");
			}
			
		}
		
		return xnx3_result;
	}
	
	/**
	 * 扫描所有物品价格，凡是低于指定价格(1铜)的都一率买进。读摊位6*4（大商家状态6*6包裹物品）
	 */
	public void oneTongScan(){
		//包裹属性，第一个包裹，初始值
		int xPosition=127;
		int yPosition=289;
		//每格的x、y递增值
		int add=39;
		
		//进行普通摊位6*4扫描,首先进行横坐标
		for(int y=0;y<4&&Command.mainThread;y++){
			for(int x=0;x<6;x++){
				if(!this.findPic.findPicE((xPosition+add*x)-22, (yPosition+y*add)-22,(xPosition+add*x)+22, (yPosition+y*add)+22, "emptyPack.bmp")){
					readTanMoney(xPosition+add*x,yPosition+y*add,this.GENERALTYPE,2,"摆错价");
				}
			}
		}
		
		//判断第5排格子是否开启
		if(!this.findPic.findPicE(107,429,145,463, "nullPack.bmp")){
			for(int x=0;x<6&&Command.mainThread;x++){
				if(!this.findPic.findPicE((xPosition+add*x)-22, (yPosition+4*add)-22,(xPosition+add*x)+22, (yPosition+4*add)+22, "emptyPack.bmp")){
					readTanMoney(xPosition+add*x, yPosition+4*add,this.GENERALTYPE,2,"摆错价");
				}
			}
		}
		
		//判断第6排格子是否开启
		if(!this.findPic.findPicE(109,468,146,501, "nullPack.bmp")){
			for(int x=0;x<6&&Command.mainThread;x++){
				if(!this.findPic.findPicE((xPosition+add*x)-22, (yPosition+5*add)-22,(xPosition+add*x)+22, (yPosition+5*add)+22, "emptyPack.bmp")){
					readTanMoney(xPosition+add*x, yPosition+5*add,this.GENERALTYPE,2,"摆错价");
				}
			}
		}
		
	}
	
	/**
	 * 扫描所有八卦灵石(凡是有卦象的都扫描)
	 */
	public void stoneScan(){
		try {
			this.activeDm.invoke("UseDict",6);
			
			//从整个摊位上扫描特定的物品图片
			Variant[] var=new Variant[7];
			var[0]=new Variant(102);
			var[1]=new Variant(260);
			var[2]=new Variant(350);
			var[3]=new Variant(521);
			var[4]=new Variant("乾|兑|离|震|巽|坎|艮|坤");
			var[5]=new Variant("ff0000-222222|cc0000-000000");
			var[6]=new Variant(Command.doubleNine);
			String findStrEx=this.activeDm.invoke("FindStrEx",var).getString();
			var=null;
			String[] getStrArray=findStrEx.split("\\|");
			int getPicLength=getStrArray.length;
			if(getPicLength<2){		//少于2个，有可能没有找到，先进行判断
				String[] picSubArray=getStrArray[0].split(",");
				if(this.lang.Integer_(picSubArray[0], -1)>-1){		//找到了
					readTanMoney(this.lang.Integer_(picSubArray[1], 0)+10,this.lang.Integer_(picSubArray[2], 0)+10,this.STONETYPE, 0, "八卦石头");
//					System.out.println("找到一个石头");
				}else{			
					//没有找到
				}
				picSubArray=null;
			}else{		//大于等于2个，一定是找到了，直接进行读取
//				System.out.println("找到2个或以上石头");
				for (int i = 0; i < getPicLength&&Command.mainThread; i++) {
					String[] strSubArray=getStrArray[i].split(",");
					//picSubArray[1]:X坐标，   picSubArray[2]：Y坐标
					readTanMoney(this.lang.Integer_(strSubArray[1], 0)+10,this.lang.Integer_(strSubArray[2], 0)+10,this.STONETYPE, 0, "八卦石头");
					strSubArray=null;
				}
			}
			
			getPicLength=0;
			findStrEx=null;
			getStrArray=null;
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("查找八卦灵石异常捕获:"+e.getMessage());
		}
	}
	
	/**
	 * 鼠标放上后查看物品，读取物品的价格
	 * <li>x,y为鼠标当前坐标，传入
	 * <li>type:类型模式，1为普通模式杂货放上扫描价格(此时maxMoney,name需要传入，起作用);  <br/>2为八卦灵石扫描模式(maxMoney,name无效,动态从列表中读取。maxMoney传入默认值99999999(99砖))
	 * <li>maxMoney为可接受的最大的金额，当物品低于这个金额时自动买进
	 * <li>name:当前购买的物品名字,成功后记录使用
	 * @param 
	 */
	public void readTanMoney(int x,int y,int type,int maxMoney,String name){
		boolean readMoney=true;			//是否读取价格，石头读取模式中如果石头的名字没有读出来则直接不读价格跳过
		this.mouse.mouseMoveTo(x, y);		//鼠标放到物品上查看
		this.sleep.sleep(250);
		
		switch (type) {		//类型
		case 1:		//【八卦灵石】this.STONETYPE
			//首先查找上方白色文字[八卦灵石]字样
			int title[]=this.findStr.findStrE(x-35, 20, x+60, y+100, "八卦灵石", "e9e5d2-777777", Command.doubleNine, 7);
			if(title[0]!=-1){	//找到了
				//读八卦灵石的名字
				name=null;
				name=this.findStr.readStr(title[1]+60, title[2]-35, title[1]+290, title[2], "35bfff-555555|00ff00-555555|acf003-555555|00ffff-555555", Command.doubleNine, 7);
			}else{	//没找到[八卦灵石]白色文字
				readMoney=false;		//直接跳出，不读价格
				//测试，先截图
//				file.screenImage("没找到[八卦灵石]白字"+include.Module.Now_date.String_bunch(), x-35, 20, x+60, y+100);
			}
			title=null;
			break;
		case 21:  //【神兽侍宠蛋】this.PETTYPE_SHENSHOU
			maxMoney=readClassName(x,y,true,"神兽侍宠蛋" , -40,-320,100,100, true, null, type);
			break;
		case 22:		//【原形宠物蛋】this.PETTYPE_YUANXING
			maxMoney=readClassName(x,y,true,"原形宠物蛋" , -45,-320,112,100, true, null, type);
			break;
		case 4:		//强力诀 this.QIANGLITYPE
			maxMoney=readClassName(x,y,true,"秘法符咒" , -38,-245,93,162, true, null, type);
			break;
		case 5:		//战魂 this.ZHANHUNTYPE
			maxMoney=readClassName(x,y, true, "侍宠战魂水晶", -37, -382, 135,102, true,null, type);
			break;
		case 6:		//风物志 this.FengWuZhi
			maxMoney=readClassName(x,y, true, "风物志", -10, -240,90, -120, true,null, type);
			break;
		case 7:
			maxMoney=readClassName(x,y, true, "传奇装备图纸", -15, -250,150, 200, true,null, type);
			break;
		case 8:
			maxMoney=readClassName(x,y,true,"秘法符咒" , -38,-245,93,162, true, null, type);
			break;
		default:
			break;
		}
		

		//出售价格、右键交易文字识别：ffd800-888888
		int chu[]=this.findStr.findStrE(x-60, y-95, x+60, 760, "出", "ffd800-888888", Command.doubleNine, 0);
		if(chu[0]!=-1){		//找到了出售价格
			if(type==this.STONETYPE){		//八卦灵石模式，需要先读取耐久度
				int naiJiu[]=this.findStr.findStrE(chu[1]-3, chu[2]-20, chu[1]+40, chu[2]+1, "耐", "ff0000-333333|d30707-666666|ffffff-222222|efefef-555555|9f9d9b-333333|00ff00-333333|03d008-555555", Command.doubleNine,8);
				if(naiJiu[0]>=-1){		//找到"耐久"了,继而读价格，读全部（耐久2/2）
					String stoneNaiJiu=this.findStr.readStr(naiJiu[1]-2, naiJiu[2]-2, naiJiu[1]+90, naiJiu[2]+20, "ff0000-333333|d30707-666666|ffffff-222222|efefef-555555|9f9d9b-333333|00ff00-333333|03d008-555555", Command.doubleNine, 8);
					name=name+stoneNaiJiu;
					stoneNaiJiu=null;
				}else{	//没找到耐久字样，可能是幻彩石头
//					System.out.println("没找到耐久");
				}
				naiJiu=null;
				//获取价格
				maxMoney=getMapData(this.STONETYPE, name);
			}
			
			
			String moneyStr=this.findStr.readStr(chu[1]+53, chu[2]-1, chu[1]+180, chu[2]+16, "bea102-333333|efca00-222222|8ea7a7-444444|d7efef-444444", Command.doubleNine, 4);
//			System.out.println("\t读取的名字："+name+"读取的价格："+moneyStr);
			if(moneyStr==""){	//没找扫描到价格
//				this.file.log("没有找到价格！进行截图记录");
//				this.file.screenImage("没有找到价格进行记录-"+include.Module.Now_date.String_bunch(), chu[1]+53, chu[2]-1, chu[1]+180, chu[2]+15);
			}else{		
				int thisMoney=moneyToInt(moneyStr);
				String screenName=null;		//若是可买进，将要截图保存的文件名，用于第二次确认交易时不符合要求不购买的话删除掉文件
				//如果此物品价格在购买范围内，可以买进，进行买进操作
				if(thisMoney<maxMoney){
					this.mouse.mouseClick(x,y,false);		//右键点击打开购买框
					this.sleep.sleep(200);
					this.mouse.mouseClick(264,370, true);		//购买选项中选择购买最大数量的
					this.sleep.sleep(50);
					this.mouse.mouseClick(426,158,false);	//释放光标
					this.sleep.sleep(50);
					
					screenName="可购买记录"+include.Module.Now_date.xnx3_time();
					this.file.screenImage(screenName, 10, 10, 1000, 760);
					
					String getNum=this.findStr.readStr(90,362,178,379, "bea102-333333|efca00-222222|8ea7a7-444444|d7efef-444444", Command.doubleNine, 5);
					int buyNum=this.lang.Integer_(getNum, 0);
					if(buyNum==0){
//						System.out.println("购买数量为0，钱不够");
						//购买数量为0，金钱不够，不做处理，等待点击取消关闭购买框
						//删除购买成功的截图
//						this.file.deleteFile(Command.thisFilePath+"\\"+Command.screenNoteFile+"\\"+screenName+".bmp");
//						this.file.screenImage("钱不够没能买进的物品记录");
//						//实时邮件提醒
//						if(Command.emailRemind){
//							if(Command.emailMoneyNotEnoughFirst){
//								new Func.SendMail().send("购买["+name+"]时金钱不足而无法购买", "购买["+name+"]时金钱不足而无法购买！该物品需要金钱："+moneyStr+"，请尽快补充金钱。摊位截图已放至logscreen文件夹下。");
//								Command.emailMoneyNotEnoughFirst=false;
//							}else{
//								//不是第一次，已经发送过了
//							}
//						}
//						this.file.log("购买["+name+"]时金钱不足而无法购买");
						this.mouse.mouseClick(276,444,true);
						this.sleep.sleep(200);
					}else{		//购买数量不为0，继而判断总金钱数
						String getAllMoney=this.findStr.readStr(117,410,276,425, "bea102-333333|efca00-222222|8ea7a7-444444|d7efef-444444", Command.doubleNine, 4);
						int allMoney=moneyToInt(getAllMoney);
						
						//确认无误，可以购买
						if((allMoney/buyNum)==thisMoney){
							this.file.screenImage("可购买记录");
							this.mouse.mouseClick(120,445,true);
							this.sleep.sleep(30);
							if(thisMoney>3000000){			//金额大于3砖会弹出确认提示,点击确认按钮
								/**
								 * 待修改，直接点击确定按钮确认购买
								 * 
								 */
								int[] findPosition=this.findPic.findPicEPosition(278,174,756,544, "enter.bmp");
								if(findPosition[0]==-1){	//没找到，默认点击确认按钮，取消掉弹出框
									this.press.keyPress(13);
								}else{		//没有找到图的位置，默认点确定按钮
									this.mouse.mouseClick(findPosition[1]+20, findPosition[2]+9, true);
								}
								this.sleep.sleep(500);
							}
							this.file.log("购买["+name+"]成功，以["+moneyToString(thisMoney)+"]每个的价格买入["+buyNum+"]个");
						}else{		//判断未匹配，购买确认按钮跟查看金钱时的价格不一样，不购买
//							file.screenImage("确认购买不匹配记录-"+include.Module.Now_date.String_bunch(), 70,282,324,475);
//							file.log("确认交易时不匹配，物品价格:"+thisMoney+"|确认购买时最大数量:"+buyNum+"|确认购买时总金额:"+allMoney);
							//删除购买成功的截图
							this.file.deleteFile(Command.thisFilePath+"\\"+Command.screenNoteFile+"\\"+screenName+".bmp");
							//等待点击取消关闭购买框
							this.sleep.sleep(50);
							this.mouse.mouseClick(276,444,true);
							this.sleep.sleep(200);
						}
					}
					
				}
				
			}
		}else{
//				购买之后摊位消失也会出现，故而取消记录
//				file.log("没有找到出售价格！进行截图记录");
//				this.file.screenImage("没有找到出售价格进行记录-"+include.Module.Now_date.String_bunch(), x-60, y-95, x+60, 760);
		}
		chu=null;
	}
	
	/**
	 * 判断是否有交易、决斗申请，避免打断
	 */
	public void guard(){
		//血条开始点血颜色是否有血
		if(!this.color.findColor(Command.myXueXStart, Command.myXueY, Command.myXueColor)){
			//判断是否有人发出交易请求
			if(this.findPic.findPicE(367,294,660,462, "requestTrade.bmp")){
				System.out.println("恶意交易");
				if(Command.screenLog){
					this.file.screenImage("恶意交易记录");
					this.file.log("发现恶意交易申请");
					
					//查取消按钮所在图片
					int[] jiaoyi=this.findPic.findPicEPosition(501,368,630,505, "cancel.bmp|cancel2.bmp");
					if(jiaoyi[0]!=-1){
						this.mouse.mouseClick(jiaoyi[1]+23, jiaoyi[2]+7, true);
						
					}else{
						this.mouse.mouseClick(547,415, true);
						this.file.log("发现恶意交易申请，取消时未发现按钮所在！进行默认点击");
					}
					jiaoyi=null;
					
					this.sleep.sleep(300);
				}
			}
			
			//判断是否有人发出决斗请求
			if(this.findPic.findPicE(367,294,660,462, "requestFight.bmp")){
				System.out.println("恶意决斗");
				if(Command.screenLog){
					this.file.screenImage("恶意决斗记录");
					this.file.log("发现决斗申请");
					
					//查取消按钮所在图片
					int[] juedou=this.findPic.findPicEPosition(501,368,630,505, "cancel.bmp");
					if(juedou[0]!=-1){
						this.mouse.mouseClick(juedou[1]+23, juedou[2]+7, true);
					}else{
						this.mouse.mouseClick(547,415, true);
						this.file.log("发现恶意决斗申请，取消时未发现按钮所在！进行默认点击");
					}
					juedou=null;
					
					this.sleep.sleep(300);
				}
			}
			
			
			//单纯查取消按钮所在图片
			int[] cancel=this.findPic.findPicEPosition(347,201,698,455, "cancel.bmp|cancel2.bmp");
			if(cancel[0]!=-1){
				this.mouse.mouseClick(cancel[1]+23, cancel[2]+7, true);
				this.file.screenImage("发现恶意申请");
				this.file.log("发现恶意申请，已取消");
			}
			cancel=null;
			
		}
	}
	
	/**
	 * 将*砖*金*银*铜全部转换为以铜为单位。
	 * 传入"12砖12金12银12铜/12铜"一律以/前计算
	 * @param xnx3_content
	 * @return
	 */
	public int moneyToInt(String xnx3_content){
		int xnx3_result=0;
		String zhuanMoney[] = null;
		boolean zhuanIf=false;
		String jinMoney[]=null;
		boolean jinIf=false;
		String yinMoney[]=null;
		boolean yinIf=false;
		String tongMoney[]=null;
		
		 //确定铜第一次的出现位置，若没出现过，则为999
		int tongFirstCoord=0;
		int tongInstr=xnx3_content.indexOf("铜");
		if(tongInstr>-1){
			tongFirstCoord=tongInstr;
		}else{
			tongFirstCoord=999;
		}
		
		//确定银第一次出现的位置
		int yinFirstCoord=0;
		int yinInstr=xnx3_content.indexOf("银");
		if(yinInstr>-1){
			yinFirstCoord=yinInstr;
		}else{
			yinFirstCoord=999;
		}
		
		//确定金第一次出现的位置
		int jinFirstCoord=0;
		int jinInstr=xnx3_content.indexOf("金");
		if(jinInstr>-1){
			jinFirstCoord=jinInstr;
		}else{
			jinFirstCoord=999;
		}
		
		 //确定砖第一次出现的位置
		int zhuanFirstCoord=0;
		int zhuanInstr=xnx3_content.indexOf("砖");
		if(zhuanInstr>-1){
			zhuanFirstCoord=zhuanInstr;
		}else{
			zhuanFirstCoord=999;
		}
		
	    if(zhuanInstr>-1 &&zhuanInstr<999 && zhuanInstr<tongFirstCoord&&zhuanInstr<yinFirstCoord && zhuanInstr<jinFirstCoord){
	    	zhuanMoney=xnx3_content.split("砖");
	    	xnx3_result=xnx3_result+(lang.Integer_(zhuanMoney[0], 99)*1000000);
	    	zhuanIf=true;
	    }
		if(jinInstr>-1&&jinInstr<999&&jinInstr<tongFirstCoord&&jinInstr<yinFirstCoord){
			if(zhuanIf){
				jinMoney=zhuanMoney[1].split("金");
			}else{
				jinMoney=xnx3_content.split("金");
			}
			xnx3_result=xnx3_result+(lang.Integer_(jinMoney[0], 99)*10000);
			jinIf=true;
		}
	    if(yinInstr>-1&&yinInstr<999&&yinInstr<tongFirstCoord){
	    	if(jinIf){
	    		yinMoney=jinMoney[1].split("银");
	    	}else{
	    		if(zhuanIf){
	    			yinMoney=zhuanMoney[1].split("银");
	    		}else{
	    			yinMoney=xnx3_content.split("银");
	    		}
	    	}
	    	xnx3_result=xnx3_result+(lang.Integer_(yinMoney[0], 99)*100);
	    	yinIf=true;
	    }
	    if(tongInstr>-1&&tongInstr<999){
	    	if(yinIf){
	    		tongMoney=yinMoney[1].split("铜");
	    	}else{
	    		if(jinIf){
	    			tongMoney=jinMoney[1].split("铜");
	    		}else{
	    			if(zhuanIf){
	    				tongMoney=zhuanMoney[1].split("铜");
	    			}else{
	    				tongMoney=xnx3_content.split("铜");
	    			}
	    		}
	    	}
	    	xnx3_result=xnx3_result+lang.Integer_(tongMoney[0], 99);
	    }
	    if(xnx3_result==0){
	    	xnx3_result=999999999;	//999砖
	    }
	    
		zhuanMoney = null;
		jinMoney=null;
		yinMoney=null;
		tongMoney=null;
		
	    return xnx3_result;
	}
	
	/**
	 * 将铜为单位的int数据转换为String类型“12砖2金12银89铜”
	 * 自动计算，如果是小于0，则赋予0铜
	 */
	public String moneyToString(int moneyInput){
		StringBuffer xnx3_result=new StringBuffer();
		
		String money=moneyInput+"";
		int moneyLength=money.length();
		if(moneyLength>6){		//砖
			xnx3_result.append(money.substring(0, moneyLength-6)+"砖");
		}
		if(moneyLength>4){		//金
			String jin=null;
			if(moneyLength>5){
				jin=money.substring(moneyLength-6, moneyLength-4);
			}else{
				jin=money.substring(moneyLength-5, moneyLength-4);
			}
			int j=this.lang.Integer_(jin, 0);
			if(j!=0){
				xnx3_result.append(j+"金");
			}
		}
		if(moneyLength>2){		//银
			String yin=null;
			if(moneyLength>3){
				yin=money.substring(moneyLength-4, moneyLength-2);
			}else{
				yin=money.substring(moneyLength-3, moneyLength-2);
			}
			int y=this.lang.Integer_(yin, 0);
			if(y!=0){
				xnx3_result.append(y+"银");
			}
		}
		
		//铜
		String tong=null;
		if(moneyLength>1){
			tong=money.substring(moneyLength-2, moneyLength);
		}else{
			if(moneyInput==0||moneyInput<=0){
				tong="";		//空
			}else{
				tong=money.substring(moneyLength-1, moneyLength);
			}
		}
		int t=this.lang.Integer_(tong, 0);
		if(t!=0){
			xnx3_result.append(t+"铜");
		}
		
		return xnx3_result.toString();
	}
	
	/**
	 * 点击摊位列表的刷新按钮
	 */
	public void refresh(){
		this.sleep.sleep(50);
		this.mouse.mouseClick(438,571, true);
		this.sleep.sleep(200);
	}
	
	/**
	 * 点击第一个摊位，查看摊位
	 * @param args
	 */
	public boolean openFirstTanWei(){
		boolean xnx3_result=false;
		
		//点击第一个摊位，查看摊位。最大有6秒的延迟时间
		for (int i = 0; i < 20&&(!xnx3_result)&Command.mainThread; i++) {
			this.mouse.mouseClick(414,254,true);		
			this.sleep.sleep(300);
			
			int getTargetTanWei[]=this.findPic.findPicEPosition(0,30,1000,700, "targetTanWei.bmp");
			if(getTargetTanWei[0]!=-1){		//找到目标摊位
				xnx3_result=true;
			}
			getTargetTanWei=null;
		}
		return xnx3_result;
	}
	
	/**
	 * 获取扫货Command存储的map数据
	 * <li>type:自动扫货存储数据源类型，传入如：getMapData_STONETYPE
	 * <li>name:名字
	 * @return
	 * <li>若是出错没有获取到，则返回2铜
	 */
	public Integer getMapData(int type,String name){
		int xnx3_result=0;
		try {
			switch (type) {
			case 1:		//八卦灵石
				xnx3_result=Command.saoHuoStone.get(name);
				break;
			case 2:		//宠物壳子
				xnx3_result=Command.saoHuoPet.get(name);
				break;
			case 6:		//风物志
				xnx3_result=Command.saoHuoFengWuZhi.get(name);
				break;
			case 7:		//传奇图纸
				xnx3_result=Command.saoHuoLegend.get(name);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			xnx3_result=1;		//2铜
//			file.log("getMapData异常捕获:"+name+"->"+e.getMessage());
		}
		return xnx3_result;
	}
	
	public static void main(String[] args) {
	}
}
