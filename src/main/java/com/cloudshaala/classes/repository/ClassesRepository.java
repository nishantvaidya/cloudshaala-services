package com.cloudshaala.classes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudshaala.classes.bean.Classes;

public interface ClassesRepository extends JpaRepository<Classes, Long> {

	List<Classes> findByCourseOrderByTitleDesc(long course);

	List<Classes> findByClassTeacherOrderByTitleDesc(long teacher);

	List<Classes> findByInstitutionOrderByTitleDesc(String institution);

}
