package com.cloudshaala.course.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
	
	 @Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	 
	    private Long id;
	    private String title;
	    private String createdBy;
	    private Long institution;
	    private String syllabus;

	    
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
