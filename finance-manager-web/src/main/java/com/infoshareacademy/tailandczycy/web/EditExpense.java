package com.infoshareacademy.tailandczycy.web;


import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.dto.ExpenseRequestViewDto;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.views.ExpenseRequestView;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
@Transactional
@WebServlet(urlPatterns = "/edit-expense")
public class EditExpense extends HttpServlet {
    private final Logger logger = Logger.getLogger(getClass().getName());
    private static final String TEMPLATE_NAME = "transactions/editTransaction";
    private static final String TEMPLATE_EXPENSES_LIST = "/home";
    @Inject
    private ExpenseDao expenseDao;
    @Inject
    private CategoryDao categoryDao;

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private ExpenseRequestViewDto expenseRequestViewDto;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        Expense expense = expenseDao.findById(Long.parseLong(req.getParameter("id")));
        List<Category> categories = categoryDao.findAll();
        Map<String, Object> dataModel = new HashMap<>();

        BigDecimal amount = expense.getAmount();
        amount = amount.setScale(2, BigDecimal.ROUND_DOWN);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);
        String result = df.format(amount);
        dataModel.put("bigdecimal", result);

        dataModel.put("category", categories);
        dataModel.put("expense", expense);
        handleTemplate(dataModel, TEMPLATE_NAME, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        Expense expense = new Expense();
//        ExpenseRequestView expenseRequestView = expenseRequestViewDto.getRequestView(req);
        expense.setAmount(BigDecimal.valueOf(Long.parseLong(req.getParameter("amount"))));
        expense.setComment(req.getParameter("comment"));
        expense.setDate(LocalDate.parse(req.getParameter("date")));
        expense.setName(req.getParameter("name"));
        expenseDao.update(expense);

        List<Category> categories = categoryDao.findCategoriesByName(req.getParameter("categories"));
        Category category = categories.get(0);

        if (category.getExpenses() == null) {
            category.setExpenses(new ArrayList<>());
        }
        category.getExpenses().add(expense);
        categoryDao.update(category);

        Map<String, Object> dataModel = new HashMap<>();
        handleResponse(resp, dataModel, expense);

    }

    private void handleTemplate(Map<String, Object> model, String templateName, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), templateName);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private void handleResponse(HttpServletResponse resp, Map<String, Object> model, Expense expense) throws IOException {
        expenseDao.update(expense);
        resp.sendRedirect(TEMPLATE_EXPENSES_LIST);
    }
}
