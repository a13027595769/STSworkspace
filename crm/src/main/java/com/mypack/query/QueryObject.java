package com.mypack.query;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class QueryObject {
	private Integer page;
	private Integer rows;
	
	public Integer getStart() {
		return (this.page-1) * rows;
	}
}
