package Func;

import java.util.Calendar;

import include.Command;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;

public class XinNuo {
	private ActiveXComponent activeDm=null;
	private LanAnswer lanAnswer=null;
	
	public XinNuo(ActiveXComponent activeDm) {
		this.activeDm=activeDm;
		this.lanAnswer=new LanAnswer(this.activeDm);
		verifyXinNuo();
	}
	public XinNuo(){
		verifyXinNuo();
	}
	/**
	 * 校验信诺对象
	 * 首先检查是否创建了信诺对象，若是创建了则跳过，没创建则先创建
	 */
	public void verifyXinNuo(){
		int i=0;
		while(i++<10){
			try {
				Command.activeXinNuo.invoke("WaitOnline");	//检测繁忙程度,判断信诺对象是否创建
				i=100;	//退出循环
			} catch (Exception e) {
				Command.activeXinNuo=new ActiveXComponent("XinNuo.SendData");		//创建信诺自动答题对象,再次创建
			}
		}
		if(i<100){	//小于100，循环中并没有成功过
			new Func.File().log("加载自动答题失败！可尝试关闭软件后重新打开软件");
		}
	}
	
	/**
	 * 出现验证码后的操作-自动答题
	 */
	public void autoDaTi(){
		File file=new File(this.activeDm);
		Mouse mouse=new Mouse(this.activeDm);
		Sleep sleep=new Sleep();
		
		int result=0;	//验证码结果,23为2|3两个位置
		int datiSussess=0;	//答题是否成功，进行3次答题，++递增
		while(datiSussess++<4){
			//使用信诺答题初始化
			boolean useXN=!Command.useLanAnswer;	
			
			//若是开启了局域网答题，首先使用局域网的进行答题
			//判断当前时间是否在设定的局域网答题范围内
			Calendar Cld = Calendar.getInstance();
			int hours = Cld.get(Calendar.HOUR_OF_DAY);
			int minute = Cld.get(Calendar.MINUTE);
			if(Command.hoursStart<=hours&&hours<Command.hoursEnd){
				//进行局域网答题
				if(Command.useLanAnswer){
					int handle=this.lanAnswer.faqCapture(428,368,596,460);
					String ansAll=this.lanAnswer.faqSend(Command.serverIP, handle);
					System.out.println("Lan--->"+ansAll);
					String ansArray[]=ansAll.split(":");
					
					if(ansArray[0].indexOf("Error")>-1){
						//有Error，失败了，可能是服务端关闭了
						file.log("局域网答题-Error,转而开启信诺答题");
//						useXN=true;
					}else{
						//成功了
						result=new Lang().Integer_(ansArray[1], 9);
					}
					ansArray=null;
				}
			}else{
				useXN=true;
			}
			
			
			//使用信诺进行答题
			if(useXN){
				System.out.println("使用XN答题");
				String getTid="123";
				//首先截图，将验证码截图保存为check.bmp文件
				file.screenImage("check", 428,368,596,460);
				
				try {
					Variant[] var=new Variant[5];
					var[0]=new Variant(Command.autoDaTiPasswordString);
					var[1]=new Variant(2022);	//游戏ID
					var[2]=new Variant(Command.thisFilePath+"\\"+Command.screenNoteFile+"\\check.bmp");
					var[3]=new Variant(42);	//超时时间42秒
					var[4]=new Variant("bmp");
					getTid=Command.activeXinNuo.invoke("SendFile",var).getString();
					var=null;
				} catch (Exception e) {
					file.log("自动答题SendGif异常捕获:"+e.getMessage());
				}
				
				
				int i=0;	//限制循环次数
				while(result<1&&i++<20){
					try {
						result=Integer.parseInt(Command.activeXinNuo.invoke("GetAnswer",getTid).getString());
					} catch (Exception e) {
						file.log("获取答题答案GetAnswer转int时异常捕获:"+e.getMessage());
					}
					sleep.sleep(2000);	//2秒一次请求
				}
			}
			
			//局域网答题或者XN答题的结果进行检测
			if(10<result&&result<89){
				file.log("	`e`答题成功,返回值:"+result);
				datiSussess=100;		//退出循环				
			}else{
				file.log("自动答题失败!");
				//点击刷新键重新答题
				result=0;	//失败，初始化0
				mouse.mouseClick(504,480, true);
				sleep.sleep(8000);	//8秒，避免延迟
			}
		}
		
		if(result==0){
			file.log("答题最终失败！！");
			mouse.mouseClick(561,480, true);		//点击取消键，取消自动答题
			sleep.sleep(3000);
		}else{
			String resultString=result+"";
			
			//进行验证动作，点击
			autoDaTiAction(resultString.charAt(0));
			sleep.sleep(500);
			autoDaTiAction(resultString.charAt(1));
			sleep.sleep(500);
			mouse.mouseClick(446,481, true);	//点击确定
		}
		
		file=null;
		mouse=null;
		sleep=null;
	}
	
	/**
	 * 为autoDaTi服务
	 * 8个验证码根据传入1~8进行左键点击
	 */
	public void autoDaTiAction(char param){
		int key=1;
		Mouse mouse=new Mouse(activeDm);
		try {
			key=Integer.parseInt(param+"");
		} catch (Exception e) {
			new Func.File().log("自动答题-自动填写验证动作异常捕获:"+e.getMessage());
		}
		switch (key) {
		case 1:
			mouse.mouseClick(454,390, true);
			break;
		case 2:
			mouse.mouseClick(492,390, true);
			break;
		case 3:
			mouse.mouseClick(526,392, true);
			break;
		case 4:
			mouse.mouseClick(564,392, true);
			break;
		case 5:
			mouse.mouseClick(449,429, true);
			break;
		case 6:
			mouse.mouseClick(489,432, true);
			break;
		case 7:
			mouse.mouseClick(523,430, true);
			break;
		case 8:
			mouse.mouseClick(564,430, true);
			break;
		default:
			break;
		}
		
		mouse=null;
	}
	
	/**
	 * 信诺答题，返回剩余可使用次数
	 */
	public String getAutoDaTiNum(){
		String result="查询时程序出现异常！";
		try {
			Variant[] var=new Variant[1];
			var[0]=new Variant(Command.autoDaTiPasswordString);
			String getResult=Command.activeXinNuo.invoke("SNSearch",var).getString();
			var=null;
			if(getResult.equals("-1")){
				result="上传异常";
			}else if(getResult.equals("-2")){
				result="用户名或密码错误";
			}else if(getResult.equals("-3")){
				result="查询失败";
			}else{	//查询成功，返回剩余题分
				result=getResult+"<br/>(每次验证消耗14题分)";
			}
			getResult=null;
		} catch (Exception e) {
			new Func.File().log("查询自动答题剩余时异常捕获："+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * DM局域网答题
	 */
	public void lanDaTi(){
		
	}
}
