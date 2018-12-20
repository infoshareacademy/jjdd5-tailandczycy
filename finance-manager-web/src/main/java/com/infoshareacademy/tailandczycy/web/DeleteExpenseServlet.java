package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.dto.ExpenseRequestViewDto;
import com.infoshareacademy.tailandczycy.views.ExpenseRequestView;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/delete-expense")
public class DeleteExpenseServlet extends HttpServlet {
    private static final String TEMPLATE_NAME = "delete-expense";
    private final Logger logger = Logger.getLogger(getClass().getName());
    private static final String TEMPLATE_EXPENSE_LIST = "expense-list";
    @Inject
    ExpenseRequestViewDto expenseRequestViewDto;

    @Inject
    ExpenseRequestView expenseRequestView;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        Long id = Long.parseLong(req.getParameter("id"));
        expenseRequestView = expenseRequestViewDto.getExpenseById(id);
        handleResponse(resp, expenseRequestView.getId());
    }

    private void handleResponse(HttpServletResponse resp, Long id) throws IOException {
        expenseRequestViewDto.deleteExpense(id);
        resp.sendRedirect(TEMPLATE_EXPENSE_LIST);
    }
}
