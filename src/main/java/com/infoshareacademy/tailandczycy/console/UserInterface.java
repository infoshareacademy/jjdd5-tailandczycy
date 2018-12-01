package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.BudgetManager;
import com.infoshareacademy.tailandczycy.service.Category;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UserInterface {
    private ConsoleReader consoleReader = new ConsoleReader();
    private CategoryChecker categoryChecker = new CategoryChecker();
    private BudgetManager budgetManager = new BudgetManager();
    private List<Category> listOfCategory = Stream.of(new Category("Party"), new Category("Food"), new Category("Sex")).collect(Collectors.toList());

    public void addExpense() {
        //user interface (submenu)
    }

    public void modifyExpense() {
        //user interface (submenu)
    }

    public void deleteExpense() {
        //user interface (submenu)
    }

    public void addCategory() {
        //user interface (submenu)
    }

    public void deleteCategory() {
        //user interface (submenu)
    }

    public void displayExpensePerCategory() {
        budgetManager.displayExpensePerCategory(consoleReader.readString());
    }

    public void displayAllExpenses() {
        budgetManager.displayAllExpenses();
    }

    public void defineBudget() {
        System.out.println("Define your budget: ");
        BigDecimal budgetLimit = consoleReader.readBigDecimal();
        budgetManager.defineBudget(budgetLimit);

    }

    public void setUpLimit() {
        System.out.println("Give category: ");
        Category category = categoryChecker.checkForCategory(listOfCategory).orElse(null);

        System.out.println("Give limit: ");
        BigDecimal limit = consoleReader.readBigDecimal();

        System.out.println(budgetManager.setUpLimit(category, limit));
    }
}
