package com.assessment.simplilearn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class subject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int subjectid;
	
private String subjectName;

public subject() {
	//TODO Auto-generated constructor stub
}
public int getSubjectid() {
	return subjectid;
}
public void setSubjectid(int subjectid) {
	this.subjectid = subjectid;
}
public String getSubjectName() {
	return subjectName;
}
public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}

public subject(int subjectid, String subjectName) {
	super();
	this.subjectid = subjectid;
	this.subjectName = subjectName;
	
}
}
