package com.infoshareacademy.tailandczycy.data.dao;

import com.infoshareacademy.tailandczycy.data.FileOperations;
import com.infoshareacademy.tailandczycy.service.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDao implements Dao<Category>{

    private FileOperations fileOperations = new FileOperations();
    private List<Category> categories = new ArrayList<>();

    public CategoryDao(){
        categories = fileOperations.getCategories();
    }

    @Override
    public Optional<Category> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Category> getAll() {
        return null;
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
