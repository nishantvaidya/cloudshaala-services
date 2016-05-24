package com.cloudshaala.teacher.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudshaala.teacher.bean.Teacher;
import com.cloudshaala.teacher.services.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public Teacher  save(@RequestBody Teacher teacher){
		
		 return service.save(teacher);
		
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public Teacher  get(@PathVariable("id") Long id){
		
		return service.get(id);
		
	}
	

	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		service.delete(id);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Teacher> getAll(){
    	return service.getAll();
    	
    }


}
