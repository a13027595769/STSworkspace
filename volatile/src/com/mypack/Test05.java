package com.mypack;

import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) {
		int i=1;
		String str = "hello";
		Integer num = 200;
		int[] arr = {1,2,3,4,5};
		MyDate date = new MyDate();
		change(i, str, num, arr, date);
		System.out.println("i="+i);
		System.out.println("str="+str);
		System.out.println("num="+num);
		System.out.println("arr="+Arrays.toString(arr));
		System.out.println("date="+date.a);
	
	}
	
	public static void change(int i,String str,Integer n,int[] a,MyDate m) {
		
		i +=1;
		str += "world";
		n += 1;
		a[0] += 1;
		m.a+=1;
	}
}

class MyDate{
	
	int a = 10;
	
}
