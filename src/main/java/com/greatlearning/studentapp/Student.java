package com.greatlearning.studentapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Student")
public class Student {
	
	public Student() {
		super();
	}
	
	public Student(String name, String department, String country) {
		super();
		this.name = name;
		this.department = department;
		this.country = country;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private int Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="department")
	private String department;
	
	@Column(name="country")
	private String country;
	
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return Id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", department=" + department + ", country=" + country + "]";
	}
	
	

	
	
}
