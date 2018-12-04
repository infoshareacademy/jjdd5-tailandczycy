package com.infoshareacademy.tailandczycy.data.dao;

import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.service.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CategoryDao {

    private FileOperations fileOperations = new FileOperations();

    public void add(Category category){
        List<Category> newList = new ArrayList<>(getAll());
        newList.add(category);
        save(newList);
    }

    public Optional<Category> get(String name) {
        return fileOperations.getCategories().stream()
                .filter(category -> category.getName().equalsIgnoreCase(name))
                .findAny();
    }

    public List<Category> getAll() {
        return fileOperations.getCategories();
    }

    public void update(Category category){
        List<Category> newList = getAll();
        Category categoryToBeUpdated = getAll().stream()
                .filter(c -> c.getName().equals(category.getName()))
                .findAny().get();
        int index = getAll().indexOf(categoryToBeUpdated);
        newList.set(index, category);
        save(newList);
    }

    public void save(List<Category> list) {
        fileOperations.saveCategories(list);
    }

    public void delete(String category) {
        List<Category> newList = getAll();
        newList.remove(get(category).get());
        save(newList);
    }
}
