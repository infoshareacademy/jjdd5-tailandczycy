package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.validations.Validator;
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

@WebServlet(urlPatterns = "/add-expense")
public class AddExpense extends HttpServlet {

    private static final String TEMPLATE_ADD = "transactions/newTransaction";

    private Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    Validator validator;

    @Inject
    TemplateProvider templateProvider;

    @Inject
    ExpenseBean expenseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        HashMap<String, Object> dataModel = new HashMap<>();
        handleTemplate(dataModel, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> dataModel = new HashMap<>();
        if(validator.isExpenseCorrect(req)) {
            ExpenseDto expenseDto = expenseBean.getRequestView(req);
            expenseBean.saveExpense(expenseDto);
            dataModel.put("state", "added");
            handleTemplate(dataModel, resp);
            logger.info("expense added");
        } else {
            dataModel.put("state", "error");
            handleTemplate(dataModel, resp);
            logger.warning("wrong input");
        }
    }

    private void handleTemplate(Map<String, Object> model, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), AddExpense.TEMPLATE_ADD);
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}

