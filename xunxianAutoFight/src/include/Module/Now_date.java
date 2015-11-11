package include.Module;

import java.util.Calendar;

/*
 * 获取当前时间
 * 2000-01-01 10:10:10
 * author:xnx3
 * String time=Now_date.xnx3_time();
 */

public class Now_date {
	public static String xnx3_time() {
		Calendar Cld = Calendar.getInstance();
		int YY = Cld.get(Calendar.YEAR);
		int MM = Cld.get(Calendar.MONTH)+1;
		int DD = Cld.get(Calendar.DATE);
		int HH = Cld.get(Calendar.HOUR_OF_DAY);
		int mm = Cld.get(Calendar.MINUTE);
		int SS = Cld.get(Calendar.SECOND);
		// 微秒 int MI = Cld.get(Calendar.MILLISECOND);

		String xnx3_time = xnx3_triansform(YY) + "-" + xnx3_triansform(MM)
				+ "-" + xnx3_triansform(DD) + " " + xnx3_triansform(HH) + ":"
				+ xnx3_triansform(mm) + ":" + xnx3_triansform(SS);

		return xnx3_time;

	}

	public static String xnx3_triansform(int xnx3_int) {
		String xnx3_temporary;
		if (xnx3_int < 10) {
			xnx3_temporary = "0" + xnx3_int;
		} else {
			xnx3_temporary = "" + xnx3_int;
		}
		return xnx3_temporary;

	}

	public static String String_bunch(){
		return new Now_date().xnx3_time().replaceAll("\\D", "");
	}

	public static void main(String[] args) {
		System.out.println(new Now_date().xnx3_time());
		System.out.println(String_bunch());
	}
}
