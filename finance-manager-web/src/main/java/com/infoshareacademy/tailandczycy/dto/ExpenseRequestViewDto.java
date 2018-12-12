package com.infoshareacademy.tailandczycy.dto;

import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.service.Expense;
import com.infoshareacademy.tailandczycy.views.ExpenseRequestView;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.LocalDate;

@RequestScoped
public class ExpenseRequestViewDto {
    @Inject
    ExpenseDao expenseDao;

    public ExpenseRequestView getRequestView(HttpServletRequest req) {
        ExpenseRequestView expenseRequestView = new ExpenseRequestView();

        expenseRequestView.setId(parseStringToLong(req.getParameter("id")));
        expenseRequestView.setComment(req.getParameter("comment"));
        expenseRequestView.setName(req.getParameter("name"));
        expenseRequestView.setAmount(parseStringToBigDecimal(req.getParameter("amount")));
        expenseRequestView.setDate(parseStringToLocalDate(req.getParameter("date")));
        /*
TODO:Make list of Categories a thing
TODO:expenseRequestView.setCategories();
*/

        return expenseRequestView;
    }

    public ExpenseRequestView getExpenseById(Long id) {
        Expense expenseById = expenseDao.getExpenseById(id);
        if (expenseById == null) {
            return null;
        }
        ExpenseRequestView expenseRequestView = new ExpenseRequestView();

        //TODO:Use DB and long format not object from base
        //TODO:expenseRequestView.setId(expenseById.getId());
        expenseRequestView.setAmount(expenseById.getAmount());
        expenseRequestView.setComment(expenseById.getComment());
        expenseRequestView.setDate(expenseById.getDate());
        //TODO:Use DB and this will be list of categories not list of Strings
        //TODO:expenseRequestView.setCategories(expenseById.getCategories());
        return expenseRequestView;
    }

    public void saveExpense(ExpenseRequestView expenseRequestView) {
        Expense expense = expenseDao.getExpenseById(expenseRequestView.getId());
        boolean newExpense = false;
        if (expense == null) {
            expense = new Expense();
            newExpense = true;
        }
        //TODO:Use DB and long format not object from base
        //TODO:expense.setId(expenseRequestView.getId());
        expense.setAmount(expenseRequestView.getAmount());
        expense.setComment(expense.getComment());
        expense.setDate(expenseRequestView.getDate());
        //TODO:Use DB and this will be list of categories not list of Strings
        //TODO:expense.setCategories(expenseRequestView.getCategories());

        if (newExpense) {
            expenseDao.addExpense(expense);
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

    private Integer parseStringToInt(String param) {
        if (validateParameter(param)) return null;
        return Integer.parseInt(param);
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
