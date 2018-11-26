package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.ConsoleReader;
import com.infoshareacademy.tailandczycy.data.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.data.dao.ExpenseDao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BudgetManager {

    private List<Expense> expenses;
    private BigDecimal totalBudget;
    private ConsoleReader consoleReader;

    private final ExpenseDao expenseDao;
    private final CategoryDao categoryDao;


    public BudgetManager(ExpenseDao expenseDao, CategoryDao categoryDao) {
        this.expenseDao = expenseDao;
        this.categoryDao = categoryDao;

        expenses = new ArrayList<>();
        consoleReader = new ConsoleReader();
    }


    public void addExpense(Expense e) {
        //Adding expense
        expenseDao.addExpense(e);
    }

    public void modifyExpense(Integer expenseId, Expense updatedValue) {
        //  int id = consoleReader.readInt();
        Expense current = expenseDao.getExpenseById(expenseId);
        current.setAmount(updatedValue.getAmount());
        expenseDao.save(current);
        //modifying expense
    }

    public void deleteExpense(Integer id) {

        //int id = consoleReader.readInt();
        expenseDao.delete(id);
        //deleting expense
    }

    public void addCategory(Category newCategory) {
        categoryDao.add(newCategory);
        //adding category
    }

    public void deleteCategory() {
        //deletingCategory
    }

    public void displayExpensePerCategory() {
        //display expense per category
    }

    public void displayAllExpenses() {
        //display all expenses
    }

    public void defineBudget() {
        //set up budget
    }

    public void setUpLimit() {
        //set up limit
    }
}
