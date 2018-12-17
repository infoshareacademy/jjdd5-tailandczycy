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
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RequestScoped
public class ExpenseRequestViewDto {
    @Inject
    private CategoryDao categoryDao;
    @Inject
    private ExpenseDao expenseDao;

    public ExpenseRequestView getRequestView(HttpServletRequest req) {
        ExpenseRequestView expenseRequestView = new ExpenseRequestView();

        expenseRequestView.setComment(req.getParameter("comment"));
        expenseRequestView.setName(req.getParameter("name"));
        expenseRequestView.setAmount(parseStringToBigDecimal(req.getParameter("amount")));
        expenseRequestView.setDate(parseStringToLocalDate(req.getParameter("date")));
        List<String> categories = Arrays.asList(req.getParameterValues("categories"));
        expenseRequestView.setCategories(parseListOfStringsToListOfCategories(categories));
        return expenseRequestView;
    }

    public ExpenseRequestView getExpenseById(Long id) {
        Expense expenseById = expenseDao.findById(id);
        if (expenseById == null) {
            return null;
        }
        ExpenseRequestView expenseRequestView = new ExpenseRequestView();

        expenseRequestView.setAmount(expenseById.getAmount());
        expenseRequestView.setComment(expenseById.getComment());
        expenseRequestView.setDate(expenseById.getDate());
        expenseRequestView.setCategories(expenseById.getCategories());
        return expenseRequestView;
    }

    public void updateExpense(ExpenseRequestView expenseRequestView) {
        Expense expense = expenseDao.findById(expenseRequestView.getId());

        expense.setAmount(expenseRequestView.getAmount());
        expense.setComment(expense.getComment());
        expense.setDate(expenseRequestView.getDate());
        expense.setCategories(expenseRequestView.getCategories());
        expenseDao.update(expense);

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
        expense.setCategories(expenseRequestView.getCategories());
        if (newExpense) {
            expenseDao.save(expense);
        }
    }

    private List<Category> parseListOfStringsToListOfCategories(List<String> param) {
        List<Category> categories = Arrays.asList();
        for (String category : param) {
            List<Category> category1 = categoryDao.findCategoriesByName(category);
            if (!category1.isEmpty()) {
                categories.add(category1.get(0));
            }
        }
        return categories;
    }


    private LocalDate parseStringToLocalDate(String param) {
        if (validateParameter(param)) return null;

        return LocalDate.parse(param);
    }

    private BigDecimal parseStringToBigDecimal(String param) {
        if (param == null || param.isEmpty() || StringUtils.isNumeric(param)) {
            return null;
        }
        return new BigDecimal(param);
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
