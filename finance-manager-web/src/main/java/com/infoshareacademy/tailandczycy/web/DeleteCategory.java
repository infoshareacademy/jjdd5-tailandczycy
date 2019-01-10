package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
import com.infoshareacademy.tailandczycy.model.Category;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/delete-category")
public class DeleteCategory extends HttpServlet {
    private final Logger logger = Logger.getLogger(getClass().getName());
    private final static String TEMPLATE_NAME = "delete-category";
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private CategoryDao categoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        HashMap<String, Object> dataModel = new HashMap<>();
        Long id = Long.parseLong(req.getParameter("id"));
        Category category = categoryDao.findById(id);
        dataModel.put("category", category);
        categoryDao.delete(category.getId());
        handleTemplate(dataModel, resp);
    }

    private void handleTemplate(Map<String, Object> model, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), DeleteCategory.TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
