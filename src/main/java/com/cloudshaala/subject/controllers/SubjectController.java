package com.cloudshaala.subject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudshaala.classes.bean.Classes;
import com.cloudshaala.subject.bean.Subject;
import com.cloudshaala.subject.services.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService service;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public Subject  save(@RequestBody Subject subject){
		
		 return service.save(subject);
		
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public Subject  get(@PathVariable("id") Long id){
		
		return service.get(id);
		
	}
	

	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		service.delete(id);
	}
	
	@RequestMapping(value = "/search/course/{course}",method=RequestMethod.GET)
	public List<Subject> searchByCourse(@PathVariable("course") String course){
    	return service.searchByCourse( course);
    	
    }

	@RequestMapping(method=RequestMethod.GET)
	public List<Subject> getAll(){
    	return service.getAll();
    	
    }
	
	


}
