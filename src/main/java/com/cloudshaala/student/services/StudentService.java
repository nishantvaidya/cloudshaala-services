package com.cloudshaala.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudshaala.student.bean.Student;
import com.cloudshaala.student.dao.StudentDaoImpl;

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
