package com.home.springboot.OMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private int id;
	 
	    @Column(name ="product_code")
	    private int product_code;
	    
	    @Column(name ="product_name")
	    private String product_name;
	 
	    @Column(name ="description")
	    private String description;

	    @Column(name ="category")
	    private String category;
	    
	    @Column(name ="quantity")
	    private int quantity;
	    
	    public Product() {
	    	//il cere Hibernate
	    }

		public Product(int product_code, String product_name, String description, String category, int quantity) {
			
			
			this.product_code = product_code;
			this.product_name = product_name;
			this.description = description;
			this.category = category;
			this.quantity = quantity;
		}

		public int getproduct_code() {
			return product_code;
		}

		public void setproduct_code(int product_code) {
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
			return "Product [id=" + id + ", product_code=" + product_code + ", productName=" + product_name + ", description="
					+ description + ", category=" + category + ", quantity=" + quantity + "]";
		}

		
		
		
}
