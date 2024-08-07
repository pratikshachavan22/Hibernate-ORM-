package com.pratiksha;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="gender")
	private String gender;

	@Column(name="address")
	private String address;

	public Student() {
		super();
	}

	public Student(int id, String name, String gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
