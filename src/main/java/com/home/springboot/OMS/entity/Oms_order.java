package com.home.springboot.OMS.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "oms_order")
public class Oms_order implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int order_id;

	@Column(name = "creation_time")
	@Temporal(TemporalType.DATE)
	private Date creation_time;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name =  "user_name", referencedColumnName = "user_name")
	private Oms_user oms_user;
	
	
	 
	public Oms_order() {

	}

	public Oms_order(Date creation_time) {

		this.creation_time = creation_time;
	}

	

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Date getCreation_time() {
		return creation_time;
	}

	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}

	public Oms_user getOms_user() {
		return oms_user;
	}

	public void setOms_user(Oms_user oms_user) {
		this.oms_user = oms_user;
	}

	@Override
	public String toString() {
		return "Oms_order [order_id=" + order_id + ", creation_time=" + creation_time + ", oms_user=" + oms_user + "]";
	}

	

	

	

	

}