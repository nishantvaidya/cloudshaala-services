package com.cloudshaala.course.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.cloudshaala.subject.bean.Subject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Course {
	
	 @Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	 
	    private Long id;
	    private String title;
	    private String createdBy;
	    private Long institution;
	    private String syllabus;
	    @OneToMany(fetch=FetchType.EAGER)
	    @JoinColumn(name="course_id")
	    @JsonManagedReference
	    private List<Subject> subjects;

	    
		public List<Subject> getSubjects() {
			return subjects;
		}


		public void setSubjects(List<Subject> subjects) {
			this.subjects = subjects;
		}


		public Long getId() {
			return id;
		}

		
		public String getTitle() {
			return title;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		

		public Long getInstitution() {
			return institution;
		}


		public void setInstitution(Long institution) {
			this.institution = institution;
		}


		public String getSyllabus() {
			return syllabus;
		}

		public void setSyllabus(String syllabus) {
			this.syllabus = syllabus;
		}
	    
	    

	    

}
