package com.project.coursemgmt.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "faculty_info")
public class FacultyPojo {

	@JsonProperty("id")
	private Integer faculty_id;

	@JsonProperty("username")
	private String faculty_username;
	
	@JsonProperty("password")
	private String faculty_password;
	@JsonProperty("name")
	private String faculty_name;
	@JsonProperty("rating")
	private Integer rating;
	@JsonProperty("experience")
	private Integer experience;
	@JsonProperty("lab")
	private Boolean lab;
	
	@JsonBackReference(value = "facultiesList")
	private List<ModulePojo> modules = new ArrayList<>();
	
	//@JsonManagedReference(value = "datesFaculty")
	private List<Calendar> dates = new ArrayList<>();

	public FacultyPojo() {
		System.out.println("faculty pojo in");
	}

	public FacultyPojo(String faculty_username, String faculty_password, String faculty_name, Integer rating,
			Integer experience, Boolean lab) {
		super();
		this.faculty_username = faculty_username;
		this.faculty_password = faculty_password;
		this.faculty_name = faculty_name;
		this.rating = rating;
		this.experience = experience;
		this.lab = lab;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(Integer faculty_id) {
		this.faculty_id = faculty_id;
	}

	@Column(name = "username", unique = true, length = 50)
	public String getFaculty_username() {
		return faculty_username;
	}

	public void setFaculty_username(String faculty_username) {
		this.faculty_username = faculty_username;
	}

	@Column(name = "faculty_name", length = 50)
	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	@Column(name = "rating", length = 5)
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Column(name = "experience")
	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	@Column(name = "lab_flag")
	public Boolean getLab() {
		return lab;
	}

	public void setLab(Boolean lab) {
		this.lab = lab;
	}

	@ManyToMany(mappedBy = "faculties")
	public List<ModulePojo> getModules() {
		return modules;
	}

	public void setModules(List<ModulePojo> modules) {
		this.modules = modules;
	}
	
	//helping methods
	public void addModules(ModulePojo module) {
		modules.add(module);
		module.getFaculties().add(this);
		
	}
	
	public void removeModules(ModulePojo module) {
		modules.remove(module);
		module.getFaculties().remove(this);
	}

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	
	@JoinTable(name = "faculty_cal", joinColumns = @JoinColumn(name = "f_id"), inverseJoinColumns = @JoinColumn(name = "dates_id"))
	@JsonIgnore
	public List<Calendar> getDates() {
		return dates;
	}

	public void setDates(List<Calendar> dates) {
		this.dates = dates;
	}

	@Column(name = "password", length = 50)
	@JsonIgnore
	public String getFaculty_password() {
		return faculty_password;
	}

	public void setFaculty_password(String faculty_password) {
		this.faculty_password = faculty_password;
	}
	
	//helping method
	public void addAvailability(Calendar cal) {
		dates.add(cal);
		cal.getAvail_faculties().add(this);
		
	}
	
	public void removeAvailability(Calendar cal) {
		dates.remove(cal);
		cal.getAvail_faculties().remove(this);
	}
	
	
	@Override
	public String toString() {
		return "FacultyPojo [faculty_id=" + faculty_id + ", faculty_username=" + faculty_username
				+ ", faculty_password=" + faculty_password + ", faculty_name=" + faculty_name + ", rating=" + rating
				+ ", experience=" + experience + ", lab=" + lab + "]";
	}

}
