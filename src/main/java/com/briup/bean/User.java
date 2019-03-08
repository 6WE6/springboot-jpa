package com.briup.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="t_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	oracle数据库主键的生成策略(sequence)
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="myGenerator")     
	@SequenceGenerator(name="myGenerator",sequenceName="my_seq")
	private Long id;
	//mysql数据库的主键生成策略
//	@Id
//	@GeneratedValue
//	private Long id;
	
	@Column(nullable=false,unique=true)
	private String name;
	
	@Column(nullable=false)
	private int age;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Gender gender;
	
	
	public User() {}
	public User(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

}