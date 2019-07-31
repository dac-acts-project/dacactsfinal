package com.project.coursemgmt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coursemgmt.daos.CalendarRepository;
import com.project.coursemgmt.daos.FacultyRepository;
import com.project.coursemgmt.daos.ModulesRepository;
import com.project.coursemgmt.pojos.Calendar;
import com.project.coursemgmt.pojos.FacultyPojo;
import com.project.coursemgmt.pojos.ModulePojo;
import com.project.coursemgmt.services.CalendarUtilities;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ModulesRepository modules;
	@Autowired
	private CalendarUtilities calservice;
	@Autowired
	private FacultyRepository faculties;
	
	@Autowired
	CalendarRepository calrepo;

	@GetMapping("/modules")
	public List<ModulePojo> populateModules() {

		return modules.findAll();
	}
	
	@GetMapping("/modules/{id}")
	public ModulePojo specificModule(@PathVariable Integer id)
	{
		if(modules.existsById(id))
		return modules.findById(id).get();
		else
			return null;
	}
	

	@PostMapping("/modules")
	public String modulesAdd(@RequestBody ModulePojo p) {

		try {
			modules.save(p);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"present \"}";
		}

	}
	

	@PutMapping("/modules")
	public String modulesUpdate(@RequestBody ModulePojo p) {
		/*
		 * ModulePojo update=modules.findById(p.getModule_id()).get(); p=update;
		 */
		try {
			modules.saveAndFlush(p);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"error in updating\"}";
		}

	}

	@DeleteMapping("/modules/{id}")
	public String moduleDelete(@PathVariable Integer id) {
		try {
			modules.deleteById(id);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"error in deleting\"}";
		}
	}
	
	
	@GetMapping("/faculty")
	public List<FacultyPojo> populateFaculty() {

		return faculties.findAll();
	}
	
	

	@PostMapping("/faculty")
	public String facultyAdd(@RequestBody FacultyPojo p) {

		try {
			faculties.save(p);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"present\" }";
		}

	}
	@GetMapping("/faculty/{id}")
	public List<ModulePojo> facultyGetInfo(@PathVariable Integer id) {

		try {
			
			
			
			return faculties.findById(id).get().getModules();
		} catch (Exception e) {
			return null;
		}

	}

	@PutMapping("/faculty/{id}")
	public String facultypdate(@RequestBody FacultyPojo p,@PathVariable String id) {
		/*
		 * ModulePojo update=modules.findById(id).get(); p=update;
		 */
		try {
			faculties.save(p);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"duplicate entry for this module\"}";
		}

	}

	@DeleteMapping("/faculty/{id}")
	public String facultyDelete(@PathVariable Integer id) {
		try {
			faculties.deleteById(id);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"error\"}";
		}
	}
	
	@GetMapping("/calendar")
	public List<Calendar> getAlldates() {
		return calrepo.findAll();
	}
	
	
	
	@PostMapping("/calendar")//[2019201,2019202]
	public String calendarSetHolidays(@RequestBody ArrayList<Integer> d) {
		
		/*
		 * List<Integer> ids=new ArrayList<Integer>(); ids=d; System.out.println(ids);
		 */
		if(calservice.setHolidays(d))
			return "{ \"status\" : \"success\"}";
		else 
			return "{ \"status\" : \"error\"}";
		
		
	}
	
	
	
	
	


}
