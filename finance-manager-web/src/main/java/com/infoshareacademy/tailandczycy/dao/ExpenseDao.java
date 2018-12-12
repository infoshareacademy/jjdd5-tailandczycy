package com.infoshareacademy.tailandczycy.dao;

import com.infoshareacademy.tailandczycy.service.Expense;

import javax.ejb.Local;

@Local
public interface ExpenseDao {
    void deleteExpense(Integer id);

    Expense getExpenseById(Integer id);

    void addExpense(Expense expense);
}
