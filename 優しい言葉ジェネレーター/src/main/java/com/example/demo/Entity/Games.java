package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="games")
public class Games {
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="code")
	private Integer code;
	
	@Column(name="grade")
	private Integer grade;
	
	@Column(name="name")
	private String name;
	
	@Column(name="caption")
	private String caption;

	public Games() {
		super();
	}

	public Games(Integer grade, String name, String caption) {
		super();
		this.grade = grade;
		this.name = name;
		this.caption = caption;
	}

	public Integer getCode() {
		return code;
	}

	public Integer getGrade() {
		return grade;
	}

	public String getName() {
		return name;
	}

	public String getCaption() {
		return caption;
	}
}
