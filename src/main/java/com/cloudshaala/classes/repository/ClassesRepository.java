package com.cloudshaala.classes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudshaala.classes.bean.TheClass;

public interface ClassesRepository extends JpaRepository<TheClass, Long> {

	List<TheClass> findByCourseIdOrderByTitleDesc(long course);

	List<TheClass> findByClassTeacherIdOrderByTitleDesc(long teacher);

	List<TheClass> findByInstitutionIdOrderByTitleDesc(long institution);

	List<TheClass> findByStudentsIdOrderByTitleDesc(long student);

	List<TheClass> findByCourseIdAndInstitutionIdOrderByTitleDesc(long course, long institution);

	List<TheClass> findByClassTeacherIdAndInstitutionIdOrderByTitleDesc(long teacher, String institution);
	
	List<TheClass> findByCourseIdAndInstitutionIdOrderByTitleDesc(long course, String institution);
	
	List<TheClass> findByCourseIdAndSectionAndAcademicSessionAndInstitutionIdOrderByTitleDesc(long course,long section,long session, long institution);
	
	

}
