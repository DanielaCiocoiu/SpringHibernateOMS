package com.home.springboot.OMS.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.springboot.OMS.entity.Product;


@Repository
public class ProductDAOHibernateImpl implements ProductDAO {

	private EntityManager entityManager;//creat automat de Spring Boot
	
	
	public ProductDAOHibernateImpl(EntityManager theEntityManager) {
	
		entityManager = theEntityManager;
	}


	@Override
	@Transactional
	public List<Product> findAll() {
		
		// sesiunea curenta Hibernate
		
		//creez query
		
		//execut interogarea si obtin result list
		
		//returnez rezultatele
		
		
		
		return null;
	}

}
