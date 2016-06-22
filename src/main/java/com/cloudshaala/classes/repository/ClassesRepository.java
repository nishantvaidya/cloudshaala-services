package com.cloudshaala.classes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudshaala.classes.bean.TheClass;

public interface ClassesRepository extends JpaRepository<TheClass, Long> {

	List<TheClass> findByCourseIdOrderByTitleDesc(long course);

	List<TheClass> findByClassTeacherIdOrderByTitleDesc(long teacher);

	List<TheClass> findByInstitutionOrderByTitleDesc(String institution);

	List<TheClass> findByStudentsIdOrderByTitleDesc(long student);

	List<TheClass> findByCourseIdAndInstitutionOrderByTitleDesc(long course, String institution);

	List<TheClass> findByClassTeacherIdAndInstitutionOrderByTitleDesc(long teacher, String institution);

}
