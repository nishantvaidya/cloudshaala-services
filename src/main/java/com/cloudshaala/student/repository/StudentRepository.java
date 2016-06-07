package com.cloudshaala.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudshaala.student.bean.Student;




public interface StudentRepository extends CrudRepository<Student,Long> {
	
	List<Student> findByClassesId(Long id);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO student_classes (student_id,class_id ) VALUES (?1, ?2)", nativeQuery = true) 
	void studentJoinClass( Long id,  Long class_id);
    
	 @Modifying
	 @Transactional
	 @Query(value="DELETE FROM student_classes WHERE student_id=?1 AND class_id=?2",nativeQuery = true)
	 void studentJoinClassDelete(Long id, Long class_id);
	 
	
    	
    

}
