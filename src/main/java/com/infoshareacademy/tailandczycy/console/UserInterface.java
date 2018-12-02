package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.BudgetManager;
import com.infoshareacademy.tailandczycy.service.Category;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class UserInterface {

    private ConsoleReader consoleReader = new ConsoleReader();
    private BudgetManager budgetManager = new BudgetManager();

    public void addExpense() {
        List<String> categories = budgetManager.gettingCategoriesFromUser();
        System.out.println("Give amount: ");
        BigDecimal amount = consoleReader.readBigDecimal();
        System.out.println("Give comment: ");
        String comment = consoleReader.readString();
        System.out.println("Give date: ");
        LocalDate dateOfExpense =  LocalDate.parse(consoleReader.readString());
        budgetManager.addExpense(categories, comment, amount, dateOfExpense);

    }

    public void modifyExpense() {
        System.out.println("type in id of an expense to be modified: ");
        int id = consoleReader.readInt();
        int option;
        do {
            budgetManager.displayExactExpense(id);
            System.out.println("1. Change categories \n" +
                                "2. Change comment \n" +
                                "3. Change amount \n" +
                                "4. Change date \n" +
                                "10. Go back");
            System.out.println("Choose an option: ");
            option = consoleReader.readInt();
            budgetManager.modifyExpenseSwitch(id, option);
        }while(option!=10);
    }

    public void deleteExpense() {
        System.out.println("type in id of an expense to be deleted: ");
        int id = consoleReader.readInt();
        budgetManager.deleteExpense(id);
        System.out.println("1. repeat operation\n" +
                           "2. quit");
        if(consoleReader.readInt()==1){
            deleteExpense();
        }
    }

    public void addCategory() {
        //user interface (submenu)
    }

    public void deleteCategory() {
        //user interface (submenu)
    }

    public void displayExpensePerCategory() {
        System.out.println("Type in category for expenses to be displayed: ");
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
        String stringCategory = consoleReader.readString();
        Category category = budgetManager.checkForCategory(stringCategory).orElse(null);

        System.out.println("Give limit: ");
        BigDecimal limit = consoleReader.readBigDecimal();

        System.out.println(budgetManager.setUpLimit(category, limit));
    }
}
