package com.home.springboot.OMS.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.springboot.OMS.entity.Order_product;
import com.home.springboot.OMS.entity.Product;

@Repository
public class Order_productDAOHibernateImpl implements Order_productDAO {

	private EntityManager entityManager;// creat automat de Spring Boot

	@Autowired
	public Order_productDAOHibernateImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override

	public List<Order_product> findAll() {

		// sesiunea curenta Hibernate
		Session currentSession = entityManager.unwrap(Session.class);

		// creez query
		Query<Order_product> theQuery = currentSession.createQuery("from Order_product", Order_product.class);

		// execut interogarea si obtin result list

		List<Order_product> order_products = theQuery.getResultList();

		return order_products;

	}

	@Override
	public Order_product findById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		// obtin produsele
		Order_product theOrder_product = currentSession.get(Order_product.class, theId);

		return theOrder_product;
	}

}
