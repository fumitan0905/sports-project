package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Performance;
import com.example.demo.entity.Player;
import com.example.demo.repository.PerformanceRepository;
import com.example.demo.repository.PlayerRepository;

@Controller
public class PerformanceController {
	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	PerformanceRepository performanceRepository;

	@GetMapping("/admin/performance")
	public String index(
			Model m) {
		List<Player> playerList = playerRepository.findAll();
		m.addAttribute("playerList", playerList);
		return "performance";
	}

	@GetMapping("/admin/performance/{id}")
	public String detail(
			@PathVariable("id") Integer id,
			Model m) {
		if (id == null) {
			return "performance";
		} else if (id != null) {
			Performance playerPerformance = performanceRepository.findByPlayerId(id).get();
			m.addAttribute("playerPerformance", playerPerformance);
		}
		return "performanceDetail";

	}

}
