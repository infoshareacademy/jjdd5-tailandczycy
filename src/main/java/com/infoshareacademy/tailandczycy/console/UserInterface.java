package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.BudgetManager;
import com.infoshareacademy.tailandczycy.service.Category;

import java.math.BigDecimal;

public class UserInterface {
    ConsoleReader consoleReader = new ConsoleReader();
    CategoryChecker categoryChecker = new CategoryChecker();
    BudgetManager budgetManager;
    //TODO: Make list of categories to check if method is working in line 53

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
         Category category = categoryChecker.()

        System.out.println("Give limit: ");
        BigDecimal limit = consoleReader.readBigDecimal();


    }
}
