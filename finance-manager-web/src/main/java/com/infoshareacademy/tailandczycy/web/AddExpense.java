package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/add-expense")
public class AddExpense extends HttpServlet {
    private static final String TEMPLATE_NAME = "add-expense";
    Logger logger = Logger.getLogger(getClass().getName());
    @Inject
    TemplateProvider templateProvider;
    @Inject
    ExpenseDao expenseDao;

}
