package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.Menu;
import com.infoshareacademy.tailandczycy.console.ConsoleReader;

import java.io.IOException;

public class StartApp {

    private MainSwitch mainSwitch = new MainSwitch();
    private ConsoleReader consoleReader = new ConsoleReader();
    private Menu menu = new Menu();

    public void runApp() throws IOException {

        menu.showMenu();
        mainSwitch.chooseMenu(consoleReader.readInt());
    }
}
