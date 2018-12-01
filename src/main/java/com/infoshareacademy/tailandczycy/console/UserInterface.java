package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.BudgetManager;
import com.infoshareacademy.tailandczycy.service.Category;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class UserInterface {

    private ConsoleReader consoleReader = new ConsoleReader();
    private CategoryChecker categoryChecker = new CategoryChecker();
    private BudgetManager budgetManager = new BudgetManager();

    public void addExpense() {
        List<String> categories = budgetManager.gettingCategoriesFromUser();
        System.out.println("Give amount: ");
        BigDecimal amount = consoleReader.readBigDecimal();
        System.out.println("Give comment: ");
        String comment = consoleReader.readString();
        System.out.println("Give date: ");
        LocalDate dateOfExpense =  LocalDate.parse(consoleReader.readString());
        
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
        Category category = categoryChecker.checkForCategory().orElse(null);

        System.out.println("Give limit: ");
        BigDecimal limit = consoleReader.readBigDecimal();

        System.out.println(budgetManager.setUpLimit(category, limit));
    }
}
