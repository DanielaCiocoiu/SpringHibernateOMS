package com.home.springboot.OMS.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.springboot.OMS.entity.Category;
import com.home.springboot.OMS.entity.Product;

@Repository
public class CategoryDAOHibernateImpl implements CategoryDAO {

	private EntityManager entityManager;// creat automat de Spring Boot

	@Autowired
	public CategoryDAOHibernateImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override

	public List<Category> findAll() {

		// sesiunea curenta Hibernate
		Session currentSession = entityManager.unwrap(Session.class);

		// creez query
		Query<Category> theQuery = currentSession.createQuery("from Category", Category.class);

		// execut interogarea si obtin result list

		List<Category> categories = theQuery.getResultList();

		return categories;

	}

	@Override
	public Category findById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		// obtin produsele
		Category theCategory = currentSession.get(Category.class, theId);

		return theCategory;
	}

}
