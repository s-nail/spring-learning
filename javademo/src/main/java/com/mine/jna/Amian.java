package com.mine.jna;

import java.io.File;

import com.sun.jna.Native;

public class Amian {
	public static void main(String[] args) {
		//系统 Windows 或者 Linux
		String osName = System.getProperties().getProperty("os.name").toLowerCase();
		//架构 x86 或者 amd64
		String osArch = System.getProperties().getProperty("os.arch").toLowerCase();
		System.out.println("操作系统: "+osName+"; "+osArch);
		
		// 调用dll的文件名
		String fileName = null;
		//64位
		if(osArch.indexOf("64")!=-1){
			if(osName.indexOf("win")!=-1){
				// win
				fileName = "test_64.dll"; 
			}else{ 
				// linux
				fileName = "test_64.so"; 
			}
			test(System.getProperty("user.dir") + File.separator + fileName);
			
		}else if(osArch.indexOf("86")!=-1){//32位
			if(osName.indexOf("win")!=-1){
				fileName = "test_32.dll";
			}else{
				fileName = "test_32.so";
			}
			test(System.getProperty("user.dir") + File.separator + fileName);
			
		}else{//不支持的
			System.out.println("This OS is not support！不支持这个操作系统!");
		}
		
		System.out.println("调用dll绝对路径: "+System.getProperty("user.dir") + File.separator + fileName);
		
	}
	
	private static void test(String path) {
		//jna linux相对路径调用c/c++接口时候，名称必须是lib开头，且第一个参数是lib后面的名称，如libtest.so,加载时候应该使用test来加载
		//jna win相对路径调用c/c++接口时候，直接名称不加后缀调用，如test.dll,加载时候应该使用test来加载
		//jna linux绝对路径调用c/c++接口时候，完整路径加上后缀，如test.so,加载时候应该使用/opt/test.so来加载
		//jna win相对路径调用c/c++接口时候，完整路径可以不接后缀，如test.dll,加载时候应该使用D:\\test来加载
//		Test lib = (Test) Native.loadLibrary("test_64", Test.class);
		Test lib = (Test) Native.load(path, Test.class);
		// 例1
		int re1 = lib.add(11, 9);
		System.out.println("j-例1：addresult = " + re1);
		// 例2
		int len = 3;
		int[] a = { 11, 18, 21 };
		int[] b = { 44, 56, 100 };
		int[] c = new int[3];
		lib.addArray(a, b, c, len);
		for (int i = 0; i < len; i++) {
			System.out.println("j-例2：addArray" + (i + 1) + " = " + c[i]);
		}
		// 例3
		String inputString1 = "Hello,";
		String inputString2 = "Word";
		String outputString = lib.stringFun(inputString1,inputString2);
		System.out.println("C-j-例3：outputString = " + outputString);
	}
}
