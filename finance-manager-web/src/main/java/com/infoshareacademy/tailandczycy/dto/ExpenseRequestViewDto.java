package com.infoshareacademy.tailandczycy.dto;

import com.infoshareacademy.tailandczycy.dao.ExpenseDao;

import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.views.ExpenseRequestView;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;

@RequestScoped
public class ExpenseRequestViewDto {
    @Inject
    private ExpenseDao expenseDao;

    public ExpenseRequestView getRequestView(HttpServletRequest req) {
        ExpenseRequestView expenseRequestView = new ExpenseRequestView();

        expenseRequestView.setId(parseStringToLong(req.getParameter("id")));
        expenseRequestView.setComment(req.getParameter("comment"));
        expenseRequestView.setName(req.getParameter("name"));
        expenseRequestView.setAmount(parseStringToBigDecimal(req.getParameter("amount")));
        expenseRequestView.setDate(parseStringToLocalDate(req.getParameter("date")));

        return expenseRequestView;
    }

    public ExpenseRequestView getExpenseById(Long id) {
        Expense expenseById = expenseDao.findById(id);
        if (expenseById == null) {
            return null;
        }
        ExpenseRequestView expenseRequestView = new ExpenseRequestView();

        expenseRequestView.setId(expenseById.getId());
        expenseRequestView.setAmount(expenseById.getAmount());
        expenseRequestView.setComment(expenseById.getComment());
        expenseRequestView.setDate(expenseById.getDate());

        return expenseRequestView;
    }

    public void saveExpense(ExpenseRequestView expenseRequestView) {
        Expense expense = expenseDao.findById(expenseRequestView.getId());
        boolean newExpense = false;
        if (expense == null) {
            expense = new Expense();
            newExpense = true;
        }


        expense.setAmount(expenseRequestView.getAmount());
        expense.setComment(expense.getComment());
        expense.setDate(expenseRequestView.getDate());
        if (newExpense) {
            expenseDao.save(expense);
        }
    }

    private LocalDate parseStringToLocalDate(String param) {
        if (validateParameter(param)) return null;

        return LocalDate.parse(param);
    }

    private BigDecimal parseStringToBigDecimal(String param) {
        if (param == null || param.isEmpty() || StringUtils.isNumeric(param)) {
            return null;
        }
        BigDecimal amount = new BigDecimal(param);
        return amount;
    }

    private Long parseStringToLong(String param) {
        if (validateParameter(param)) return null;
        return Long.parseLong(param);
    }

    private boolean validateParameter(String param) {
        if (param == null || param.isEmpty() || !StringUtils.isNumeric(param)) {
            return true;
        }
        return false;
    }
}
