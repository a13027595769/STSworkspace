package com.mypack;

public class Test6 {
	public static void main(String[] args) {
			
		System.out.println(f(100));
	}
	
	public static int f(int n) {
		if(n<1) {
			throw new IllegalArgumentException(n+"不能小于1");
		}
		if(n==1||n==2) {
			return n;
		}
		return f(n-2) + f(n-1);
	}
	
}

