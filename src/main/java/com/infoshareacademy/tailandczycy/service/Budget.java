package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.Reader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Budget {

    private List<Expense> expenses;
    private BigDecimal totalBudget;
    private Reader reader;


    public Budget() {
        expenses = new ArrayList<>();
        reader = new Reader();
    }


    public void addExpense() {
        //Adding expense
    }
    public void modifyExpense(){
        int id = reader.readInt();
        //modifying expense
    }
    public void deleteExpense(){
        int id = reader.readInt();
        //deleting expense
    }
    public void addCategory(){
        //adding category
    }
    public void deleteCategory(){
        //deletingCategory
    }
    public void displayExpensePerCategory(){
        //display
    }
    public void displayAllExpenses(){

    }
    public void defineBudget(){
        //set up budget
    }
    public void setUpLimit(){
        //
    }
}
