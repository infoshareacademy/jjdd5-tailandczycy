package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.staticVariables.Template;
import com.infoshareacademy.tailandczycy.validations.Validator;
import com.infoshareacademy.tailandczycy.cdi.ExpenseBean;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


@WebServlet(urlPatterns = "/add-expense")
public class AddExpense extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    Validator validator;

    @Inject
    TemplateBean templateBean;

    @Inject
    ExpenseBean expenseBean;

    @Inject
    ExpenseDao expenseDao;

    @Inject
    CategoryDao categoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HashMap<String, Object> dataModel = new HashMap<>();
        List<Category> categories = categoryDao.findAll();
        dataModel.put("categories", categories);
        templateBean.handleTemplate(getServletContext(), Template.ADD_EXPENSE, dataModel, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HashMap<String, Object> dataModel = new HashMap<>();
        if(validator.isExpenseCorrect(req)) {
            ExpenseDto expenseDto = expenseBean.getRequestView(req);
            expenseBean.saveExpense(expenseDto);
            List<Expense> expenses = expenseDao.findAll();
            dataModel.put("state", "added");
            dataModel.put("expenses", expenses);
            logger.info("Expense {} added", expenseDto.toString());
        } else {
            List<Expense> expenses = expenseDao.findAll();
            dataModel.put("state", "error");
            dataModel.put("expenses", expenses);
            logger.error("Wrong input");
        }
        templateBean.handleTemplate(getServletContext(), Template.HOME, dataModel, resp);
    }
}

