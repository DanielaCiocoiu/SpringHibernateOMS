package com.home.springboot.OMS.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="product")
public class Product implements Serializable{
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private int id;
	 
	    @Column(name ="product_code")
	    private int product_code;
	    
	    @NaturalId
	    @Column(name ="product_name")
	    private String product_name;
	 
	    @Column(name ="description")
	    private String description;
 
	    @NaturalId
	    @Column(name ="quantity")
	    private int quantity;
	    
	    @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="category_id")
	    private Category category;
	    
	   	    
	    public Product() {
	    	//il cere Hibernate
	    }

		public Product(int product_code, String product_name, String description, int quantity) {
			
			
			this.product_code = product_code;
			this.product_name = product_name;
			this.description = description;
			this.quantity = quantity;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		@Override
		public String toString() {
			return "Product [id=" + id + ", product_code=" + product_code + ", product_name=" + product_name
					+ ", description=" + description + ", quantity=" + quantity + ", category=" + category + "]";
		}

		
	
		
}
