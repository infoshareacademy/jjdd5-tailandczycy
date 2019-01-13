package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.staticVariables.Template;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(urlPatterns = "/delete-category")
public class DeleteCategory extends HttpServlet {

    @Inject
    private CategoryDao categoryDao;

    @Inject
    TemplateBean templateBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        HashMap<String, Object> dataModel = new HashMap<>();
        Long id = Long.parseLong(req.getParameter("id"));
        Category category = categoryDao.findById(id);
        dataModel.put("category", category);
        categoryDao.delete(category.getId());
        templateBean.handleTemplate(getServletContext(), Template.DELETE_CATEGORY, dataModel, resp);
    }
}
