package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.ExpenseBean;
import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;
import com.infoshareacademy.tailandczycy.staticVariables.Template;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "edit-expense")
public class EditExpense extends HttpServlet {

    @Inject
    TemplateBean templateBean;

    @Inject
    ExpenseBean expenseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        ExpenseDto expenseDto = expenseBean.getExpenseById(Long.parseLong(req.getParameter("id")));
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("expense", expenseDto);
        templateBean.handleTemplate(getServletContext(), Template.EDIT_EXPENSE, dataModel, resp);
        handleResponse(resp, expenseDto);
    }

    private void handleResponse(HttpServletResponse resp, ExpenseDto expenseView) throws IOException {
        expenseBean.saveExpense(expenseView);
        resp.sendRedirect("/expenses");
    }
}
