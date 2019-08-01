package com.home.springboot.OMS.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "cat")
	private String cat;

	
	@OneToMany(mappedBy="category", fetch = FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Product> products= new ArrayList<Product>();
	
	
	
	public Category() {

	}

	public Category(String cat) {

		this.cat = cat;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", cat=" + cat + ", products=" + products + "]";
	}

public void add(Product tempProduct) {
		
		if (products == null) {
			products = new ArrayList<>();
		}
		
		products.add(tempProduct);
		
		tempProduct.setCategory(this);
	}

}