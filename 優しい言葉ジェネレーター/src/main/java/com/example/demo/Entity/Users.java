package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="code")
	private Integer code;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;

	public Users() {
		super();
	}

	public Users(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public Users(Integer code, String name, String password) {
		super();
		this.code = code;
		this.name = name;
		this.password = password;
	}
	
	public void deleteUser(Integer code) {
		
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	

}
