import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.BusinessBlackSteelSkin;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;
import org.jvnet.substance.utils.SubstanceConstants.ImageWatermarkKind;
import org.jvnet.substance.watermark.SubstanceImageWatermark;
import Func.Lang;
import Func.Sleep;
import UI.Message;
import UI.SaoHuo;
import UI.SeniorFight;
import UI.Skill;
import action.File;
import action.UIFunc;
import com.jacob.activeX.ActiveXComponent;
import include.Command;

public class Main {
	public static void main(String[] args) {
		Command.JForm=new UI.Main();
		Command.JForm.setVisible(true);
		Command.jframeMessage=new Message();
		new UIFunc().showMessageLoad();		//加载
		Command.JframeSaoHuo=new SaoHuo();
		Command.JframeSkill=new Skill();
		Command.JframeSeniorFight=new SeniorFight();
		
		init();	//初始化
		
		try {
			new Func.File().log("获取本机机器码："+Command.activeDm.invoke("GetMachineCodeNoMac"));
		} catch (Exception e) {
			new Func.File().log("获取机器码异常捕获："+e.getMessage());
		}
		
		new File().UILoad();	//加载UI数据
		new UIFunc().daguaiItemIsChange_UI();
		new UIFunc().delayItemIsChange_UI();
		
		initSaoHuoUI();
//		adInit();		//广告,v2.4.2以后的版本已废弃
		
		new UIFunc().loadMyInfoLabel();		//更新-加载我的当前信息
		
		new Func.File().log("开启完毕！");
		
		lookAndFeel();	//外观设置
		new File().systemLoad();	//加载软件本身配置信息
		
		new UIFunc().hiddenMessage();
		
//		explainInit();	//公告说明
//		update();		//版本更新
		
		Command.JForm.setTitle((Command.JForm.roleNamejTextField.getText().length()>2? Command.JForm.roleNamejTextField.getText()+"_"+Command.getTitle():Command.getTitle())+Command.version);
		
		collapse();
	}
	
	/**
	 * 容易导致程序崩溃打不开的项
	 */
	public static void collapse(){
		//容易导致程序崩溃，拿出来
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Command.JForm.setCursor(new include.Module.j2se.Interface().cursor("pointer.png"));
					Command.JframeSaoHuo.setCursor(new include.Module.j2se.Interface().cursor("pointer.png"));
					Command.JframeSkill.setCursor(new include.Module.j2se.Interface().cursor("pointer.png"));
					new Func.File().log("创建寻仙鼠标光标完毕");
					
					new include.Module.j2se.Interface().createTrayIcon();	//创建托盘对象
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	/**
	 * 软件打开后加载公告说明
	 */
	public static void explainInit(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				String getExplainSource=include.Module.Url_string.getHtml("http://www.xnx3.com/xunxian/fuzhu/openLoadUrl.html", "utf-8");
				String getExplainArray[]=getExplainSource.split("\\|");
				
				if(getExplainArray[0].equals("1")){	//开启，弹出提示
					Lang lang=new Lang();
					Command.browser.loadUrl(getExplainArray[1],lang.Integer_(getExplainArray[2], 200),lang.Integer_(getExplainArray[3], 200),lang.Integer_(getExplainArray[4], 200),lang.Integer_(getExplainArray[5], 200));
				}
			}
		}).start();
	}
	
	public static void init(){
		new action.Command_Register().init();		//初始化注册数据
		
		try {
			Command.activeDm=new ActiveXComponent("dm.dmsoft");		//创建大漠对象
			Command.activeDb_IE=null;
			Command.activeDb_IE =new ActiveXComponent("DBSoft.DBSoft_IE");	//创建大兵-浏览器相关对象
			
		} catch (Exception e) {
			new Func.File().log("创建对象失败！请重新启动");
			new Func.Message().showMessageDialog("创建对象失败！请重新启动<br/>请确认点击了【第一次使用，先注册到系统】");
		}
		try {
			Command.activeXinNuo=null;
			Command.activeXinNuo=new ActiveXComponent("XinNuo.SendData");		//创建信诺自动答题对象
		} catch (Exception e) {
			new Func.File().log("创建XinNuo.reply对象失败！若是没有购买自动答题过验证功能，此项不用在意");
			new Func.Message().showMessageDialog("创建自动答题对象失败！<br/>若是没有购买自动答题过验证功能，此项不用在意<br/><br/>请检查杀毒软件设置，将XinNuo.dll添加信任项<br/>然后重新点第一次使用，注册到系统");
		}
		
		//创建Com组件
		
		int thisFilePathI=0;
		while(thisFilePathI++<5){
			try { 
				Command.thisFilePath=Command.activeDm.invoke("GetDir",0).toString();	//获取当前文件所在的路径
				new Func.File().log("取得当前所在的路径"+Command.thisFilePath);
				
				//创建日志截图记录文件夹
				int createFolder=Command.activeDm.invoke("CreateFolder",Command.thisFilePath+"\\"+Command.screenNoteFile).getInt();
				new Func.File().log("创建截图日志记录文件夹-"+(createFolder==1? "成功":"失败"));
				
				thisFilePathI=100;	//退出循环
			} catch (Exception e) {
				new Func.File().log("获取当前文件所在的路径异常捕获："+e.getMessage());
			}
		}
		
		if(thisFilePathI<100){
			new Func.Message().showMessageDialog("初始化失败！请重启软件。<br/>若第一次使用，请先运行<br/>  【第一次使用，先注册到系统.bat】");
		}
		
		//UI列出打怪类型选择
		for (int i = 0; i < Command.daguaiModeArray.length; i++) {
			Command.JForm.daGuaiModeljComboBox.addItem(Command.daguaiModeArray[i]);
		}
		Command.JForm.daGuaiModeljComboBox.removeItemAt(0);
		Command.JForm.daGuaiModeljComboBox.setSelectedIndex(3);		//打开后默认是免费免注册模式
		
		Command.JForm.runEndjButton.setVisible(false);
		Command.JForm.setTitle(Command.title);
		Command.JForm.setIconImage(new include.Module.j2se.Interface().ico());
		Command.JframeSaoHuo.setTitle("寻仙自动扫货配置");
		Command.JframeSaoHuo.setIconImage(new include.Module.j2se.Interface().ico());
		Command.JframeSkill.setIconImage(new include.Module.j2se.Interface().ico());
		Command.JframeSeniorFight.setIconImage(new include.Module.j2se.Interface().ico());
		new Func.File().log("创建图标完毕");
	}
	
	
	/**
	 * 界面
	 */
	public static void lookAndFeel(){
		Command.useLookAndFeel=true;		//使用次外观，设置上
		try {
			//外观设置
			Command.JForm.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());
			
			JDialog.setDefaultLookAndFeelDecorated(true);
			Command.JForm.getRootPane().putClientProperty(SubstanceLookAndFeel.WATERMARK_IMAGE_OPACITY, true);
			SubstanceLookAndFeel.setSkin(new mySkin());
		} catch (Exception e) {
			//如果设置lookAndFeel外观失败，则还原为系统风格
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			new Func.File().log("设置界面外观异常捕获:"+e.getMessage());
		}
	}
	
	/**
	 * 打开软件后会打开的网址,我的广告
	 */
	public static void adInit(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					new Sleep().sleep(5000);
					new Func.Net().openIE("http://www.xnx3.com/xunxian/fuzhu/2012-10-15/6.html");
					new Func.File().log("打开软件介绍页面");
				} catch (Exception e) {
					new Func.File().log("打开软件介绍页面异常捕获:"+e.getMessage());
				}
			}
		}).start();
	}
	
	/**
	 * 软件开启完毕之后开启版本检测线程，检测是否需要更新
	 */
	public static void update(){
		new Thread(new Runnable() {
			public void run() {
				try {
					String getVersionSource=include.Module.Url_string.getHtml("http://www.xnx3.com/xunxian/fuzhu/autoFightUpdate.html", "utf-8");
					String getVersionArray[]=getVersionSource.split("\\|");
					
					if(getVersionArray[0].equals(Command.version)){
						new Func.File().log("版本检测完毕，当前为最新版本");
					}else{
						new Func.File().log("版发现最新版本！");
						if(new Func.Message().showConfirmDialog(getVersionArray[2])==ConfirmationCallback.YES){
							new Func.File().log("用户选择了下载更新，文件下载中……下载完毕将自动打开所在文件夹");
							String updateAllArray[]=getVersionArray[1].split("#");
							
							int allLength=updateAllArray.length;
							for(int i=0;i<allLength;i++){
								String updateArray[]=updateAllArray[i].split("@");
//								"F:\\MyEclipseWordspace\\xunxianAutoFight\\"
								String filePath=Command.thisFilePath+updateArray[2].replaceAll("thisPath", "");
								new include.Module.HttpDownloadFile().downAction(updateArray[0], updateArray[1], filePath);
								updateArray=null;
							}
							updateAllArray=null;
							
							new Func.File().log("文件下载完毕！已经放置于寻仙自动打怪文件夹根目录下，正在打开所在文件夹……");
							new Func.Net().openIE(Command.thisFilePath);
						}else{
							new Func.File().log("用户选择了不下载更新");
						}
					}
					getVersionArray=null;
					getVersionSource=null;
				} catch (Exception e) {
					new Func.File().log("检测版本是否需更新时异常捕获:"+e.getMessage());
					e.printStackTrace();
				}
			}
		}).start();
		
	}
	
	/**
	 * 自动扫货数据界面加载
	 */
	public static void initSaoHuoUI(){
		new Thread(new Runnable() {
			public void run() {
				File file= new action.File();
				file.saoHuoGroceriesLoad();
				file.saoHuoStoneLoad();
				file.saoHuoPetLoad();
				file.saoHuoFengWuZhiLoad();
				file.saoHuoLegendLoad();
				file.saoHuoElseClassLoad();
				
				Command.JframeSaoHuo.setSize(688, 380);
				new Func.File().log("自动扫货UI界面数据加载完毕");
				
			}
		}).start();
	}
	
}
class mySkin extends BusinessBlackSteelSkin{
	
	public mySkin(){
		super();
		try {
			//新建一个图片水印，路径可以自己该，使用自己喜欢的图片来做应用程序的水印图片、  
			SubstanceImageWatermark watermark = new SubstanceImageWatermark(Main.class.getResourceAsStream("include/Module/j2se/res/bg.png"));
			watermark.setOpacity(0.2f);
	        watermark.setKind(ImageWatermarkKind.APP_CENTER);
//	        new Func.File().log("创建水印背景完毕");
	        this.watermark=watermark;
		} catch (Exception e) {
//			new Func.File().log("初始化界面捕获异常:"+e.getMessage());
		}
	}
}
