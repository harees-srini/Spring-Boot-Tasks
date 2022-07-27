package com.example.crud2.crudDemo2;

import java.io.Serializable;


public class Mstm_User_Category_DTO implements Serializable{
	private String name;
	private String code;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
