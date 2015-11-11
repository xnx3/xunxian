package include.Module;

import include.Command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class TextFile {
	
	/**
	 * 读文本文件，返回文件信息
	 * path:文件路径，encode:文件编码.如UTF-8,GBK
	 */
	public String read(String path,String encode){
		StringBuffer xnx3_content=new StringBuffer();
		try{
			File file=new File(path);
			BufferedReader xnx3_reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),encode));
			String date=null;
			while((date=xnx3_reader.readLine())!=null){
				xnx3_content.append(date);
			}
			xnx3_reader.close();
		}catch (Exception e) {
		}
		
		return xnx3_content.toString();
	}
	public String read(File file,String encode){
		StringBuffer xnx3_content=new StringBuffer();
		try{
			BufferedReader xnx3_reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),encode));
			String date=null;
			while((date=xnx3_reader.readLine())!=null){
				xnx3_content.append(date);
			}
			xnx3_reader.close();
		}catch (Exception e) {
		}
		
		return xnx3_content.toString();
	}
	
	
	
	/*
	 * boolean
	 * 传入要保存至的路径————如D:\\a.txt
	 * 传入要保存的内容，String content
	 */

	public boolean write(String path,String xnx3_content){
		try {
			FileWriter fw=new FileWriter(path);
			java.io.PrintWriter pw=new java.io.PrintWriter(fw);
			pw.print(xnx3_content);
			pw.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean write(File file,String xnx3_content){
		try {
			java.io.PrintWriter pw=new java.io.PrintWriter(file);
			pw.print(xnx3_content);
			pw.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(new TextFile().read("F:\\MyEclipseWordspace\\xunxianAutoFight\\log.txt", "utf-8").replaceAll(" ", Command.lineNotePad));
		
	}
}
