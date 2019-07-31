package com.project.coursemgmt.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.coursemgmt.pojos.CommonLoginPojo;

public interface CommonLoginDao extends JpaRepository<CommonLoginPojo, String> {
	
	
	
	Optional<CommonLoginPojo> findById(String id) ;
	
		boolean existsById(String id);
	
	  
		
}
