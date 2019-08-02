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

		Session currentSession = entityManager.unwrap(Session.class); 

		Query<Oms_order> theQuery = currentSession.createQuery("from Oms_order", Oms_order.class);

		List<Oms_order> Orders = theQuery.getResultList();

		return Orders;
	}

	@Override
	public Oms_order findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Oms_order theOrder = currentSession.get(Oms_order.class, theId);

		return theOrder;
	}

	@Override
	public void save(Oms_order theOrder) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theOrder);

	}
	
	// Retrieve Order GET …/{user_name}/oms_orders
	// localhost:8080/api/Petro/oms_orders
	@Override
	public List<Oms_order> findByUserName(String user_name) {
		Session currentSession = entityManager.unwrap(Session.class);

		List<Oms_order> orders = currentSession.createQuery
		("from Oms_order o where o.oms_user.user_name='" + 
		user_name + "'", Oms_order.class).getResultList();

		return orders;
	}
	
	@Override
	public void saveByUserName(Oms_order user_name) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(user_name);
		
		
	}


}
