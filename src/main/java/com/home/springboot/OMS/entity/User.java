package com.home.springboot.OMS.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "\"user\"")
public class User implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "user_name")
    @NaturalId
	private String user_name;
	
	

	@Column(name = "full_name")
	private String full_name;

	public User() {

	}

	

	public User(String user_name, String full_name) {
		super();
		this.user_name = user_name;
		this.full_name = full_name;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public String getFull_name() {
		return full_name;
	}



	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", full_name=" + full_name + "]";
	}



	

}
