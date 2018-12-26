package com.infoshareacademy.tailandczycy.web;



import com.infoshareacademy.tailandczycy.dto.ExpenseRequestViewDto;
import com.infoshareacademy.tailandczycy.views.ExpenseRequestView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-expense-main")
public class DeleteExpenseMainPageServlet extends HttpServlet {
    private final Logger LOG = LoggerFactory.getLogger(DeleteExpenseMainPageServlet.class);
    private static final String TEMPLATE_EXPENSE_LIST = "/home";
    @Inject
    private ExpenseRequestView expenseRequestView;
    @Inject
    private ExpenseRequestViewDto expenseRequestViewDto;

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
