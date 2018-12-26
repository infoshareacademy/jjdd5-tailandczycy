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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
@Transactional
@WebServlet(urlPatterns = "/add-expense")
public class
AddExpense extends HttpServlet {
    private static final String TEMPLATE_NAME = "transactions/newTransaction";
    private static final String TEMPLATE_EXPENSES_LIST = "/home";
    private Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    ExpenseDao expenseDao;
    @Inject
    TemplateProvider templateProvider;
    @Inject
    CategoryDao categoryDao;
    @Inject
    ExpenseRequestViewDto expenseRequestViewDto;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        HashMap<String, Object> dataModel = new HashMap<>();
        List<Category> categories = categoryDao.findAll();
        dataModel.put("category", categories);
        handleTemplate(dataModel, TEMPLATE_NAME, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        List<Category> categories = categoryDao.findCategoriesByName(req.getParameter("categories"));
        Category category = categories.get(0);

        Expense expense = new Expense();
//        ExpenseRequestView expenseRequestView = expenseRequestViewDto.getRequestView(req);
        expense.setAmount(BigDecimal.valueOf(Long.parseLong(req.getParameter("amount"))));
        expense.setComment(req.getParameter("comment"));
        expense.setDate(LocalDate.parse(req.getParameter("date")));
        expense.setName(req.getParameter("name"));
        expense.setCategories(new ArrayList<>(Arrays.asList(category)));
        expenseDao.save(expense);

        Map<String, Object> dataModel = new HashMap<>();
//        dataModel.put("expense", expense);
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
        expenseDao.save(expense);
        resp.sendRedirect(TEMPLATE_EXPENSES_LIST);
    }
}

