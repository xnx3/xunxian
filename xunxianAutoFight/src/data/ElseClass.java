package data;

import java.util.HashMap;
import java.util.Map;

/**
 * 扫货时其他类别的扫描
 * @author xnx3
 *
 */
public class ElseClass {
	
	public Map<String, Integer> elseClassBak(){
		Map<String, Integer> map=new HashMap<String, Integer>();
		
		//战魂
		map.put("5级战魂", 2);
		map.put("6级战魂", 2);
		map.put("7级战魂", 2);
		map.put("8级战魂", 2);
		map.put("9级战魂", 2);
		map.put("10级战魂", 2);
		
		//强力诀
		map.put("强力诀至尊属性", 2);
		map.put("强力诀稀有属性", 2);
		map.put("强力诀高级属性", 2);
		map.put("强力诀中级属性", 2);
		map.put("强力诀普通属性", 2);
		
		//通神诀
		map.put("通神诀极品附灵属性", 2);
		map.put("通神诀稀有附灵属性", 2);
		map.put("通神诀高级附灵属性", 2);
		map.put("通神诀中级附灵属性", 2);
		map.put("通神诀普通附灵属性", 2);
		
		return map;
	}
	
}
