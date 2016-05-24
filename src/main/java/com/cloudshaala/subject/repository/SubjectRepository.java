package com.cloudshaala.subject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudshaala.subject.bean.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

	List<Subject> findByCourseIdOrderByTitleDesc(long course);
}
