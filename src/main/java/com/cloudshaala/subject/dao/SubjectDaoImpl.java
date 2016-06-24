package com.cloudshaala.subject.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudshaala.classes.bean.TheClass;
import com.cloudshaala.subject.bean.Subject;
import com.cloudshaala.subject.repository.SubjectRepository;

@Repository
@Transactional
public class SubjectDaoImpl {

	@Autowired
	private SubjectRepository repository;

	public Subject save(Subject subject) {
		return repository.save(subject);

	}

	public Subject get(Long id) {
		return repository.findOne(id);

	}

	public void delete(Long id) {
		repository.delete(id);
	}
	
	public List<Subject> searchByCourse(String course) {
		Iterable<Subject> subjectItr = repository.findByCourseIdOrderByTitleDesc(Long.parseLong(course));

		List<Subject> subject = StreamSupport.stream(subjectItr.spliterator(), false).collect(Collectors.toList());
		return subject;

	}

	public List<Subject> getAll() {
		Iterable<Subject> subjectItr = repository.findAll();

		List<Subject> subject = StreamSupport.stream(subjectItr.spliterator(), false).collect(Collectors.toList());
		return subject;
	}

	

}
