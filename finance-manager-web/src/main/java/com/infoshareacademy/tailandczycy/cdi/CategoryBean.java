package com.infoshareacademy.tailandczycy.cdi;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.dto.CategoryDto;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@RequestScoped
public class CategoryBean {
    @Inject
    private CategoryDao categoryDao;

    public CategoryDto getCategoryDto(HttpServletRequest req) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(parseStringToLong(req.getParameter("id")));
        categoryDto.setLimit(parseStringToBigDecimal(req.getParameter("limit")));
        String category = req.getParameter("name");
        if (validateParameter(category)) {
            return null;
        }
        categoryDto.setName(category);
        return categoryDto;
    }

    public CategoryDto getCategoryById(Long id) {
        Category categoryById = categoryDao.findById(id);
        if (categoryById == null) {
            return null;
        }
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setName(categoryById.getName());
        categoryDto.setLimit(categoryById.getLimit());
        return categoryDto;
    }

    public void saveCategory(CategoryDto categoryDto) {
        Category category = categoryDao.findById(categoryDto.getId());
        boolean newCategory = false;
        if (category == null) {
            category = new Category();
            newCategory = true;
        }

        category.setLimit(categoryDto.getLimit());
        category.setName(categoryDto.getName());

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
