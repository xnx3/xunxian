package Func;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;

public class FindStr {
	private ActiveXComponent activeDm=null;
	public FindStr(ActiveXComponent active) {
		this.activeDm=active;
	}
	/**
	 * 查找文字，包含文字是否出现、出现的文字的范围
	 * @return 数据int[3]   <li>int[0]:是否查找到，若是没有则返回-1  <li>int[1]查找到的文字的X的值，没有返回-1   <li>int[2]查找到的文字的Y值，没有返回-1
	 */
	public int[] findStrE(int xStart, int yStart, int xEnd,int yEnd, String findString ,String colorFormat,double sim,int useDict ){
		int[] xnx3_result=new int[3];
		//初始化赋值，避免走catch
		xnx3_result[0]=-1;
		xnx3_result[1]=-1;
		xnx3_result[2]=-1;
		try{
			activeDm.invoke("UseDict",useDict);
			
			Variant[] var=new Variant[7];
			var[0]=new Variant(xStart);
			var[1]=new Variant(yStart);
			var[2]=new Variant(xEnd);
			var[3]=new Variant(yEnd);
			var[4]=new Variant(findString);
			var[5]=new Variant(colorFormat);
			var[6]=new Variant(sim);
			String findStrE=activeDm.invoke("FindStrE",var).getString();
			var=null;
			String[] findStrEArray=findStrE.split("\\|");
			xnx3_result[0]=Integer.parseInt(findStrEArray[0]);
			xnx3_result[1]=Integer.parseInt(findStrEArray[1]);
			xnx3_result[2]=Integer.parseInt(findStrEArray[2]);
			findStrE=null;
			findStrEArray=null;
		}catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("查找文字异常捕获:"+e.getMessage());
		}
		
		return xnx3_result;
	}
	
	/**
	 * 读取文字
	 * <li>xStart,xEnd,yStart,yEnd   读取文字所在的区域
	 * <li>colorFormat:文字颜色及范围，如ffd800-888888，多个用|分割
	 * <li>sim:相似度，最大为1，一般0.9便可
	 * @return:若是没找到，返回""
	 * 
	 */
	public String readStr(int xStart,int yStart,int xEnd,int yEnd,String colorFormat,double sim,int useDict){
		String xnx3_result="";
		try {
			activeDm.invoke("UseDict",useDict);
			Variant[] var=new Variant[6];
			var[0]=new Variant(xStart);
			var[1]=new Variant(yStart);
			var[2]=new Variant(xEnd);
			var[3]=new Variant(yEnd);
			var[4]=new Variant(colorFormat);
			var[5]=new Variant(sim);
			xnx3_result=activeDm.invoke("Ocr",var).getString();
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("读取文字异常捕获:"+e.getMessage());
		}
		
		return xnx3_result;
	}
}
