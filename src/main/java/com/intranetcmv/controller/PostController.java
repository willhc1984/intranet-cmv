package com.intranetcmv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.intranetcmv.model.PostModel;
import com.intranetcmv.service.PostService;

@Controller
@RequestMapping("posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/blog-post")
	public String blogPost(){
		return "/posts/blog-post";
	}
	
	@GetMapping("/add-post")
	public String criarPost(PostModel postModel){
		return "posts/criar-post";
	}
	
	@PostMapping("/salvar")
	public String salvar(PostModel postModel, RedirectAttributes attr) {
		postService.salvar(postModel);
		attr.addFlashAttribute("sucesso", "Post salvo!");
		return "redirect:/posts/add-post";
	}
	
}
