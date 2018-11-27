package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BudgetManager {

    private BigDecimal Budget;

    public void setBudget(BigDecimal budget) {
        this.Budget = budget;
    }

    public BigDecimal getBudget() {
        return Budget;
    }

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

    public void defineBudget(BigDecimal budget) {
        //TODO: Ask user for Category
        // TODO: Ask user for Integer and make it limit
        //TODO: Make from both variables map where Category will have limit
    }

    public void setUpLimit(BigDecimal budget) {
        //sets up limit for category
    }
}
