package com.hibernate.HibernatePractice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "STUDENT_1")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private int studentId;
	
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	@Column(name = "STUDENT_CITY")
	private String city;
	
	@Column(name = "STUDENT_MARKS")
	private int marks;

	public Student() {
		super();
	}
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Student(int studentId, String studentName, String city, int marks) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.city = city;
		this.marks = marks;
	}
}
