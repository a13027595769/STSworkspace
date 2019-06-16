package com.mypack;

public class Test7 {
	public static void main(String[] args) {
			
		System.out.println(loop(40));
	}
	
	public static int loop(int n) {
		if(n<1) {
			throw new IllegalArgumentException(n+"不能小于1");
		}
		if(n==1||n==2) {
			return n;
		}
		int one = 2;//初始化为走到第二阶台阶的走法
		int two = 1;//初始化为走到第一节台阶的走法
		int sum = 0;
		for(int i=3;i<n;i++) {
			//最后跨两步+最后跨一步
			sum = two + one;
			two = one;
			one = sum;
		}
		return sum;
		
		
	}
	
}

