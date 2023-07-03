package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="health")
public class Health {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "player_health_id")
	private Integer playerHealthId;
	
	@Column(name = "wakeup_time")
	private String wakeupTime;
	
	@Column(name = "bedtime_time")
	private String bedtimeTime;
	
	@Column(name = "cooking_id")
	private Integer cookingId;
	
	@Column(name = "eat_date")
	private LocalDate eatDate;

}
