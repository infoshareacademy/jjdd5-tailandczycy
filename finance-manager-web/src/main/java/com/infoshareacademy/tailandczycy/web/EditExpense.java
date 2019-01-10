package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.ExpenseBean;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;
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

@WebServlet(urlPatterns = "edit-expense")
public class EditExpense extends HttpServlet {
    private final Logger logger = Logger.getLogger(getClass().getName());
    private static final String TEMPLATE_NAME = "edit-expense";
    private static final String TEMPLATE_EXPENSES_LIST = "/expenses";

    @Inject
    TemplateProvider templateProvider;

    @Inject
    ExpenseBean expenseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        ExpenseDto expenseDto = expenseBean.getExpenseById(Long.parseLong(req.getParameter("id")));
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("expense", expenseDto);
        handleTemplate(dataModel, resp);
        handleResponse(resp, expenseDto);

    }

    private void handleTemplate(Map<String, Object> model, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), EditExpense.TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private void handleResponse(HttpServletResponse resp, ExpenseDto expenseView) throws IOException {
        expenseBean.saveExpense(expenseView);
        resp.sendRedirect(TEMPLATE_EXPENSES_LIST);
    }
}
