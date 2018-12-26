package com.infoshareacademy.tailandczycy.Validations;

import com.infoshareacademy.tailandczycy.dto.ExpenseDto;
import com.infoshareacademy.tailandczycy.model.Category;
import org.apache.commons.lang3.StringUtils;

import javax.faces.bean.RequestScoped;
import java.math.BigDecimal;
import java.util.List;

@RequestScoped
public class Validator {

    public boolean isExpenseCorrect(ExpenseDto expenseDto) {
        return validateName(expenseDto.getName()) ||
                validateComment(expenseDto.getComment()) ||
                validateBigDecimal(expenseDto.getAmount()) ||
                checkIfAmountExceeds(expenseDto.getAmount(), expenseDto.getCategories());
    }

    private boolean validateComment(String comment) {
        return comment == null || comment.isEmpty() || !StringUtils.isNumeric(comment);
    }

    private boolean validateName(String name) {
        if (name == null || name.isEmpty() || !StringUtils.isNumeric(name) || isLessThan15Letters(name)) {
            return false;
        }
        return true;
    }

    private boolean isLessThan15Letters(String string){
        return string.chars().count()<15;
    }

    private boolean validateBigDecimal(BigDecimal bigDecimal) {
        if (bigDecimal == null || bigDecimal.signum()<0) {
            return false;
        }
        return true;
    }

    private boolean checkIfAmountExceeds(BigDecimal amount, List<Category> categories) {
        return categories.stream()
                        .anyMatch(category -> category.getTotal().add(amount).compareTo(category.getLimit())>0);
    }
}
