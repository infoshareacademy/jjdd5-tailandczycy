package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.userInterface;

public class MainSwitch {

    private com.infoshareacademy.tailandczycy.console.userInterface userInterface;

    public MainSwitch() {
        userInterface = new userInterface();
    }

    public void chooseMenu(int option){

        switch(option){
            case 1:
                userInterface.uIaddExpense();
                break;
            case 2:
                userInterface.uImodifyExpense();
                break;
            case 3:
                userInterface.uIdeleteExpense();
                break;
            case 4:
                userInterface.uIaddCategory();
                break;
              case 5:
                userInterface.uIdeleteCategory();
                  break;
            case 6:
                userInterface.uIdisplayExpensePerCategory();
                    break;
            case 7:
                userInterface.uIdisplayAllExpenses();
                break;
            case 8:
                userInterface.uIdefineBudget();
                  break;
            case 9:
                userInterface.uIsetUpLimit();
                    break;
        }
    }

}
