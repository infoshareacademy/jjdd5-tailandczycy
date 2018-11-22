package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.Budget;

public class MainSwitch {

    Budget budget = new Budget();

        public void chooseMenu(int option){

        switch(option){
            case 1:
                budget.addExpense();
                break;
            case 2:
                budget.modifyExpense();
                break;
            case 3:
                budget.deleteExpense();
                break;
            case 4:
                budget.addCategory();
                break;
              case 5:
                budget.deleteCategory();
                  break;
            case 6:
                budget.displayExpensePerCategory();
                    break;
            case 7:
                budget.displayAllExpenses();
                break;
            case 8:
                budget.defineBudget();
                  break;
            case 9:
                budget.setUpLimit();
                    break;
        }
    }

}
