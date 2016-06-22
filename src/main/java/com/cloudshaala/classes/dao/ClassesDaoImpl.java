package com.cloudshaala.classes.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudshaala.classes.bean.TheClass;
import com.cloudshaala.classes.repository.ClassesRepository;
import com.cloudshaala.utils.Database;

@Repository
@Transactional
public class ClassesDaoImpl {

	@Autowired
	private ClassesRepository repository;

	public TheClass save(TheClass classes) {	
		
		return Database.saveClass(classes);
		//return repository.save(classes);
		

	}

	public TheClass get(Long id) {
		return repository.findOne(id);

	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public List<TheClass> getAll() {
		Iterable<TheClass> classesItr = repository.findAll();

		List<TheClass> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;
	}

	public List<TheClass> searchByCourse(String course) {
		Iterable<TheClass> classesItr = repository.findByCourseIdOrderByTitleDesc(Long.parseLong(course));

		List<TheClass> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;

	}

	public List<TheClass> searchByTeacher(String id) {
		Iterable<TheClass> classesItr = repository.findByClassTeacherIdOrderByTitleDesc(Long.parseLong(id));

		List<TheClass> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;

	}

	public List<TheClass> searchByIntitution(String institution) {
		Iterable<TheClass> classesItr = repository.findByInstitutionOrderByTitleDesc(institution);

		List<TheClass> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;

	}
	
	public List<TheClass> searchByStudent(String student) {
		Iterable<TheClass> classesItr = repository.findByStudentsIdOrderByTitleDesc(Long.parseLong(student));

		List<TheClass> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;

	}
	
	public List<TheClass> searchByCourseAndIntitution(String course,String id) {
		Iterable<TheClass> classesItr = repository.findByCourseIdAndInstitutionOrderByTitleDesc(Long.parseLong(course),id);

		List<TheClass> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;

	}
	
	public List<TheClass> searchByTeacherAndIntitution(String teacher,String id) {
		Iterable<TheClass> classesItr = repository.findByClassTeacherIdAndInstitutionOrderByTitleDesc(Long.parseLong(teacher),id);

		List<TheClass> classes = StreamSupport.stream(classesItr.spliterator(), false).collect(Collectors.toList());
		return classes;

	}



	
	
}
