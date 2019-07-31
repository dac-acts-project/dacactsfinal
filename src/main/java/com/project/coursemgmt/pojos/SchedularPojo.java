package com.project.coursemgmt.pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchedularPojo {

	
	private Integer roomId;
	private String  roomName;
	private Map<Integer, List<Integer>> finalFacultyDates=new HashMap<>();
	
	private Integer facultyId;
	private String facultyName;
	
	
	
	
	
	
public SchedularPojo() {
	System.out.println("shedular on");
}

}