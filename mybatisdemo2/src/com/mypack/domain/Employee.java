package com.mypack.domain;


public class Employee {
	private Long id;
	private String name;
	private Department dept;//员工所在部门对象
	
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
}
