package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.BudgetManager;
import com.infoshareacademy.tailandczycy.service.Category;
import com.infoshareacademy.tailandczycy.service.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private ConsoleReader consoleReader = new ConsoleReader();
    private BudgetManager budgetManager = new BudgetManager();

    public void addExpense() {
        int option;
        List<String> categories = new ArrayList<>();
        String comment;
        BigDecimal amount;
        String date;

        System.out.println("Type in Categories for the expense: ");
        do {
            String category = consoleReader.readString();
            categories.add(category);
            System.out.println("1. repeat operation");
            System.out.println("2. finish adding categories for the expense");
            option = consoleReader.readInt();
        }while(option!=2);
        System.out.println("Type in comment: ");
        comment = consoleReader.readString();
        System.out.println("Type in amount: ");
        amount = consoleReader.readBigDecimal();
        System.out.println("Type in date in format yyyy-mm-dd: ");
        date = consoleReader.readString();
        while(!budgetManager.checkIfDateParsable(date)){
            System.out.println("Wrong format ;d");
            System.out.println("Enter date again: ");
            date = consoleReader.readString();
        }
        budgetManager.addExpense(categories, comment, amount, LocalDate.parse(date));
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
        System.out.println("Type in id of an expense to be deleted: ");
        int id = consoleReader.readInt();
        if(budgetManager.checkIfPresent(id)){
            budgetManager.deleteExpense(id);
        }else{
            System.out.println("no such expense");
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
