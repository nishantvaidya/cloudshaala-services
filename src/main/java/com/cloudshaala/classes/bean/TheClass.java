package com.cloudshaala.classes.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cloudshaala.course.bean.Course;
import com.cloudshaala.student.bean.Student;
import com.cloudshaala.teacher.bean.Teacher;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "class")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class TheClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	private boolean active;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name ="class_teacher_id",referencedColumnName = "id" )
	private Teacher classTeacher;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name ="course_id",referencedColumnName = "id" )
	private Course course;
	private Long section;
	@Column( name = "institution_id" )
	private Long institutionId;
	@ManyToMany(targetEntity = Student.class)
    @JoinTable(name = "student_classes", joinColumns = { @JoinColumn(name = "class_id") }, 
                       inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private List<Student> students;
	private Long createdBy;
	
	private Long academicSession;
	
	public Long getAcademicSession() {
		return academicSession;
	}

	public void setAcademicSession(Long academicSession) {
		this.academicSession = academicSession;
	}

	

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public Long getSection() {
		return section;
	}

	public void setSection(Long section) {
		this.section = section;
	}

	public Teacher getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	
	public Long getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}




	
	

}
