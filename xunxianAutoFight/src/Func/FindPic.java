package Func;

import include.Command;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;

public class FindPic {
	private ActiveXComponent activeDm=null;
	public FindPic(ActiveXComponent active) {
		this.activeDm=active;
	}
	/**
	 * 查找图片
	 * @param pic:图像集，多个用|分割，bmp格式,且边框为同一种颜色
	 * @return 找到图返回true,未找到返回false
	 */
	public boolean findPicE(int xStart,int yStart,int xEnd,int yEnd,String pic){
		boolean xnx3_result=false;
		try {
			Variant[] var=new Variant[8];
			var[0]=new Variant(xStart);
			var[1]=new Variant(yStart);
			var[2]=new Variant(xEnd);
			var[3]=new Variant(yEnd);
			var[4]=new Variant(pic);
			var[5]=new Variant(Command.picColor);
			var[6]=new Variant(Command.picSim);
			var[7]=new Variant(0);
			String findPicE=activeDm.invoke("FindPicE",var).getString();
			var=null;
			String[] getPic=findPicE.split("\\|");
			if(Integer.parseInt(getPic[0])>-1){
				xnx3_result=true;
			}
			findPicE=null;
			getPic=null;
		} catch (Exception e) {
			new Func.File().log("查找图片Func.findPicE()异常捕获:"+e.getMessage());
		}
		return xnx3_result;
	}
	
	/**
	 * 查找图片，返回找到的第一个图片的坐标
	 * <li>String pic:图像集，多个用|分割，24位色bmp格式,且边框为同一种颜色
	 * @return 返回找到的第一个图片位置，返回int[]   <li>int[0]:是否找到，没找到返回-1  <li>int[1]:找到的图像的x坐标  <li>int[2]:找到的图像的y坐标
	 */
	public int[] findPicEPosition(int xStart,int yStart,int xEnd,int yEnd,String pic){
		int[] xnx3_result=new int[3];
		//初始化，避免走catch
		xnx3_result[0]=-1;
		xnx3_result[1]=-1;
		xnx3_result[2]=-1;
		try {
			Variant[] var=new Variant[8];
			var[0]=new Variant(xStart);
			var[1]=new Variant(yStart);
			var[2]=new Variant(xEnd);
			var[3]=new Variant(yEnd);
			var[4]=new Variant(pic);
			var[5]=new Variant(Command.picColor);
			var[6]=new Variant(Command.picSim);
			var[7]=new Variant(0);
			String findPicE=activeDm.invoke("FindPicE",var).getString();
			var=null;
			String[] getPic=findPicE.split("\\|");
			xnx3_result[0]=Integer.parseInt(getPic[0]);
			xnx3_result[1]=Integer.parseInt(getPic[1]);
			xnx3_result[2]=Integer.parseInt(getPic[2]);
			findPicE=null;
			getPic=null;
		} catch (Exception e) {
			new Func.File().log("查找图片Func.findPicEPosition()异常捕获:"+e.getMessage());
		}

		return xnx3_result;
	}
	
	/**
	 * 查找图片，返回找到的第一个图片的坐标
	 * <li>String pic:图像集，多个用|分割，24位色bmp格式,且边框为同一种颜色
	 * <li>String picColor:偏离颜色范围,303030
	 * <li>double picSim:近似度，一般不变的图为1.0
	 * @return 返回找到的第一个图片位置，返回int[]   <li>int[0]:是否找到，没找到返回-1  <li>int[1]:找到的图像的x坐标  <li>int[2]:找到的图像的y坐标
	 */
	public int[] findPicEPosition(int xStart,int yStart,int xEnd,int yEnd,String pic,String picColor,double picSim){
		int[] xnx3_result=new int[3];
		//初始化，避免走catch
		xnx3_result[0]=-1;
		xnx3_result[1]=-1;
		xnx3_result[2]=-1;
		try {
			Variant[] var=new Variant[8];
			var[0]=new Variant(xStart);
			var[1]=new Variant(yStart);
			var[2]=new Variant(xEnd);
			var[3]=new Variant(yEnd);
			var[4]=new Variant(pic);
			var[5]=new Variant(picColor);
			var[6]=new Variant(picSim);
			var[7]=new Variant(0);
			String findPicE=activeDm.invoke("FindPicE",var).getString();
			var=null;
			String[] getPic=findPicE.split("\\|");
			xnx3_result[0]=Integer.parseInt(getPic[0]);
			xnx3_result[1]=Integer.parseInt(getPic[1]);
			xnx3_result[2]=Integer.parseInt(getPic[2]);
			findPicE=null;
			getPic=null;
		} catch (Exception e) {
			new Func.File().log("查找图片Func.findPicEPosition()异常捕获:"+e.getMessage());
		}

		return xnx3_result;
	}
	
}
