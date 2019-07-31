package com.project.coursemgmt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coursemgmt.daos.CalendarRepository;
import com.project.coursemgmt.pojos.Calendar;

@Service

public class CalendarUtilitiesImpl implements CalendarUtilities {
	
	@Autowired
	private CalendarRepository repo;
	
	
	@Override
	public Boolean setHolidays(List<Integer> ids) {
		
		ArrayList<Integer> list=(ArrayList<Integer>)ids;
		System.out.println(list);
		Calendar cal;
		for (Integer id : list) {
			
			
			cal=repo.getOne(id);
			System.out.println(cal);
			cal.setHoliday_flag('t');
			repo.save(cal);
		System.out.println(cal);
		}
			
		return true;
		
	}
	
	
}
