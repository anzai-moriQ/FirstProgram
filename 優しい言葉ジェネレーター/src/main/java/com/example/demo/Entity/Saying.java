package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="saying")
public class Saying {
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="code")
	private Integer code;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="word")
	private String word;

	public Saying() {
		super();
	}

	public Saying(Integer code, String grade, String word) {
		super();
		this.code = code;
		this.grade = grade;
		this.word = word;
	}

	public Integer getCode() {
		return code;
	}

	public String getGrade() {
		return grade;
	}

	public String getWord() {
		return word;
	}

}
