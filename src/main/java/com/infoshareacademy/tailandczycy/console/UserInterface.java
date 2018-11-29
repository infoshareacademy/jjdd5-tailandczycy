package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.BudgetManager;
import com.infoshareacademy.tailandczycy.service.Category;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UserInterface {
    ConsoleReader consoleReader = new ConsoleReader();
    CategoryChecker categoryChecker = new CategoryChecker();
    BudgetManager budgetManager;
    List<Category> listOfCategory = Stream.of(new Category("Party"), new Category("Food"), new Category("Sex") ).collect(Collectors.toList());

    public UserInterface() {
        BudgetManager budgetManager = new BudgetManager();
    }

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
        //user interface (submenu)
    }

    public void displayAllExpenses() {
        //user interface (submenu)
    }

    public void defineBudget() {
        //user interface (submenu)
    }

    public void setUpLimit() {
        System.out.println("Give category: ");
        Category category = categoryChecker.checkForCategory(listOfCategory).orElse(null);

        System.out.println("Give limit: ");
        BigDecimal limit = consoleReader.readBigDecimal();

        System.out.println(budgetManager.setUpLimit(category, limit));
    }
}
