package com.mine.jna;

import com.sun.jna.Library;

public interface Test extends Library{

	// c代码: int add(int a,int b)
	int add(int a, int b);  

	// c代码: void addArray(int *a,int *b, int *c, int len)
	void addArray(int[] a, int[] b, int[] c,int len);  

	// c代码: char* stringFun(char *str1,char *str2)
	String stringFun(String str1,String str2);

}
