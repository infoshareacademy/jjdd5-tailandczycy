package com.infoshareacademy.tailandczycy.dto;

import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.views.ExpenseRequestView;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
public class ExpenseRequestViewDto {
    @Inject
    ExpenseDao expenseDao;

    public ExpenseRequestView expenseRequestView(HttpServletRequest req) {
        ExpenseRequestView expenseRequestView = new ExpenseRequestView();

        expenseRequestView.setId(parseStringToLong(req.getParameter("id")));
        //TODO:ADD all setters to make view of object Expense

        return expenseRequestView;
    }

    private Integer parseStringToInt(String param) {
        if (param == null || param.isEmpty() || !StringUtils.isNumeric(param)) {
            return null;
        }
        return Integer.parseInt(param);
    }

    private Long parseStringToLong(String param) {
        if (param == null || param.isEmpty() || !StringUtils.isNumeric(param)) {
            return null;
        }
        return Long.parseLong(param);
    }
}
