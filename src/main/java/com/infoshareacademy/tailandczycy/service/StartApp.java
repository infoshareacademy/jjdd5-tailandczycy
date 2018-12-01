package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.Menu;
import com.infoshareacademy.tailandczycy.console.ConsoleReader;

public class StartApp {

    private MainSwitch mainSwitch = new MainSwitch();
    private ConsoleReader consoleReader = new ConsoleReader();
    private Menu menu = new Menu();
    private int option = 0;

    public void runApp() {

        while(option!=10) {
            menu.showMenu();
            option = consoleReader.readInt();
            mainSwitch.chooseMenu(option);
        }
    }
}
