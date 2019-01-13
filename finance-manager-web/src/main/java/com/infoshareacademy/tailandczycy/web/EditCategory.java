package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.CategoryBean;
import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.dto.CategoryDto;
import com.infoshareacademy.tailandczycy.staticVariables.Template;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "edit-category")
public class EditCategory extends HttpServlet {

    @Inject
    TemplateBean templateBean;

    @Inject
    CategoryBean categoryBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        CategoryDto categoryRequestView = categoryBean.getCategoryById(Long.parseLong(req.getParameter("id")));
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("category", categoryRequestView);
        templateBean.handleTemplate(getServletContext(), Template.EDIT_CATEGORY, dataModel, resp);
        handleResponse(resp, categoryRequestView);
    }

    private void handleResponse(HttpServletResponse resp, CategoryDto categoryView) throws IOException {
        categoryBean.saveCategory(categoryView);
        resp.sendRedirect("/expenses");
    }
}
