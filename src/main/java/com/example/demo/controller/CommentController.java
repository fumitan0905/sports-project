package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Comment;
import com.example.demo.model.Account;
import com.example.demo.repository.CommentRepository;

@Controller
public class CommentController {
	
	@Autowired
	Account account;
	
	@Autowired
	CommentRepository commentRepository;

	
	@GetMapping("/admin/comment")
	public String comment(
			Model model) {
		return "comment";
	}

	@PostMapping("/upload")
	public String upload(
			@RequestParam(name="title",required = false) String title,
			@RequestParam(name="content",required = false) String content,
			Model model) {
		
		String name = account.getName();
		//LocalDateTime createdAt = LocalDateTime.now();

		Comment comment = new Comment(title, name, content);
		
		commentRepository.save(comment);

		return "comment";
	}

	@GetMapping("/comment/archive")
	public String archive(Model model
			)
	{
		List<Comment> commentList = null;
		commentList = commentRepository.findAll();
		model.addAttribute("comments",commentList);
		return "commentArchive";
	}


}
