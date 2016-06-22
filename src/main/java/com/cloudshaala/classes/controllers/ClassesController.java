package com.cloudshaala.classes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudshaala.classes.bean.TheClass;
import com.cloudshaala.classes.services.ClassesService;

@RestController
@RequestMapping("/classes")
public class ClassesController {
	
	@Autowired
	private ClassesService service;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public TheClass  save(@RequestBody TheClass classes){
		
		 return service.save(classes);
		
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public TheClass  get(@PathVariable("id") Long id){
		
		return service.get(id);
		
	}
	

	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		service.delete(id);
	}
	
	

	@RequestMapping(method=RequestMethod.GET)
	public List<TheClass> getAll(){
    	return service.getAll();
    	
    }
	
	@RequestMapping(value = "/search/course/{course}",method=RequestMethod.GET)
	public List<TheClass> searchByCourse(@PathVariable("course") String course){
    	return service.searchByCourse( course);
    	
    }
	
	@RequestMapping(value = "/search/teacher/{teacher}",method=RequestMethod.GET)
	public List<TheClass> searchByTeacher(@PathVariable("teacher") String title){
    	return service.searchByTeacher( title);
    	
    }
	
	@RequestMapping(value = "/search/teacher/{teacher}/intitution/{id}",method=RequestMethod.GET)
	public List<TheClass> searchByTeacherAndIntitution(@PathVariable("teacher") String  teacher,@PathVariable("id") String id){
    	return service.searchByTeacherAndIntitution( teacher,id);
    	
    }
	@RequestMapping(value = "/search/intitution/{id}",method=RequestMethod.GET)
	public List<TheClass> searchByIntitution(@PathVariable("id") String id){
    	return service.searchByIntitution( id);
    	
    }
	
	@RequestMapping(value = "/search/student/{id}",method=RequestMethod.GET)
	public List<TheClass> searchByStudent(@PathVariable("id") String id){
    	return service.searchByStudent( id);
    	
    }
	
	@RequestMapping(value = "/search/course/{course}/intitution/{id}",method=RequestMethod.GET)
	public List<TheClass> searchByCourseAndIntitution(@PathVariable("course") String course,@PathVariable("id") String id){
    	return service.searchByCourseAndIntitution(course, id);
    	
    }


}
