package com.cloudshaala.classteaching.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudshaala.classteaching.bean.ClassTeaching;
import com.cloudshaala.classteaching.repository.ClassTeachingRepository;

@Repository
@Transactional
public class ClassTeachingDaoImpl {

	@Autowired
	private ClassTeachingRepository repository;

	public ClassTeaching save(ClassTeaching classes) {
		return repository.save(classes);

	}

	public ClassTeaching get(Long id) {
		return repository.findOne(id);

	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public List<ClassTeaching> getAll() {
		Iterable<ClassTeaching> classesItr = repository.findAll();

		List<ClassTeaching> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;
	}

	

	
	
}
