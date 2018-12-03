package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.Menu;
import com.infoshareacademy.tailandczycy.console.ConsoleReader;

public class StartApp {

    private Switch aSwitch = new Switch();
    private ConsoleReader consoleReader = new ConsoleReader();
    private int option = 0;

    public void runApp() {

        while(option!=10) {
            Menu menu = new Menu();
            menu.showMenu();
            option = consoleReader.readInt();
            aSwitch.chooseMenu(option);
        }
    }
}
