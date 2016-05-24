package com.cloudshaala.teacher.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudshaala.teacher.bean.Teacher;
import com.cloudshaala.teacher.repository.TeacherRepository;

@Repository
@Transactional
public class TeacherDaoImpl {

	@Autowired
	private TeacherRepository repository;

	public Teacher save(Teacher teacher) {
		return repository.save(teacher);

	}

	public Teacher get(Long id) {
		return repository.findOne(id);

	}

	public void delete(Long id) {
		repository.delete(id);
	}
	
	

	public List<Teacher> getAll() {
		Iterable<Teacher> teacherItr = repository.findAll();
		
		List<Teacher> students =
				StreamSupport.stream(teacherItr.spliterator(), false).collect(Collectors.toList());
		return students;
	}

}
