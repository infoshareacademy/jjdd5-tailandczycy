package com.infoshareacademy.tailandczycy.dao;

import com.infoshareacademy.tailandczycy.model.Expense;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ExpenseDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Expense s) {
        entityManager.persist(s);
        return s.getId();
    }

    public Expense update(Expense s) {
        return entityManager.merge(s);
    }

    public void delete(Long id) {
        final Expense s = entityManager.find(Expense.class, id);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public Expense findById(Long id) {
        return entityManager.find(Expense.class, id);
    }

    public List<Expense> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Expense s");

        return query.getResultList();
    }
}
