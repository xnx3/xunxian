package include.Module;
import java.util.Date;  
import java.util.Properties;  
//import javax.servlet.*; //此句报错误的话请注释
import javax.mail.Session;  
import javax.mail.Authenticator;  
import javax.mail.PasswordAuthentication;  
import javax.mail.internet.MimeMessage;  
import javax.mail.internet.InternetAddress;  
import javax.mail.Transport;  

import Func.File;
/**
 * 依赖mail.jar
 * @author xnx3.com
 *
 */
public class SendMail {  
	private Properties properties;  
	private Session mailSession;  
	private MimeMessage mailMessage;  
	private Transport trans;  
	public SendMail() {  
		
	}  

	/**
	 * 
	 * @param targetMail  发送至的账号
	 * @param title  发送的标题
	 * @param content  发送的内容
	 */
	public void sendMail(String targetMail,String title,String content) {  
	  try {  
	  properties = new Properties();  
	  //设置邮件服务器  
	  properties.put("mail.smtp.host", "smtp.163.com");  
	  //验证  
	  properties.put("mail.smtp.auth", "true");  
	  //根据属性新建一个邮件会话  
	  mailSession = Session.getInstance(properties,  
	  new Authenticator() {  
	  public PasswordAuthentication getPasswordAuthentication() {  
	  return new PasswordAuthentication("xnx3_cs@163.com",  
	  "cccccc");  
	  }  
	  });  
	  mailSession.setDebug(true);  
	  //建立消息对象  
	  mailMessage = new MimeMessage(mailSession);  
	  //发件人  
	  mailMessage.setFrom(new InternetAddress("xnx3_cs@163.com"));  
	  //收件人  
	  mailMessage.setRecipient(MimeMessage.RecipientType.TO,  
	  new InternetAddress(targetMail));  
	  //主题  
	  mailMessage.setSubject(title);  
	  //内容  
	  mailMessage.setText(content);  
	  //发信时间  
	  mailMessage.setSentDate(new Date());  
	  //存储信息  
	  mailMessage.saveChanges();  
	  //  
	  trans = mailSession.getTransport("smtp");  
	  //发送  
	  trans.send(mailMessage);  
	  } catch (Exception e) {  
		  new File().log("邮件发送失败异常捕获:"+e.getMessage());
	  e.printStackTrace();  
	  } finally {  
	  }  
	  }  
	
	/**
	  * @param args
	  */
	public static void main(String[] args) {
	  // TODO Auto-generated method stub
	  new SendMail().sendMail("mail@xnx3.com","我是标题","我是内容");
	}
}