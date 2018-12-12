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
        boolean abort = false;
        String option;
        List<String> categories = new ArrayList<>();
        String comment;
        BigDecimal amount;
        String date;

        System.out.println("Type in Categories for the expense: ");
        do {
            String category = consoleReader.readString();
            categories.add(category.toLowerCase());
            System.out.println("1. repeat operation");
            System.out.println("2. finish adding categories for the expense");
            option = consoleReader.readString();
        } while (!option.equals("2"));
        System.out.println("Type in comment: ");
        comment = consoleReader.readString();
        System.out.println("Type in amount: ");
        amount = consoleReader.readBigDecimal();
        while (budgetManager.isExceedingLimit(categories, amount)) {
            System.out.println("Expense has exceeded category limit");
            System.out.println("do you want to continue?");
            System.out.println("y/n");
            if (consoleReader.readString().equals("y")) {
                amount = consoleReader.readBigDecimal();
            } else {
                abort = true;
                break;
            }
        }
        if (!abort) {
            System.out.println("Type in date in format yyyy-mm-dd: ");
            date = consoleReader.readString();
            while (!budgetManager.checkIfDateParsable(date)) {
                System.out.println("Wrong format ;d");
                System.out.println("Enter date again: ");
                date = consoleReader.readString();
            }
            budgetManager.addExpense(categories, comment, amount, LocalDate.parse(date));
        }
    }

    public void modifyExpense() {
        int option;

        System.out.println("type in id of an expense to be modified: ");
        int id = consoleReader.readInt();
        if (budgetManager.checkIfExpensePresent(id)) {
            do {
                budgetManager.displayExactExpense(id);
                System.out.println("1. Change categories \n" +
                        "2. Change comment \n" +
                        "3. Change amount \n" +
                        "4. Change date \n" +
                        "10. Go back");
                System.out.println("Choose an option: ");
                option = consoleReader.readInt();
                modifyExpenseSwitch(id, option);
            } while (option != 10);
        } else {
            System.out.println("no such expense");
        }
    }

    public void changeCategories(int id) {
        String category;
        List<String> categories = new ArrayList<>();
        int option;

        System.out.println("Type in new set of categories each accepted by enter button: ");
        do {
            System.out.println("Type in category: ");
            category = consoleReader.readString();
            categories.add(category);
            System.out.println("1 repeat operation");
            System.out.println("2. finish adding categories");
            option = consoleReader.readInt();
        } while (option != 2);
        System.out.println(categories);
        System.out.println("Do you want to save?");
        System.out.println("y/n");
        if (consoleReader.readString().equals("y")) {
            budgetManager.changeCategories(id, categories);
        }
    }

    public void changeComment(int id) {
        String comment;

        System.out.println("Type in comment: ");
        comment = consoleReader.readString();
        System.out.println("Do you want to save?");
        System.out.println("y/n");
        if (consoleReader.readString().equals("y")) {
            budgetManager.changeComment(id, comment);
        }
    }

    public void changeAmount(int id) {
        BigDecimal amount;
        boolean abort = false;

        System.out.println("Type in amount: ");
        amount = consoleReader.readBigDecimal();
        while (budgetManager.isExceedingLimit(budgetManager.getExpense(id).get().getCategories(), amount)) {
            System.out.println("Thats too much for a category limit!");
            System.out.println("Do you want to continue?");
            System.out.println("y/n");
            if (consoleReader.readString().equals("y")) {
                System.out.println("Type in amount: ");
                amount = consoleReader.readBigDecimal();
            } else {
                abort = true;
                break;
            }
        }
        if (!abort) {
            System.out.println("Do you want to save?");
            System.out.println("y/n");
            if (consoleReader.readString().equals("y")) {
                budgetManager.changeAmount(id, amount);
            }
        }
    }

    public void changeDate(int id) {
        String date;

        System.out.println("Type in date in format yyyy-mm-dd: ");
        date = consoleReader.readString();
        while (!budgetManager.checkIfDateParsable(date)) {
            System.out.println("Wrong format ;d");
            System.out.println("Enter date again: ");
            date = consoleReader.readString();
        }
        budgetManager.changeDate(id, date);
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
        String name;
        BigDecimal limit;
        boolean abort = false;

        System.out.println("Type in name of category to be added: ");
        name = consoleReader.readString();
        while (budgetManager.checkIfCategoryPresent(name)) {
            System.out.println("This category already exists");
            System.out.println("Do you want to continue?");
            System.out.println("y/n");
            if (consoleReader.readString().equals("y")) {
                name = consoleReader.readString();
            } else {
                abort = true;
                break;
            }
        }
        if (!abort) {
            System.out.println("Do you want to add limit for your category?");
            System.out.println("y/n");
            if (consoleReader.readString().equals("y")) {
                System.out.println("Type in limit for you category: ");
                limit = consoleReader.readBigDecimal();
                while (limit.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("cant be negative value");
                    System.out.println("Type in new one");
                    limit = consoleReader.readBigDecimal();
                }
                budgetManager.addCategory(name, limit);
            } else {
                budgetManager.addCategory(name);
            }
        }
    }

    public void deleteCategory() {
        String name;

        System.out.println("Type in category to be deleted: ");
        name = consoleReader.readString();
        if (budgetManager.checkIfCategoryPresent(name)) {
            budgetManager.deleteCategory(name);

        } else {
            System.out.println("no such category");
        }
    }

    public void displayExpensePerCategory() {
        String category;

        System.out.println("Type in category for expenses to be displayed: ");
        category = consoleReader.readString();
        if (budgetManager.checkIfCategoryPresent(category.toLowerCase())) {
            budgetManager.displayExpensePerCategory(category.toLowerCase());
        } else {
            System.out.println("no such category");
        }
    }

    public void displayAllExpenses() {
        budgetManager.displayAllExpenses();
    }

    public void defineBudget() {
        BigDecimal budgetLimit;

        System.out.println("Define your budget: ");
        budgetLimit = consoleReader.readBigDecimal();
        while (budgetLimit.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("budget is below zero ;d");
            System.out.println("Type in value above or equal zero");
            budgetLimit = consoleReader.readBigDecimal();
        }
        budgetManager.defineBudget(budgetLimit);
    }

    public void setUpLimit() {
        String category;
        BigDecimal limit;

        System.out.println("Type in category to set up its limit: ");
        category = consoleReader.readString();
        if (budgetManager.checkIfCategoryPresent(category.toLowerCase())) {
            System.out.println("Type in limit to be set up");
            limit = consoleReader.readBigDecimal();
            while (limit.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("limit below zero ;d");
                System.out.println("Type in limit above zero");
                limit = consoleReader.readBigDecimal();
            }
            budgetManager.setUpLimit(category.toLowerCase(), limit);
        } else {
            System.out.println("no such category");
        }
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
                System.out.println("\nWrong input \n");
        }
    }
}