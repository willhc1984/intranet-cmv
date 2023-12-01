package com.intranetcmv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.intranetcmv.service.UserDetailsServiceImp;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImp userDetailsServiceImp;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http	
			.authorizeRequests()
			.antMatchers("/", "/css/**", "/images/**", "/js/**", "/blog-post").permitAll()			
			.anyRequest().authenticated()			
				.and()
					.formLogin().loginPage("/login")
					.defaultSuccessUrl("/", true)
					.failureUrl("/login-error")
					.permitAll()
				.and()
					.logout()
					.logoutSuccessUrl("/")
				.and()
					.exceptionHandling()
					.accessDeniedPage("/acesso-negado");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImp).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
