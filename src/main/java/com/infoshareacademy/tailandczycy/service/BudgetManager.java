package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.ConsoleReader;
import com.infoshareacademy.tailandczycy.data.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.data.dao.ExpenseDao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class BudgetManager {
    private ConsoleReader consoleReader = new ConsoleReader();
    private ExpenseDao expenseDao = new ExpenseDao();
    private CategoryDao categoryDao = new CategoryDao();
    private Budget budgetDao = new Budget();

    public void addExpense(List<String> categories, String comment, BigDecimal amount, LocalDate localDate) {
        Expense expense = new Expense(categories, comment, amount, localDate);
        expenseDao.getAll().add(expense);
        expenseDao.save();
    }

    public void modifyExpense(int id, List<String> categories, String comment, BigDecimal amount, LocalDate localDate) {
        //modifies expense
    }

    public void deleteExpense(int id) {
        if(expenseDao.get(id).isPresent()){
            expenseDao.delete(expenseDao.get(id).get());
        }else{
            System.out.println("no such Expense");
        }
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
        categoryDao.save();
        return category;
    }

    public BigDecimal getActualBudget() {
        return budgetDao.getBudget().subtract(expenseDao.getAll().stream()
                .map(Expense::getAmount)
                .reduce(new BigDecimal(0), BigDecimal::add));
    }

    public List<String> gettingCategoriesFromUser() {
        boolean allCategories = true;
        List<String> categories = new ArrayList<>();
        while (allCategories) {
            System.out.println("Define category: ");
            categories.add(consoleReader.readString());
            System.out.println("Are those all categories?");
            System.out.println("If not click n otherwise y");
            String flag = consoleReader.readString();
            if (flag.equalsIgnoreCase("y")) {
                allCategories = false;
            }

        }
        return categories;
    }

    public Optional<Category> checkForCategory(String category) {
        return findCategory(category);
    }

    private Optional<Category> findCategory(String categoryString) {
        return categoryDao.getAll().stream()
                .filter(o -> o.getName().equals(categoryString))
                .findAny();
    }
}
