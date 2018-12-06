package com.infoshareacademy.tailandczycy.data.dao;

import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.service.Expense;

import java.util.List;
import java.util.Optional;

public class ExpenseDao {

    private FileOperations fileOperations = new FileOperations();

    public void add(Expense expense) {
        List<Expense> newList = getAll();
        newList.add(expense);
        save(newList);
    }

    public Optional<Expense> get(int id) {
        return fileOperations.getExpenses().stream()
                .filter(expense -> expense.getId() == id)
                .findAny();
    }

    public void update(Expense expense) {
        List<Expense> newList = getAll();
        int id = expense.getId();
        newList.set(id, expense);
        save(newList);
    }

    public List<Expense> getAll() {
        return fileOperations.getExpenses();
    }

    public void save(List<Expense> list) {
        fileOperations.saveExpenses(list);
    }

    public void delete(int id) {
        List<Expense> newList = getAll();
        newList.remove(get(id).get());
        newList.forEach(expense -> expense.setId(newList.indexOf(expense)));
        save(newList);
    }
}
