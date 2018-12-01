package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.data.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.data.dao.ExpenseDao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BudgetManager {

    private ExpenseDao expenseDao = new ExpenseDao();
    private CategoryDao categoryDao = new CategoryDao();
    private Budget budgetDao = new Budget();

    public void addExpense(List<String> categories, String comment, BigDecimal amount, LocalDate localDate) {
        //adds expense
    }

    public void modifyExpense(int id, List<String> categories, String comment, BigDecimal amount, LocalDate localDate) {
        //modifies expense
    }

    public void deleteExpense(int id) {
        //deletes expense
    }

    public void addCategory(String name, BigDecimal limit) {
        //adds category with limit or not
    }

    public void deleteCategory(String name) {
        //deletes Category
    }

    public void displayExpensePerCategory(String name) {
        expenseDao.getAll().stream()
                .filter(expense -> expense.getCategories().contains(name))
                .forEach(System.out::println);
    }

    public void displayAllExpenses() {
        expenseDao.getAll()
                .forEach(System.out::println);
    }

    public Budget defineBudget(BigDecimal actualBudget) {
        return new Budget(actualBudget);
    }

    public Category setUpLimit(Category category, BigDecimal limit) {
        category.setLimit(limit);
        return category;
    }

    public BigDecimal getActualBudget(){
        return budgetDao.getBudget().subtract(expenseDao.getAll().stream()
                .map(Expense::getAmount)
                .reduce(new BigDecimal(0) , BigDecimal::add));
    }
}
