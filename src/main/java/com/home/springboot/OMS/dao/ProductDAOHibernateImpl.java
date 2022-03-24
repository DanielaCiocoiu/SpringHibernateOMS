package com.home.springboot.OMS.dao;

import com.home.springboot.OMS.entity.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

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

    @Override
    public List<Product> findByCat(String cat) {
        Session currentSession = entityManager.unwrap(Session.class);

        List<Product> theCatProduct = currentSession.createQuery
                (" from Product p where p.category.cat=:cat", Product.class).getResultList();

        return theCatProduct;

    }
}
