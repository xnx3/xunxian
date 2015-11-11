package data;

import java.util.HashMap;
import java.util.Map;

public class System {
	
	/**
	 * 若是从外部加载system.xnx3配置文件失败，则执行这里的数据填入
	 */
	public Map<String, String> systemBak(){
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("registerClass", "11");
		
		return map;
	}
	
}
