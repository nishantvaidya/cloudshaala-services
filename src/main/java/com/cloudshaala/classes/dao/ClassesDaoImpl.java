package com.cloudshaala.classes.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudshaala.classes.bean.Classes;
import com.cloudshaala.classes.repository.ClassesRepository;

@Repository
@Transactional
public class ClassesDaoImpl {

	@Autowired
	private ClassesRepository repository;

	public Classes save(Classes classes) {
		return repository.save(classes);

	}

	public Classes get(Long id) {
		return repository.findOne(id);

	}

	public void delete(Long id) {
		repository.delete(id);
	}
	
	

	public List<Classes> getAll() {
		Iterable<Classes> classesItr = repository.findAll();
		
		List<Classes> students =
				StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return students;
	}

}
