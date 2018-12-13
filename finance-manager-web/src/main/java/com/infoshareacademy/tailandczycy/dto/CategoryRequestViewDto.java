package com.infoshareacademy.tailandczycy.dto;


import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.service.Category;
import com.infoshareacademy.tailandczycy.views.CategoryRequestView;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@RequestScoped
public class CategoryRequestViewDto {
    @Inject
    CategoryDao categoryDao;

    public CategoryRequestView getcategoryRequestView(HttpServletRequest req) {
        CategoryRequestView categoryRequestView = new CategoryRequestView();
        categoryRequestView.setId(parseStringToInt(req.getParameter("id")));
        categoryRequestView.setLimit(parseStringToBigDecimal(req.getParameter("limit")));
        String category = req.getParameter("name");
        if (validateParameter(category)) {
            return null;
        }
        categoryRequestView.setName(category);
        return categoryRequestView;
    }

    public CategoryRequestView getExpenseById(Integer id) {
        Category categoryById = categoryDao.getCategoryById(id);
        if (categoryById == null) {
            return null;
        }
        CategoryRequestView categoryRequestView = new CategoryRequestView();

        //TODO:Use DB and Integer format not object from base
        //TODO:categoryRequestView.setId(categoryById.getId());
        categoryRequestView.setName(categoryById.getName());
        categoryRequestView.setLimit(categoryById.getLimit());
        return categoryRequestView;
    }

    public void saveCategory(CategoryRequestView categoryRequestView) {
        Category category = categoryDao.getCategoryById(categoryRequestView.getId());
        boolean newCategory = false;
        if (category == null) {
            category = new Category();
            newCategory = true;
        }
        //TODO: Get ID from DB terminal based categoory dont have id
//        category.setId(categoryRequestView.getId());
        category.setLimit(categoryRequestView.getLimit());
        category.setName(categoryRequestView.getName());

        if (newCategory) {
            categoryDao.addCategory(category);
        }
    }

    private Integer parseStringToInt(String param) {
        if (validateParameter(param)) return null;
        return Integer.parseInt(param);
    }

    private BigDecimal parseStringToBigDecimal(String param) {
        if (param == null || param.isEmpty() || StringUtils.isNumeric(param)) {
            return null;
        }
        BigDecimal amount = new BigDecimal(param);
        return amount;
    }


    private boolean validateParameter(String param) {
        if (param == null || param.isEmpty() || !StringUtils.isNumeric(param)) {
            return true;
        }
        return false;
    }
}
