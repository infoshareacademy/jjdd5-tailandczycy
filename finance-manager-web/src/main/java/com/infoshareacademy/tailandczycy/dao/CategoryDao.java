package com.infoshareacademy.tailandczycy.dao;

import com.infoshareacademy.tailandczycy.model.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Category s) {
        entityManager.persist(s);
        return s.getId();
    }

    public Category update(Category s) {
        return entityManager.merge(s);
    }

    public void delete(Long id) {
        final Category s = entityManager.find(Category.class, id);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Category s");

        return query.getResultList();
    }
}
