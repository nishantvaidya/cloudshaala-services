package com.cloudshaala.subject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudshaala.subject.bean.Subject;
import com.cloudshaala.subject.dao.SubjectDaoImpl;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectDaoImpl dao;
	
	public Subject save(Subject subject){
		return dao.save(subject);
		
	}
	
	public Subject get(Long id){
		
		return dao.get(id);
		
	}
	
	 public List<Subject> searchByCourse(String course){
	    	return dao.searchByCourse( course);
	    	
	   }
	
	public void delete(Long id){
		dao.delete(id);
	}

    public List<Subject> getAll(){
    	return dao.getAll();
    	
    }
    
 
   
   
}
