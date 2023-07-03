package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Cook;
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

		List<Player> playerList = playerRepository.findByOrderById();
		m.addAttribute("playerList", playerList);

		LocalDate now = LocalDate.now();

//		if (year != null && month != null && day != null) {
//
//			LocalDate search = LocalDate.of(year, month, day);
//			List<Health> finds = healthRepository.findByEatDate(search);
//			m.addAttribute("finds", finds);
//			m.addAttribute("year", year);
//			m.addAttribute("month", month);
//			m.addAttribute("day", day);
//			return "healthDate";
//		}

		year = year != null ? year : now.getYear();
		month = month != null ? month : now.getMonthValue();
		day = day != null ? day : now.getDayOfMonth();

		LocalDate date = LocalDate.of(year, month, 1);
		System.out.println(date);

		int max = date.lengthOfMonth();
		System.out.println(max);

		int week = date.getDayOfWeek().getValue();
		System.out.println(week);

		m.addAttribute("date", date);
		m.addAttribute("max", max);
		m.addAttribute("week", week == 7 ? 0 : week);
		m.addAttribute("year", year);
		m.addAttribute("month", month.toString().length() == 1 ? "0" + month : month);

		m.addAttribute("lastYear", month - 1 < 1 ? year - 1 : year);
		m.addAttribute("lastMonth", month - 1 < 1 ? 12 : month - 1);
		m.addAttribute("nextYear", month + 1 > 12 ? year + 1 : year);
		m.addAttribute("nextMonth", month + 1 > 12 ? 1 : month + 1);

		return "health";
	}
	
	@GetMapping("/admin/health/information")
	public String information(
			@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "month", required = false) Integer month,
			@RequestParam(value = "day", required = false) Integer day,
			Model m) {

		List<Player> playerList = playerRepository.findByOrderById();
		m.addAttribute("playerList", playerList);
		
		List<Cook> cookList = cookRepository.findAll();
		m.addAttribute("cookList",cookList);
 
		if (year != null && month != null && day != null) {

			LocalDate search = LocalDate.of(year, month, day);
			List<Health> finds = healthRepository.findByEatDate(search);
			m.addAttribute("finds", finds);
			m.addAttribute("year", year);
			m.addAttribute("month", month);
			m.addAttribute("day", day);
		}
		
		return "healthDate";
	}


	//	private List<List<Integer>> generateCalendarRows(int year, int month) {
	//		List<List<Integer>> rows = new ArrayList<>();
	//
	//		YearMonth yearMonth = YearMonth.of(year, month + 1);
	//		int numberOfDays = yearMonth.lengthOfMonth();
	//
	//		List<Integer> row = new ArrayList<>();
	//		for (int day = 1; day <= numberOfDays; day++) {
	//			row.add(day);
	//			if (row.size() == 7) {
	//				rows.add(row);
	//				row = new ArrayList<>();
	//			}
	//		}
	//		if (!row.isEmpty()) {
	//			rows.add(row);
	//		}
	//
	//		return rows;
	//	}

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
			@RequestParam(value = "playerId", defaultValue = "") Integer playerId,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "height", defaultValue = "") Integer height,
			@RequestParam(value = "weight", defaultValue = "") Integer weight,
			@RequestParam(value = "age", defaultValue = "") Integer age,
			@RequestParam(value = "birthplace", defaultValue = "") String birthplace,
			@RequestParam(value = "position", defaultValue = "") String position,
			@RequestParam(value = "bodyFatPer", defaultValue = "") Integer bodyFatPer,
			Model m) {
		Player player = new Player(id, playerId, name, height, weight, age, position, birthplace, bodyFatPer);
		playerRepository.save(player);
		return "redirect:/admin/health";
	}

}
