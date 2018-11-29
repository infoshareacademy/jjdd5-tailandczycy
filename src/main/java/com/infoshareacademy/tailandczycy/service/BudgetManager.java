package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BudgetManager {


//    public void setBudget(BigDecimal budget) {
//        this.budget = budget;
//    }
//
//    public BigDecimal getBudget() {
//        return budget;
//    }

    public void addExpense(String category, String comment, BigDecimal amount, LocalDate localDate) {
        //adds expense
    }

    public void modifyExpense(int id, String category, String comment, BigDecimal amount, LocalDate localDate) {
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
        //displays expense per category
    }

    public void displayAllExpenses() {
        //displays all expenses by id
    }

    public Budget defineBudget(BigDecimal actualBudget) {
        return new Budget(actualBudget);
    }

    public Map<Category, BigDecimal> setUpLimit(Category category, BigDecimal limit) {
        HashMap<Category, BigDecimal> categoryToLimit = new HashMap<>();
        categoryToLimit.put(category, limit);
        return categoryToLimit;
    }
}
