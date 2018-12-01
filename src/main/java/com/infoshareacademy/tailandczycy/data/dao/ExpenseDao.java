package com.infoshareacademy.tailandczycy.data.dao;

import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.service.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExpenseDao implements Dao<Expense> {

    private FileOperations fileOperations = new FileOperations();
    private List<Expense> expenses = new ArrayList<>();

    public ExpenseDao() {
        expenses = fileOperations.getExpenses();
    }

    @Override
    public Optional<Expense> get(int id) {
        return Optional.ofNullable(expenses.get(id));
    }

    @Override
    public List<Expense> getAll() {
        return expenses;
    }

    @Override
    public void save() {
        fileOperations.saveExpenses(expenses);
    }

    @Override
    public void update(Expense expense, String[] params) {

    }

    @Override
    public void delete(Expense expense) {
        expenses.remove(expense);
        save();
    }
}
