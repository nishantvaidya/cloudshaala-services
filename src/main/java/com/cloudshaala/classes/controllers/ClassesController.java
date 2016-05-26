package com.cloudshaala.classes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudshaala.classes.bean.Classes;
import com.cloudshaala.classes.services.ClassesService;

@RestController
@RequestMapping("/classes")
public class ClassesController {
	
	@Autowired
	private ClassesService service;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public Classes  save(@RequestBody Classes classes){
		
		 return service.save(classes);
		
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public Classes  get(@PathVariable("id") Long id){
		
		return service.get(id);
		
	}
	

	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		service.delete(id);
	}
	
	

	@RequestMapping(method=RequestMethod.GET)
	public List<Classes> getAll(){
    	return service.getAll();
    	
    }
	
	@RequestMapping(value = "/search/course/{course}",method=RequestMethod.GET)
	public List<Classes> searchByCourse(@PathVariable("course") String course){
    	return service.searchByCourse( course);
    	
    }
	
	@RequestMapping(value = "/search/teacher/{teacher}",method=RequestMethod.GET)
	public List<Classes> searchByTeacher(@PathVariable("teacher") String title){
    	return service.searchByTeacher( title);
    	
    }
	@RequestMapping(value = "/search/intitution/{id}",method=RequestMethod.GET)
	public List<Classes> searchByIntitution(@PathVariable("id") String id){
    	return service.searchByIntitution( id);
    	
    }
	
	@RequestMapping(value = "/search/student/{id}",method=RequestMethod.GET)
	public List<Classes> searchByStudent(@PathVariable("id") String id){
    	return service.searchByStudent( id);
    	
    }


}
