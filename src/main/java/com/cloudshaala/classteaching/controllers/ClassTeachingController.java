package com.cloudshaala.classteaching.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudshaala.classteaching.bean.ClassTeaching;
import com.cloudshaala.classteaching.services.ClassTeachingService;

@RestController
@RequestMapping("/classteaching")
public class ClassTeachingController {
	
	@Autowired
	private ClassTeachingService service;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ClassTeaching  save(@RequestBody ClassTeaching classes){
		
		 return service.save(classes);
		
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public ClassTeaching  get(@PathVariable("id") Long id){
		
		return service.get(id);
		
	}
	

	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		service.delete(id);
	}
	
	

	@RequestMapping(method=RequestMethod.GET)
	public List<ClassTeaching> getAll(){
    	return service.getAll();
    	
    }
	
	

}
