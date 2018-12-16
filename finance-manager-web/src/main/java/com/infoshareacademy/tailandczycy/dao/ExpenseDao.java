package com.infoshareacademy.tailandczycy.dao;

import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    public List<Expense> findExpensesPerCategory(Category category) {
        final Query query = entityManager
                .createNamedQuery("Expense.findExpensesPerCategory");
        query.setParameter("param1", category);
        return query.getResultList();
    }

    public List<Expense> findExpensesCreatedAfterOrEven(LocalDate date) {
        final Query query = entityManager
                .createNamedQuery("Expense.findExpensesCreatedAfterOrEven");
        query.setParameter("param1", date);
        return query.getResultList();
    }

    public List<Expense> findExpensesCreatedBeforeOrEven(LocalDate date) {
        final Query query = entityManager
                .createNamedQuery("Expense.findExpensesCreatedBeforeOrEven");
        query.setParameter("param1", date);
        return query.getResultList();
    }

    public List<Expense> findExpensesCreatedAt(LocalDate date) {
        final Query query = entityManager
                .createNamedQuery("Expense.findExpensesCreatedAt");
        query.setParameter("param1", date);
        return query.getResultList();
    }

    public List<Expense> findExpensesCheaperOrEven(BigDecimal bigDecimal) {
        final Query query = entityManager
                .createNamedQuery("Expense.findExpensesCheaperOrEven");
        query.setParameter("param1", bigDecimal);
        return query.getResultList();
    }

    public List<Expense> findExpensesMoreExpOrEven(BigDecimal bigDecimal) {
        final Query query = entityManager
                .createNamedQuery("Expense.findExpensesMoreExpOrEven");
        query.setParameter("param1", bigDecimal);
        return query.getResultList();
    }

    public List<Expense> findExpensesEven(BigDecimal bigDecimal) {
        final Query query = entityManager
                .createNamedQuery("Expense.findExpensesEven");
        query.setParameter("param1", bigDecimal);
        return query.getResultList();
    }

    public List<Expense> findExpensesByName(String string) {
        final Query query = entityManager
                .createNamedQuery("Expense.findExpensesByName");
        query.setParameter("param1", string);
        return query.getResultList();
    }

    public List<Expense> orderByDateAscLimit5() {
        final Query query = entityManager
                .createNamedQuery("Expense.orderByDateAsc");
        return query.setMaxResults(5).getResultList();
    }

    public List<Expense> orderByDateDescLimit5() {
        final Query query = entityManager
                .createNamedQuery("Expense.orderByDateDesc");
        return query.setMaxResults(5).getResultList();
    }

    public List<Expense> orderByAmountAscLimit5() {
        final Query query = entityManager
                .createNamedQuery("Expense.orderByAmountAsc");
        return query.setMaxResults(5).getResultList();
    }

    public List<Expense> orderByAmountDescLimit5() {
        final Query query = entityManager
                .createNamedQuery("Expense.orderByAmountDesc");
        return query.setMaxResults(5).getResultList();
    }

    public List<Expense> findExpensesByDateBetween(LocalDate date1, LocalDate date2) {
        final Query query = entityManager
                .createNamedQuery("Expense.findExpensesByDateBetween");
        query.setParameter("param1", date1);
        query.setParameter("param2", date2);
        return query.getResultList();
    }
}
