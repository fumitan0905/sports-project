package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Health;

public interface HealthRepository extends JpaRepository<Health, Integer> {
	Optional<Health> findByPlayerHealthId(Integer playerHealthId);
	
	List<Health> findByEatDate(LocalDate eatDate);
}
