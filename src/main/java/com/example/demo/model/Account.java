package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data
@Component
@SessionScope
public class Account {
	//フィールド
	private Integer id;
	private String name;
	
	//コンストラクタ
	public Account() {
		
	}

	public Account(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
}
