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

	@PostMapping("/admin/performance/{playerId}/edit")
	public String update(
			@PathVariable("playerId") Integer playerId,
			@RequestParam(value = "goals", defaultValue = "") Integer goals,
			@RequestParam(value = "asists", defaultValue = "") Integer asists,
			@RequestParam(value = "foul", defaultValue = "") Integer foul,
			@RequestParam(value = "fouled", defaultValue = "") Integer fouled,
			@RequestParam(value = "yellowcard", defaultValue = "") Integer yellowcard,
			@RequestParam(value = "redcard", defaultValue = "") Integer redcard,
			@RequestParam(value = "games", defaultValue = "") Integer games,
			Model m) {
		Performance performance = performanceRepository.findByPlayerId(playerId).get();
		
		performance.setGoals(goals);
		performance.setAsists(asists);
		performance.setFoul(foul);
		performance.setFouled(fouled);
		performance.setYellowcard(yellowcard);
		performance.setRedcard(redcard);
		performance.setGames(games);
//		Performance performance = new Performance(id, goals, asists, foul, fouled, yellowcard, redcard, games,
//				playerId);
		performanceRepository.save(performance);
		return "redirect:/admin/performance";
	}

	@GetMapping("/admin/performance/add")
	public String addpage() {
		return "addPlayer";
	}

	@PostMapping("/admin/performance/add")
	public String create(
			@RequestParam(value = "playerId", defaultValue = "") Integer playerId,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "height", defaultValue = "") Integer height,
			@RequestParam(value = "weight", defaultValue = "") Integer weight,
			@RequestParam(value = "age", defaultValue = "") Integer age,
			@RequestParam(value = "position", defaultValue = "") String position,
			@RequestParam(value = "birthplace", defaultValue = "") String birthplace,
			@RequestParam(value = "bodyFatPer", defaultValue = "") Integer bodyFatPer,
			@RequestParam(value = "goals", defaultValue = "") Integer goals,
			@RequestParam(value = "asists", defaultValue = "") Integer asists,
			@RequestParam(value = "foul", defaultValue = "") Integer foul,
			@RequestParam(value = "fouled", defaultValue = "") Integer fouled,
			@RequestParam(value = "yellowcard", defaultValue = "") Integer yellowcard,
			@RequestParam(value = "redcard", defaultValue = "") Integer redcard,
			@RequestParam(value = "games", defaultValue = "") Integer games,
			Model m) {
		Player player = new Player(playerId,name,height,weight,age,position,birthplace,bodyFatPer);
		playerRepository.save(player);
		Performance performance = new Performance(goals,asists,foul,fouled,yellowcard,redcard,games,player.getId());
		
		performanceRepository.save(performance);
		return "redirect:/admin/performance";
	}

}
