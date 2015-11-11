package Func;

import include.Command;

/**
 * 发送邮件
 * @author Administrator
 *
 */
public class SendMail {
	
	/**
	 * 发送到指定账号，无限制
	 * @param targetMail  发送至的账号
	 * @param title  发送的标题
	 * @param content  发送的内容
	 */
	public void send(String targetMail,String title,String content){
		new include.Module.SendMail().sendMail(targetMail, title, content);
	}
	
	/**
	 * 发送邮件，只限有权限使用的会员
	 */
	public void send(String title,String content){
		if(Command.emailRemind){		//有接受邮件权限
			send(Command.myEmail, title+"-"+Command.roleName+"-寻仙自动打怪"+Command.version, content+"-"+Command.roleName+"-技术支持：寻仙网www.xnx3.com");
		}
	}
	
}
