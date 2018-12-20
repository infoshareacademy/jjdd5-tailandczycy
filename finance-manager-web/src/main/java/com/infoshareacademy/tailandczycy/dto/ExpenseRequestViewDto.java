package com.infoshareacademy.tailandczycy.dto;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.dao.ExpenseDao;

import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.views.ExpenseRequestView;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestScoped
public class ExpenseRequestViewDto {
    @Inject
    private ExpenseDao expenseDao;
    @Inject
    private CategoryDao categoryDao;

    public ExpenseRequestView getRequestView(HttpServletRequest req) {
        ExpenseRequestView expenseRequestView = new ExpenseRequestView();
        List<String> categoriesString = new ArrayList<>(Arrays.asList(req.getParameterValues("categories")));
        List<Category> categories = categoryDao.findCategoryByName(categoriesString);

        expenseRequestView.setComment(req.getParameter("comment"));
        expenseRequestView.setName(req.getParameter("name"));
        expenseRequestView.setAmount(parseStringToBigDecimal(req.getParameter("amount")));
        expenseRequestView.setDate(parseStringToLocalDate(req.getParameter("date")));
        expenseRequestView.setCategories(categories);

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
        Expense expense = new Expense();
        expense.setName(expenseRequestView.getName());
        expense.setAmount(expenseRequestView.getAmount());
        expense.setComment(expense.getComment());
        expense.setDate(expenseRequestView.getDate());
        expense.setCategories(expenseRequestView.getCategories());
        expenseDao.save(expense);
    }

    private LocalDate parseStringToLocalDate(String param) {
        if (validateParameter(param)) return null;

        return LocalDate.parse(param);
    }

    private BigDecimal parseStringToBigDecimal(String param) {
        if (param == null || param.isEmpty() || StringUtils.isNumeric(param)) {
            return null;
        }
        BigDecimal amount = new BigDecimal(param).setScale(2, RoundingMode.HALF_UP);
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
