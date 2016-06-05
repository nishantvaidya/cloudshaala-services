package com.cloudshaala.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudshaala.course.bean.Course;


public interface CourseRepository extends JpaRepository<Course,Long> {
	
	List<Course> findByTitleContainingOrderByTitleDesc(String title);
	
	List<Course> findByInstitutionOrderByTitleDesc(Long institution);
	
	

}
