package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.TemplateBean;

import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.staticVariables.Template;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/home")
public class MainPageServlet extends HttpServlet {

    @Inject
    TemplateBean templateBean;

    @Inject
    ExpenseDao expenseDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        Map<String, Object> dataModel = new HashMap<>();
        List<Expense> expenses = expenseDao.findAll();
        dataModel.put("expenses", expenses);
        templateBean.handleTemplate(getServletContext(), Template.HOME, dataModel, resp);
    }
}

