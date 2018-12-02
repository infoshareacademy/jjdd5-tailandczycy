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

        int id = expenseDao.get(expenseDao.getAll().size() - 1).get().getId() + 1;
        Expense expense = new Expense(categories, comment, amount, localDate);
        expense.setId(id);
        expenseDao.getAll().add(expense);
        expenseDao.save();
    }

    public void modifyExpense(int id, List<String> categories, String comment, BigDecimal amount, LocalDate localDate) {
        //modifies expense
    }

    public void deleteExpense(int id) {
        Expense tmpExpense = expenseDao.getAll().stream()
                .filter(expense -> expense.getId() == id)
                .findAny().get();
        expenseDao.delete(tmpExpense);
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

    public void displayExactExpense(int id) {
        if (expenseDao.get(id).isPresent()) {
            System.out.println(expenseDao.get(id).get());
        } else {
            System.out.println("no such expense");
        }
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

    public void modifyExpenseSwitch(int id, int option) {
        switch (option) {
            case 1:
                changeCategories(id);
                break;
            case 2:
                changeComment(id);
                break;
            case 3:
                changeAmount(id);
                break;
            case 4:
                changeDate(id);
                break;
            case 10:
                break;
            default:
                System.out.println("Wrong input \n");
        }
    }

    private void changeCategories(int id) {
        System.out.println("Type in new set of categories each accepted by enter button: \n" +
                "Type in 10 to go back.");
        String category;
        List<String> categories = new ArrayList<>();
        do {
            category = consoleReader.readString();
            if (!category.equals("10")) {
                categories.add(category);
            }
        } while (!category.equals("10"));

        System.out.println(categories);
        System.out.println("Do you want to save?");
        System.out.println("y/n");
        if (consoleReader.readString().equals("y")) {
            expenseDao.get(id).get().setCategories(categories);
            expenseDao.save();
        }
    }

    private void changeComment(int id) {
        System.out.println("Type in comment: \n" +
                "Type in 10 to go back.");
        String comment;
        comment = consoleReader.readString();
        if (!comment.equals("10")) {
            System.out.println("Do you want to save?");
            System.out.println("y/n");
            if (consoleReader.readString().equals("y")) {
                expenseDao.get(id).get().setComment(comment);
            }
        }
    }

    private void changeAmount(int id) {
        System.out.println("Type in amount: ");
        BigDecimal amount;
        amount = consoleReader.readBigDecimal();
        System.out.println("Do you want to save?");
        System.out.println("y/n");
        if (consoleReader.readString().equals("y")) {
            expenseDao.get(id).get().setAmount(amount);
        }
    }

    private void changeDate(int id) {
        System.out.println("Type int Date in format yyyy-mm-dd");
        String date = consoleReader.readString();
        if (dateChecker(date)) {
            System.out.println("Do you want to save?");
            System.out.println("y/n");
            if (consoleReader.readString().equals("y")) {
                expenseDao.get(id).get().setDate(LocalDate.parse(date));
            }
        } else {
            System.out.println("Wrong format ;d");
        }
    }

    private boolean dateChecker(String date) {

        return date.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$");
    }
}
