package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.CategoryBean;
import com.infoshareacademy.tailandczycy.dto.CategoryDto;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "add-category")
public class AddCategory extends HttpServlet {
    private static final String TEMPLATE_CATEGORY_LIST = "expenses";

    @Inject
    CategoryBean categoryBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CategoryDto categoryRequestView = categoryBean.getCategoryDto(req);
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("category", categoryRequestView);
        handleResponse(resp, categoryRequestView);
    }

    private void handleResponse(HttpServletResponse resp, CategoryDto categoryView) throws IOException {
        categoryBean.saveCategory(categoryView);
        resp.sendRedirect(TEMPLATE_CATEGORY_LIST);
    }
}
