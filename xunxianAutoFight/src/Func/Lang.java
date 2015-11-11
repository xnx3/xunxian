package Func;

public class Lang {
	
	/**
	 * 字符型转换为整数型
	 * <li>value：待转换的字符串
	 * <li>errorNum:try异常后的返回值
	 * @return
	 */
	public int Integer_(String value,int errorNum){
		int xnx3_result=0;
		
		//首先判断字符串不能为空
		if(value==null||value.equalsIgnoreCase("null")){
			xnx3_result=errorNum;
		}else{
			try {
				xnx3_result=Integer.parseInt(value);
			} catch (Exception e) {
				xnx3_result=errorNum;
			}
		}
		
		return xnx3_result;
	}
	
	/**
	 * 
	 * @param value  要转换的
	 * @param errorNum  转换出错异常时返回的值
	 * @param radix  进制。16进制转换则为16
	 * @return  返回int-10禁制
	 */
	public int Integer_(String value,int errorNum,int radix){
		int xnx3_result=0;
		
		//首先判断字符串不能为空
		if(value==null||value.equalsIgnoreCase("null")){
			xnx3_result=errorNum;
		}else{
			try {
				xnx3_result=Integer.parseInt(value, radix);
			} catch (Exception e) {
				xnx3_result=errorNum;
			}
		}
		
		return xnx3_result;
	}
}
