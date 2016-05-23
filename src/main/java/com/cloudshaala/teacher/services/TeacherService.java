package com.cloudshaala.teacher.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudshaala.teacher.bean.Teacher;
import com.cloudshaala.teacher.dao.TeacherDaoImpl;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherDaoImpl dao;
	
	public Teacher save(Teacher teacher){
		return dao.save(teacher);
		
	}
	
	public Teacher get(Long id){
		
		return dao.get(id);
		
	}
	
	public void delete(Long id){
		dao.delete(id);
	}

    public List<Teacher> getAll(){
    	return dao.getAll();
    	
    }
    
  
    
   
}
