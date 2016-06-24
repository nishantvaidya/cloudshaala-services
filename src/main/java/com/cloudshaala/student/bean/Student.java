package com.cloudshaala.student.bean;

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
import javax.persistence.OneToOne;

import com.cloudshaala.classes.bean.TheClass;
import com.cloudshaala.user.bean.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Student {
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="student_id")
	    private long id;
	 
	    private boolean active;
	    
	    @OneToOne(fetch = FetchType.EAGER)
		@JoinColumn( name ="user_id",referencedColumnName = "user_id" )
	    private User details;
	    
	    @ManyToMany(targetEntity = TheClass.class)
	    @JoinTable(name = "student_classes", joinColumns = { @JoinColumn(name = "student_id") }, 
	                       inverseJoinColumns = { @JoinColumn(name = "class_id") })
	    private List<TheClass> classes;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public User getDetails() {
			return details;
		}

		public void setDetails(User details) {
			this.details = details;
		}

		public List<TheClass> getClasses() {
			return classes;
		}

		public void setClasses(List<TheClass> classes) {
			this.classes = classes;
		}
	    
		
	    

}
