package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.Menu;
import com.infoshareacademy.tailandczycy.console.ConsoleReader;

public class StartApp {

    public void runApp(){
        Budget budget = new Budget();
        ConsoleReader consoleReader = new ConsoleReader();
        Menu menu = new Menu();
        menu.showMenu();
        MainSwitch mainSwitch = new MainSwitch();
        mainSwitch.chooseMenu(consoleReader.readInt());
    }
}
