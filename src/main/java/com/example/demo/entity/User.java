package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Getter
	private Integer id; 

	@Getter 
	private String memberID;
	
	@Getter
	private String name; 

	@Getter
	private Integer role; 
	
	@Getter
	private String password; 

	// コンストラクタ
	public User() {
		
	}
	
	public User(String memberID, String name, Integer role, String password) {
		this.memberID = memberID;
		this.name = name;
		this.role = role;
		this.password = password;
	}
}
