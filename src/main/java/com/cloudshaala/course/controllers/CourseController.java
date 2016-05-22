package com.cloudshaala.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudshaala.course.bean.Course;
import com.cloudshaala.course.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public Course  save(@RequestBody Course course){
		
		 return service.save(course);
		
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public Course  get(@PathVariable("id") Long id){
		
		return service.get(id);
		
	}
	

	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		service.delete(id);
	}
	
	@RequestMapping(value = "/search/title/{title}",method=RequestMethod.GET)
	public List<Course> searchByTitle(@PathVariable("title") String title){
    	return service.searchByTitle( title);
    	
    }

	@RequestMapping(method=RequestMethod.GET)
	public List<Course> getAll(){
    	return service.getAll();
    	
    }


}
