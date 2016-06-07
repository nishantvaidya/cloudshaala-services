package com.cloudshaala.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudshaala.student.bean.Student;
import com.cloudshaala.student.services.StudentService;

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
	
	@RequestMapping(value = "/classes/{id}",method=RequestMethod.GET)
	public List<Student> findByClasses(@PathVariable("id")Long id) {
		return service.findByClasses(id);
	}
	
	@RequestMapping(value = "/{id}/join/class/{class_id}",method=RequestMethod.PUT)
	public void studentJoinClass(@PathVariable("id")Long id,@PathVariable("class_id")Long class_id) {
		 service.studentJoinClass(id,class_id);
	}
	
	@RequestMapping(value = "/{id}/join/class/{class_id}",method=RequestMethod.DELETE)
	public void studentJoinClassDelete(@PathVariable("id")Long id,@PathVariable("class_id")Long class_id) {
		 service.studentJoinClassDelete(id,class_id);
	}
		
	}



