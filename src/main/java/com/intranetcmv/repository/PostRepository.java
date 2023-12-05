package com.intranetcmv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intranetcmv.model.PostModel;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long>{

}
