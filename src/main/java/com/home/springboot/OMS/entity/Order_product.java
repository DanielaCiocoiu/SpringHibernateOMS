package com.home.springboot.OMS.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_product")
public class Order_product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderid")
	private Oms_order oms_order;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_code", referencedColumnName = "product_code")
	private Product product;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "quantity", referencedColumnName = "quantity")
	private Product product1;
	
public Order_product () {
	
}
	
	public Order_product(Oms_order oms_order, Product product, Product product1) {
		
		this.oms_order = oms_order;
		this.product = product;
		this.product1 = product1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Oms_order getOms_order() {
		return oms_order;
	}

	public void setOms_order(Oms_order oms_order) {
		this.oms_order = oms_order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct1() {
		return product1;
	}

	public void setProduct1(Product product1) {
		this.product1 = product1;
	}

	@Override
	public String toString() {
		return "Order_product [id=" + id + ", oms_order=" + oms_order + ", product=" + product + ", product1="
				+ product1 + "]";
	}

	

	
	
	

}
