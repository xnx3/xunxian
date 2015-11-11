package action;
import java.awt.event.MouseEvent;

import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import com.jacob.com.Variant;
import Func.Com;
import Func.Message;
import Func.Mouse;
import Func.Press;
import Func.Sleep;
import Func.Window;
import include.Command;

public class UIFunc {
	
	/**
	 * 提示框，可用户鼠标跟随提示、软件加载loading提示等
	 * @param startX jframe开始出位于屏幕的坐标
	 * @param startY
	 * @param width jframe的宽度
	 * @param height
	 * @param content 传入html格式字符串
	 */
	public void showMessage(int startX,int startY,int width,int height,String content){
		if(!Command.useLookAndFeel){	//如果使用的不是LookAndFeel外观，则height+30，避免金属外观显示不全
			height=height+30;
		}
		Command.jframeMessage.setBounds(startX, startY, width, height);	//height+30，避免金属版简化模式显示不全
		Command.jframeMessage.messagejLabel.setText("<html><div style=\"padding:10px;\">"+content+"</div>");
		
		Command.jframeMessage.setVisible(true);
	}
	public void showMessageLoad(){
		showMessage(Command.JForm.getX()+200, Command.JForm.getY()+100, 250, 100, "<div style=\"text-align:center; font-size:18px; padding-left:35px;\">请稍后……</div>");
	}
	public void hiddenMessage(){
		Command.jframeMessage.setVisible(false);
	}
	
	
	/**
	 * 设置选项卡提示文字
	 * @param content
	 */
	public void setExplainLabel(String content) {
		Command.JForm.explainjLabel.setText("<html>"+content);	//<html>自动换行
	}
	
	/**
	 * 更新我的信息选项卡我的当前信息的文字
	 * @param content
	 */
	public void loadMyInfoLabel() {
		Command.JForm.myInfojLabel.setText("<html>当前注册状态："+(Command.register.get("use").equals("1")? "已":"未")+"注册" +(Command.register.get("use").equals("1")? "<br/>当前绑定电脑："+(Command.bindComputer? "已绑定":"未绑定<br/>当前已用次数："+Command.softUseCount+"次<br/>剩余使用次数："+Command.softSetCount+"次"):"")+
				"<br/>当前自动答题："+(Command.autoDaTi? "已开启<br/>当前答题余额："+Command.autoDaTiRemain:"未开启")+
				"<br/>水底自动开鼓：\t"+(Command.autoKaiGu? "":"不")+"可用<br/>自动打怪功能：\t"+(Command.useDaguai? "":"不")+"可用<br/>自动扫货功能："+(Command.useSaoHuo? "":"不")+"可用<br/>  捉  宝  宝：可用<br/>邮件实时提醒："+(Command.emailRemind? "":"不")+"可用");	//<html>自动换行
	}
	
	
	/**
	 * 打怪类型发生改变_UI交互
	 */
	public void daguaiModelIsChange_UI(){
		int modeIndex=Command.JForm.daGuaiModeljComboBox.getSelectedIndex();
		Command.JForm.daGuaiMapjComboBox.removeAllItems();
		for (int i = 0; i < Command.daguaiMapArray[modeIndex].length; i++) {
			Command.JForm.daGuaiMapjComboBox.addItem(Command.daguaiMapArray[modeIndex][i]);
		}
		
		Command.JForm.setParamjButton.setVisible(false);		//初始化参数设置按钮为隐藏
		
		switch (Command.JForm.daGuaiModeljComboBox.getSelectedIndex()) {
		case 0:
			new UIFunc().setExplainLabel("水底自动刷钱宁河叛军+开小鼓刷15绝");
			break;
		case 1:
			new UIFunc().setExplainLabel("水底不打怪，只来回找小鼓，开小鼓刷15绝");
			break;
		case 2:		//普通打怪模式
			new UIFunc().setExplainLabel("用户可选择购买自动过验证<br/>全自动智能答题!<br/>未购买自动答题的出验证码需要人工手动输入");
			Command.JForm.setParamjButton.setVisible(true);
			break;
		case 3:		//捉宝宝
			new UIFunc().setExplainLabel("后台打符防掉线！软件操作跟打怪配置相同<br/>123键放符，锁定目标怪后开启将自动打符");
			break;
		case 4:
			new UIFunc().setExplainLabel("交易全自动扫货！<br/>要有足够的包裹空间");
			Command.JForm.setParamjButton.setVisible(true);
			Command.JForm.setParamjButton.setText("参数设定");
			break;
		case 5:
			new UIFunc().setExplainLabel("后台自动模拟按键，防掉线!");
			Command.JForm.setParamjButton.setVisible(true);
			Command.JForm.setParamjButton.setText("参数设定");
			break;
		case 6:
			new UIFunc().setExplainLabel("定点开鼓，请先将号设置好放到出鼓的地点，被恶意刷死亡后就不能正常使用了。使用此前提需要保证自己号不要死<br/> (试用)");
			break;
		case 7:	//高级打怪模式
			new UIFunc().setExplainLabel("比普通打怪增加了自动回门派修理装备、<br/>自动治疗、工作室局域网答题等功能");
			Command.JForm.setParamjButton.setVisible(true);
			Command.JForm.setParamjButton.setText("参数设定");
			break;
		default:
			break;
		}
	}
	
	/**
	 * 打怪具体子选项选择改变，交互
	 */
	public void daguaiItemIsChange_UI(){
		if(Command.JForm.daGuaiModeljComboBox.getSelectedIndex()==2){	//普通打怪模式
			if(Command.JForm.daGuaiMapjComboBox.getSelectedIndex()==0){	//用户自定义打怪点
				Command.JForm.setParamjButton.setVisible(true);
				if(Command.routeMapXArray[12][0]>0){	//有数值，已经设置
					Command.JForm.setParamjButton.setText("已设定挂机点");
				}else{
					Command.JForm.setParamjButton.setText("请设定挂机点");
				}
			}else{	//使用内置的挂机地图
				Command.JForm.setParamjButton.setVisible(false);
			}
		}
	}
	
	/**
	 * 主界面延迟项选择
	 */
	public void delayItemIsChange_UI(){
		switch (Command.JForm.delayjComboBox.getSelectedIndex()) {
		case 0:
			Command.delay=200;
			break;
		case 1:
			Command.delay=500;
			break;
		case 2:
			Command.delay=1000;
			break;
		case 3:
			Command.delay=2000;
			break;
		case 4:
			Command.delay=3000;
			break;
		default:
			break;
		}
	}
	
	/**
	 * 点击按钮后设置自定义挂机点
	 */
	public void setCustomDaGuaiPlace(){
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				//改变窗口大小
				int setClientSize=Command.activeDm.invoke("SetClientSize", new Variant(Command.hwnd),new Variant(Command.clientWidth),new Variant(Command.clientHeight)).getInt();
				
				Com com=new Com();
				com.createDb_MouseKeyCom();
				com.createDmCom();
				com.createDb_WindowCom();
				Sleep sleep=new Func.Sleep();
				Mouse mouse=new Mouse(com.activeDb_MouseKey,com.activeDm);
				Window window=new Func.Window(com.activeDm,com.activeDb_Window);
				Press press=new Func.Press(com.activeDm);
				Message message=new Func.Message();
				
				window.MoveWindow(Command.hwnd, 0, 10);
				window.setWindowState(Command.hwnd, 1);
				sleep.sleep(500);
				for (int i = 5; i > 0; i--) {
					new UIFunc().showMessage(200, 50, 650, 50, "<div style=\"font-size:18px; text-align:center; color:yellow;\">请将鼠标放到要挂机的点,倒计时剩余时间："+i+"秒</div>");
					sleep.sleep(1000);
				}
				new UIFunc().showMessage(200, 50, 650, 50, "<div style=\"font-size:18px; text-align:center; color:yellow;\">正在获取……请稍后</div>");
				try {
					int position[]=mouse.getMousePosition();

					sleep.sleep(1000);
					int dian[]=window.windowPosition(Command.hwnd, position[0], position[1], 2);
					System.out.println("屏幕坐标"+position[0]+"|"+position[1]+"|设定挂机点:"+dian[0]+"|"+dian[1]);
					if(dian[1]==-1){	//没有找到
						new Func.Message().showMessageDialog("设定挂机点坐标失败！<br/>请按照视频说明来操作！");
					}else{
						//成功
						//继而判断设定的挂机点范围，是否在窗口范围内
						if(dian[0]>0&&dian[0]<1024&&dian[1]>0&&dian[1]<768){
							Command.routeMapXArray[12][0]=dian[0];
							Command.routeMapXArray[12][1]=dian[0]+3;
							Command.routeMapYArray[12][0]=dian[1];
							Command.routeMapYArray[12][1]=dian[1]+3;
							Command.JForm.setParamjButton.setText("已设定挂机点");
							new UIFunc().showMessage(200, 50, 650, 60, "<div style=\"font-size:18px; text-align:center; color:blue;\">设置完毕！</div>");
						}else{		//不在范围内，没有正确操作
							new UIFunc().showMessage(200, 50, 650, 60, "<div style=\"font-size:18px; text-align:center; color:red;\">设置失败！操作不正确</div>");
						}
					}
				} catch (Exception e) {
					message.showMessageDialog("设置失败！<br/>错误代码:"+e.getMessage());
					e.printStackTrace();
				}
				
				
				com.release();
				
				sleep.sleep(1000);
				hiddenMessage();
			}
		}).start();
	}
	
	/**
	 * test_button
	 */
	public void test(){
//		System.out.println("test");
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				Com com=new Com();
//				com.createDm();
//				
//				DaGuaiFunc daguaiFunc=new DaGuaiFunc(com.activeDm);
//				daguaiFunc.kaiGuAction();
//				
//				com.releaseDm();
//				System.out.println("release");
//				
//			}
//		}).start();
	}
	
	/**
	 * 点击按钮后设置自定义挂机点
	 */
	public int[] getBackstageCursorPlace(){
		int[] result={0,0};
		if(Command.hwnd==0){
			new Message().showMessageDialog("请先获取目标窗口！");
			return result;
		}

		Com com=new Com();
		com.createDb_MouseKeyCom();
		com.createDmCom();
		com.createDb_WindowCom();
		Sleep sleep=new Func.Sleep();
		Mouse mouse=new Mouse(com.activeDb_MouseKey,com.activeDm);
		Window window=new Func.Window(com.activeDm,com.activeDb_Window);
		Message message=new Func.Message();
		
//		window.MoveWindow(Command.hwnd, 0, 10);
		window.setWindowState(Command.hwnd, 1);
		sleep.sleep(500);
		for (int i = 3; i > 0; i--) {
			new UIFunc().showMessage(200, 50, 650, 50, "<div style=\"font-size:18px; text-align:center; color:yellow; background-color:black;\">请将鼠标放到要挂机的点,倒计时剩余时间："+i+"秒</div>");
			sleep.sleep(1000);
		}
		new UIFunc().showMessage(200, 50, 650, 50, "<div style=\"font-size:18px; text-align:center; color:yellow;\">正在获取……请稍后</div>");
		try {
			int position[]=mouse.getMousePosition();

			sleep.sleep(1000);
			int dian[]=window.windowPosition(Command.hwnd, position[0], position[1], 2);
			System.out.println("屏幕坐标"+position[0]+"|"+position[1]+"|设定挂机点:"+dian[0]+"|"+dian[1]);
			if(dian[1]==-1){	//没有找到
				new Func.Message().showMessageDialog("设定坐标失败！<br/>请按照视频说明来操作！");
			}else{
				//成功
				//继而判断设定的挂机点范围，是否在窗口范围内
				if(dian[0]>0&&dian[0]<1024&&dian[1]>0&&dian[1]<768){
					result=dian;
					new Func.Message().showMessageDialog("设置完毕！");
				}else{		//不在范围内，没有正确操作
					new UIFunc().showMessage(200, 50, 650, 60, "<div style=\"font-size:18px; text-align:center; color:red;\">设置失败！操作不正确</div>");
				}
			}
		} catch (Exception e) {
			message.showMessageDialog("设置失败！<br/>错误代码:"+e.getMessage());
			e.printStackTrace();
		}
		com.release();
		hiddenMessage();
		return result;
	}
	
	/**
	 * 鼠标放上提示-skill.form的按键模拟设置
	 */
	public void skillKeyMessage(MouseEvent evt,boolean use){
		if(use){
			showMessage(evt.getXOnScreen()+20, evt.getYOnScreen()+20, 250, 70, "鼠标放于输入框内，按下要模拟的按键便可设置完毕");
		}
	}
	
	/**
	 * Skill.form的设置鼠标点的提示信息
	 */
	public void skillCursorMessage(MouseEvent evt){
		showMessage(evt.getXOnScreen()+20, evt.getYOnScreen()+20, 450, 70, "点击设置后将鼠标放至要后台操作的窗口上要点击的点，等待2秒会自动记下此点。");
	}
	
	/**
	 * 扫货的搜索物品
	 */
	public void saoHuoSearch(){
		String searchString=Command.JframeSaoHuo.jTextFieldSearch.getText();
		if(searchString.length()<1){
			new Func.Message().showMessageDialog("搜索物品最少为1个字符！");
			return;
		}
		
		//八卦灵石类扫描
		TableModel stoneModel = (TableModel) Command.JframeSaoHuo.stonejTable.getModel();
		for (int row = stoneModel.getRowCount() - 1; row >= 0; row--) {
			if(stoneModel.getValueAt(row, 0).toString().indexOf(searchString)>-1){
				ListSelectionModel model = Command.JframeSaoHuo.stonejTable.getSelectionModel();
				model.setSelectionInterval(row, 0);
				Command.JframeSaoHuo.jTabbedPane.setSelectedIndex(1);
				return;
			}
		}
		stoneModel=null;
		
		//宠物壳子扫描
		TableModel petModel = (TableModel) Command.JframeSaoHuo.petjTable.getModel();
		for (int row = petModel.getRowCount() - 1; row >= 0; row--) {
			if(petModel.getValueAt(row, 0).toString().indexOf(searchString)>-1){
				ListSelectionModel model = Command.JframeSaoHuo.petjTable.getSelectionModel();
				model.setSelectionInterval(row, 0);
				Command.JframeSaoHuo.jTabbedPane.setSelectedIndex(2);
				return;
			}
		}
		petModel=null;
		
		//风物志
		TableModel fengWuZhiModel = (TableModel) Command.JframeSaoHuo.fengWuZhijTable.getModel();
		for (int row = fengWuZhiModel.getRowCount() - 1; row >= 0; row--) {
			if(fengWuZhiModel.getValueAt(row, 0).toString().indexOf(searchString)>-1){
				ListSelectionModel model = Command.JframeSaoHuo.fengWuZhijTable.getSelectionModel();
				model.setSelectionInterval(row, 0);
				Command.JframeSaoHuo.jTabbedPane.setSelectedIndex(3);
				return;
			}
		}
		fengWuZhiModel=null;
		
		//传奇图纸
		TableModel legendModel = (TableModel) Command.JframeSaoHuo.legendjTable.getModel();
		for (int row = legendModel.getRowCount() - 1; row >= 0; row--) {
			if(legendModel.getValueAt(row, 0).toString().indexOf(searchString)>-1){
				ListSelectionModel model = Command.JframeSaoHuo.legendjTable.getSelectionModel();
				model.setSelectionInterval(row, 0);
				Command.JframeSaoHuo.jTabbedPane.setSelectedIndex(4);
				return;
			}
		}
		legendModel=null;
		
		//杂货类扫描
		TableModel groceriesModel = (TableModel) Command.JframeSaoHuo.groceriesjTable.getModel();
		for (int row = groceriesModel.getRowCount() - 1; row >= 0; row--) {
			if(groceriesModel.getValueAt(row, 0).toString().indexOf(searchString)>-1){
				//找到了
				ListSelectionModel model = Command.JframeSaoHuo.groceriesjTable.getSelectionModel();
				model.setSelectionInterval(row, 0);
				Command.JframeSaoHuo.jTabbedPane.setSelectedIndex(5);
				return;
			}
		}
		groceriesModel=null;
		
		//其他分类
		TableModel elseClassModel = (TableModel) Command.JframeSaoHuo.elseClassjTable.getModel();
		for (int row = elseClassModel.getRowCount() - 1; row >= 0; row--) {
			if(elseClassModel.getValueAt(row, 0).toString().indexOf(searchString)>-1){
				ListSelectionModel model = Command.JframeSaoHuo.elseClassjTable.getSelectionModel();
				model.setSelectionInterval(row, 0);
				Command.JframeSaoHuo.jTabbedPane.setSelectedIndex(6);
				return;
			}
		}
		elseClassModel=null;
		
		new Func.Message().showMessageDialog("没有搜索到该物品！");
	}
	
	/**
	 * SeniorFight.form是否开启修理功能
	 */
	public void autoXiuLiItemStateChanged(){
		if(Command.JframeSeniorFight.jCheckBoxAutoXiuLi.isSelected()){
			Command.JframeSeniorFight.jPanelUseRepair.setVisible(true);
		}else{
			Command.JframeSeniorFight.jPanelUseRepair.setVisible(false);
		}
	}
	public void jPanelLanAnswer(){
		if(Command.JframeSeniorFight.jCheckBoxUseLanAnswer.isSelected()){
			Command.JframeSeniorFight.jPanelLanAnswer.setVisible(true);
		}else{
			Command.JframeSeniorFight.jPanelLanAnswer.setVisible(false);
		}
	}
}
