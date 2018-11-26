package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.data.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.data.dao.ExpenseDao;

public class MainSwitch {

    CategoryDao categoryDao = new CategoryDao();
    ExpenseDao expenseDao = new ExpenseDao();


    BudgetManager budget = new BudgetManager(expenseDao, categoryDao);
    //UI ui = new UI(budget)

        public void chooseMenu(int option) {

        switch(option) {
            case 1:
                //budget.addExpense();
                break;
            case 2:
                //budget.modifyExpense();
                break;
            case 3:
                //budget.deleteExpense();
                break;
            case 4:
                //budget.addCategory();
                break;
              case 5:
                //budget.deleteCategory();
                  break;
            case 6:
                //budget.displayExpensePerCategory();
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
