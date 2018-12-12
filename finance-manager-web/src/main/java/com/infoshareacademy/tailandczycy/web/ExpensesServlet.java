package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.data.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
import com.infoshareacademy.tailandczycy.service.Expense;
import freemarker.template.Template;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(urlPatterns = "/expenses")
public class ExpensesServlet extends HttpServlet {
    private static final String TEMPLATE_NAME = "expenses";
    @Inject
    TemplateProvider templateProvider;
     private ExpenseDao expenseDao = new ExpenseDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);
        HashMap<String, Object> dataModel = new HashMap<>();
        List<Expense> listOfExpenses = expenseDao.getAll();
        dataModel.put("expenses", listOfExpenses);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
