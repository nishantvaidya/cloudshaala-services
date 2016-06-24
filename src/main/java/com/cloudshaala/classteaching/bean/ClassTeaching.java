package com.cloudshaala.classteaching.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cloudshaala.classes.bean.TheClass;
import com.cloudshaala.subject.bean.Subject;
import com.cloudshaala.teacher.bean.Teacher;

@Entity
@Table(name = "class_subject_teaching")
public class ClassTeaching {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "class_id", referencedColumnName = "id")
	private TheClass classes;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private Subject subject;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subject_teacher_id", referencedColumnName = "id")
	private Teacher subjectTeacher;

	@Column(name = "start_datetime")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "end_datetime")
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column(name = "class_start_timing")
	private String starTiming;

	@Column(name = "class_end_timing")
	private String endTiming;

	public String getStarTiming() {
		return starTiming;
	}

	public void setStarTiming(String starTiming) {
		this.starTiming = starTiming;
	}

	public String getEndTiming() {
		return endTiming;
	}

	public void setEndTiming(String endTiming) {
		this.endTiming = endTiming;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TheClass getClasses() {
		return classes;
	}

	public void setClasses(TheClass classes) {
		this.classes = classes;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Teacher getSubjectTeacher() {
		return subjectTeacher;
	}

	public void setSubjectTeacher(Teacher subjectTeacher) {
		this.subjectTeacher = subjectTeacher;
	}
}
