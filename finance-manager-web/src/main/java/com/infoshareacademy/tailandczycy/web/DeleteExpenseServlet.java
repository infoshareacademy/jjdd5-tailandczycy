package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.dto.ExpenseRequestViewDto;
import com.infoshareacademy.tailandczycy.views.ExpenseRequestView;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete-expense")
public class DeleteExpenseServlet extends HttpServlet {
    private final org.slf4j.Logger LOG = LoggerFactory.getLogger(DeleteExpenseMainPageServlet.class);
    private static final String TEMPLATE_EXPENSE_LIST = "expense-list";
    @Inject
    private ExpenseRequestViewDto expenseRequestViewDto;
    @Inject
    private ExpenseRequestView expenseRequestView;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        Long id = Long.parseLong(req.getParameter("id"));
        expenseRequestView = expenseRequestViewDto.getExpenseById(id);
        handleResponse(resp, expenseRequestView.getId());
    }

    private void handleResponse(HttpServletResponse resp, Long id) throws IOException {
        LOG.info("Deleting Expense with {} id", id);
        expenseRequestViewDto.deleteExpense(id);
        resp.sendRedirect(TEMPLATE_EXPENSE_LIST);
    }
}
