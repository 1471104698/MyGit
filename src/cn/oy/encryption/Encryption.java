package cn.oy.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {		//加密算法
	public static String hash(String msg) throws NoSuchAlgorithmException {
//		int a=1008611;
//		int b=1008612;
//		int hash=0;
//		for(int i=0;i<key.length();i++) {
//			hash+=a*hash+key.charAt(i);									//0x7FFFFFFF 是32位最大带符号整数
//			a*=b;
//		}
//		
//		String pwd=(hash&0x7FFFFFFF)+"";
//		return pwd;
	 	
//	System.out.println("原文是：" + msg);	
	MessageDigest md;		
	md = MessageDigest.getInstance("MD5");	
	md.update(msg.getBytes());		//更新摘要
	byte[] encrypMsg = md.digest();
//	 System.out.println("加密后是：" + new String(encrypMsg));
	 msg=new String(encrypMsg);
	return msg;		
	
	}
}