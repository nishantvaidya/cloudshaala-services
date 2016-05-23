package com.cloudshaala.classes.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

import com.cloudshaala.course.bean.Course;
import com.cloudshaala.teacher.bean.Teacher;

@Entity
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private boolean active;
	@ManyToOne(cascade = CascadeType.ALL )
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn( name = "class_teacher_id" )
	private Teacher classTeacherId;
	@ManyToOne(cascade = CascadeType.ALL )
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn( name = "course_id" )
	private Course courseId;
	private String section;
	private String institutionId;

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

	

	public Teacher getClassTeacherId() {
		return classTeacherId;
	}

	public void setClassTeacherId(Teacher classTeacherId) {
		this.classTeacherId = classTeacherId;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

}
