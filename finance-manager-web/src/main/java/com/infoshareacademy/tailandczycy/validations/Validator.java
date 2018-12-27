package com.infoshareacademy.tailandczycy.validations;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.model.Category;
import org.apache.commons.lang3.StringUtils;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

@RequestScoped
public class Validator {

    @Inject
    CategoryDao categoryDao;

    public boolean isExpenseCorrect(HttpServletRequest request) {
        if (!isNameCorrect(request.getParameter("name"))) {
            return false;
        }
        if (!isCommentCorrect(request.getParameter("comment"))) {
            return false;
        }
        if (!areCategoriesCorrect(Arrays.asList(request.getParameterValues("categories")))) {
            return false;
        }
        if (!isAmountCorrect(request.getParameter("amount"), Arrays.asList(request.getParameterValues("categories")))) {
            return false;
        }
        if (!isDateCorrect(request.getParameter("date"))) {
            return false;
        }

        return true;
    }

    private boolean isCommentCorrect(String comment) {
        return comment == null || comment.isEmpty() || !StringUtils.isNumeric(comment);
    }

    private boolean isNameCorrect(String name) {
        if (name == null || name.isEmpty() || !StringUtils.isNumeric(name) || isLessThan15Letters(name)) {
            return false;
        }
        return true;
    }

    private boolean isAmountCorrect(String amount, List<String> categoriesString) {
        List<Category> categories = categoryDao.findCategoriesByNames(categoriesString);

        if (!isBigDecimalCorrect(amount)) {
            return false;
        }
        if (!checkIfAmountDoesNotExceed(new BigDecimal(amount), categories)) {
            return false;
        }

        return true;
    }

    private boolean isDateCorrect(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean areCategoriesCorrect(List<String> categoriesString) {
        if (categoriesString.isEmpty()) {
            return false;
        }
        if (categoryDao.findCategoriesByNames(categoriesString).size() != categoriesString.size()) {
            return false;
        }
        return true;
    }

    private boolean isLessThan15Letters(String string) {
        return string.chars().count() < 15;
    }

    private boolean isBigDecimalCorrect(String bigDecimalString) {
        if (bigDecimalString == null) {
            return false;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(bigDecimalString);
            if (bigDecimal.signum() <= 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkIfAmountDoesNotExceed(BigDecimal amount, List<Category> categories) {
        return categories.stream()
                .anyMatch(category -> category.getTotal().add(amount).compareTo(category.getLimit()) <= 0);
    }
}
