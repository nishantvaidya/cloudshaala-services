package com.cloudshaala.course.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudshaala.course.bean.Course;
import com.cloudshaala.course.repository.CourseRepository;

@Repository
@Transactional
public class CourseDaoImpl {

	@Autowired
	private CourseRepository repository;

	public Course save(Course course) {
		return repository.save(course);

	}

	public Course get(Long id) {
		return repository.findOne(id);

	}

	public void delete(Long id) {
		repository.delete(id);
	}
	
	public List<Course> searchByTitle(String title) {
		return repository.findByTitleContainingOrderByTitleDesc(title);
		
	}
	

	public List<Course> getAll() {
		Iterable<Course> courseItr = repository.findAll();
		
		List<Course> students =
				StreamSupport.stream(courseItr.spliterator(), false).collect(Collectors.toList());
		return students;
	}

}
