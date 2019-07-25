package com.home.springboot.OMS.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.home.springboot.OMS.entity.Product;

@Repository
public class ProductDAOHibernateImpl implements ProductDAO {

	private EntityManager entityManager;// creat automat de Spring Boot

	@Autowired
	public ProductDAOHibernateImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override

	public List<Product> findAll() {

		// sesiunea curenta Hibernate
		Session currentSession = entityManager.unwrap(Session.class);

		// creez query
		Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);

		// execut interogarea si obtin result list

		List<Product> products = theQuery.getResultList();

		return products;

	}

	@Override
	public Product findByName(String productproduct_name) {

		Session currentSession = entityManager.unwrap(Session.class);

		// obtin produsele
		Product theProduct = currentSession.get(Product.class, productproduct_name);

		return theProduct;
	}

	

}
