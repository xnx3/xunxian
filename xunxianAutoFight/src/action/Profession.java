package action;

import include.Command;

/**
 * 9种职业，UI交互
 * @author xnx3
 *
 */
public class Profession {
	public static void seeJiNengUI(){
		switch (Command.JForm.professionjComboBox.getSelectedIndex()) {
		case 0:		//掌电法师
			Command.browser.loadUrl("http://www.xnx3.com/xunxian/autofight/20130114/929.html",200,200,800,600);
			break;
		case 1:		//控火法师
			Command.browser.loadUrl("http://www.xnx3.com/xunxian/autofight/20130114/931.html",200,200,800,600);
			break;
		case 2:		//乘风法师
			Command.browser.loadUrl("http://www.xnx3.com/xunxian/autofight/20130114/930.html",200,200,800,600);
			break;
		case 3:		//罗刹力士
			Command.browser.loadUrl("http://www.xnx3.com/xunxian/autofight/20130114/928.html",200,200,800,600);
			break;
		case 4:		//金刚力士
			Command.browser.loadUrl("http://www.xnx3.com/xunxian/autofight/20130114/932.html",200,200,800,600);
			break;
		case 5:		//奇门游侠
			Command.browser.loadUrl("http://www.xnx3.com/xunxian/autofight/20130114/933.html",200,200,800,600);
			break;
		case 6:		//御剑游侠
			Command.browser.loadUrl("http://www.xnx3.com/xunxian/autofight/20130114/934.html",200,200,800,600);
			break;
		case 7:		//天君符咒师
			Command.browser.loadUrl("http://www.xnx3.com/xunxian/autofight/20130114/935.html",200,200,800,600);
			break;
		case 8:		//幽冥符咒师
			Command.browser.loadUrl("http://www.xnx3.com/xunxian/autofight/20130114/936.html",200,200,800,600);
			break;	
		case 9:		//乾坤游侠
			Command.browser.loadUrl("http://www.xnx3.com/xunxian/autofight/20131017/941.html",200,200,800,600);
			break;
		default:
			break;
		}
	}
	
	/**
	 * 运行时根据职业选择初始化配置数据
	 */
	public static void dataInit(){
		//初始化技能
		Command.helpJiNeng1Use=true;	//开启
		Command.helpJiNeng1Num=8;			//当血量少于百分之多少时(90%)
		Command.helpJiNeng1Key=4;			//5键	对应keyArray数组中的数据	
		Command.helpJiNeng1Time=0;			//技能释放时间，对应keySleep数组中的数据
		
		Command.helpJiNeng2Use=true;	//开启
		Command.helpJiNeng2Num=3;			//40%
		Command.helpJiNeng2Key=5;			//6键
		Command.helpJiNeng2Time=1;
		
		Command.helpHongUse=true;			//血条监控自动喝红、回生水开启
		Command.helpLanUse=true;			//蓝条监控自动喝蓝开启
		
		//多线程定时技能释放，选择职业时启动后初始化
		Command.threadJiNengTime=300000;	//多长时间释放一次(3分钟)
		Command.threadJiNengSleep=1000;		//辅助技能释放时间
		
		Command.zTime=500;		//一键拾取0.5秒
		
		switch (Command.JForm.professionjComboBox.getSelectedIndex()) {
		case 0:		//掌电法师
			Command.helpJiNeng1Time=0;	//八卦·吸收200毫秒
			Command.helpJiNeng2Time=0;	//八卦·虚无200毫秒
			
			Command.threadJiNengTime=480000;	//力场·节能，8分钟一次
			Command.zTime=1500;			//Z一键拾取拾取
			break;
		case 1:		//控火法师
			Command.helpJiNeng1Num=6;	//血70%时使用技能
			
			Command.threadJiNengTime=480000;	//心火术，8分钟一次
			Command.zTime=1500;			//Z一键拾取拾取
			break;
		case 2:		//乘风法师
			Command.threadJiNengTime=480000;	//清风术，8分钟一次
			Command.helpJiNeng1Time=0;		//银晶甲技能释放时间0.2秒
			Command.zTime=1500;			//Z一键拾取拾取
			break;
		case 3:		//罗刹力士
			Command.helpLanUse=false;	//不喝蓝
			Command.zTime=500;			//Z一键拾取拾取
			break;
		case 4:		//金刚力士
			Command.helpJiNeng1Time=3;	//祭·连击，2秒

			Command.helpLanUse=false;	//不喝蓝
			Command.zTime=500;			//Z一键拾取拾取
			break;
		case 5:		//奇门游侠
			Command.threadJiNengTime=60000;		//奇门术·导引术，1分钟一次
			Command.zTime=500;			//Z一键拾取拾取
			break;
		case 6:		//御剑游侠
			Command.helpJiNeng2Time=0;	//乱影步0.2秒
			Command.zTime=500;			//Z一键拾取拾取
			break;
		case 7:		//天君符咒师
			Command.threadJiNengTime=900000;	//15分钟一次，天君符
			Command.zTime=1500;			//Z一键拾取拾取
			break;
		case 8:		//幽冥符咒师
			Command.helpJiNeng2Time=2;		//1秒
			Command.threadJiNengTime=900000;	//15分钟一次，血符
			Command.zTime=1500;			//Z一键拾取拾取
			break;	
		case 9:		//乾坤游侠
			Command.helpLanUse=false;		//关闭喝蓝监控
			Command.zTime=1000;				//Z一键拾取拾取
			Command.threadJiNengTime=300000;//5分钟一次，锻筋决
			Command.threadJiNengSleep=2500;	//锻筋决释放时间,2.5秒
			Command.helpJiNeng1Time=1;		//0.5秒,炼魄术
			Command.helpJiNeng2Time=1;		//飞燕决
			break;
		default:
			break;
		}
	}
}
