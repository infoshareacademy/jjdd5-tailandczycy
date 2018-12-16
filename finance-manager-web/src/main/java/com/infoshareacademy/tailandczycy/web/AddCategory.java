package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.dto.CategoryRequestViewDto;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
import com.infoshareacademy.tailandczycy.views.CategoryRequestView;

import javax.inject.Inject;
import javax.servlet.ServletException;
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
    CategoryRequestViewDto categoryRequestViewDto;

    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryRequestView categoryRequestView = categoryRequestViewDto.getcategoryRequestView(req);
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("category", categoryRequestView);
        handleResponse(resp, dataModel, categoryRequestView);
    }

    private void handleResponse(HttpServletResponse resp, Map<String, Object> model, CategoryRequestView categoryView) throws IOException {
        categoryRequestViewDto.saveCategory(categoryView);
        resp.sendRedirect(TEMPLATE_CATEGORY_LIST);
    }
}
