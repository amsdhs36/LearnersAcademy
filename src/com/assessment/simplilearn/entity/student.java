package com.assessment.simplilearn.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="student")
public class student {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
protected int id;
@Column(name="fname")
protected String fname;
@Column(name="sname")
protected String sname;
@Column(name="address")
protected String address;
@Column(name="age")
protected int age;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public student(String fname, String sname, String address, int age) {
	super();
	this.fname = fname;
	this.sname = sname;
	this.address = address;
	this.age = age;
}
public student(int id, String fname, String sname, String address, int age) {
	super();
	this.id = id;
	this.fname = fname;
	this.sname = sname;
	this.address = address;
	this.age = age;
}
public student() {
	//TODO Auto-generated constructor stub
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
}