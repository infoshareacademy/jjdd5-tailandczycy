package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.Menu;
import com.infoshareacademy.tailandczycy.console.ConsoleReader;
import com.infoshareacademy.tailandczycy.console.UserInterface;

public class StartApp {

    public void runApp(){
        UserInterface userInterface = new UserInterface();
        MainSwitch mainSwitch = new MainSwitch();
        ConsoleReader consoleReader = new ConsoleReader();
        Menu menu = new Menu();
        menu.showMenu();
        mainSwitch.chooseMenu(consoleReader.readInt());
    }
}
