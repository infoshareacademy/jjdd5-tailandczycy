package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.data.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.data.dao.ExpenseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class BudgetManager {

    public static final Logger LOG = LoggerFactory.getLogger(BudgetManager.class);

    private ExpenseDao expenseDao = new ExpenseDao();
    private CategoryDao categoryDao = new CategoryDao();
    private Budget budgetDao = new Budget();

    public void addExpense(List<String> categories, String comment, BigDecimal amount, LocalDate localDate) {
        int id;
        if (expenseDao.getAll().size() == 0) {
            id = 0;
        } else {
            id = expenseDao.getAll().size();
        }
        categories.stream()
                .filter(c -> !checkIfCategoryPresent(c))
                .forEach(c -> addCategory(c));
        Expense expense = new Expense();
        expense.setId(id);
        expense.setCategories(categories);
        expense.setComment(comment);
        expense.setAmount(amount);
        expense.setDate(localDate);
        expenseDao.add(expense);
    }

    public void deleteExpense(int id) {
        expenseDao.delete(id);
    }

    public void addCategory(String name, BigDecimal limit) {
        Category category = new Category();

        category.setName(name.toLowerCase());
        category.setLimit(limit);
        categoryDao.add(category);
    }

    public void addCategory(String name) {
        Category category = new Category();

        category.setName(name);
        category.setLimit(budgetDao.getBudget());
        categoryDao.add(category);
    }

    public void deleteCategory(String name) {
        categoryDao.delete(name);
        expenseDao.getAll().stream()
                .filter(expense -> expense.getCategories().contains(name))
                .peek(expense -> expense.getCategories().remove(name))
                .forEach(expense -> expenseDao.update(expense));
        expenseDao.getAll().stream()
                .filter(expense -> expense.getCategories().size() == 0)
                .peek(expense -> expense.setCategories(Collections.singletonList("other")))
                .forEach(expense -> expenseDao.update(expense));
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

    public void displayExactExpense(int id) {
        if (checkIfExpensePresent(id)) {
            System.out.println(expenseDao.get(id).get());
        } else {
            System.out.println("no such expense");
        }
    }

    public void defineBudget(BigDecimal actualBudget) {
        budgetDao.setBudget(actualBudget);
        budgetDao.save();
    }

    public void setUpLimit(String name, BigDecimal limit) {

        Category category = new Category();
        category.setName(name);
        category.setLimit(limit);
        categoryDao.update(category);
    }

    public boolean isExceedingLimit(List<String> categories, BigDecimal amount) {
        return categories.stream()
                .filter(c -> categoryDao.get(c).isPresent())
                .anyMatch(c -> categoryDao.get(c).get().getLimit().compareTo(getSumOfExpensesPerCategory(c).add(amount)) < 0);
    }

    public BigDecimal getActualBudget() {
        return budgetDao.getBudget().subtract(expenseDao.getAll().stream()
                .map(Expense::getAmount)
                .reduce(new BigDecimal(0), BigDecimal::add));
    }

    public Optional<Expense> getExpense(int id) {
        return expenseDao.get(id);
    }

    public BigDecimal getSumOfExpensesPerCategory(String name) {
        String nameToLower = name.toLowerCase();
        return expenseDao.getAll().stream()
                .filter(expense -> expense.getCategories().contains(nameToLower.toLowerCase()))
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void changeCategories(int id, List<String> categories) {

        Expense expense = expenseDao.get(id).get();
        expense.setCategories(categories);
        expenseDao.update(expense);
    }

    public void changeComment(int id, String comment) {
        Expense expense = expenseDao.get(id).get();
        expense.setComment(comment);
        expenseDao.update(expense);
    }


    public void changeAmount(int id, BigDecimal amount) {
        Expense expense = expenseDao.get(id).get();
        expense.setAmount(amount);
        expenseDao.update(expense);
    }


    public void changeDate(int id, String date) {
        Expense expense = expenseDao.get(id).get();
        expense.setDate(LocalDate.parse(date));
        expenseDao.update(expense);
    }

    public boolean checkIfDateParsable(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean checkIfExpensePresent(int id) {
        return expenseDao.get(id).isPresent();
    }

    public boolean checkIfCategoryPresent(String name) {
        return categoryDao.get(name.toLowerCase()).isPresent();
    }
}
