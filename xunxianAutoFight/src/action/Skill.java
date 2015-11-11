package action;

import Func.Lang;
import include.Command;

public class Skill {
	
	public Skill() {
		
	}
	
	public void setVisible(){
		Command.JframeSkill.setVisible(true);
		jComboBox1UseItemStateChanged();
		jComboBox2UseItemStateChanged();
		jComboBox3UseItemStateChanged();
		jComboBox4UseItemStateChanged();
		jComboBox5UseItemStateChanged();
	}
	
	/**
	 * 初始化数据，将界面的数据加载至Command
	 */
	public void initData(){
		Lang lang=new Lang();
		Command.skillJcomboboxUse[0]=Command.JframeSkill.jComboBox1Use.getSelectedIndex();
		Command.skillJcomboboxUse[1]=Command.JframeSkill.jComboBox2Use.getSelectedIndex();
		Command.skillJcomboboxUse[2]=Command.JframeSkill.jComboBox3Use.getSelectedIndex();
		Command.skillJcomboboxUse[3]=Command.JframeSkill.jComboBox4Use.getSelectedIndex();
		Command.skillJcomboboxUse[4]=Command.JframeSkill.jComboBox5Use.getSelectedIndex();
		
		//具体的数据在设置界面或者从config文件载入时已经加载至commond故不用再次加载
		Command.skillTime[0]=lang.Integer_(Command.JframeSkill.jTextField1Time.getText(), 100);
		Command.skillTime[1]=lang.Integer_(Command.JframeSkill.jTextField2Time.getText(), 100);
		Command.skillTime[2]=lang.Integer_(Command.JframeSkill.jTextField3Time.getText(), 100);
		Command.skillTime[3]=lang.Integer_(Command.JframeSkill.jTextField4Time.getText(), 100);
		Command.skillTime[4]=lang.Integer_(Command.JframeSkill.jTextField5Time.getText(), 100);
		
		lang=null;
	}
	
	public void setCursorAction(int num){
		Command.skillSetData[num]=new action.UIFunc().getBackstageCursorPlace();
		switch (num) {
		case 0:
			Command.JframeSkill.jTextField1Key.setText(Command.skillSetData[num][0]+"|"+Command.skillSetData[num][1]);
			break;
		case 1:
			Command.JframeSkill.jTextField2Key.setText(Command.skillSetData[num][0]+"|"+Command.skillSetData[num][1]);
			break;
		case 2:
			Command.JframeSkill.jTextField3Key.setText(Command.skillSetData[num][0]+"|"+Command.skillSetData[num][1]);
			break;
		case 3:
			Command.JframeSkill.jTextField4Key.setText(Command.skillSetData[num][0]+"|"+Command.skillSetData[num][1]);
			break;
		case 4:
			Command.JframeSkill.jTextField5Key.setText(Command.skillSetData[num][0]+"|"+Command.skillSetData[num][1]);
			break;
		default:
			break;
		}
	}

	
	public void jComboBox1UseItemStateChanged(){
		switch (Command.JframeSkill.jComboBox1Use.getSelectedIndex()) {
		case 0: //不启用
			Command.JframeSkill.jTextField1Key.setEnabled(false);
			Command.JframeSkill.jButtonCursorSet1.setVisible(false);
			break;
		case 1: //键盘模拟
			Command.JframeSkill.jTextField1Key.setEnabled(true);
			Command.JframeSkill.jButtonCursorSet1.setVisible(false);
			break;
		default:
			Command.JframeSkill.jTextField1Key.setEnabled(false);
			Command.JframeSkill.jButtonCursorSet1.setVisible(true);
			break;
		}
	}
	public void jComboBox2UseItemStateChanged(){
		switch (Command.JframeSkill.jComboBox2Use.getSelectedIndex()) {
		case 0: //不启用
			Command.JframeSkill.jTextField2Key.setEnabled(false);
			Command.JframeSkill.jButtonCursorSet2.setVisible(false);
			break;
		case 1: //键盘模拟
			Command.JframeSkill.jTextField2Key.setEnabled(true);
			Command.JframeSkill.jButtonCursorSet2.setVisible(false);
			break;
		default:
			Command.JframeSkill.jTextField2Key.setEnabled(false);
			Command.JframeSkill.jButtonCursorSet2.setVisible(true);
			break;
		}
	}
	public void jComboBox3UseItemStateChanged(){
		switch (Command.JframeSkill.jComboBox3Use.getSelectedIndex()) {
		case 0: //不启用
			Command.JframeSkill.jTextField3Key.setEnabled(false);
			Command.JframeSkill.jButtonCursorSet3.setVisible(false);
			break;
		case 1: //键盘模拟
			Command.JframeSkill.jTextField3Key.setEnabled(true);
			Command.JframeSkill.jButtonCursorSet3.setVisible(false);
			break;
		default:
			Command.JframeSkill.jTextField3Key.setEnabled(false);
			Command.JframeSkill.jButtonCursorSet3.setVisible(true);
			break;
		}
	}
	public void jComboBox4UseItemStateChanged(){
		switch (Command.JframeSkill.jComboBox4Use.getSelectedIndex()) {
		case 0: //不启用
			Command.JframeSkill.jTextField4Key.setEnabled(false);
			Command.JframeSkill.jButtonCursorSet4.setVisible(false);
			break;
		case 1: //键盘模拟
			Command.JframeSkill.jTextField4Key.setEnabled(true);
			Command.JframeSkill.jButtonCursorSet4.setVisible(false);
			break;
		default:
			Command.JframeSkill.jTextField4Key.setEnabled(false);
			Command.JframeSkill.jButtonCursorSet4.setVisible(true);
			break;
		}
	}
	public void jComboBox5UseItemStateChanged(){
		switch (Command.JframeSkill.jComboBox5Use.getSelectedIndex()) {
		case 0: //不启用
			Command.JframeSkill.jTextField5Key.setEnabled(false);
			Command.JframeSkill.jButtonCursorSet5.setVisible(false);
			break;
		case 1: //键盘模拟
			Command.JframeSkill.jTextField5Key.setEnabled(true);
			Command.JframeSkill.jButtonCursorSet5.setVisible(false);
			break;
		default:
			Command.JframeSkill.jTextField5Key.setEnabled(false);
			Command.JframeSkill.jButtonCursorSet5.setVisible(true);
			break;
		}
	}
	
}
