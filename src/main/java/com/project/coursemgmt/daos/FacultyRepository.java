package com.project.coursemgmt.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.coursemgmt.pojos.FacultyPojo;

public interface FacultyRepository extends JpaRepository<FacultyPojo,Integer> {
	
	

}
