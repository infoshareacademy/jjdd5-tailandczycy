package com.infoshareacademy.tailandczycy.web;


import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.dto.ExpenseRequestViewDto;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
import com.infoshareacademy.tailandczycy.model.Expense;
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

@WebServlet("/delete-expense")
public class DeleteExpenseServlet extends HttpServlet {
    private static final String TEMPLATE_NAME = "delete-expense";
    private final Logger logger = Logger.getLogger(getClass().getName());
    private static final String TEMPLATE_EXPENSE_LIST = "expense-list";

    @Inject
    private
    ExpenseDao expenseDao;

    @Inject
    ExpenseRequestViewDto expenseRequestViewDto;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        Long id = Long.parseLong(req.getParameter("id"));
        Expense expense = expenseDao.findById(id);
        handleResponse(resp, expense.getId());
    }

    private void handleTemplate(Map<String, Object> model, String templateName, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), templateName);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
    private void handleResponse(HttpServletResponse resp, Long id) throws IOException {
        expenseDao.delete(id);
        resp.sendRedirect(TEMPLATE_EXPENSE_LIST);
    }
}
