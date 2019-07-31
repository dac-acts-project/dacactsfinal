package com.project.coursemgmt.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity 
@Table(name = "common_login")
public class CommonLoginPojo {
	
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;

    @Transient
	private String confirm_password;
	private String role;
	
	

	public CommonLoginPojo() {
	System.out.println("login pojo created");	
	}



	public CommonLoginPojo(String username) {
		
		this.username = username;
	}



	



	@Id
	@Column(name = "uname" ,length = 50)
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}


	@Column(name = "password" ,length = 50)
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getConfirm_password() {
		return confirm_password;
	}



	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	@Column(name = "role" ,length = 20)
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	

}
