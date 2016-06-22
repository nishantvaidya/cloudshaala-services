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

@Entity
@Table(name = "class")
public class TheClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String acadmic_session;
	private boolean active;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name ="class_teacher_id",referencedColumnName = "id" )
	private Teacher classTeacher;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name ="course_id",referencedColumnName = "id" )
	private Course course;
	private String section;
	@Column( name = "institution_id" )
	private String institution;
	@ManyToMany(targetEntity = Student.class)
    @JoinTable(name = "student_classes", joinColumns = { @JoinColumn(name = "class_id") }, 
                       inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private List<Student> students;
	

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


	public String getSection() {
		return section;
	}

	public void setSection(String section) {
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	
	public String getAcadmic_session() {
		return acadmic_session;
	}

	public void setAcadmic_session(String acadmic_session) {
		this.acadmic_session = acadmic_session;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}




	
	

}
