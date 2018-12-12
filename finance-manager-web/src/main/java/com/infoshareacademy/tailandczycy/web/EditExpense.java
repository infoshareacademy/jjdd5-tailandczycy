package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.dto.ExpenseRequestViewDto;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "edit-expense")
public class EditExpense extends HttpServlet {
    private final Logger logger = Logger.getLogger(getClass().getName());
    private static final String TEMPLATE_NAME = "edit-expense";
    @Inject
    TemplateProvider templateProvider;
    @Inject
    ExpenseDao expenseDao;
    @Inject
    ExpenseRequestViewDto expenseRequestViewDto;
}
