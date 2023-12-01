package com.intranetcmv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intranetcmv.model.RoleModel;
import com.intranetcmv.model.UserModel;
import com.intranetcmv.repository.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImp implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public UserModel findByName(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = findByName(username);
		return new User(userModel.getUsername(),userModel.getPassword(),
				AuthorityUtils.createAuthorityList(getAuthorities(userModel.getRoles())));
	}
	
	private String[] getAuthorities(List<RoleModel> roles) {
		String[] authorities = new String[roles.size()];
		for(int i = 0; i < roles.size(); i++) {
			authorities[i] = roles.get(i).getRoleName().toString();
		}
		return authorities;
	}

}
