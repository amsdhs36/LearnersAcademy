package com.assessment.simplilearn.entity;

public class teacher {
private int teacher_id;
private String fullname;
private String subject;
private int courseid;
public teacher() {
	//TODO Auto-generated constructor stub
}
public int getTeacher_id() {
	return teacher_id;
}
public void setTeacher_id(int teacher_id) {
	this.teacher_id = teacher_id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public int getCourseid() {
	return courseid;
}
public void setCourseid(int courseid) {
	this.courseid = courseid;
}
public teacher(int teacher_id, String fullname, String subject, int courseid) {
	super();
	this.teacher_id = teacher_id;
	this.fullname = fullname;
	this.subject = subject;
	this.courseid=courseid;
}
}
