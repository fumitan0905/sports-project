package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Performance;

public interface PerformanceRepository extends JpaRepository<Performance,Integer>{
 Optional<Performance> findByPlayerId(Integer playerId);
 List<Performance> findByOrderByIdAsc();
}
