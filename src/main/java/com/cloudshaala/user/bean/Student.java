package com.cloudshaala.user.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private long id;
	    private String firstName;
	    private String lastName;

	    protected Student() {}

	    public Student(String firstName, String lastName) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	    }

	    @Override
	    public String toString() {
	        return String.format(
	                "Student[id=%d, firstName='%s', lastName='%s']",
	                id, firstName, lastName);
	    }

}
