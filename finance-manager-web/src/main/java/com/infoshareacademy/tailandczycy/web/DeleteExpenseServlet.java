package com.infoshareacademy.tailandczycy.web;


import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
import com.infoshareacademy.tailandczycy.model.Expense;
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

@WebServlet("/delete-expense")
public class DeleteExpenseServlet extends HttpServlet {
    private static final String TEMPLATE_NAME = "delete-expense";
    private final Logger logger = Logger.getLogger(getClass().getName());
    @Inject
    ExpenseDao expenseDao;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        HashMap<String, Object> dataModel = new HashMap<>();
        Long id = Long.parseLong(req.getParameter("id"));
        //Validate if there is any object with this id
        Expense expense = expenseDao.findById(id);
        dataModel.put("expenses", expense);
        expenseDao.delete(id);
        handleTemplate(dataModel, TEMPLATE_NAME, resp);


    }

    private void handleTemplate(Map<String, Object> model, String templateName, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), templateName);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
