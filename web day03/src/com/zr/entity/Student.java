package com.zr.entity;

/**
 * 学生实体类
 * @author Administrator
 *
 */
public class Student {

	private int id;
	private String stuno;
	private String name;
	private int gender;
	private String age;
	
	public Student(int id, String stuno, String name, int gender, String age) {
		super();
		this.id = id;
		this.stuno = stuno;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	
}
