package com.project.coursemgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.project.pojos.util","com.project.coursemgmt.*"})
public class DacCourseMgmtFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DacCourseMgmtFinalApplication.class, args);
	}

}
