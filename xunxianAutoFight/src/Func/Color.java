package Func;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;
import include.Command;

public class Color {
	private ActiveXComponent activeDm=null;
	
	public Color(ActiveXComponent active) {
		this.activeDm=active;
	}
	
	/**
	 * 获取指定点的颜色
	 * @param x
	 * @param y
	 * @return 字符串形式16禁制FFFFFF
	 */
	public String getColor(int x,int y){
		String color="FFFFFF";
		try {
			color=activeDm.invoke("GetColor",x,y).getString();
		} catch (Exception e) {
			new Func.File().log("获取指定点颜色getColor异常捕获:"+e.getMessage());
		}
		return color;
	}
	
	/**
	 * 判断某点颜色是否跟指定的相同或相似
	 * @param color:要判断的颜色（FFFFFF）
     * @return 若颜色匹配，此点是这颜色，则返回true
	 */
	public boolean findColor(int x,int y,String color){
		boolean xnx3_result=false;
		try {
			Variant[] var=new Variant[4];
			var[0]=new Variant(x);
			var[1]=new Variant(y);
			var[2]=new Variant(color+"-"+Command.dianColor);
			var[3]=new Variant(Command.dianSim);
			
			int cmpColor=activeDm.invoke("CmpColor",var).getInt();
			var=null;

			if(cmpColor==0){
				xnx3_result=true;
			}
			cmpColor=0;
		} catch (Exception e) {
			new Func.File().log("获取颜色findColor异常捕获:"+e.getMessage());
		}
		return xnx3_result;
	}
	
	/**
	 * 范围区域内查询某颜色是否存在
	 * <li>color:查找的颜色，如"ffffff-333333"多个用|分割
	 * <li>sim:查找的精确度
	 * <li>dir:查询的顺序，1为从左到右从上到下，详细参考DM-FindColorE函数
	 * 
	 * @return  
	 * 若是成功返回坐在坐标int[0]：X坐标，int[1]：Y坐标
	 * 若是失败，则都是-1
	 */
	public int[] findColor(int xStart,int yStart,int xEnd,int yEnd,String color,double sim,int dir){
		int[] xnx3_result=new int[2];
		try {
			Variant[] var=new Variant[7];
			var[0]=new Variant(xStart);
			var[1]=new Variant(yStart);
			var[2]=new Variant(xEnd);
			var[3]=new Variant(yEnd);
			var[4]=new Variant(color);
			var[5]=new Variant(sim);
			var[6]=new Variant(dir);
			
			String findColor=activeDm.invoke("FindColorE",var).getString();
			String[] findColorArray=findColor.split("\\|");
			xnx3_result[0]=new Func.Lang().Integer_(findColorArray[0], -1);
			xnx3_result[1]=new Func.Lang().Integer_(findColorArray[1], -1);
			var=null;
			findColorArray=null;
			findColor=null;
		} catch (Exception e) {
			new Func.File().log("获取颜色findColor异常捕获:"+e.getMessage());
		}
		return xnx3_result;
	}
	
	/**
	 * 判断2个16进制数据的差
	 */
	public boolean compareColor(String color1,String color2,String param){
		boolean xnx3_result=false;
		if(color1==null||color1.length()!=6||color2==null||color2.length()!=6||param==null||param.length()!=6){
			//false
		}else{
			try {
				Lang lang=new Func.Lang();
				int color1_12=lang.Integer_(color1.substring(0, 2), 0, 16);
				int color1_34=lang.Integer_(color1.substring(2, 4), 0, 16);
				int color1_56=lang.Integer_(color1.substring(4, 6), 0, 16);

				int color2_12=lang.Integer_(color2.substring(0, 2), 9, 16);
				int color2_34=lang.Integer_(color2.substring(2, 4), 9, 16);
				int color2_56=lang.Integer_(color2.substring(4, 6), 9, 16);
				
				int param_12=lang.Integer_(param.substring(0, 2), 5, 16);
				int param_34=lang.Integer_(param.substring(2, 4), 5, 16);
				int param_56=lang.Integer_(param.substring(4, 6), 5, 16);
				
				if(Math.abs(color1_12-color2_12)<param_12&&Math.abs(color1_34-color2_34)<param_34&&Math.abs(color1_56-color2_56)<param_56){
					xnx3_result=true;
				}else{
					xnx3_result=false;
				}
				
				lang=null;
			} catch (Exception e) {
				e.printStackTrace();
				new Func.File().log("16进制判断异常捕获:"+e.getMessage());
			}
		}
		
		return xnx3_result;
	}
}
