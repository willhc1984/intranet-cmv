package com.intranetcmv.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intranetcmv.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	//Optional<UserModel> findByUserName(String userName);
	
	 @Query("select u from UserModel u where u.username like :username") 
	 UserModel findByUsername(@Param("username") String username);
	 
	 }
