package com.intranetcmv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	
	@GetMapping("/blog-post")
	public String blogPost(){
		return "posts/blog-post";
	}
	
	@GetMapping("/add-post")
	public String criarPost(){
		return "posts/criar-post";
	}

}
