package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.dto.ExpenseRequestViewDto;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
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

@WebServlet(urlPatterns = "/add-expensive")
public class AddExpense extends HttpServlet {
    private static final String TEMPLATE_NAME = "transactions/newTransaction";
    private static final String TEMPLATE_EXPENSES_LIST = "/expenses";

    private Logger logger = Logger.getLogger(getClass().getName());
    @Inject
    TemplateProvider templateProvider;
    @Inject
    ExpenseDao expenseDao;
    @Inject
    ExpenseRequestViewDto expenseRequestViewDto;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> dataModel = new HashMap<>();
        handleTemplate(dataModel, TEMPLATE_NAME, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExpenseRequestView expenseRequestView = expenseRequestViewDto.getRequestView(req);
        //TODO: Make methods for Category and validation
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("expense", expenseRequestView);
        handleResponse(resp, dataModel, expenseRequestView);
    }

    private void handleTemplate(Map<String, Object> model, String templateName, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), templateName);
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private void handleResponse(HttpServletResponse resp, Map<String, Object> model, ExpenseRequestView expenseView) throws IOException {
        expenseRequestViewDto.saveExpense(expenseView);
        resp.sendRedirect(TEMPLATE_EXPENSES_LIST);
    }
}

