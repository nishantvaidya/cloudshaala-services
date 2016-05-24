package com.cloudshaala.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudshaala.course.bean.Course;
import com.cloudshaala.course.dao.CourseDaoImpl;

@Service
public class CourseService {
	
	@Autowired
	private CourseDaoImpl dao;
	
	public Course save(Course course){
		return dao.save(course);
		
	}
	
	public Course get(Long id){
		
		return dao.get(id);
		
	}
	
	public void delete(Long id){
		dao.delete(id);
	}

    public List<Course> getAll(){
    	return dao.getAll();
    	
    }
    
    public List<Course>  searchByTitle( String title){
    	return dao.searchByTitle(title);
    	
    }
    
   
}
