package com.infoshareacademy.tailandczycy.data.dao;

import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.service.Expense;
import java.util.List;
import java.util.Optional;

public class ExpenseDao implements Dao<Expense>{

    private List<Expense> expenses;

    public ExpenseDao(){
        FileOperations fileOperations = new FileOperations();
        expenses = fileOperations.getExpenses();
    }

    @Override
    public Optional<Expense> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Expense> getAll() {
        return expenses;
    }

    @Override
    public void save(Expense expense) {

    }

    @Override
    public void update(Expense expense, String[] params) {

    }

    @Override
    public void delete(Expense expense) {

    }
}
