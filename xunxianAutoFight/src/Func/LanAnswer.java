package Func;

import org.omg.IOP.ServiceIdHelper;

import include.Command;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;

public class LanAnswer {
	private ActiveXComponent activeDm=null;
	
	public LanAnswer(ActiveXComponent active) {
		this.activeDm=active;
	}
	
	/**
	 * 截取这个范围内,3秒动画,图像质量为中等50,动画帧率间隔为100ms
	 * faqCapture(0,2,72,12,50,100,3000)
	 * 
	 * @param xStart 左上角X坐标
	 * @param yStart 左上角Y坐标
	 * @param xEnd 右下角X坐标
	 * @param yEnd 右下角Y坐标
	 * @param quality 图像或动画品质,或者叫压缩率,此值越大图像质量越好 取值范围（1-100）
	 * @param delay 截取动画时用,表示相隔两帧间的时间间隔,单位毫秒 （如果只是截取静态图像,这个参数必须是0）
	 * @param time 表示总共截取多久的动画,单位毫秒 （如果只是截取静态图像,这个参数必须是0）
	 * 
	 * @return 整数型，图像或者动画句柄,0为失败 
	 */
	public int faqCapture(int xStart, int yStart, int xEnd, int yEnd, int quality, int delay, int time){
		int xnx3_result = 0;

		try {
			Variant[] var=new Variant[7];
			var[0]=new Variant(xStart);
			var[1]=new Variant(yStart);
			var[2]=new Variant(xEnd);
			var[3]=new Variant(yEnd);
			var[4]=new Variant(quality);
			var[5]=new Variant(delay);
			var[6]=new Variant(time);
			
			xnx3_result=activeDm.invoke("FaqCapture",var).getInt();
			var=null;

		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("局域网答题faqCapture异常捕获:"+e.getMessage());
		}
		
		return xnx3_result;
	}
	
	/**
	 * 同上，发送指定区域的静态图
	 */
	public int faqCapture(int xStart, int yStart, int xEnd, int yEnd){
		return faqCapture(xStart, yStart, xEnd, yEnd, 100, 0, 0);
	}
	
	/**
	 * 发送指定的图像句柄到指定的服务器,并等待返回结果(同步等待)
	 * @param server 字符串: 服务器地址以及端口,格式为(ip:port),例如 "192.168.1.100:12345" 多个地址可以用"|"符号连接。比
	 * @param handle 由FaqCapture获取到的句柄
	 * @param request_type 整形数: 取值定义如下 <li>0 : 要求获取坐标<li>1 : 要求获取选项,比如(ABCDE)<li>2 : 要求获取文字答案
	 * @param time_out 整形数: 表示等待多久,单位是毫秒
	 * @return String 包含"Error"为失败，否则返回结果  OK:答案<li>当request_type 为0时,答案的格式为"x,y" (不包含引号)<li>当request_type 为1时,答案的格式为"1" "2" "3" "4" "5" "6" (不包含引号)<li>当request_type 为2时,答案就是要求的答案 比如 "李白" (不包含引号)
	 */
	public String faqSend(String server, long handle, int request_type, int time_out){
		String xnx3_result="Error";
		try {
			Variant[] var=new Variant[4];
			var[0]=new Variant(server);
			var[1]=new Variant(handle);
			var[2]=new Variant(request_type);
			var[3]=new Variant(time_out);
			
			xnx3_result=activeDm.invoke("FaqSend",var).getString();
			var=null;

		} catch (Exception e) {
			new Func.File().log("局域网答题faqSend异常捕获:"+e.getMessage());
		}
		
		return xnx3_result;
	}
	
	/**
	 * 同faqSend，只不过serverIp只是IP，端口固定了，多个IP用|分割
	 */
	public String faqSend(String serverIp,long handle){
		String server="";
		
		//将多个IP分割，加入端口号拼接
		String[] serverArray=serverIp.split("\\|");
		for (String string : serverArray) {
			if(server.equals("")){
				server=string+":"+Command.faqSendPort;
			}else{
				server=server+"|"+string+":"+Command.faqSendPort;
			}
		}
		serverArray=null;
		
		return faqSend(server, handle, 2, 40000);
	} 
}
