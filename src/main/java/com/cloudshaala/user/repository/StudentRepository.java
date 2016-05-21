package com.cloudshaala.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cloudshaala.user.bean.Student;


public interface StudentRepository extends CrudRepository<Student,Long> {
	
	List<Student> findByLastName(String lastName);

}
