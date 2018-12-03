package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.BudgetManager;

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
        } while (option != 2);
        System.out.println("Type in comment: ");
        comment = consoleReader.readString();
        System.out.println("Type in amount: ");
        amount = consoleReader.readBigDecimal();
        System.out.println("Type in date in format yyyy-mm-dd: ");
        date = consoleReader.readString();
        while (!budgetManager.checkIfDateParsable(date)) {
            System.out.println("Wrong format ;d");
            System.out.println("Enter date again: ");
            date = consoleReader.readString();
        }
        budgetManager.addExpense(categories, comment, amount, LocalDate.parse(date));
    }

    public void modifyExpense() {
        int option;

        int id = consoleReader.readInt();
        if(budgetManager.checkIfExpensePresent(id)) {
            System.out.println("type in id of an expense to be modified: ");
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
            } while (option != 10);
        }else{
            System.out.println("no such expense");
        }
    }

    public void deleteExpense() {
        System.out.println("Type in id of an expense to be deleted: ");
        int id = consoleReader.readInt();
        if (budgetManager.checkIfExpensePresent(id)) {
            budgetManager.deleteExpense(id);
        } else {
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
        String category;
        BigDecimal limit;

        System.out.println("Type in category to set up its limit: ");
        category = consoleReader.readString();
        System.out.println("Type in limit to be set up");
        limit = consoleReader.readBigDecimal();
        if (budgetManager.checkIfCategoryPresent(category)) {
            budgetManager.setUpLimit(category, limit);
        }
    }

    public void changeCategories(int id) {
        String category;
        List<String> categories = new ArrayList<>();
        int option;

        System.out.println("Type in new set of categories each accepted by enter button: \n" +
                "Type in 10 to go back.");
        do {
            category = consoleReader.readString();
            categories.add(category);
            System.out.println("1 repeat operation");
            System.out.println("2. finish adding categories");
            option = consoleReader.readInt();
        } while (!category.equals("2"));
        System.out.println(categories);
        System.out.println("Do you want to save?");
        System.out.println("y/n");
        if (consoleReader.readString().equals("y")) {
            budgetManager.changeCategories(id, categories);
        }
    }

    public void changeComment(int id) {


    }
}
