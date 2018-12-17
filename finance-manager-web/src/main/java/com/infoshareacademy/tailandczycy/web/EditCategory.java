package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.dto.CategoryRequestViewDto;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
import com.infoshareacademy.tailandczycy.views.CategoryRequestView;
import com.infoshareacademy.tailandczycy.views.ExpenseRequestView;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "edit-category")
public class EditCategory extends HttpServlet {
    private final Logger logger = Logger.getLogger(getClass().getName());
    private static final String TEMPLATE_NAME = "edit-category";
    private static final String TEMPLATE_EXPENSES_LIST = "/expenses";

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private CategoryRequestViewDto categoryRequestViewDto;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        CategoryRequestView categoryRequestView = categoryRequestViewDto.getCategoryById(Long.parseLong(req.getParameter("id")));
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("category", categoryRequestView);
        handleTemplate(dataModel, TEMPLATE_NAME, resp);
        handleResponse(resp, dataModel, categoryRequestView);
    }


    private void handleTemplate(Map<String, Object> model, String templateName, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), templateName);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private void handleResponse(HttpServletResponse resp, Map<String, Object> model, CategoryRequestView categoryView) throws IOException {
        categoryRequestViewDto.saveCategory(categoryView);
        resp.sendRedirect(TEMPLATE_EXPENSES_LIST);
    }
}
