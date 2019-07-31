package com.project.coursemgmt.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.coursemgmt.pojos.ModulePojo;

public interface ModulesRepository extends JpaRepository<ModulePojo,Integer> {

}
