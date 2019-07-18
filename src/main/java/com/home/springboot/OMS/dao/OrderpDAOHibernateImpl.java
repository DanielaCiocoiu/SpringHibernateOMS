package com.home.springboot.OMS.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.springboot.OMS.entity.Orderp;
import com.home.springboot.OMS.entity.Product;
import com.home.springboot.OMS.entity.User;

@Repository
public class OrderpDAOHibernateImpl implements OrderpDAO {

	private EntityManager entityManager;

	@Autowired
	public OrderpDAOHibernateImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Orderp> findAll() {
		// sesiunea curenta Hibernate
		Session currentSession = entityManager.unwrap(Session.class);

		// creez query
		Query<Orderp> theQuery = currentSession.createQuery("from Orderp", Orderp.class);

		// execut interogarea si obtin result list

		List<Orderp> Orderps = theQuery.getResultList();

		return Orderps;
	}

	@Override
	public Orderp findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		// obtin produsele
		Orderp theOrderp = currentSession.get(Orderp.class, theId);

		return theOrderp;
	}

	@Override
	public void save(Orderp theOrderp) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theOrderp);

	}

}
