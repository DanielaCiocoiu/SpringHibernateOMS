package com.home.springboot.OMS.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.springboot.OMS.entity.Order;

@Repository
public class OrderDAOHibernateImpl implements OrderDAO {

	private EntityManager entityManager;

	@Autowired
	public OrderDAOHibernateImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Order> findAll() {
		// sesiunea curenta Hibernate
		Session currentSession = entityManager.unwrap(Session.class);

		// creez query
		Query<Order> theQuery = currentSession.createQuery("from Order", Order.class);

		// execut interogarea si obtin result list

		List<Order> Orders = theQuery.getResultList();

		return Orders;
	}

	@Override
	public Order findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		// obtin produsele
		Order theOrder = currentSession.get(Order.class, theId);

		return theOrder;
	}

	@Override
	public void save(Order theOrder) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theOrder);

	}

}
