package com.cloudshaala.student.dao;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudshaala.student.bean.Student;
import com.cloudshaala.student.repository.StudentRepository;

import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl {

	@Autowired
	private StudentRepository repository;

	public Student save(Student student) {
		return repository.save(student);

	}

	public Student get(Long id) {
		return repository.findOne(id);

	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public List<Student> getAll() {
		Iterable<Student> studentsItr = repository.findAll();
		
		List<Student> students =
				StreamSupport.stream(studentsItr.spliterator(), false).collect(Collectors.toList());
		return students;
	}
	
	public List<Student> findByClasses(Long id) {
		Iterable<Student> studentsItr = repository.findByClassesId(id);
		
		List<Student> students =
				StreamSupport.stream(studentsItr.spliterator(), false).collect(Collectors.toList());
		return students;
	}
	
	public void studentJoinClass(Long id, Long class_id){
		repository.studentJoinClass(id,class_id);
    	
    }
    
    public void studentJoinClassDelete(Long id, Long class_id){
    	repository.studentJoinClassDelete(id,class_id);
    	
    }

}
