package com.infoshareacademy.tailandczycy.dao;

import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class ExpenseDao {

    static final String PARAM1 = "param1";
    static final String PARAM2 = "param2";

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
        final TypedQuery<Expense> query = entityManager.createQuery("SELECT s FROM Expense s", Expense.class);

        return query.getResultList();
    }

    public List<Expense> findExpensesPerCategory(Category category) {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.findExpensesPerCategory", Expense.class);
        query.setParameter(PARAM1, category);
        return query.getResultList();
    }

    public List<Expense> findExpensesCreatedAfterOrEven(LocalDate date) {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.findExpensesCreatedAfterOrEven", Expense.class);
        query.setParameter(PARAM1, date);
        return query.getResultList();
    }

    public List<Expense> findExpensesCreatedBeforeOrEven(LocalDate date) {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.findExpensesCreatedBeforeOrEven", Expense.class);
        query.setParameter(PARAM1, date);
        return query.getResultList();
    }

    public List<Expense> findExpensesCreatedAt(LocalDate date) {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.findExpensesCreatedAt", Expense.class);
        query.setParameter(PARAM1, date);
        return query.getResultList();
    }

    public List<Expense> findExpensesCheaperOrEven(BigDecimal bigDecimal) {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.findExpensesCheaperOrEven", Expense.class);
        query.setParameter(PARAM1, bigDecimal);
        return query.getResultList();
    }

    public List<Expense> findExpensesMoreExpOrEven(BigDecimal bigDecimal) {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.findExpensesMoreExpOrEven", Expense.class);
        query.setParameter(PARAM1, bigDecimal);
        return query.getResultList();
    }

    public List<Expense> findExpensesEven(BigDecimal bigDecimal) {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.findExpensesEven", Expense.class);
        query.setParameter(PARAM1, bigDecimal);
        return query.getResultList();
    }

    public List<Expense> findExpensesByName(String string) {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.findExpensesByName", Expense.class);
        query.setParameter(PARAM1, string);
        return query.getResultList();
    }

    public List<Expense> orderByDateAscLimit5() {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.orderByDateAsc", Expense.class);
        return query.setMaxResults(5).getResultList();
    }

    public List<Expense> orderByDateDescLimit5() {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.orderByDateDesc", Expense.class);
        return query.setMaxResults(5).getResultList();
    }

    public List<Expense> orderByAmountAscLimit5() {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.orderByAmountAsc", Expense.class);
        return query.setMaxResults(5).getResultList();
    }

    public List<Expense> orderByAmountDescLimit5() {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.orderByAmountDesc", Expense.class);
        return query.setMaxResults(5).getResultList();
    }

    public List<Expense> findExpensesByDateBetween(LocalDate date1, LocalDate date2) {
        final TypedQuery<Expense> query = entityManager
                .createNamedQuery("Expense.findExpensesByDateBetween", Expense.class);
        query.setParameter(PARAM1, date1);
        query.setParameter(PARAM2, date2);
        return query.getResultList();
    }
}
