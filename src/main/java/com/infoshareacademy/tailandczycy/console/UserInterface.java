package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.service.BudgetManager;
import com.infoshareacademy.tailandczycy.service.Category;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UserInterface {
    private ConsoleReader consoleReader = new ConsoleReader();
    private CategoryChecker categoryChecker = new CategoryChecker();
    private BudgetManager budgetManager = new BudgetManager();
    private FileOperations fileOperations = new FileOperations();

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
        System.out.println("Define your budget: ");
        BigDecimal budgetLimit = consoleReader.readBigDecimal();
        budgetManager.defineBudget(budgetLimit);

    }

    public void setUpLimit() throws IOException {
        System.out.println("Give category: ");
        Category category = categoryChecker.checkForCategory(fileOperations.getListOfCategories()).orElse(null);
        System.out.println("Give limit: ");
        BigDecimal limit = consoleReader.readBigDecimal();
       budgetManager.setUpLimit(category, limit);
    }
}
