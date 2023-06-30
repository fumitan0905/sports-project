package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer playerId;

	private String name;

	private Integer height;

	private Integer weight;

	private Integer age;

	private String position;

	private String birthplace;

	@Column(name = "body_fat_per")
	private Integer bodyFatPer;

	public Player() {

	}

	public Player(Integer id, Integer bodyFatPer) {
		this.id = id;
		this.bodyFatPer = bodyFatPer;

	}
}