package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	
	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	UserRepository userRepository;

	@GetMapping({ "/", "/login", "/logout" })
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {
		// セッション情報を全てクリアする
		session.invalidate();

		// エラーパラメータのチェック
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインしてください");
		}

		return "login";
	}
	
	// ログインを実行
	@PostMapping("/login")
	public String login(
			@RequestParam(name = "memberID") String memberID,
			@RequestParam(name = "password") String password,
			Model model) {
		
		User user = null;

		Optional<User> record = userRepository.findByMemberIDAndPassword(memberID, password);

		if (record.isEmpty() == false) {
			user = record.get();
		}

		// 名前が空の場合にエラーとする
		if (user == null) {
			model.addAttribute("message", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}

		// セッション管理されたアカウント情報にIDと名前をセット
		Integer id = user.getId();
		String name = user.getName();
		
		account.setId(id);
		account.setName(name);

		return "index";
	}
}
