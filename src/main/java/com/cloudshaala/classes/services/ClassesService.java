package com.cloudshaala.classes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudshaala.classes.bean.Classes;
import com.cloudshaala.classes.dao.ClassesDaoImpl;

@Service
public class ClassesService {
	
	@Autowired
	private ClassesDaoImpl dao;
	
	public Classes save(Classes classes){
		return dao.save(classes);
		
	}
	
	public Classes get(Long id){
		
		return dao.get(id);
		
	}
	
	public void delete(Long id){
		dao.delete(id);
	}

    public List<Classes> getAll(){
    	return dao.getAll();
    	
    }
    
  public List<Classes> searchByCourse(String course){
    	return dao.searchByCourse( course);
    	
    }
	
	public List<Classes> searchByTeacher( String title){
    	return dao.searchByTeacher( title);
    	
    }
	public List<Classes> searchByIntitution( String id){
    	return dao.searchByIntitution( id);
    	
    }
	
	public List<Classes> searchByStudent( String id){
    	return dao.searchByStudent( id);
    	
    }
    
   
   
}
