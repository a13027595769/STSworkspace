package com.mypack.login;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception {
		if("admin".equals(username)&&"root".equals(password)) {
			System.out.println("登录成功");
		}else {
			System.out.println("输入错误");
		}
		return NONE;
	}
}
