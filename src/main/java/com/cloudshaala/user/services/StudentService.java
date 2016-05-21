package com.cloudshaala.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudshaala.user.bean.Student;
import com.cloudshaala.user.dao.StudentDaoImpl;

@Service
public class StudentService {
	
	@Autowired
	private StudentDaoImpl dao;
	
	public Student save(Student student){
		return dao.save(student);
		
	}
	
	public Student get(Long id){
		
		return dao.get(id);
		
	}
	
	public void delete(Long id){
		dao.delete(id);
	}

    public List<Student> getAll(){
    	return dao.getAll();
    	
    }
}
