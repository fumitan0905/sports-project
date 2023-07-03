package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		List<Player> playerList = playerRepository.findByOrderById();
		List<Performance> playerPerformance = performanceRepository.findByOrderByIdAsc();
		m.addAttribute("playerPerformance", playerPerformance);
		m.addAttribute("playerList", playerList);
		return "performance";
	}

	@GetMapping("/admin/performance/{id}/edit")
	public String edit(
			@PathVariable("id") Integer id,
			Model m) {
		if (id == null) {
			return "performance";
		} else if (id != null) {
			Performance playerPerformance = performanceRepository.findById(id).get();
			Player player = playerRepository.findById(id).get();
			m.addAttribute("player", player);
			m.addAttribute("pp", playerPerformance);
		}
		return "performanceDetail";

	}

	@PostMapping("/admin/performance/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam(value = "goals", defaultValue = "") Integer goals,
			@RequestParam(value = "asists", defaultValue = "") Integer asists,
			@RequestParam(value = "foul", defaultValue = "") Integer foul,
			@RequestParam(value = "fouled", defaultValue = "") Integer fouled,
			@RequestParam(value = "yellowcard", defaultValue = "") Integer yellowcard,
			@RequestParam(value = "redcard", defaultValue = "") Integer redcard,
			@RequestParam(value = "games", defaultValue = "") Integer games,
			@RequestParam(value = "playerId", defaultValue = "") Integer playerId,
			Model m) {
		Performance performance = new Performance(id, goals, asists, foul, fouled, yellowcard, redcard, games,
				playerId);
		performanceRepository.save(performance);
		return "redirect:/admin/performance";
	}

}
