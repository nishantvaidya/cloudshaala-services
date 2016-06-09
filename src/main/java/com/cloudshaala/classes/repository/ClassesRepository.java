package com.cloudshaala.classes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudshaala.classes.bean.Classes;

public interface ClassesRepository extends JpaRepository<Classes, Long> {

	List<Classes> findByCourseIdOrderByTitleDesc(long course);

	List<Classes> findByClassTeacherIdOrderByTitleDesc(long teacher);

	List<Classes> findByInstitutionOrderByTitleDesc(String institution);
	
	List<Classes> findByStudentsIdOrderByTitleDesc(long student);
	
	List<Classes> findByCourseIdAndInstitutionOrderByTitleDesc(long course,String institution);

}
