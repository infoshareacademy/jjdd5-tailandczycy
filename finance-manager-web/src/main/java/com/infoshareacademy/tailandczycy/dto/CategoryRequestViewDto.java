package com.infoshareacademy.tailandczycy.dto;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.views.CategoryRequestView;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@RequestScoped
public class CategoryRequestViewDto {
    @Inject
    private CategoryDao categoryDao;

    public CategoryRequestView getcategoryRequestView(HttpServletRequest req) {
        CategoryRequestView categoryRequestView = new CategoryRequestView();
        categoryRequestView.setId(parseStringToLong(req.getParameter("id")));
        categoryRequestView.setLimit(parseStringToBigDecimal(req.getParameter("limit")));
        String category = req.getParameter("name");
        if (validateParameter(category)) {
            return null;
        }
        categoryRequestView.setName(category);
        return categoryRequestView;
    }

    public CategoryRequestView getCategoryById(Long id) {
        Category categoryById = categoryDao.findById(id);
        if (categoryById == null) {
            return null;
        }
        CategoryRequestView categoryRequestView = new CategoryRequestView();


        TODO:categoryRequestView.setId(categoryById.getId());
        categoryRequestView.setName(categoryById.getName());
        categoryRequestView.setLimit(categoryById.getLimit());
        return categoryRequestView;
    }

    public void saveCategory(CategoryRequestView categoryRequestView) {
        Category category = categoryDao.findById(categoryRequestView.getId());
        boolean newCategory = false;
        if (category == null) {
            category = new Category();
            newCategory = true;
        }

//        category.setId(categoryRequestView.getId());
        category.setLimit(categoryRequestView.getLimit());
        category.setName(categoryRequestView.getName());

        if (newCategory) {
            categoryDao.save(category);
        }
    }

    private Long parseStringToLong(String param) {
        if (validateParameter(param)) return null;
        return Long.parseLong(param);
    }

    private BigDecimal parseStringToBigDecimal(String param) {
        if (param == null || param.isEmpty() || StringUtils.isNumeric(param)) {
            return null;
        }
        return new BigDecimal(param);
    }


    private boolean validateParameter(String param) {
        return param == null || param.isEmpty() || !StringUtils.isNumeric(param);
    }
}
