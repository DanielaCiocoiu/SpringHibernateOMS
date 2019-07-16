package com.home.springboot.OMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OMS")
public class Product {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private int id;
	 
	    @Column(name ="code")
	    private int code;
	    
	    @Column(name ="product_name")
	    private String productName;
	 
	    @Column(name ="description")
	    private String description;

	    @Column(name ="category")
	    private String category;
	    
	    @Column(name ="quantity")
	    private int quantity;
	    
	    public Product() {
	    	//il cere Hibernate
	    }

		public Product(int id, int code, String productName, String description, String category, int quantity) {
			super();
			this.id = id;
			this.code = code;
			this.productName = productName;
			this.description = description;
			this.category = category;
			this.quantity = quantity;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", code=" + code + ", productName=" + productName + ", description="
					+ description + ", category=" + category + ", quantity=" + quantity + "]";
		}

		
		
		
}
