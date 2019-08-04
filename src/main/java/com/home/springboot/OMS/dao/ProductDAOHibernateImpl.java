package com.home.springboot.OMS.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.home.springboot.OMS.entity.Oms_order;
import com.home.springboot.OMS.entity.Product;

@Repository
public class ProductDAOHibernateImpl implements ProductDAO {

	private EntityManager entityManager;

	@Autowired
	public ProductDAOHibernateImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override

	public List<Product> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);

		List<Product> products = theQuery.getResultList();

		return products;

	}

	@Override
	public Product findById(int product_id) {

		Session currentSession = entityManager.unwrap(Session.class);

		Product theProduct = currentSession.get(Product.class, product_id);

		return theProduct;
	}

	@Override
	public List<Product> findByName(String product_name) {

		Session currentSession = entityManager.unwrap(Session.class);

		List<Product> theProductName = currentSession
				.createQuery("from Product p where p.product_name='" + product_name + "'", Product.class)
				.getResultList();

		return theProductName;
	}

	// localhost:8080/api/Petro/oms_orders
//		@Override
//		public List<Oms_order> findByUserName(String user_name) {
//			Session currentSession = entityManager.unwrap(Session.class);
///			List<Oms_order> orders = currentSession.createQuery
//			("from Oms_order o where o.oms_user.user_name='" + user_name + "'", Oms_order.class).getResultList();
//
//			return orders;
//		}

	@Override
	public List<Product> findByCat(String cat) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		List<Product> theCatProduct = currentSession.createQuery
				(" from Product p where p.category.cat=:cat", Product.class).getResultList();
		
		return theCatProduct;

	}
}
