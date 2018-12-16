package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.BudgetManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private static final Logger LOG = LoggerFactory.getLogger(UserInterface.class);

    private ConsoleReader consoleReader = new ConsoleReader();
    private BudgetManager budgetManager = new BudgetManager();
    private final String TYPE_IN_AMOUNT = "type in amount: ";
    private final String DO_YOU_WANT_TO_SAVE = "do you want to save?";
    private final String NO_SUCH_CATEGORY = "no such category";

    public void addExpense() {
        boolean abort = false;
        String option;
        List<String> categories = new ArrayList<>();
        String comment;
        BigDecimal amount;
        String date;

        LOG.info("Type in Categories for the expense: ");
        do {
            String category = consoleReader.readString();
            categories.add(category.toLowerCase());
            LOG.info("1. repeat operation");
            LOG.info("2. finish adding categories for the expense");
            option = consoleReader.readString();
        } while (!option.equals("2"));
        LOG.info("Type in comment: ");
        comment = consoleReader.readString();
        LOG.info(TYPE_IN_AMOUNT);
        amount = consoleReader.readBigDecimal();
        while (budgetManager.isExceedingLimit(categories, amount)) {
            LOG.warn("Expense has exceeded category limit");
            LOG.info("do you want to continue?");
            LOG.info("y/n");
            if (consoleReader.readString().equals("y")) {
                amount = consoleReader.readBigDecimal();
            } else {
                abort = true;
                break;
            }
        }
        if (!abort) {
            LOG.info("Type in date in format yyyy-mm-dd: ");
            date = consoleReader.readString();
            while (!budgetManager.checkIfDateParsable(date)) {
                LOG.error("Wrong format ;d");
                LOG.info("Enter date again: ");
                date = consoleReader.readString();
            }
            budgetManager.addExpense(categories, comment, amount, LocalDate.parse(date));
        }
    }

    public void modifyExpense() {
        int option;

        LOG.info("type in id of an expense to be modified: ");
        int id = consoleReader.readInt();
        if (budgetManager.checkIfExpensePresent(id)) {
            do {
                budgetManager.displayExactExpense(id);
                LOG.info("1. Change categories \n" +
                        "2. Change comment \n" +
                        "3. Change amount \n" +
                        "4. Change date \n" +
                        "10. Go back");
                LOG.info("Choose an option: ");
                option = consoleReader.readInt();
                modifyExpenseSwitch(id, option);
            } while (option != 10);
        } else {
            LOG.error("no such expense");
        }
    }

    public void changeCategories(int id) {
        String category;
        List<String> categories = new ArrayList<>();
        int option;

        LOG.info("Type in new set of categories each accepted by enter button: ");
        do {
            LOG.info("Type in category: ");
            category = consoleReader.readString();
            categories.add(category);
            LOG.info("1 repeat operation");
            LOG.info("2. finish adding categories");
            option = consoleReader.readInt();
        } while (option != 2);
        System.out.println(categories);
        LOG.info(DO_YOU_WANT_TO_SAVE);
        LOG.info("y/n");
        if (consoleReader.readString().equals("y")) {
            budgetManager.changeCategories(id, categories);
        }
    }

    public void changeComment(int id) {
        String comment;

        LOG.info("Type in comment: ");
        comment = consoleReader.readString();
        LOG.info(DO_YOU_WANT_TO_SAVE);
        LOG.info("y/n");
        if (consoleReader.readString().equals("y")) {
            budgetManager.changeComment(id, comment);
        }
    }

    public void changeAmount(int id) {
        BigDecimal amount;
        boolean abort = false;

        LOG.info(TYPE_IN_AMOUNT);
        amount = consoleReader.readBigDecimal();
        while (budgetManager.isExceedingLimit(budgetManager.getExpense(id).get().getCategories(), amount)) {
            LOG.error("Thats too much for a category limit!");
            LOG.info("Do you want to continue?");
            LOG.info("y/n");
            if (consoleReader.readString().equals("y")) {
                LOG.info(TYPE_IN_AMOUNT);
                amount = consoleReader.readBigDecimal();
            } else {
                abort = true;
                break;
            }
        }
        if (!abort) {
            LOG.info(DO_YOU_WANT_TO_SAVE);
            LOG.info("y/n");
            if (consoleReader.readString().equals("y")) {
                budgetManager.changeAmount(id, amount);
            }
        }
    }

    public void changeDate(int id) {
        String date;

        LOG.info("Type in date in format yyyy-mm-dd: ");
        date = consoleReader.readString();
        while (!budgetManager.checkIfDateParsable(date)) {
            LOG.error("Wrong format ;d");
            LOG.info("Enter date again: ");
            date = consoleReader.readString();
        }
        budgetManager.changeDate(id, date);
    }

    public void deleteExpense() {
        LOG.info("Type in id of an expense to be deleted: ");
        int id = consoleReader.readInt();
        if (budgetManager.checkIfExpensePresent(id)) {
            budgetManager.deleteExpense(id);
        } else {
            LOG.error("no such expense");
        }
    }

    public void addCategory() {
        String name;
        BigDecimal limit;
        boolean abort = false;

        LOG.info("Type in name of category to be added: ");
        name = consoleReader.readString();
        while (budgetManager.checkIfCategoryPresent(name)) {
            LOG.warn("This category already exists");
            LOG.info("Do you want to continue?");
            LOG.info("y/n");
            if (consoleReader.readString().equals("y")) {
                name = consoleReader.readString();
            } else {
                abort = true;
                break;
            }
        }
        if (!abort) {
            LOG.info("Do you want to add limit for your category?");
            LOG.info("y/n");
            if (consoleReader.readString().equals("y")) {
                LOG.info("Type in limit for you category: ");
                limit = consoleReader.readBigDecimal();
                while (limit.compareTo(BigDecimal.ZERO) < 0) {
                    LOG.warn("cant be negative value");
                    LOG.info("Type in new one");
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

        LOG.info("Type in category to be deleted: ");
        name = consoleReader.readString();
        if (budgetManager.checkIfCategoryPresent(name)) {
            budgetManager.deleteCategory(name);

        } else {
            LOG.error(NO_SUCH_CATEGORY);
        }
    }

    public void displayExpensePerCategory() {
        String category;

        LOG.info("Type in category for expenses to be displayed: ");
        category = consoleReader.readString();
        if (budgetManager.checkIfCategoryPresent(category.toLowerCase())) {
            budgetManager.displayExpensePerCategory(category.toLowerCase());
        } else {
            LOG.error(NO_SUCH_CATEGORY);
        }
    }

    public void displayAllExpenses() {
        budgetManager.displayAllExpenses();
    }

    public void defineBudget() {
        BigDecimal budgetLimit;

        LOG.info("Define your budget: ");
        budgetLimit = consoleReader.readBigDecimal();
        while (budgetLimit.compareTo(BigDecimal.ZERO) < 0) {
            LOG.error("budget is below zero ;d");
            LOG.info("Type in value above or equal zero");
            budgetLimit = consoleReader.readBigDecimal();
        }
        budgetManager.defineBudget(budgetLimit);
    }

    public void setUpLimit() {
        String category;
        BigDecimal limit;

        LOG.info("Type in category to set up its limit: ");
        category = consoleReader.readString();
        if (budgetManager.checkIfCategoryPresent(category.toLowerCase())) {
            LOG.info("Type in limit to be set up");
            limit = consoleReader.readBigDecimal();
            while (limit.compareTo(BigDecimal.ZERO) < 0) {
                LOG.error("limit below zero ;d");
                LOG.info("Type in limit above zero");
                limit = consoleReader.readBigDecimal();
            }
            budgetManager.setUpLimit(category.toLowerCase(), limit);
        } else {
            LOG.info(NO_SUCH_CATEGORY);
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
                LOG.info("\nWrong input \n");
        }
    }
}
