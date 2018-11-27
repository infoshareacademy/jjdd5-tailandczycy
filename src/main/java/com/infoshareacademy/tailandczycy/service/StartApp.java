package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.Menu;
import com.infoshareacademy.tailandczycy.console.ConsoleReader;
import com.infoshareacademy.tailandczycy.console.userInterface;

public class StartApp {

    public void runApp(){
        userInterface userInterface = new userInterface();
        MainSwitch mainSwitch = new MainSwitch();
        ConsoleReader consoleReader = new ConsoleReader();
        Menu menu = new Menu();
        menu.showMenu();
        mainSwitch.chooseMenu(consoleReader.readInt());
    }
}
