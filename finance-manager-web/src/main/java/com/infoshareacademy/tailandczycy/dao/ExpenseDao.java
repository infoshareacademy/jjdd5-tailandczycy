package com.infoshareacademy.tailandczycy.dao;

import com.infoshareacademy.tailandczycy.service.Expense;

import javax.ejb.Local;

@Local
public interface ExpenseDao {
    void deleteExpense(Long id);

    Expense getExpenseById(Long id);

    void addExpense(Expense expense);

}
