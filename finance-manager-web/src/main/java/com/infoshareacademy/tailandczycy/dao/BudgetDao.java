package com.infoshareacademy.tailandczycy.dao;

import com.infoshareacademy.tailandczycy.model.Budget;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class BudgetDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Budget s) {
        entityManager.persist(s);
        return s.getId();
    }

    public Budget update(Budget s) {
        return entityManager.merge(s);
    }

    public void delete(Long id) {
        final Budget s = entityManager.find(Budget.class, id);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public Budget findById(Long id) {
        return entityManager.find(Budget.class, id);
    }

    public List<Budget> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Budget s");

        return query.getResultList();
    }
}
