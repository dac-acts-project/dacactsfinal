package com.project.coursemgmt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coursemgmt.daos.CommonLoginDao;
import com.project.coursemgmt.pojos.CommonLoginPojo;
@RestController
@RequestMapping("/user")

public class CommonUserLogin {

	@Autowired
	CommonLoginDao dao;
	
	
	@GetMapping("/check")
	public String checkingRediection() {
		return "user login";
	}

	@PostMapping
	public void validate(@RequestBody CommonLoginPojo p, HttpServletResponse res) {

		if (dao.existsById(p.getUsername())) {

			System.out.println("under checking");

			if (dao.findById(p.getUsername()).get().getRole().equalsIgnoreCase("admin")) {

				System.out.println("admin in");

				try {
					res.sendRedirect(res.encodeRedirectURL("admin/modules"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (dao.findById(p.getUsername()).get().getRole().equalsIgnoreCase("scheduler")) {
				System.out.println("sheduler in");
				try {
					res.sendRedirect(res.encodeRedirectURL("sheduler/check"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			else if (dao.findById(p.getUsername()).get().getRole().equalsIgnoreCase("faculty")) {
				System.out.println("faculty");
				try {
					res.sendRedirect(res.encodeRedirectURL("faculty/check"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			try {
				res.sendRedirect("/");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}
