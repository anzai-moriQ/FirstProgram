package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="words")
public class Words {
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="code")
	private Integer code;
	
	@Column(name="stress")
	private Integer stress;
	
	@Column(name="word")
	private String word;

	public Words() {
		super();
	}

	public Words( Integer stress, String word) {
		super();
		this.stress = stress;
		this.word = word;
	}

	public Integer getCode() {
		return code;
	}

	public Integer getStress() {
		return stress;
	}

	public String getWord() {
		return word;
	}
	
	
}
