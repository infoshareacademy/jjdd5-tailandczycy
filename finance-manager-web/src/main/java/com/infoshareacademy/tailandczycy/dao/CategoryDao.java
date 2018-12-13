package com.infoshareacademy.tailandczycy.dao;

import com.infoshareacademy.tailandczycy.service.Category;

public interface CategoryDao {
    Category getCategoryById(Integer id);

    void addCategory(Category category);

    void deleteCategory(Integer id);
}
