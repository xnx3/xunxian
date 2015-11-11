package action;

import include.Command;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import net.sf.json.JSONArray;
import Func.Lang;
public class File {
	
	/**
	 * 加载系统方面信息
	 */
	public void systemLoad(){
		Lang lang=new Func.Lang();
		try {
			String xnx3_content=new include.Module.TextFile().read(include.Command.thisFilePath+"\\config\\system.xnx3", "UTF-8");
			xnx3_content=include.Module.UrlTransition.urlToUtf8(xnx3_content);
			Map map=new include.Module.Json().StringToMap_try(xnx3_content);
			System.out.println(xnx3_content);
			
			new Func.File().log("加载系统配置数据完毕");
		} catch (Exception e) {
			e.printStackTrace();
			new Func.Message().showMessageDialog("初始化系统信息失败！<br/>已还原至初始数据！<br/><br/>可能导致的原因：<br/>1.dm.dll文件被误删或第一次使用没有注册<br/>2.目录内config文件夹不存在");
			
			Map<String, String> map=new data.System().systemBak();
			
			new Func.File().log("初始化系统信息失败！已还原至初始数据！");
		}
		lang=null;
	}
	
	
	/**
	 * 自动扫货杂货类加载数据
	 * <li>加载groceries.xnx3文件，若是加载中数据出错，则自动使用默认数据data.Groceries
	 */
	public void saoHuoGroceriesLoad(){
		Lang lang=new Func.Lang();
		try {
			String xnx3_content=new include.Module.TextFile().read(include.Command.thisFilePath+"\\config\\groceries.xnx3", "UTF-8");
			xnx3_content=include.Module.UrlTransition.urlToUtf8(xnx3_content);
			Map map=new include.Module.Json().StringToMap_try(xnx3_content);
			//杂货类加载数据,   data.Groceries()
			Command.saoHuoGroceriesDataMap.clear();		//清空
			Command.saoHuoGroceriesDataMap=new data.Groceries().groceriesBak();
			try {
				Command.saoHuoGroceriesDataMap.put("侍宠玩具", lang.Integer_(map.get("侍宠玩具").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("秘法结晶", lang.Integer_(map.get("秘法结晶").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("幽寒淬炼石碎片", lang.Integer_(map.get("幽寒淬炼石碎片").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("炽炎淬炼石碎片", lang.Integer_(map.get("炽炎淬炼石碎片").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("紫晶云母", lang.Integer_(map.get("紫晶云母").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("妖怪黄历", lang.Integer_(map.get("妖怪黄历").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("空白符纸", lang.Integer_(map.get("空白符纸").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("炽炎淬炼石", lang.Integer_(map.get("炽炎淬炼石").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("玫瑰花", lang.Integer_(map.get("玫瑰花").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("气之精", lang.Integer_(map.get("气之精").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("五彩灵石碎片", lang.Integer_(map.get("五彩灵石碎片").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("聚灵晶（小）", lang.Integer_(map.get("聚灵晶（小）").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("灵虚精髓", lang.Integer_(map.get("灵虚精髓").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("太乙珠", lang.Integer_(map.get("太乙珠").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("绿山辉石", lang.Integer_(map.get("绿山辉石").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("侍宠炼化符", lang.Integer_(map.get("侍宠炼化符").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("骑宠炼化符", lang.Integer_(map.get("骑宠炼化符").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("坤灵寒玉", lang.Integer_(map.get("坤灵寒玉").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("天罡破界石", lang.Integer_(map.get("天罡破界石").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("骑宠玩具", lang.Integer_(map.get("骑宠玩具").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("巫术结晶", lang.Integer_(map.get("巫术结晶").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("精之晶", lang.Integer_(map.get("精之晶").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("白色魂玉", lang.Integer_(map.get("白色魂玉").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("绿色魂玉", lang.Integer_(map.get("绿色魂玉").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("朴素的戒指", lang.Integer_(map.get("朴素的戒指").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("附魂石", lang.Integer_(map.get("附魂石").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("火力之石", lang.Integer_(map.get("火力之石").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("定魂石", lang.Integer_(map.get("定魂石").toString(), 2));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {	//v2.5.2
				Command.saoHuoGroceriesDataMap.put("仙兽骑宠蛋", lang.Integer_(map.get("仙兽骑宠蛋").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("雷击枣木干裂", lang.Integer_(map.get("雷击枣木干裂").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("雷击枣木", lang.Integer_(map.get("雷击枣木").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("两仪石", lang.Integer_(map.get("两仪石").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("破损的玉佩", lang.Integer_(map.get("破损的玉佩").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("三孔", lang.Integer_(map.get("三孔").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("三孔碎片", lang.Integer_(map.get("三孔碎片").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("神威印记", lang.Integer_(map.get("神威印记").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("五行封镇玄铁", lang.Integer_(map.get("五行封镇玄铁").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("五行封镇玄铁碎片", lang.Integer_(map.get("五行封镇玄铁碎片").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("幽寒碎炼石", lang.Integer_(map.get("幽寒碎炼石").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("天罡破界石碎片", lang.Integer_(map.get("天罡破界石碎片").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("二级返虚符", lang.Integer_(map.get("二级返虚符").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("凝元颗粒", lang.Integer_(map.get("凝元颗粒").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("千字天书", lang.Integer_(map.get("千字天书").toString(), 2));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try{	//v3.3
				Command.saoHuoGroceriesDataMap.put("真圣血晶", lang.Integer_(map.get("真圣血晶").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("出海蛟龙配饰", lang.Integer_(map.get("出海蛟龙配饰").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("天元石", lang.Integer_(map.get("天元石").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("伏魔令", lang.Integer_(map.get("伏魔令").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("空白配饰附魔符纸", lang.Integer_(map.get("空白配饰附魔符纸").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("弱水之精", lang.Integer_(map.get("弱水之精").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("凝气石", lang.Integer_(map.get("凝气石").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("圣灵丹", lang.Integer_(map.get("圣灵丹").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("四级返虚符", lang.Integer_(map.get("四级返虚符").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("中级灵虚符", lang.Integer_(map.get("中级灵虚符").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("威灵仙粉", lang.Integer_(map.get("威灵仙粉").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("独山玉", lang.Integer_(map.get("独山玉").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("捆仙绳", lang.Integer_(map.get("捆仙绳").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("金龙梭", lang.Integer_(map.get("金龙梭").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("子午火云针", lang.Integer_(map.get("子午火云针").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("戳目珠", lang.Integer_(map.get("戳目珠").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("五火七禽扇", lang.Integer_(map.get("五火七禽扇").toString(), 2));
				
				Command.saoHuoGroceriesDataMap.put("炸鸡啤酒", lang.Integer_(map.get("炸鸡啤酒").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("灵气结晶", lang.Integer_(map.get("灵气结晶").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("解绑玉玦", lang.Integer_(map.get("解绑玉玦").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("门派任贤印记", lang.Integer_(map.get("门派任贤印记").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("仙书魔典", lang.Integer_(map.get("仙书魔典").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("煎饼", lang.Integer_(map.get("煎饼").toString(), 2));
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try{	//v3.4
				Command.saoHuoGroceriesDataMap.put("偃师之书丙卷", lang.Integer_(map.get("偃师之书丙卷").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("秘法符纸精华", lang.Integer_(map.get("秘法符纸精华").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("破界结晶", lang.Integer_(map.get("破界结晶").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("凝魂紫晶", lang.Integer_(map.get("凝魂紫晶").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("乾坤鼎", lang.Integer_(map.get("乾坤鼎").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("初级飘羽仙丹", lang.Integer_(map.get("初级飘羽仙丹").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("融宝精元", lang.Integer_(map.get("融宝精元").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("四孔", lang.Integer_(map.get("四孔").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("破界结晶", lang.Integer_(map.get("破界结晶").toString(), 2));
				Command.saoHuoGroceriesDataMap.put("破界结晶", lang.Integer_(map.get("破界结晶").toString(), 2));
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			SaoHuoFunc saoHuoFunc=new SaoHuoFunc();
			
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo.groceriesjTable.getModel();
			tableModel.getDataVector().clear();		//清空所有
			//遍历Map
			Set<Map.Entry<String, Integer>> set = Command.saoHuoGroceriesDataMap.entrySet();
	        for (Iterator<Map.Entry<String, Integer>> it = set.iterator(); it.hasNext();) {
	            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
	            Vector rowData = new Vector();
				rowData.add(entry.getKey());
				rowData.add(saoHuoFunc.moneyToString(entry.getValue()));
				rowData.add(entry.getValue());
				tableModel.insertRow(0, rowData);
				rowData=null;
	        }
			
			saoHuoFunc=null;
			map=null;
			new Func.File().log("加载自动扫货杂货类数据完毕");
		} catch (Exception e) {
			e.printStackTrace();
			new Func.Message().showMessageDialog("初始化失败！<br/>加载自动扫货杂货类数据异常");
		}
		lang=null;
	}
	
	/**
	 * 自动扫货杂货类保存数据
	 */
	public void saoHuoGroceriesSave(){
		Lang lang=new Func.Lang();
		
		try {
			Map map=new HashMap();
			
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo.groceriesjTable.getModel();
			int length=tableModel.getRowCount();
			for (int i = 0; i < length; i++) {
				System.out.println(tableModel.getValueAt(i, 0));
				map.put(tableModel.getValueAt(i, 0), tableModel.getValueAt(i, 2)+"");
			}
			JSONArray json=new JSONArray().fromObject(map);
			String jsonContent=include.Module.UrlTransition.utf8ToUrl(json.toString());
			String Str_file=include.Command.thisFilePath+"\\config\\groceries.xnx3";
			new include.Module.TextFile().write(Str_file, jsonContent);
			
			map=null;
			new Func.File().log("自动扫货杂货类数据保存完毕");
		} catch (Exception e) {
			new Func.File().log("自动扫货杂货类数据保存异常捕获:"+e.getMessage());
		}
		
		lang=null;
	}
	
	/**
	 * 自动扫货八卦灵石类加载数据
	 * <li>加载stone.xnx3文件，若是加载中数据出错，则自动使用默认数据data.Stone.stoneBak
	 */
	public void saoHuoStoneLoad(){
		Lang lang=new Func.Lang();
		try {
			String xnx3_content=new include.Module.TextFile().read(include.Command.thisFilePath+"\\config\\stone.xnx3", "UTF-8");
			xnx3_content=include.Module.UrlTransition.urlToUtf8(xnx3_content);
			JSONArray j=JSONArray.fromObject(xnx3_content);
			List l=j.toList(j);
//			List l=new Stone().stoneBak();
			SaoHuoFunc saoHuoFunc=new SaoHuoFunc();
			Command.JframeSaoHuo.stonejTable.removeAll();	//移除所有的重新添加
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo.stonejTable.getModel();
			Command.saoHuoStone.clear();		//情空，重新放入
			tableModel.getDataVector().clear();		//清空所有
			new Func.File().log("八卦灵石载入："+l.size()+"条数据");
			for (int i = l.size()-1; i >-1; i--) {
				JSONArray jSub=JSONArray.fromObject(l.get(i));
				List lSub=jSub.toList(jSub);
//				System.out.println(jSub.get(0)+"-->"+jSub.get(1));
				String key=jSub.getString(0);
				int value=lang.Integer_(jSub.getString(1), 2);
				Command.saoHuoStone.put(key, value);
				Vector rowData = new Vector();
				rowData.add(key);
				rowData.add(saoHuoFunc.moneyToString(value));
				rowData.add(value);
				tableModel.insertRow(0, rowData);
				rowData=null;
			}
			saoHuoFunc=null;
			new Func.File().log("加载自动扫货八卦灵石类数据完毕");
		} catch (Exception e) {
			e.printStackTrace();
			new Func.Message().showMessageDialog("初始化失败！<br/>加载自动扫货八卦灵石类数据异常<br/>八卦灵石类数据已自动还原为初始数据");
//			Command.saoHuoStone=new Stone().stoneBak();
			new Func.File().log("加载自动扫货八卦灵石类数据异常!");
		}
		lang=null;
	}
	
	/**
	 * 自动扫货八卦灵石类保存数据
	 */
	public void saoHuoStoneSave(){
		Lang lang=new Func.Lang();
		
		try {
			List<String[]> list=new ArrayList<String[]>();
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo.stonejTable.getModel();
			
			int length=tableModel.getRowCount();
			System.out.println("行数："+length);
			for (int i = 0; i < length; i++) {
//				map.put(tableModel.getValueAt(i, 0), tableModel.getValueAt(i, 2));
				String[] data={tableModel.getValueAt(i, 0).toString(),tableModel.getValueAt(i, 2).toString()};
				list.add(data);
				data=null;
			}
			JSONArray json=new JSONArray().fromObject(list);
//			System.out.println("数据-->"+json.toString());
			String jsonContent=include.Module.UrlTransition.utf8ToUrl(json.toString());
			String Str_file=include.Command.thisFilePath+"\\config\\stone.xnx3";
			new include.Module.TextFile().write(Str_file, jsonContent);
			
			list=null;
			new Func.File().log("自动扫货八卦灵石类数据保存完毕");
		} catch (Exception e) {
			new Func.File().log("自动扫货八卦灵石类数据保存异常捕获:"+e.getMessage());
		}
		
		lang=null;
	}
	
	/**
	 * 自动扫货宠物壳子类加载数据
	 * <li>加载pet.xnx3文件，若是加载中数据出错，则自动使用默认数据data.Pet.petBak
	 */
	public void saoHuoPetLoad(){
		Lang lang=new Func.Lang();
		Command.saoHuoPet.clear();		//清空Map
		Command.saoHuoPet=new data.Pet().petBak();
		
		try {
			String xnx3_content=new include.Module.TextFile().read(include.Command.thisFilePath+"\\config\\pet.xnx3", "UTF-8");
			xnx3_content=include.Module.UrlTransition.urlToUtf8(xnx3_content);
			JSONArray j=JSONArray.fromObject(xnx3_content);
			List l=j.toList(j);
//			List l=new Pet().petBak();
			SaoHuoFunc saoHuoFunc=new SaoHuoFunc();
			Command.JframeSaoHuo.petjTable.removeAll();	//移除所有的重新添加
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo.petjTable.getModel();
			tableModel.getDataVector().clear();		//清空所有
			
			new Func.File().log("宠物壳子载入："+l.size()+"条数据");
			for (int i = l.size()-1; i >-1; i--) {
				JSONArray jSub=JSONArray.fromObject(l.get(i));
				List lSub=jSub.toList(jSub);
				String key=jSub.getString(0);
				int value=lang.Integer_(jSub.getString(1), 2);
				System.out.println("Key->"+key+"-->"+value);
				Command.saoHuoPet.put(key, value);
			}
			
			Set<Map.Entry<String, Integer>> set = Command.saoHuoPet.entrySet();
	        for (Iterator<Map.Entry<String, Integer>> it = set.iterator(); it.hasNext();) {
	            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
	            Vector rowData = new Vector();
				rowData.add(entry.getKey());
				rowData.add(saoHuoFunc.moneyToString(entry.getValue()));
				rowData.add(entry.getValue());
				tableModel.insertRow(0, rowData);
				rowData=null;
	        }
			
			saoHuoFunc=null;
			new Func.File().log("加载自动扫货宠物壳子类数据完毕");
		} catch (Exception e) {
			e.printStackTrace();
			new Func.Message().showMessageDialog("初始化失败！<br/>加载自动扫货宠物壳子类数据异常<br/>宠物壳子类数据已自动还原为初始数据");
//			Command.saoHuoStone=new Stone().stoneBak();
			new Func.File().log("加载自动扫货宠物壳子类数据异常!");
		}
		lang=null;
	}
	
	/**
	 * 自动扫货宠物壳子类保存数据
	 */
	public void saoHuoPetSave(){
		Lang lang=new Func.Lang();
		
		try {
			List<String[]> list=new ArrayList<String[]>();
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo.petjTable.getModel();
			
			int length=tableModel.getRowCount();
			System.out.println("行数："+length);
			for (int i = 0; i < length; i++) {
//				map.put(tableModel.getValueAt(i, 0), tableModel.getValueAt(i, 2));
				String[] data={tableModel.getValueAt(i, 0).toString(),tableModel.getValueAt(i, 2).toString()};
				list.add(data);
				data=null;
			}
			JSONArray json=new JSONArray().fromObject(list);
//			System.out.println("数据-->"+json.toString());
			String jsonContent=include.Module.UrlTransition.utf8ToUrl(json.toString());
			String Str_file=include.Command.thisFilePath+"\\config\\pet.xnx3";
			new include.Module.TextFile().write(Str_file, jsonContent);
			
			list=null;
			new Func.File().log("自动扫货宠物壳子类数据保存完毕");
		} catch (Exception e) {
			new Func.File().log("自动扫货宠物壳子类数据保存异常捕获:"+e.getMessage());
		}
		
		lang=null;
	}
	
	/**
	 * 	保存UI界面的数据、自定义挂机点
	 *  
	 */
	public void UISave(){
		try {
			Map map=new HashMap();
			
			//Main.from
			map.put("registerCode", Command.JForm.registerCode.getText());
			map.put("professionjComboBox", Command.JForm.professionjComboBox.getSelectedIndex());
			map.put("daGuaiModeljComboBox", Command.JForm.daGuaiModeljComboBox.getSelectedIndex());
			map.put("daGuaiMapjComboBox", Command.JForm.daGuaiMapjComboBox.getSelectedIndex());
			
			map.put("setMailjTextField", Command.JForm.setMailjTextField.getText());
			map.put("roleNamejTextField", Command.JForm.roleNamejTextField.getText());
			map.put("jComboBoxErrorXueStart", Command.JForm.jComboBoxErrorXueStart.getSelectedIndex());
			map.put("jTextFieldMyOverTime", Command.JForm.jTextFieldMyOverTime.getText());
			map.put("jComboBoxErrorXueStart", Command.JForm.jComboBoxErrorXueStart.getSelectedIndex());
			map.put("jComboBoxOptimize", Command.JForm.jComboBoxOptimize.getSelectedIndex());
			map.put("jCheckBoxUseOptimizeCpu", Command.JForm.jCheckBoxUseOptimizeCpu.isSelected());
			
			//SaoHuo.form
			map.put("saoHuoOneTongjCheckBox", Command.JframeSaoHuo.saoHuoOneTongjCheckBox.isSelected());
			map.put("saoHuoGroceriesjCheckBox", Command.JframeSaoHuo.saoHuoGroceriesjCheckBox.isSelected());
			map.put("saoHuoPetjCheckBox", Command.JframeSaoHuo.saoHuoPetjCheckBox.isSelected());
			map.put("saoHuoStonejCheckBox", Command.JframeSaoHuo.saoHuoStonejCheckBox.isSelected());
			map.put("saoHuoFengWuZhijCheckBox", Command.JframeSaoHuo.saoHuoFengWuZhijCheckBox.isSelected());
			map.put("saoHuoLegendjCheckBox", Command.JframeSaoHuo.saoHuoLegendjCheckBox.isSelected());
			map.put("saoHuoQiangLiJuejCheckBox", Command.JframeSaoHuo.saoHuoQiangLiJuejCheckBox.isSelected());
			map.put("saoHuoTongShenJuejCheckBox", Command.JframeSaoHuo.saoHuoTongShenJuejCheckBox.isSelected());
			map.put("saoHuoZhanHunjCheckBox", Command.JframeSaoHuo.saoHuoZhanHunjCheckBox.isSelected());
			
			map.put("routeMapXArray_12_0", Command.routeMapXArray[12][0]);
			map.put("routeMapXArray_12_1", Command.routeMapXArray[12][1]);
			map.put("routeMapYArray_12_0", Command.routeMapYArray[12][0]);
			map.put("routeMapYArray_12_1", Command.routeMapYArray[12][1]);
			
			map.put("delayjComboBox", Command.JForm.delayjComboBox.getSelectedIndex());
			
			//Skill.form
			map.put("skillJComboBox1Use", Command.JframeSkill.jComboBox1Use.getSelectedIndex());
			map.put("skillJComboBox2Use", Command.JframeSkill.jComboBox2Use.getSelectedIndex());
			map.put("skillJComboBox3Use", Command.JframeSkill.jComboBox3Use.getSelectedIndex());
			map.put("skillJComboBox4Use", Command.JframeSkill.jComboBox4Use.getSelectedIndex());
			map.put("skillJComboBox5Use", Command.JframeSkill.jComboBox5Use.getSelectedIndex());
			
			map.put("skillJTextField1Key", Command.JframeSkill.jTextField1Key.getText());
			map.put("skillJTextField2Key", Command.JframeSkill.jTextField2Key.getText());
			map.put("skillJTextField3Key", Command.JframeSkill.jTextField3Key.getText());
			map.put("skillJTextField4Key", Command.JframeSkill.jTextField4Key.getText());
			map.put("skillJTextField5Key", Command.JframeSkill.jTextField5Key.getText());			Command.JframeSkill.jTextField1Key.setText(map.get("skillJTextField1Key").toString());
			
			map.put("skillJTextField1Time", Command.JframeSkill.jTextField1Time.getText());
			map.put("skillJTextField2Time", Command.JframeSkill.jTextField2Time.getText());
			map.put("skillJTextField3Time", Command.JframeSkill.jTextField3Time.getText());
			map.put("skillJTextField4Time", Command.JframeSkill.jTextField4Time.getText());
			map.put("skillJTextField5Time", Command.JframeSkill.jTextField5Time.getText());
			
			map.put("skillSetData_0_0", Command.skillSetData[0][0]);
			map.put("skillSetData_0_1", Command.skillSetData[0][1]);
			map.put("skillSetData_1_0", Command.skillSetData[1][0]);
			map.put("skillSetData_1_1", Command.skillSetData[1][1]);
			map.put("skillSetData_2_0", Command.skillSetData[2][0]);
			map.put("skillSetData_2_1", Command.skillSetData[2][1]);
			map.put("skillSetData_3_0", Command.skillSetData[3][0]);
			map.put("skillSetData_3_1", Command.skillSetData[3][1]);
			map.put("skillSetData_4_0", Command.skillSetData[4][0]);
			map.put("skillSetData_4_1", Command.skillSetData[4][1]);
			
			//SeniorFight.form
			map.put("jCheckBoxUseLanAnswer", Command.JframeSeniorFight.jCheckBoxUseLanAnswer.isSelected());
			map.put("jTextFieldServerIP", Command.JframeSeniorFight.jTextFieldServerIP.getText());
			map.put("jTextFieldFaqSendPort", Command.JframeSeniorFight.jTextFieldFaqSendPort.getText());
			map.put("jCheckBoxAutoXiuLi", Command.JframeSeniorFight.jCheckBoxAutoXiuLi.isSelected());
			map.put("jCheckBoxAutoEmptyParcel", Command.JframeSeniorFight.jCheckBoxAutoEmptyParcel.isSelected());
			map.put("jTextFieldHoursStart", Command.JframeSeniorFight.jTextFieldHoursStart.getText());
			map.put("jTextFieldHoursEnd", Command.JframeSeniorFight.jTextFieldHoursEnd.getText());
			map.put("jCheckBoxXiuLi_UseMenPai", Command.JframeSeniorFight.jCheckBoxXiuLi_UseMenPai.isSelected());
			map.put("jCheckBoxLanIpIsOnline",Command.JframeSeniorFight.jCheckBoxLanIpIsOnline.isSelected());
			
			JSONArray json=new JSONArray().fromObject(map);
			String jsonContent=include.Module.UrlTransition.utf8ToUrl(json.toString());
			String Str_file=include.Command.thisFilePath+"\\config\\ui.xnx3";
			new include.Module.TextFile().write(Str_file, jsonContent);
			
			map=null;
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("保存界面UI数据时异常捕获:"+e.getMessage());
			new Func.Message().showMessageDialog("保存界面UI数据失败!");
		}
	}
	
	/**
	 * 加载界面的数据
	 */
	public void UILoad(){
		
		try {
			Func.Lang lang=new Func.Lang();
			String xnx3_content=new include.Module.TextFile().read(include.Command.thisFilePath+"\\config\\ui.xnx3", "UTF-8");
			xnx3_content=include.Module.UrlTransition.urlToUtf8(xnx3_content);
			Map map=new include.Module.Json().StringToMap_try(xnx3_content);
			
			//Main.from
			Command.JForm.registerCode.setText(map.get("registerCode").toString());
			Command.JForm.professionjComboBox.setSelectedIndex(lang.Integer_(map.get("professionjComboBox").toString(), 0));
			Command.JForm.daGuaiModeljComboBox.setSelectedIndex(lang.Integer_(map.get("daGuaiModeljComboBox").toString(), 0));
			Command.JForm.daGuaiMapjComboBox.setSelectedIndex(lang.Integer_(map.get("daGuaiMapjComboBox").toString(), 0));
			
			Command.JForm.setMailjTextField.setText(map.get("setMailjTextField").toString());
			Command.JForm.roleNamejTextField.setText(map.get("roleNamejTextField").toString());
			try {	//2.5.2->2.5.3
				Command.JForm.jTextFieldMyOverTime.setText(map.get("jTextFieldMyOverTime").toString());
				Command.JForm.jComboBoxErrorXueStart.setSelectedIndex(lang.Integer_(map.get("jComboBoxErrorXueStart").toString(), 0));
				Command.JForm.jComboBoxOptimize.setSelectedIndex(lang.Integer_(map.get("jComboBoxOptimize").toString(), 0));
			} catch (Exception e) { }
			try{	//2.5.4->3.1
				Command.JForm.jCheckBoxUseOptimizeCpu.setSelected(map.get("jCheckBoxUseOptimizeCpu").toString().equals("true"));
			}catch (Exception e) { }
			
			//SaoHuo.form
			Command.JframeSaoHuo.saoHuoOneTongjCheckBox.setSelected(map.get("saoHuoOneTongjCheckBox").toString().equals("true"));
			Command.JframeSaoHuo.saoHuoGroceriesjCheckBox.setSelected(map.get("saoHuoGroceriesjCheckBox").toString().equals("true"));
			Command.JframeSaoHuo.saoHuoPetjCheckBox.setSelected(map.get("saoHuoPetjCheckBox").toString().equals("true"));
			Command.JframeSaoHuo.saoHuoStonejCheckBox.setSelected(map.get("saoHuoStonejCheckBox").toString().equals("true"));
			try {		//2.5.2->2.5.3
				Command.JframeSaoHuo.saoHuoFengWuZhijCheckBox.setSelected(map.get("saoHuoFengWuZhijCheckBox").toString().equals("true"));
				Command.JframeSaoHuo.saoHuoLegendjCheckBox.setSelected(map.get("saoHuoLegendjCheckBox").toString().equals("true"));
				Command.JframeSaoHuo.saoHuoQiangLiJuejCheckBox.setSelected(map.get("saoHuoQiangLiJuejCheckBox").toString().equals("true"));
				Command.JframeSaoHuo.saoHuoTongShenJuejCheckBox.setSelected(map.get("saoHuoTongShenJuejCheckBox").toString().equals("true"));
				Command.JframeSaoHuo.saoHuoZhanHunjCheckBox.setSelected(map.get("saoHuoZhanHunjCheckBox").toString().equals("true"));
			} catch (Exception e) {}
			
			Command.routeMapXArray[12][0]=lang.Integer_(map.get("routeMapXArray_12_0").toString(), -1);
			Command.routeMapXArray[12][1]=lang.Integer_(map.get("routeMapXArray_12_1").toString(), -1);
			Command.routeMapYArray[12][0]=lang.Integer_(map.get("routeMapYArray_12_0").toString(), -1);
			Command.routeMapYArray[12][1]=lang.Integer_(map.get("routeMapYArray_12_1").toString(), -1);
			
			Command.JForm.delayjComboBox.setSelectedIndex(lang.Integer_(map.get("delayjComboBox").toString(), 3));
			
			//Skill.form
			try {		//2.4.4->2.4.5
				Command.JframeSkill.jComboBox1Use.setSelectedIndex(lang.Integer_(map.get("skillJComboBox1Use").toString(), 0));
				Command.JframeSkill.jComboBox2Use.setSelectedIndex(lang.Integer_(map.get("skillJComboBox2Use").toString(), 0));
				Command.JframeSkill.jComboBox3Use.setSelectedIndex(lang.Integer_(map.get("skillJComboBox3Use").toString(), 0));
				Command.JframeSkill.jComboBox4Use.setSelectedIndex(lang.Integer_(map.get("skillJComboBox4Use").toString(), 0));
				Command.JframeSkill.jComboBox5Use.setSelectedIndex(lang.Integer_(map.get("skillJComboBox5Use").toString(), 0));
				
				Command.JframeSkill.jTextField1Key.setText(map.get("skillJTextField1Key").toString());
				Command.JframeSkill.jTextField2Key.setText(map.get("skillJTextField2Key").toString());
				Command.JframeSkill.jTextField3Key.setText(map.get("skillJTextField3Key").toString());
				Command.JframeSkill.jTextField4Key.setText(map.get("skillJTextField4Key").toString());
				Command.JframeSkill.jTextField5Key.setText(map.get("skillJTextField5Key").toString());
				
				Command.JframeSkill.jTextField1Time.setText(map.get("skillJTextField1Time").toString());
				Command.JframeSkill.jTextField2Time.setText(map.get("skillJTextField2Time").toString());
				Command.JframeSkill.jTextField3Time.setText(map.get("skillJTextField3Time").toString());
				Command.JframeSkill.jTextField4Time.setText(map.get("skillJTextField4Time").toString());
				Command.JframeSkill.jTextField5Time.setText(map.get("skillJTextField5Time").toString());
				
				//加载至Command数组中的数据
				Command.skillSetData[0][0]=lang.Integer_(map.get("skillSetData_0_0").toString(), 0);
				Command.skillSetData[0][1]=lang.Integer_(map.get("skillSetData_0_1").toString(), 0);
				Command.skillSetData[1][0]=lang.Integer_(map.get("skillSetData_1_0").toString(), 0);
				Command.skillSetData[1][1]=lang.Integer_(map.get("skillSetData_1_1").toString(), 0);
				Command.skillSetData[2][0]=lang.Integer_(map.get("skillSetData_2_0").toString(), 0);
				Command.skillSetData[2][1]=lang.Integer_(map.get("skillSetData_2_1").toString(), 0);
				Command.skillSetData[3][0]=lang.Integer_(map.get("skillSetData_3_0").toString(), 0);
				Command.skillSetData[3][1]=lang.Integer_(map.get("skillSetData_3_1").toString(), 0);
				Command.skillSetData[4][0]=lang.Integer_(map.get("skillSetData_4_0").toString(), 0);
				Command.skillSetData[4][1]=lang.Integer_(map.get("skillSetData_4_1").toString(), 0);
				
				action.Skill skill=new action.Skill();
				skill.jComboBox1UseItemStateChanged();
				skill.jComboBox2UseItemStateChanged();
				skill.jComboBox3UseItemStateChanged();
				skill.jComboBox4UseItemStateChanged();
				skill.jComboBox5UseItemStateChanged();
				skill=null;
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//SeniorFight.form
			try{	//2.5.4->3.1
				Command.JframeSeniorFight.jCheckBoxUseLanAnswer.setSelected(map.get("jCheckBoxUseLanAnswer").toString().equals("true"));
				Command.JframeSeniorFight.jTextFieldServerIP.setText(map.get("jTextFieldServerIP").toString());
				Command.JframeSeniorFight.jTextFieldFaqSendPort.setText(map.get("jTextFieldFaqSendPort").toString());
				Command.JframeSeniorFight.jCheckBoxAutoXiuLi.setSelected(map.get("jCheckBoxAutoXiuLi").toString().equals("true"));
				Command.JframeSeniorFight.jCheckBoxAutoEmptyParcel.setSelected(map.get("jCheckBoxAutoEmptyParcel").toString().equals("true"));
				Command.JframeSeniorFight.jTextFieldHoursStart.setText(map.get("jTextFieldHoursStart").toString());
				Command.JframeSeniorFight.jTextFieldHoursEnd.setText(map.get("jTextFieldHoursEnd").toString());
				Command.JframeSeniorFight.jCheckBoxXiuLi_UseMenPai.setSelected(map.get("jCheckBoxXiuLi_UseMenPai").toString().equals("true"));
				Command.JframeSeniorFight.jCheckBoxLanIpIsOnline.setSelected(map.get("jCheckBoxLanIpIsOnline").toString().equals("true"));
				
				new UIFunc().jPanelLanAnswer();
				new UIFunc().autoXiuLiItemStateChanged();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			map=null;
			lang=null;
		} catch (Exception e) {
			e.printStackTrace();
			new Func.File().log("加载界面UI数据时异常捕获:"+e.getMessage());
//			new Func.Message().showMessageDialog("加载界面配置数据失败！");
		}
	}
	
	/**
	 * 自动扫货风物志类加载数据
	 * <li>加载fengWuZhi.xnx3文件，若是加载中数据出错，则自动使用默认数据data.FengWuZhi()
	 */
	public void saoHuoFengWuZhiLoad(){
		Lang lang=new Func.Lang();
		Command.saoHuoFengWuZhi.clear();		//清空Map
		Command.saoHuoFengWuZhi=new data.FengWuZhi().fengWuZhiBak();
		
		try {
			String xnx3_content=new include.Module.TextFile().read(include.Command.thisFilePath+"\\config\\fengWuZhi.xnx3", "UTF-8");
			xnx3_content=include.Module.UrlTransition.urlToUtf8(xnx3_content);
			JSONArray j=JSONArray.fromObject(xnx3_content);
			List l=j.toList(j);
//			List l=new Pet().petBak();
			SaoHuoFunc saoHuoFunc=new SaoHuoFunc();
			Command.JframeSaoHuo.fengWuZhijTable.removeAll();	//移除所有的重新添加
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo.fengWuZhijTable.getModel();
			tableModel.getDataVector().clear();		//清空所有
			
			new Func.File().log("风物志载入："+l.size()+"条数据");
			for (int i = l.size()-1; i >-1; i--) {
				JSONArray jSub=JSONArray.fromObject(l.get(i));
				List lSub=jSub.toList(jSub);
				String key=jSub.getString(0);
				int value=lang.Integer_(jSub.getString(1), 2);
				Command.saoHuoFengWuZhi.put(key, value);
			}
			
			Set<Map.Entry<String, Integer>> set = Command.saoHuoFengWuZhi.entrySet();
	        for (Iterator<Map.Entry<String, Integer>> it = set.iterator(); it.hasNext();) {
	            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
	            Vector rowData = new Vector();
				rowData.add(entry.getKey());
				rowData.add(saoHuoFunc.moneyToString(entry.getValue()));
				rowData.add(entry.getValue());
				tableModel.insertRow(0, rowData);
				rowData=null;
	        }
			
			saoHuoFunc=null;
			new Func.File().log("加载自动扫货风物志类数据完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
		lang=null;
	}
	
	/**
	 * 自动扫货风物志类保存数据
	 */
	public void saoHuoFengWuZhiSave(){
		Lang lang=new Func.Lang();
		
		try {
			List<String[]> list=new ArrayList<String[]>();
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo.fengWuZhijTable.getModel();
			
			int length=tableModel.getRowCount();
			System.out.println("行数："+length);
			for (int i = 0; i < length; i++) {
//				map.put(tableModel.getValueAt(i, 0), tableModel.getValueAt(i, 2));
				String[] data={tableModel.getValueAt(i, 0).toString(),tableModel.getValueAt(i, 2).toString()};
				list.add(data);
				data=null;
			}
			JSONArray json=new JSONArray().fromObject(list);
//			System.out.println("数据-->"+json.toString());
			String jsonContent=include.Module.UrlTransition.utf8ToUrl(json.toString());
			String Str_file=include.Command.thisFilePath+"\\config\\fengWuZhi.xnx3";
			new include.Module.TextFile().write(Str_file, jsonContent);
			
			list=null;
			new Func.File().log("自动扫货风物志类数据保存完毕");
		} catch (Exception e) {
			new Func.File().log("自动扫货风物志类数据保存异常捕获:"+e.getMessage());
		}
		
		lang=null;
	}
	
	
	/**
	 * 自动扫货传奇配方类加载数据
	 * <li>加载legend.xnx3文件，若是加载中数据出错，则自动使用默认数据data.Legend()
	 */
	public void saoHuoLegendLoad(){
		Lang lang=new Func.Lang();
		Command.saoHuoLegend.clear();		//清空Map
		Command.saoHuoLegend=new data.Legend().legendBak();
		
		try {
			String xnx3_content=new include.Module.TextFile().read(include.Command.thisFilePath+"\\config\\legend.xnx3", "UTF-8");
			xnx3_content=include.Module.UrlTransition.urlToUtf8(xnx3_content);
			JSONArray j=JSONArray.fromObject(xnx3_content);
			List l=j.toList(j);
//			List l=new Pet().petBak();
			SaoHuoFunc saoHuoFunc=new SaoHuoFunc();
			Command.JframeSaoHuo.legendjTable.removeAll();	//移除所有的重新添加
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo.legendjTable.getModel();
			tableModel.getDataVector().clear();		//清空所有
			
			new Func.File().log("传奇配方载入："+l.size()+"条数据");
			for (int i = l.size()-1; i >-1; i--) {
				JSONArray jSub=JSONArray.fromObject(l.get(i));
				List lSub=jSub.toList(jSub);
				String key=jSub.getString(0);
				int value=lang.Integer_(jSub.getString(1), 2);
				Command.saoHuoLegend.put(key, value);
			}
			
			Set<Map.Entry<String, Integer>> set = Command.saoHuoLegend.entrySet();
	        for (Iterator<Map.Entry<String, Integer>> it = set.iterator(); it.hasNext();) {
	            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
	            Vector rowData = new Vector();
				rowData.add(entry.getKey());
				rowData.add(saoHuoFunc.moneyToString(entry.getValue()));
				rowData.add(entry.getValue());
				tableModel.insertRow(0, rowData);
				rowData=null;
	        }
			
			saoHuoFunc=null;
			new Func.File().log("加载自动扫货传奇配方类数据完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
		lang=null;
	}
	
	/**
	 * 自动扫货传奇配方类保存数据
	 */
	public void saoHuoLegendSave(){
		Lang lang=new Func.Lang();
		
		try {
			List<String[]> list=new ArrayList<String[]>();
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo.legendjTable.getModel();
			
			int length=tableModel.getRowCount();
			for (int i = 0; i < length; i++) {
				String[] data={tableModel.getValueAt(i, 0).toString(),tableModel.getValueAt(i, 2).toString()};
				list.add(data);
				data=null;
			}
			JSONArray json=new JSONArray().fromObject(list);
			String jsonContent=include.Module.UrlTransition.utf8ToUrl(json.toString());
			String Str_file=include.Command.thisFilePath+"\\config\\legend.xnx3";
			new include.Module.TextFile().write(Str_file, jsonContent);
			
			list=null;
			new Func.File().log("自动扫货传奇配方类数据保存完毕");
		} catch (Exception e) {
			new Func.File().log("自动扫货传奇配方类数据保存异常捕获:"+e.getMessage());
		}
		
		lang=null;
	}
	
	/**
	 * 其他分类加载数据
	 * <li>加载elseClass.xnx3文件，若是加载中数据出错，则自动使用默认数据data.ElseClass
	 */
	public void saoHuoElseClassLoad(){
		Lang lang=new Func.Lang();
		try {
			String xnx3_content=new include.Module.TextFile().read(include.Command.thisFilePath+"\\config\\elseClass.xnx3", "UTF-8");
			xnx3_content=include.Module.UrlTransition.urlToUtf8(xnx3_content);
			Map map=new include.Module.Json().StringToMap_try(xnx3_content);
			//杂货类加载数据,   data.Groceries()
			Command.saoHuoElseClass.clear();		//清空
			Command.saoHuoElseClass=new data.ElseClass().elseClassBak();
			try {
				Command.saoHuoElseClass.put("5级战魂", lang.Integer_(map.get("5级战魂").toString(), 2));
				Command.saoHuoElseClass.put("6级战魂", lang.Integer_(map.get("6级战魂").toString(), 2));
				Command.saoHuoElseClass.put("7级战魂", lang.Integer_(map.get("7级战魂").toString(), 2));
				Command.saoHuoElseClass.put("8级战魂", lang.Integer_(map.get("8级战魂").toString(), 2));
				Command.saoHuoElseClass.put("9级战魂", lang.Integer_(map.get("9级战魂").toString(), 2));
				Command.saoHuoElseClass.put("10级战魂", lang.Integer_(map.get("10级战魂").toString(), 2));
				
				Command.saoHuoElseClass.put("强力诀至尊属性", lang.Integer_(map.get("强力诀至尊属性").toString(), 2));
				Command.saoHuoElseClass.put("强力诀稀有属性", lang.Integer_(map.get("强力诀稀有属性").toString(), 2));
				Command.saoHuoElseClass.put("强力诀高级属性", lang.Integer_(map.get("强力诀高级属性").toString(), 2));
				Command.saoHuoElseClass.put("强力诀中级属性", lang.Integer_(map.get("强力诀中级属性").toString(), 2));
				Command.saoHuoElseClass.put("强力诀普通属性", lang.Integer_(map.get("强力诀普通属性").toString(), 2));
				
				Command.saoHuoElseClass.put("通神诀极品附灵属性", lang.Integer_(map.get("通神诀极品附灵属性").toString(), 2));
				Command.saoHuoElseClass.put("通神诀稀有附灵属性", lang.Integer_(map.get("通神诀稀有附灵属性").toString(), 2));
				Command.saoHuoElseClass.put("通神诀高级附灵属性", lang.Integer_(map.get("通神诀高级附灵属性").toString(), 2));
				Command.saoHuoElseClass.put("通神诀中级附灵属性", lang.Integer_(map.get("通神诀中级附灵属性").toString(), 2));
				Command.saoHuoElseClass.put("通神诀普通附灵属性", lang.Integer_(map.get("通神诀普通附灵属性").toString(), 2));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			SaoHuoFunc saoHuoFunc=new SaoHuoFunc();
			
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo. elseClassjTable.getModel();
			tableModel.getDataVector().clear();		//清空所有
			//遍历Map
			Set<Map.Entry<String, Integer>> set = Command.saoHuoElseClass.entrySet();
	        for (Iterator<Map.Entry<String, Integer>> it = set.iterator(); it.hasNext();) {
	            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
	            Vector rowData = new Vector();
				rowData.add(entry.getKey());
				rowData.add(saoHuoFunc.moneyToString(entry.getValue()));
				rowData.add(entry.getValue());
				tableModel.insertRow(0, rowData);
				rowData=null;
	        }
			
			saoHuoFunc=null;
			map=null;
			new Func.File().log("加载自动扫货其他分类数据完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
		lang=null;
	}
	
	/**
	 * 自动扫货其他分类保存数据
	 */
	public void saoHuoElseClassSave(){
		Lang lang=new Func.Lang();
		
		try {
			Map map=new HashMap();
			
			DefaultTableModel tableModel=(DefaultTableModel) Command.JframeSaoHuo.elseClassjTable.getModel();
			int length=tableModel.getRowCount();
			for (int i = 0; i < length; i++) {
				map.put(tableModel.getValueAt(i, 0), tableModel.getValueAt(i, 2)+"");
			}
			JSONArray json=new JSONArray().fromObject(map);
			String jsonContent=include.Module.UrlTransition.utf8ToUrl(json.toString());
			String Str_file=include.Command.thisFilePath+"\\config\\elseClass.xnx3";
			new include.Module.TextFile().write(Str_file, jsonContent);
			
			map=null;
			new Func.File().log("自动扫货其他分类数据保存完毕");
		} catch (Exception e) {
			new Func.File().log("自动扫货其他分类数据保存异常捕获:"+e.getMessage());
		}
		
		lang=null;
	}
}
