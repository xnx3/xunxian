package Func;

import include.Command;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;

public class Position {
	private ActiveXComponent activeDm=null;
	public Position(ActiveXComponent active) {
		this.activeDm=active;
	}
	
	/**
	 * 获取小地图x坐标
	 * @return 失败则返回0
	 */
	public int getMapPositionX(){
		int result=0;
		try{
			activeDm.invoke("UseDict",1).getInt();
			
			Variant[] var=new Variant[6];
			var[0]=new Variant(Command.mapXPositionXStart);
			var[1]=new Variant(Command.mapXPositionYStart);
			var[2]=new Variant(Command.mapXPositionXEnd);
			var[3]=new Variant(Command.mapXPositionYEnd);
			var[4]=new Variant(Command.mapPositionColor);
			var[5]=new Variant(Command.mapPositionSim);
			String returnNum=activeDm.invoke("Ocr",var).getString();
			result=Integer.parseInt(returnNum);
			var=null;
			returnNum=null;
		}catch (Exception e) {
			new Func.File().log("获取小地图X坐标异常捕获:"+e.getMessage());
		}
		return result;
	}
	
	/**
	 * 获取小地图y坐标
	 * @return 失败返回0
	 */
	public int getMapPositionY(){
		int result=0;
		try{
			activeDm.invoke("UseDict",1).getInt();
			Variant[] var=new Variant[6];
			var[0]=new Variant(Command.mapYPositionXStart);
			var[1]=new Variant(Command.mapYPositionYStart);
			var[2]=new Variant(Command.mapYPositionXEnd);
			var[3]=new Variant(Command.mapYPositionYEnd);
			var[4]=new Variant(Command.mapPositionColor);
			var[5]=new Variant(Command.mapPositionSim);
			String returnNum=activeDm.invoke("Ocr",var).getString();
			result=Integer.parseInt(returnNum);
			var=null;
			returnNum=null;
		}catch (Exception e) {
			new Func.File().log("获取小地图Y坐标异常捕获:"+e.getMessage());
		}
		
		return result;
	}
	
	
	/**
	 * 调整小地图方向，面向北
	 */
	public void mapArrowsInit(){
		int numMax=300;	//设置最大次数为300次
		
		Mouse mouse=new Mouse(activeDm);
		Press press=new Press(activeDm);
		Sleep sleep=new Sleep();
		File file=new File(activeDm);
		Invoke invoke=new Invoke(activeDm);
		FindPic findPic=new FindPic(activeDm);
		Color color=new Func.Color(this.activeDm);
		
		//首先走动一下，避免出现暂离
		press.keyPress(87);		//W
		
		sleep.sleep(500);
		press.keyPress(65);		//A
		sleep.sleep(3000);
		
		//M 开地图，取消之前的寻路
		press.keyPress(77);	
		sleep.sleep(500);
		mouse.mouseClick(748,569, true);
		sleep.sleep(200);
		press.keyPress(77);
		
		file.log("等待8秒，等待小地图闪烁取消");
		sleep.sleep(8000);
		
		file.log("进行方向偏移调整");
		
//		int dian1X=920;
//		int dianY=106;
//		int dian2X=940;
//		//提取小地图扇形弧度范围内上方的2个点的坐标颜色
//		String dian1Color1=null;	//其中一中颜色
//		String dian2Color1=null;
//		String dian1Color2=null;	
//		String dian2Color2=null;
//		int dian1Color1Num=0;		//出现的次数
//		int dian1Color2Num=0;
//		int dian2Color1Num=0;
//		int dian2Color2Num=0;
//		
//		String param="222222";		//误差模糊匹配
//		
//		//错误匹配记录,超过5此进行邮件提醒。理论上应该不存在
//		int dian1Error=0;
//		int dian2Error=0;
//		
//		//找图，直到找到图或者到达找图的次数为止
//		int i=0;
//		while(i++<numMax){
//			String getColor1=color.getColor(dian1X,dianY);	//点1
//			String getColor2=color.getColor(dian2X,dianY);	//点2
//			System.out.println("捕获两点颜色:点1："+getColor1+"|点2："+getColor2);
//			//首先对这两个点赋值
//			if(dian1Color1==null||dian1Color2==null){
//				if(dian1Color1==null){
//					dian1Color1=getColor1;
//				}else if (color.compareColor(dian1Color1, getColor1, param)) {
//					dian1Color1Num++;
//				}else if (dian1Color2==null) {
//					dian1Color2=getColor1;
//				}
//			}
//			if(dian2Color1==null||dian2Color2==null){
//				if(dian2Color1==null){
//					dian2Color1=getColor2;
//				}else if (color.compareColor(dian2Color1, getColor2, param)) {
//					dian2Color1Num++;
//				}else if (dian2Color2==null) {
//					dian2Color2=getColor2;
//				}
//			}
//			//两个点赋值结束
//			
//			if(color.compareColor(dian1Color1, getColor1, param)){
//				dian1Color1Num++;
//			}else if (color.compareColor(dian1Color2, getColor1, param)) {
//				dian1Color2Num++;
//			}else{
//				dian1Error++;
//			}
//			
//			if(color.compareColor(dian2Color1, getColor2, param)){
//				dian2Color1Num++;
//			}else if (color.compareColor(dian2Color2, getColor2, param)) {
//				dian2Color2Num++;
//			}else{
//				dian2Error++;
//			}
//			
//			
//			//进行默认固定方向偏移
//			mouse.mouseMoveTo(501, 150);
//			invoke.invoke("RightDown");
//			sleep.sleep(50);
//			mouse.mouseMoveTo(510, 180);
//			sleep.sleep(300);
//			invoke.invoke("RightUp");
//			
//			sleep.sleep(300);
//		}
//		//这种错误理论上应该不存在
//		if(dian1Error>5||dian2Error>5){
//			file.log("方向偏移异常");
////			new SendMail().send("水底开鼓方向偏移出现异常", "水底被杀后，方向水底开鼓方向偏移出现异常，建议请进入游戏查看");
//		}
//		
//		//循环完毕，进行最终覆盖点判断,提取覆盖点应该的颜色
//		String d1=null;
//		String d2=null;
//		if(dian1Color1Num>dian1Color2Num){
//			d1=dian1Color2;
//		}else{
//			d1=dian1Color1;
//		}
//		if(dian2Color1Num>dian2Color2Num){
//			d2=dian2Color2;
//		}else{
//			d2=dian2Color1;
//		}
//		//至此颜色匹配最终完毕
//		
//		//为了防止人物因为时间过长出现暂离现象，防御一下，解除暂离状态
//		press.keyPress(32);
//		sleep.sleep(1000);
//		press.keyPress(32);
//		System.out.println("dian1-1"+dian1Color1+">"+dian1Color1Num+"|dian1-2"+dian1Color2+">"+dian1Color2Num);
//		System.out.println("dian1-1"+dian2Color1+">"+dian2Color1Num+"|dian1-2"+dian2Color2+">"+dian2Color2Num);
//		System.out.println("error:"+dian1Error+"|"+dian2Error);
//		
//		boolean setIng=true;		//是否在调整中，若是调整成功，为false
//		int j=0;
//		while(j++<numMax){
//			boolean dian1Yes=color.compareColor(color.getColor(dian1X, dianY), d1, param);
//			boolean dian2Yes=color.compareColor(color.getColor(dian2X, dianY), d2, param);
//			System.out.println(dian1Yes+"|"+dian2Yes);
//			if(dian1Yes&&dian2Yes&&setIng){
//				setIng=false;
//				j=numMax;
//				file.log("识别成功，记录");
//			}else{		//两个都不匹配
//				mouse.mouseMoveTo(501, 150);
//				invoke.invoke("RightDown");
//				sleep.sleep(50);
//				mouse.mouseMoveTo(510, 180);
//				sleep.sleep(300);
//				invoke.invoke("RightUp");
//			}
//			
//			sleep.sleep(500);
//		}
//		
		int i=0;
		while(i++<numMax){
			int findArrows[]=findPic.findPicEPosition(905,103,967,147, "mapArrows.bmp", "050505", 0.9);
			if(findArrows[0]!=-1){	//找到了
				i=332;	//退出
			}else{
				mouse.mouseMoveTo(501, 150);
				invoke.invoke("RightDown");
				sleep.sleep(50);
				mouse.mouseMoveTo(510, 180);
				sleep.sleep(50);
				invoke.invoke("RightUp");
				sleep.sleep(500);
			}
		}
		
		//W向前走一步，确定方向，避免出现方向回滚
		press.keyPressTime(87, 1000);
		
		if(i==333){
			file.log("方向确立完毕!");
		}else{
			file.log("方向偏移失败！");
			new SendMail().send("水底开鼓方向偏移失败", "水底被杀后，方向自动识别失败，可能是被人杀的次数过多受伤过重！请进入游戏查看");
		}
		
		
		mouse=null;
		press=null;
		sleep=null;
		file=null;
		invoke=null;
		findPic=null;
	}
}
