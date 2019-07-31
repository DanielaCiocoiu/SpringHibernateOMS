package com.home.springboot.OMS.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "product")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")

public class Product implements Serializable {

	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int product_id;

	
	@Column(name = "product_code")
	private int product_code;

	@NaturalId
	@Column(name = "product_name")
	private String product_name;

	@Column(name = "description")
	private String description;

	@NaturalId
	@Column(name = "quantity")
	private int quantity;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "order_product", 
	joinColumns = @JoinColumn(name = "product_id"), 
	inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Oms_order> oms_orders = new ArrayList<Oms_order>(0);


	public Product() {
		
	}

	public Product(int product_code, String product_name, String description, int quantity, Category category) {

		this.product_code = product_code;
		this.product_name = product_name;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
	}

	public Product(List<Oms_order> oms_orders, int product_code, String product_name, String description, int quantity,
			Category category) {

		this.oms_orders = oms_orders;
		this.product_code = product_code;
		this.product_name = product_name;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public List<Oms_order> getOms_orders() {
		return oms_orders;
	}

	public void setOms_orders(List<Oms_order> oms_orders) {
		this.oms_orders = oms_orders;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void addOms_order(Oms_order theOms_order) {

		if (oms_orders == null) {
			oms_orders = new ArrayList<>();
		}

		oms_orders.add(theOms_order);
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_code=" + product_code + ", product_name=" + product_name
				+ ", description=" + description + ", quantity=" + quantity + ", category=" + category + "]";
	}

	

}
