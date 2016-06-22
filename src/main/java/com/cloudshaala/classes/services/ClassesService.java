package com.cloudshaala.classes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudshaala.classes.bean.TheClass;
import com.cloudshaala.classes.dao.ClassesDaoImpl;

@Service
public class ClassesService {
	
	@Autowired
	private ClassesDaoImpl dao;
	
	public TheClass save(TheClass classes){
		return dao.save(classes);
		
	}
	
	public TheClass get(Long id){
		
		return dao.get(id);
		
	}
	
	public void delete(Long id){
		dao.delete(id);
	}

    public List<TheClass> getAll(){
    	return dao.getAll();
    	
    }
    
  public List<TheClass> searchByCourse(String course){
    	return dao.searchByCourse( course);
    	
    }
	
	public List<TheClass> searchByTeacher( String title){
    	return dao.searchByTeacher( title);
    	
    }
	public List<TheClass> searchByIntitution( String id){
    	return dao.searchByIntitution( id);
    	
    }
	
	public List<TheClass> searchByStudent( String id){
    	return dao.searchByStudent( id);
    	
    }
	public List<TheClass> searchByCourseAndIntitution(String course,String id){
    	return dao.searchByCourseAndIntitution(course, id);
    	
    }
	
	public List<TheClass> searchByTeacherAndIntitution(String teacher,String id){
    	return dao.searchByTeacherAndIntitution(teacher, id);
    	
    }
	
	
    
   
	
}
