package Func;


public class Sleep {
	/**
	 * 延迟等待，多线程sleep，与软件同步停止
	 * @param millis毫秒
	 */
	public void sleep(int millis){
		
		try {
			if(millis>3000){
				int i=Math.round(millis/1000)+1;
				//include.Command.run 软件的主体控制运行状态，点击结束后此项为false
				for(int j=0;j<i&&include.Command.run;j++){
					Thread.sleep(1000);
				}
			}else{
				Thread.sleep(millis);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
