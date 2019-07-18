package com.home.springboot.OMS.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderp")
public class Orderp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "creation_time")
	private Date creation_time;

	@Column(name = "username")
	private String username;

	public Orderp() {
		
	}
	public Orderp(Date creation_time, String username) {
	
		this.creation_time = creation_time;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreation_time() {
		return creation_time;
	}
	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}
	public String getUsername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Orderp [id=" + id + ", creation_time=" + creation_time + ", username=" + username + "]";
	}
	
	
}
