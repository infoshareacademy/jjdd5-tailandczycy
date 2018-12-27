package com.infoshareacademy.tailandczycy.cdi;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.dao.ExpenseDao;

import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;

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
        List<Category> categories = categoryDao.findCategoriesByNames(categoriesString);

        expenseDto.setName(req.getParameter("name"));
        expenseDto.setComment(req.getParameter("comment"));
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
        expense.getCategories()
                .forEach(category -> {
                                        category.getTotal().add(expenseDto.getAmount());
                                        categoryDao.update(category);
                                     });
        expenseDao.save(expense);
    }

    private LocalDate parseStringToLocalDate(String date) {
        return LocalDate.parse(date);
    }

    private BigDecimal parseStringToBigDecimal(String param) {

        return new BigDecimal(param).setScale(2, RoundingMode.HALF_UP);
    }
}
