package com.intranetcmv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intranetcmv.model.PostModel;
import com.intranetcmv.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Transactional(readOnly = false)
	public void salvar(PostModel postModel) {
		postRepository.save(postModel);
	}

}
