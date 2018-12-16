package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.UserInterface;

public class Switch {

    private UserInterface userInterface = new UserInterface();

    public void chooseMenu(int option) {

        switch (option) {
            case 1:
                userInterface.addExpense();
                break;
            case 2:
                userInterface.modifyExpense();
                break;
            case 3:
                userInterface.deleteExpense();
                break;
            case 4:
                userInterface.addCategory();
                break;
            case 5:
                userInterface.deleteCategory();
                break;
            case 6:
                userInterface.displayExpensePerCategory();
                break;
            case 7:
                userInterface.displayAllExpenses();
                break;
            case 8:
                userInterface.defineBudget();
                break;
            case 9:
                userInterface.setUpLimit();
                break;
            case 10:
                break;
            default:
                System.out.println("Wrong input \n");
        }
    }
}
