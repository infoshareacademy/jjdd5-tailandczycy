package com.infoshareacademy.tailandczycy.cdi;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.dao.ExpenseDao;

import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;
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
public class ExpenseBean {
    @Inject
    private ExpenseDao expenseDao;
    @Inject
    private CategoryDao categoryDao;

    public ExpenseDto getRequestView(HttpServletRequest req) {
        ExpenseDto expenseDto = new ExpenseDto();
        List<String> categoriesString = new ArrayList<>(Arrays.asList(req.getParameterValues("categories")));
        List<Category> categories = categoryDao.findCategoryByName(categoriesString);

        expenseDto.setComment(req.getParameter("comment"));
        expenseDto.setName(req.getParameter("name"));
        expenseDto.setAmount(parseStringToBigDecimal(req.getParameter("amount")));
        expenseDto.setDate(parseStringToLocalDate(req.getParameter("date")));
        expenseDto.setCategories(categories);

        return expenseDto;
    }

    public ExpenseDto getExpenseById(Long id) {
        Expense expenseById = expenseDao.findById(id);
        if (expenseById == null) {
            return null;
        }
        ExpenseDto expenseDto = new ExpenseDto();

        expenseDto.setId(expenseById.getId());
        expenseDto.setAmount(expenseById.getAmount());
        expenseDto.setComment(expenseById.getComment());
        expenseDto.setDate(expenseById.getDate());

        return expenseDto;
    }

    public void saveExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setName(expenseDto.getName());
        expense.setAmount(expenseDto.getAmount());
        expense.setComment(expense.getComment());
        expense.setDate(expenseDto.getDate());
        expense.setCategories(expenseDto.getCategories());
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
