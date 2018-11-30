package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.Menu;
import com.infoshareacademy.tailandczycy.console.ConsoleReader;
import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.data.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.data.dao.ExpenseDao;

public class StartApp {

    private MainSwitch mainSwitch = new MainSwitch();
    private ConsoleReader consoleReader = new ConsoleReader();
    private Menu menu = new Menu();
    private CategoryDao categoryDao = new CategoryDao();
    private ExpenseDao expenseDao = new ExpenseDao();

    public void runApp() {

        menu.showMenu();
        mainSwitch.chooseMenu(consoleReader.readInt());
    }
}
