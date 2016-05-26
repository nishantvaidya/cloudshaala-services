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

		List<Classes> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;
	}

	public List<Classes> searchByCourse(String course) {
		Iterable<Classes> classesItr = repository.findByCourseIdOrderByTitleDesc(Long.parseLong(course));

		List<Classes> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;

	}

	public List<Classes> searchByTeacher(String id) {
		Iterable<Classes> classesItr = repository.findByClassTeacherIdOrderByTitleDesc(Long.parseLong(id));

		List<Classes> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;

	}

	public List<Classes> searchByIntitution(String institution) {
		Iterable<Classes> classesItr = repository.findByInstitutionOrderByTitleDesc(institution);

		List<Classes> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;

	}
	
	public List<Classes> searchByStudent(String student) {
		Iterable<Classes> classesItr = repository.findByInstitutionOrderByTitleDesc(student);

		List<Classes> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;

	}

}
