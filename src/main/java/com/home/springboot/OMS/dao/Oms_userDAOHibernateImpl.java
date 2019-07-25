package com.home.springboot.OMS.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.home.springboot.OMS.entity. Oms_user;

@Repository
public class  Oms_userDAOHibernateImpl implements  Oms_userDAO {

	private EntityManager entityManager;

	@Autowired
	public  Oms_userDAOHibernateImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override

	public List< Oms_user> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query< Oms_user> theQuery = currentSession.createQuery("from  Oms_user",  Oms_user.class);
		List< Oms_user>  Oms_users = theQuery.getResultList();
		return Oms_users;
	}

	@Override
	public  Oms_user findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		 Oms_user theOms_user = currentSession.get( Oms_user.class, theId);

		return theOms_user;
	}
	@Override
	public void save( Oms_user theOms_user) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theOms_user);
	}

	@Override
	public void update( Oms_user theOms_user) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theOms_user);
	}

}
