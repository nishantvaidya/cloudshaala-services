package com.cloudshaala.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudshaala.beans.rest.response.RESTServiceResponseBean;
import com.cloudshaala.user.bean.Student;
import com.cloudshaala.user.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	public StudentService service;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public Student  save(@RequestBody Student student){
		
		 return service.save(student);
		
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public Student  get(@PathVariable("id") Long id){
		
		return service.get(id);
		
	}
	

	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		service.delete(id);
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Student> getAll(){
    	return service.getAll();
    	
    }


}
