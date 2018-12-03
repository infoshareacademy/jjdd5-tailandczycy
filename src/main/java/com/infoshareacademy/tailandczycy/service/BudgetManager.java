package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.ConsoleReader;
import com.infoshareacademy.tailandczycy.console.UserInterface;
import com.infoshareacademy.tailandczycy.data.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.data.dao.ExpenseDao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class BudgetManager {
    private ConsoleReader consoleReader = new ConsoleReader();
    private ExpenseDao expenseDao = new ExpenseDao();
    private CategoryDao categoryDao = new CategoryDao();
    private Budget budgetDao = new Budget();
    private UserInterface userInterface = new UserInterface();

    public void addExpense(List<String> categories, String comment, BigDecimal amount, LocalDate localDate) {
        int id;
        if (expenseDao.getAll().size() == 0) {
            id = 0;
        } else {
            id = expenseDao.get(expenseDao.getAll().size() - 1).get().getId() + 1;
        }
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

        category.setName(name);
        category.setLimit(limit);
        categoryDao.add(category);
    }

    public void addCategory(String name){
        Category category = new Category();

        category.setName(name);
        category.setLimit(budgetDao.getBudget());
        categoryDao.add(category);
    }

    public void deleteCategory(String name) {
        categoryDao.delete(name);
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
    }

    public Category setUpLimit(String category, BigDecimal limit) {

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

    public void modifyExpenseSwitch(int id, int option) {
        switch (option) {
            case 1:
                userInterface.changeCategories(id);
                break;
            case 2:
                userInterface.changeComment(id);
                break;
            case 3:
                userInterface.changeAmount(id);
                break;
            case 4:
                userInterface.changeDate(id);
                break;
            case 10:
                break;
            default:
                System.out.println("\nWrong input \n");
        }
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

    public boolean dateChecker(String date) {

        return date.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$");
    }

    public boolean checkIfDateParsable(String date) {
        LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean checkIfExpensePresent(int id) {
        return expenseDao.get(id).isPresent();
    }

    public boolean checkIfCategoryPresent(String name) {
        return categoryDao.get(name).isPresent();
    }
}
