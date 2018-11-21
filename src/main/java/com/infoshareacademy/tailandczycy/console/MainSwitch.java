package com.infoshareacademy.tailandczycy.console;

import com.infoshareacademy.tailandczycy.service.Budget;

public class MainSwitch {

    Budget budget = new Budget();
    Reader reader = new Reader();

        public void chooseMenu(int option){

        switch(option){
            case 1:
                budget.addExpense();
                break;
//            case 2:
//                modifyExpense();
//                break;
//            case 3:
//                deleteExpense();
//                break;
//            case 4:
//                addCategory();
//                break;
//              case 5:
//                deleteCateogory();
//                  break;
//            case 6:
//                displayExpensePerCategory();
//                    break;
//            case 7:
//                displayAllExpenses();
//                break;
//            case 8:
//                defineBudget();
//                  break;
//            case 9:
//                setUpLimit();
//                    break;
        }
    }

}
