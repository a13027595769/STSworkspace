package com.mypack.entity;

import com.mysql.fabric.xmlrpc.base.Data;

public class Item {
	int itemId;//���ﳵ��Ʒ��Ŀ���
	Goods good;//��Ʒid 
	int nums;//��������
	Data time;//�µ�ʱ��
	double xiaoji;//�����С��
	double zongji;//�ܼ�
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Item(Goods good, int nums, double xiaoji, double zongji) {
		super();
		this.good = good;
		this.nums = nums;
		
		this.xiaoji = xiaoji;
		this.zongji = zongji;
	}

	public Item(int itemId, Goods good, int nums, Data time, double xiaoji,
			double zongji) {
		super();
		this.itemId = itemId;
		this.good = good;
		this.nums = nums;
		this.time = time;
		this.xiaoji = xiaoji;
		this.zongji = zongji;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public Goods getGood() {
		return good;
	}
	public void setGood(Goods good) {
		this.good = good;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public Data getTime() {
		return time;
	}
	public void setTime(Data time) {
		this.time = time;
	}
	public double getXiaoji() {
		return xiaoji;
	}
	public void setXiaoji(double xiaoji) {
		this.xiaoji = xiaoji;
	}
	public double getZongji() {
		return zongji;
	}
	public void setZongji(double zongji) {
		this.zongji = zongji;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", good" + good + ", nums=" + nums
				+ ", time=" + time + ", xiaoji=" + xiaoji + ", zongji="
				+ zongji + "]";
	}
	
	
	

}
