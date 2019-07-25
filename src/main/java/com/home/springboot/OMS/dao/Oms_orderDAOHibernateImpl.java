package com.home.springboot.OMS.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.springboot.OMS.entity.Oms_order;

@Repository
public class Oms_orderDAOHibernateImpl implements Oms_orderDAO {

	private EntityManager entityManager;

	@Autowired
	public Oms_orderDAOHibernateImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Oms_order> findAll() {
		// sesiunea curenta Hibernate
		Session currentSession = entityManager.unwrap(Session.class);

		// creez query
		Query<Oms_order> theQuery = currentSession.createQuery("from Oms_order", Oms_order.class);

		// execut interogarea si obtin result list

		List<Oms_order> Orders = theQuery.getResultList();

		return Orders;
	}

	@Override
	public Oms_order findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		// obtin produsele
		Oms_order theOrder = currentSession.get(Oms_order.class, theId);

		return theOrder;
	}

	@Override
	public void save(Oms_order theOrder) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theOrder);

	}

}
