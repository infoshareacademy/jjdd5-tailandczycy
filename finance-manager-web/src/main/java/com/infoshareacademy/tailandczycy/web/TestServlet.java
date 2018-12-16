package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Transactional
@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    private static final String TEMPLATE_NAME = "test";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    ExpenseDao expenseDao;

    @Inject
    CategoryDao categoryDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        Expense expense = new Expense("expense", "csfsd ffds", new BigDecimal(200), LocalDate.of(2018,03,03));
        expenseDao.save(expense);

        Category category = new Category("category", new BigDecimal(1500), Arrays.asList(expense));
        categoryDao.save(category);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();
        model.put("expenses", expenseDao.findAll());

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
