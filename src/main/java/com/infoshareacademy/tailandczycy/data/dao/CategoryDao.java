package com.infoshareacademy.tailandczycy.data.dao;

import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.service.Category;

import java.util.List;
import java.util.Optional;

public class CategoryDao implements Dao<Category> {

    private List<Category> categories;

    public CategoryDao() {
        FileOperations fileOperations = new FileOperations();
        categories = fileOperations.getCategories();
    }

    @Override
    public Optional<Category> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void update(Category category, String[] params) {

    }

    @Override
    public void delete(Category category) {

    }
}
