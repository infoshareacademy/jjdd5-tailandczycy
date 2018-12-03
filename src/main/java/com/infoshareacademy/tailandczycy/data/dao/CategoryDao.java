package com.infoshareacademy.tailandczycy.data.dao;

import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.service.Category;

import java.util.List;
import java.util.Optional;

public class CategoryDao {

    private FileOperations fileOperations = new FileOperations();

    public Optional<Category> get(String name) {
        return fileOperations.getCategories().stream()
                .filter(category -> category.getName().equals(name))
                .findAny();
    }

    public List<Category> getAll() {
        return fileOperations.getCategories();
    }

    public void save(List<Category> list) {
        fileOperations.saveCategories(list);
    }

    public void delete(Category category) {
        List<Category> newList = getAll();
        newList.remove(category);
        save(newList);
    }
}
