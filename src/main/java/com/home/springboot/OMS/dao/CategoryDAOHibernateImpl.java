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

    private EntityManager entityManager;

    @Autowired
    public CategoryDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override

    public List<Category> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Category> theQuery = currentSession.createQuery("from Category", Category.class);

        List<Category> categories = theQuery.getResultList();

        return categories;
    }

    @Override
    public Category findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Category theCategory = currentSession.get(Category.class, theId);

        return theCategory;
    }

}
