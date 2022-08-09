package com.StudentInfo;
import javax.persistence.*;
@Entity
@Table(name="student")

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rollno;
	@Column(length=20)
	private String name;
	@Column
	private int marks;
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
