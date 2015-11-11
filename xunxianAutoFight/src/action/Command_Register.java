package action;

import include.Command;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import Func.Sleep;
import Func.XinNuo;

public class Command_Register{

	public void init() {
		// TODO Auto-generated method stub
		include.Command.register.put("use", "0");
		include.Command.register.put("message", "尚未注册！");
	}

	public void start() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			@Override
			public void run() {
				new UIFunc().showMessageLoad();
				include.Command.JForm.registerCodeButton.setText("正在注册");
				String xnx3_message="";		//提示信息
				
				String registerCode=include.Command.JForm.registerCode.getText();
				if(registerCode.equals("")||registerCode.length()<1){
					xnx3_message="请填写注册码!";
				}else{
					if(include.Command.register.get("use").equals("1")){
						xnx3_message="亲！你已经注册了哦";
						include.Command.JForm.registerCodeButton.setText("已注册");
					}else{
						String[] result=new Command_Register().accredit(registerCode);
						try{
							if(result[0].equals("0")){
								//注册失败
								include.Command.register.put("use", "0");
								include.Command.register.put("message", result[1]);
								xnx3_message=result[1];
								include.Command.JForm.registerCodeButton.setText("注册失败！重新注册");
							}else if(result[0].equals("1")){
								//注册成功
								boolean xnx3_result=false;		//是否注册成功
								include.Command.register.put("use", "1");
								include.Command.register.put("message", result[1]);

								//根据key分配的唯一识别码进行检测权限
								String soleKey[]=result[2].split("-");
								if(soleKey[0].equals("1")){		//是否绑定了电脑，若是绑定了特定的电脑
									Command.bindComputer=true;
									String myComputerCode=Command.activeDm.invoke("GetMachineCodeNoMac").getString();
									if(myComputerCode==null||myComputerCode.length()<10){
										xnx3_message="获取本机机器码失败！<br/>请用管理员身份进入系统";
										xnx3_result=false;
									}else{
										if(result[2].indexOf(myComputerCode)>-1){		//机器码在从服务器获取的唯一注册码中，则为验证通过
											xnx3_message="注册成功!";
											Command.myComputerSoleCode=true;			//验证通过，true。软件开启时若bindCOmputer为true，绑定了电脑，需要在进行此处的验证
											xnx3_result=true;
										}else{
											xnx3_message="注册失败!此注册码不是绑定的此台计算机";
											Command.myComputerSoleCode=false;
											xnx3_result=false;
											include.Command.register.put("use", "0");		//还原为未注册状态
										}
									}
								}else{		//没有绑定电脑
									xnx3_result=true;
								}
								soleKey=null;
								if(xnx3_result){
									if(result[2].indexOf("daguai")>-1){
										Command.useDaguai=true;
									}else{
										Command.useDaguai=false;
									}
									if(result[2].indexOf("kaigu")>-1){
										Command.emailRemind=true;			//付费开鼓用户，开启邮件发送
										Command.autoKaiGu=true;
									}else{
										Command.autoKaiGu=false;
									}
									if(result[2].indexOf("saohuo")>-1){
										Command.emailRemind=true;			//付费扫货用户，开启邮件发送
										Command.useSaoHuo=true;
									}else{
										Command.useSaoHuo=false;
									}
									if(result[2].indexOf("sfight")>-1){
										Command.emailRemind=true;			//付费高级打怪功能用户，开启邮件发送
										Command.useSFight=true;
									}else{
										Command.useSFight=false;
									}
									
									
									try {	//信诺答题
										String getDaTi[]=result[6].split("-");
										if(getDaTi[0]!=null&&getDaTi[0].equals("1")){		//开启了自动答题
											Command.emailRemind=true;			//付费购买答题用户，开启邮件发送
											try {
												Command.autoDaTi=true;
												Command.autoDaTiPasswordString=getDaTi[2];
												Command.autoDaTiUserName=getDaTi[3];
												Command.autoDaTiPassword=getDaTi[4];
												new Func.File().log("已设置自动答题");
												
												new Thread(new Runnable() {
													@Override
													public void run() {
														new Func.XinNuo().verifyXinNuo();	//先对信诺自动答题对象进行校验
														Command.autoDaTiRemain=new XinNuo().getAutoDaTiNum();
													}
												}).start();
												
												int i=0;
												while(i++<10){		//10秒的时间
													if(Command.autoDaTiRemain==null){
														new Sleep().sleep(1000);
													}else{
														i=15;	//退出循环
													}
												}
												if(Command.autoDaTiRemain==null){
													new Func.Message().showMessageDialog("您已设置了自动答题<br/>但是获取自动答题剩余题分时尚未获得！<br/><br/>原因：<br/>1.你的网速慢或者网络受阻<br/>2.答题第三方服务器出现异常(可关注QQ群94538237)");
												}
												new UIFunc().setExplainLabel(Command.autoDaTiRemain);
											} catch (Exception e) {
												e.printStackTrace();
												new Func.File().log("加载自动答题辨别时异常捕获:"+e.getMessage());
											}
											
										}else{		//没有开启自动答题
											Command.autoDaTi=false;
											new Func.File().log("未设置自动答题，出验证码时需手动输入！");
											new UIFunc().setExplainLabel("未设置自动答题，出验证码时需手动输入！");
										}
										getDaTi=null;
									} catch (Exception e) {
										e.printStackTrace();
									}
										
									Command.softSetCount=Integer.parseInt(result[3]);
									Command.softUseCount=Integer.parseInt(result[4]);
									
									xnx3_message=result[1];
									include.Command.JForm.registerCodeButton.setText("已注册");
								}
								
							}else{
								include.Command.register.put("use", "0");
								include.Command.register.put("message", "注册失败！未连接服务器！");
								xnx3_message="注册失败！<br/>未连接服务器！";
							}
						}catch (Exception e) {
							e.printStackTrace();
							include.Command.register.put("use", "0");
							include.Command.register.put("message", "注册失败！程序处理出错！");
							xnx3_message="注册失败！<br/>程序处理出错！";
						}
						result=null;
					}
				}
				
				new UIFunc().loadMyInfoLabel();
				new UIFunc().hiddenMessage();
				new Func.Message().showMessageDialog(xnx3_message);
			}}).start();
		
		
	}
	
	
	

	/**
	 * new getServiceAccredit().accredit("注册码");
	 * 
	 * @return 返回值为数组,共有5个值。皆为String类型。其中
	 * <li>0->能否使用(0或者1，1为可使用)
	 * <li>1->返回的提示说明(小于500字符的字符串,返回是否成功注册+添加软件时自定义的提示信息)
	 * <li>2->剩余使用次数(数字)
	 * <li>3->到今为止总的使用次数(数字)
	 * <li>4->到期时间(格式为:2012-9-21)
	 * 
	 * 注意，软件的编号需要自己去http://www.xnx3.com/e/extend/SoftKey/user/index.php
	 * 注册后填写你的软件，然后取到你软件的编码填入此处！
	 */
		public String[] accredit(String registerCode){
			//http://www.xnx3.com/e/extend/SoftKey/CheckKey.php?cid=你的软件编号&key=注册码
			String getXnx3Result=getHtml(Command.getRegApiUrl()+"&key="+registerCode, "GBK");
			System.out.println(getXnx3Result);
			String resultArray[]=getXnx3Result.split("\\|");
			
			return resultArray;
		}
		
		public static void main(String[] args) {
			System.out.println(new Command_Register().accredit("mykey"));
		}
		//网络访问
		public static String getHtml(String path,String code) {
			StringBuffer str = new StringBuffer();
			URL u;
			BufferedReader in = null;
			try {
				u = new URL(path);
				in = new BufferedReader(
						new InputStreamReader(u.openStream(), code));
				String s = "";
				while ((s = in.readLine()) != null) {
					str.append(s);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (in != null)
						in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return str.toString();
		}

}
