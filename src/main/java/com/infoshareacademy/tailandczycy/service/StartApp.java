package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.Menu;
import com.infoshareacademy.tailandczycy.console.ConsoleReader;
import com.infoshareacademy.tailandczycy.data.Parser;
import com.infoshareacademy.tailandczycy.data.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.data.dao.ExpenseDao;

import java.io.FileNotFoundException;

public class StartApp {


    public void runApp() throws FileNotFoundException {
        Parser parser = new Parser();
        System.out.println(parser.getDataList());
        CategoryDao categoryDao = new CategoryDao();
        ExpenseDao expenseDao = new ExpenseDao();
        BudgetManager budget = new BudgetManager(expenseDao, categoryDao);
        ConsoleReader consoleReader = new ConsoleReader();
        Menu menu = new Menu();
        menu.showMenu();
        MainSwitch mainSwitch = new MainSwitch();
        mainSwitch.chooseMenu(consoleReader.readInt());
    }


}
