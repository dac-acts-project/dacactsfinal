package com.project.coursemgmt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coursemgmt.daos.FacultyRepository;
import com.project.coursemgmt.daos.ModulesRepository;
import com.project.coursemgmt.pojos.FacultyPojo;
import com.project.coursemgmt.pojos.ModulePojo;

@RestController
@RequestMapping("/schedular")
public class SchedulerController {
	
	@Autowired
	ModulesRepository mod_repo;
	@Autowired
	FacultyRepository f_repo;
	
	@GetMapping("/modules")
	public List<ModulePojo> getModuleWithfaculties() {
		return mod_repo.findAll();
	}
	
	@GetMapping("/faculties/{moduleId}")
	public List<FacultyPojo> getFacultyDetails(@PathVariable Integer moduleId){
		
		System.out.println(mod_repo.findById(moduleId).get().getFaculties());
		return mod_repo.findById(moduleId).get().getFaculties();
	}

	@GetMapping("/labfaculties/{moduleId}")
	public List<FacultyPojo> getLabFaculties(@PathVariable Integer moduleId){
		List<FacultyPojo> lisTosend=new ArrayList<>();
		List<FacultyPojo> faculties=mod_repo.findById(moduleId).get().getFaculties();
		System.out.println(faculties);
		for (FacultyPojo facultyPojo : faculties) {
			if(facultyPojo.getLab())
				lisTosend.add(facultyPojo);
			}
		return lisTosend;
		
	}
	
	@PostMapping("/timetable/{facultyId}")
	public String setTimetable(@RequestBody List<Integer> confirmedDateList,@PathVariable Integer facultyId)
	{
		return "success";
	}
}
