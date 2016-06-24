package com.cloudshaala.classteaching.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudshaala.classteaching.bean.ClassTeaching;
import com.cloudshaala.classteaching.dao.ClassTeachingDaoImpl;

@Service
public class ClassTeachingService {
	
	@Autowired
	private ClassTeachingDaoImpl dao;
	
	public ClassTeaching save(ClassTeaching classes){
		return dao.save(classes);
		
	}
	
	public ClassTeaching get(Long id){
		
		return dao.get(id);
		
	}
	
	public void delete(Long id){
		dao.delete(id);
	}

    public List<ClassTeaching> getAll(){
    	return dao.getAll();
    	
    }
    
   
	
}
