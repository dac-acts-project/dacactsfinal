package com.project.coursemgmt.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.coursemgmt.pojos.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> {

}
