package Func;

import javax.swing.JOptionPane;

import action.UIFunc;


public class Test {
	Com com=null;
	public Test() {
		this.com=new Com();
		this.com.createDm();
	}
	
	public void test(){
//		System.out.println("Command->"+Command.activeDm.invoke("Ver"));
		
	}
	
	public static void main(String[] args) {
		Object[] options = {"在线购买","联系客服购买","取消"};
		int response=JOptionPane.showOptionDialog(null, "这是个选项对话框，用户可以选择自己的按钮的个数", "选项对话框标题",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		System.out.println(response);
	}
}
