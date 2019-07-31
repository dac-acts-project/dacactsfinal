package com.project.coursemgmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coursemgmt.daos.CalendarRepository;
import com.project.coursemgmt.daos.CommonLoginDao;
import com.project.coursemgmt.daos.FacultyRepository;
import com.project.coursemgmt.daos.ModulesRepository;
import com.project.coursemgmt.pojos.Calendar;
import com.project.coursemgmt.pojos.CommonLoginPojo;
import com.project.coursemgmt.pojos.FacultyPojo;
import com.project.coursemgmt.pojos.ModulePojo;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	FacultyRepository faculties;
	@Autowired
	CommonLoginDao dao;
	@Autowired
	CalendarRepository calrepo;
	@Autowired
	ModulesRepository module_repo;
	
	@GetMapping
	public List<ModulePojo> listingInRegistration(){
		
		return module_repo.findAll();
		
	}

	@GetMapping("/dashboard")
	public List<Calendar> registerFaculty() {

		return calrepo.findAll();

	}

	@PostMapping("/registration")
	public String registeringData(@RequestBody FacultyPojo f, HttpServletResponse res) {
		CommonLoginPojo user = new CommonLoginPojo(f.getFaculty_username());

		System.out.println(f);
		try {
			FacultyPojo p = faculties.save(f );

			/* user.setUsername(p.getFaculty_username()); */
			user.setPassword(p.getFaculty_password());
			user.setRole("faculty");
			
			dao.save(user);

		} catch (Exception e) {

			return "{ \"status\" : \"error\"}";
		}

		return "{ \"status\" : \"success\"}";

	}

	@PostMapping("/availability/{id}") // [2019105,2019106 ,2019107]
	public String availabilityAdd(@RequestBody List<Integer> dates, @PathVariable Integer id) {

		FacultyPojo fp = faculties.findById(id).get();
		for (Integer dateid : dates) {
			fp.addAvailability(calrepo.findById(dateid).get());
		}
		faculties.save(fp);
		
		return "success";
		
	}

	@PostMapping("/moduleadd/{facultyId}") // [121,122]
	public String modulesAdd(@RequestBody List<Integer> modules, @PathVariable Integer facultyId) {

		System.out.println(modules);
		System.out.println(facultyId);
		FacultyPojo fp = faculties.findById(facultyId).get();
		ModulePojo mp;
		
		System.out.println(fp);
		

		
		for (int moduleid : modules) {
			System.out.println(moduleid);
			
			mp=module_repo.findById(moduleid).get();
			System.out.println(mp);
			
		fp.addModules(mp);
		}
		
	faculties.save(fp);
	
		return "success";
	}
	
	

}
