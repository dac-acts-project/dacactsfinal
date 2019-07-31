package com.project.coursemgmt.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "calendar")
public class Calendar {

	private Integer cal_id;
	private LocalDate db_date;
	private Integer year;
	private Integer month;// month INTEGER NOT NULL, -- 1 to 12
	private Integer day;// day INTEGER NOT NULL, -- 1 to 31
	private Integer quarter; // quarter INTEGER NOT NULL, -- 1 to 4
	private Integer week;// week INTEGER NOT NULL, -- 1 to 52/53
	private String day_name;// day_name VARCHAR(9) NOT NULL, -- 'Monday', 'Tuesday'...
	private String month_name;// month_name VARCHAR(9) NOT NULL, -- 'January', 'February'...
	private Character holiday_flag;// holiday_flag CHAR(1) DEFAULT 'f' CHECK (holiday_flag in ('t', 'f')),
	private Character weekend_flag;// weekend_flag CHAR(1) DEFAULT 'f' CHECK (weekday_flag in ('t', 'f')),
	private String event;// event VARCHAR(50),
	// UNIQUE td_ymd_idx (year,month,day),
	// UNIQUE td_dbdate_idx (db_date)
	@JsonBackReference(value = "datesFaculty")
	private List<FacultyPojo> avail_faculties=new ArrayList<>();
	
	
	@Id
	public Integer getCal_id() {
		return cal_id;
	}
	public void setCal_id(Integer cal_id) {
		this.cal_id = cal_id;
	}
	
	@Column(unique = true)
	public LocalDate getDb_date() {
		return db_date;
	}
	public void setDb_date(LocalDate db_date) {
		this.db_date = db_date;
	}
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	
	
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	
	
	public Integer getQuarter() {
		return quarter;
	}
	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}
	
	
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	
	
	public String getDay_name() {
		return day_name;
	}
	public void setDay_name(String day_name) {
		this.day_name = day_name;
	}
	
	
	public String getMonth_name() {
		return month_name;
	}
	public void setMonth_name(String month_name) {
		this.month_name = month_name;
	}
	
	
	public Character getHoliday_flag() {
	
		return holiday_flag;
	}
	public void setHoliday_flag(Character holiday_flag) {
		this.holiday_flag = holiday_flag;
	}
	
	
	public Character getWeekend_flag() {
		return weekend_flag;
	}
	public void setWeekend_flag(Character weekend_flag) {
		this.weekend_flag = weekend_flag;
	}
	
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	
	@ManyToMany(mappedBy = "dates")
	public List<FacultyPojo> getAvail_faculties() {
		return avail_faculties;
	}
	public void setAvail_faculties(List<FacultyPojo> avail_faculties) {
		this.avail_faculties = avail_faculties;
	}
	@Override
	public String toString() {
		return "Calendar [cal_id=" + cal_id + ", db_date=" + db_date + ", year=" + year + ", month=" + month + ", day="
				+ day + ", quarter=" + quarter + ", week=" + week + ", day_name=" + day_name + ", month_name="
				+ month_name + ", holiday_flag=" + holiday_flag + ", weekend_flag=" + weekend_flag + ", event=" + event
				+ ", avail_faculties=" + avail_faculties + "]";
	}



}