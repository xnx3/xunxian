package include.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;

public class Json {

	/**
	 * StringToMap这两个，都加入两个判断的变量，map.put("xnx3_json_if","1/0");	,1为正常，成功，0为失败，没有正确获取或获取的字符串出错
	 * 接受的字符串为: 	[{"a":"aaa","b":"bb"}]
	 */
	
	@SuppressWarnings("unchecked")
	public Map<String, String> StringToMap(String xnx3_input){
		JSONArray json=JSONArray.fromObject(xnx3_input);
		Map<String, String> map=null;
		Iterator<Map<String, String>> iter=json.iterator();
		if(iter.hasNext()){
			map=iter.next();
			map.put("xnx3_json_if", "1");
		}else{
			map=new HashMap<String, String>();
			map.put("xnx3_json_if", "0");
		}
		json=null;
		return map;
	}
	
	/**
	 * 将Json格式的String数据转换为List类型
	 * @param args:传入纯文本数据，如[{"a":"aaa","b":"bb"}]
	 * 
	 */
	public List<String[]> StringToList(String xnx3_input){
		JSONArray json=JSONArray.fromObject(xnx3_input);
		List<String[]> list=new ArrayList<String[]>();
		Iterator<Map<String, String>> iter=json.iterator();
		if(iter.hasNext()){
			Map<String, String> map=iter.next();
			Iterator i=map.entrySet().iterator();
			
			while(i.hasNext()){//只遍历一次,速度快
				Map.Entry e=(Map.Entry)i.next();
				System.out.println(e.getKey());
				String[] data=new String[2];
				data[0]=e.getKey().toString();
				data[1]=e.getValue().toString();
				list.add(data);
				data=null;
			}
		}
		json=null;
		return list;
		
	}
	
	
	public Map<String, String> StringToMap_try(String xnx3_input){
		Map<String, String> map=null;
		try {
			map=StringToMap(xnx3_input);
			map.put("xnx3_json_if", "1");
		} catch (Exception e) {
			map=new HashMap<String, String>();
			map.put("xnx3_json_if", "0");
			e.printStackTrace();
		}
		return map;
	}
	
	
	public void ListToJsonString(List list){
		
	}
	
	
	public static void main(String[] args) {
//		System.out.println(new Json().StringToMap_try("[{\"a\":\"a\",\"b\":\33}]"));
		String a="[{\"a\":\"aaa\",\"b\":\"bb\"}]";
		System.out.println(a);
		new Json().StringToList(a);
//		StoneBean stoneBean=(StoneBean)list.get(1);
//		System.out.println();
	}
}
