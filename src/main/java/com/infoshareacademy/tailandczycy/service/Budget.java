package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.console.Reader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> 9c7e558f49e1a43e888502abb802e250fb231a72

public class Budget {

    private BigDecimal totalBudget;
    private List<Expense> expenses = new ArrayList<>();
<<<<<<< HEAD
    Reader reader = new Reader();



    public void addExpense(){


        Category category;
        String comment;
        BigDecimal amount;
        String date;
=======
>>>>>>> 9c7e558f49e1a43e888502abb802e250fb231a72

        category = Reader.readString();

<<<<<<< HEAD
=======

    public void addExpense(){

        Category category;
        String comment;
        BigDecimal amount;
        String date;

>>>>>>> 9c7e558f49e1a43e888502abb802e250fb231a72
        expenses.add(new Expense(category, comment, amount, date));
    }
    

}
