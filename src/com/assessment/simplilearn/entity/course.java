package com.assessment.simplilearn.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="course")
public class course {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int courseid;
@Column(name="coursename")
private String coursename;

public course() {
	//TODO Auto-generated constructor stub
}

public int getCourseid() {
	return courseid;
}
public void setCourseid(int courseid) {
	this.courseid = courseid;
}
public String getCoursename() {
	return coursename;
}
public void setCoursename(String coursename) {
	this.coursename = coursename;
}
public course(int courseid, String coursename) {
	super();
	this.courseid = courseid;
	this.coursename = coursename;
}
public course(String coursename) {
	super();

	this.coursename = coursename;
}

}
