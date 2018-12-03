package com.infoshareacademy.tailandczycy.data.dao;

import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.service.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExpenseDao {

    private FileOperations fileOperations = new FileOperations();

    public Optional<Expense> get(int id) {
        return fileOperations.getExpenses().stream()
                .filter(expense -> expense.getId()==id)
                .findAny();
    }

    public List<Expense> getAll() {
        return fileOperations.getExpenses();
    }

    public void save(List<Expense> list) {
        fileOperations.saveExpenses(list);
    }

    public void delete(Expense expense) {
        List<Expense> newList = getAll();
        newList.remove(expense);
        save(newList);
    }
}
