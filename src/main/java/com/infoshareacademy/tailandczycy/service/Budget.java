package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.Reader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Budget {

    private BigDecimal totalBudget;
    private List<Expense> expenses = new ArrayList<>();
    Reader reader = new Reader();



    public void addExpense(){


        Category category;
        String comment;
        BigDecimal amount;
        String date;

        category = Reader.readString();

        expenses.add(new Expense(category, comment, amount, date));
    }
    

}
