package com.briup.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_car")
public class Car implements Serializable{
	private static final long serialVersionUID = 1L;
//  mysql
//	@Id
//	@GeneratedValue
//	private long id;
	
//	oralce主键生成策略
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="myGenerator")     
	@SequenceGenerator(name="myGenerator",sequenceName="my_seq")
	private long id;
	private String name;
	private double price;
	private String color;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color + ", user=" + user + "]";
	}
	
}
