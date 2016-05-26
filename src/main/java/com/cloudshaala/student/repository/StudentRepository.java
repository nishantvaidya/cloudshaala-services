package com.cloudshaala.student.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cloudshaala.student.bean.Student;




public interface StudentRepository extends CrudRepository<Student,Long> {
	
	List<Student> findByClassesId(Long id);

}
