package com.infoshareacademy.tailandczycy.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Budget {

    private BigDecimal totalBudget;
    private List<Expense> expenses = new ArrayList<>();



    public void addExpense(){

        Category category;
        String comment;
        BigDecimal amount;
        String date;

        expenses.add(new Expense(category, comment, amount, date));
    }
    

}
