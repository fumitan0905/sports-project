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
@Table(name="performance")
public class Performance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer goals;
	
	private Integer asists;
	
	private Integer foul;
	
	private Integer fouled;
	
	private Integer yellowcard;
	
	private Integer redcard;
	
	private Integer games;
	
	@Column(name = "player_id")
	private Integer playerId;

}
