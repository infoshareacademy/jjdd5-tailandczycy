package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.Budget;
import com.infoshareacademy.tailandczycy.service.MainSwitch;

public class StartApp {


    public void runApp(){
        Budget budget = new Budget();
        Reader reader = new Reader();
        Menu menu = new Menu();
        menu.showMenu();
        MainSwitch mainSwitch = new MainSwitch();
        mainSwitch.chooseMenu(reader.readInt());
    }


}
