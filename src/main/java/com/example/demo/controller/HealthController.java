package com.example.demo.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Health;
import com.example.demo.entity.Player;
import com.example.demo.repository.CookRepository;
import com.example.demo.repository.HealthRepository;
import com.example.demo.repository.PlayerRepository;

@Controller
@SpringBootApplication
public class HealthController {

	@Autowired
	HealthRepository healthRepository;

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	CookRepository cookRepository;

	@GetMapping("/admin/health")
	public String index(
			@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "month", required = false) Integer month,
			@RequestParam(value = "day", required = false) Integer day,
			Model m) {
		
		List<Player> playerList = playerRepository.findAll();
		m.addAttribute("playerList", playerList);

		Calendar rightNow = Calendar.getInstance();
		if (year == null) {
			year = rightNow.get(Calendar.YEAR);
		}
		if (month == null) {
			month = rightNow.get(Calendar.MONTH);
		}
		if (year != null && month != null && day != null) {
			
			LocalDate search = LocalDate.of(year, month, day);
			List<Health> finds =  healthRepository.findByEatDate(search);
			m.addAttribute("finds",finds);
			return "healthDate";
		}

		List<List<Integer>> rows = generateCalendarRows(year, month);
		m.addAttribute("year", year);
		m.addAttribute("month", month);
		m.addAttribute("rows", rows);

		return "health";
	}

	private List<List<Integer>> generateCalendarRows(int year, int month) {
		List<List<Integer>> rows = new ArrayList<>();

		YearMonth yearMonth = YearMonth.of(year, month + 1);
		int numberOfDays = yearMonth.lengthOfMonth();

		List<Integer> row = new ArrayList<>();
		for (int day = 1; day <= numberOfDays; day++) {
			row.add(day);
			if (row.size() == 7) {
				rows.add(row);
				row = new ArrayList<>();
			}
		}
		if (!row.isEmpty()) {
			rows.add(row);
		}

		return rows;
	}

	@GetMapping("/admin/health/{id}/edit")
	public String detail(
			@PathVariable("id") Integer id,
			Model m) {
		if (id == null) {
			return "health";
		} else if (id != null) {

			Player player = playerRepository.findById(id).get();
			m.addAttribute("player", player);
		}
		return "healthDetail";
	}

	@PostMapping("/admin/health/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam(value = "bodyFatPer", defaultValue = "") Integer bodyFatPer,
			Model m) {
		Player player = new Player(id, bodyFatPer);
		playerRepository.save(player);
		return "redirect:/admin/health";
	}

}
