package com.intranetcmv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.intranetcmv.model.UserModel;
import com.intranetcmv.repository.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("erro"));
		return userModel;
	}

}
