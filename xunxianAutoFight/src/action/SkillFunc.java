package action;

import Func.Mouse;
import Func.Press;
import Func.Sleep;

import com.jacob.activeX.ActiveXComponent;

import include.Command;

public class SkillFunc {
	private ActiveXComponent activeDm=null;
	private Press press=null; 
	private Sleep sleep=null;
	private Mouse mouse=null;
	
	public SkillFunc(ActiveXComponent activeDm) {
		this.activeDm=activeDm;
		this.press=new Press(this.activeDm);
		this.sleep=new Sleep();
		this.mouse=new Mouse(this.activeDm);
	}
	
	public void action(){
		int i=0;
		while(Command.run){
			for(i=0;i<5&&Command.run;i++){
				switch (Command.skillJcomboboxUse[i]) {
				case 0:
					//不启用
					break;
				case 1:		//键盘模拟
					this.press.keyPress(Command.skillSetData[i][0]);
					this.sleep.sleep(Command.skillTime[i]);
					break;
				case 2:		//鼠标左键单击
					this.mouse.mouseClick(Command.skillSetData[i][0], Command.skillSetData[i][1], true);
					this.sleep.sleep(Command.skillTime[i]);
					break;
				case 3:		//鼠标右键单击
					this.mouse.mouseClick(Command.skillSetData[i][0], Command.skillSetData[i][1], false);
					this.sleep.sleep(Command.skillTime[i]);
					break;
				case 4:		//鼠标左键双击
					break;
				case 5:		//鼠标右键双击,未加
					break;
				default:
					break;
				}
				
			}
		}
	}
}
